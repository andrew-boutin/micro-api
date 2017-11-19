package com.bbs.restapi.controller;

import com.bbs.restapi.exception.TechnologyNotFoundException;
import com.bbs.restapi.TestUtilities;
import com.bbs.restapi.service.TechnologyService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by aboutin on 10/7/17.
 */
// TODO: @RuntWith - SpringRunner vs SpringJunit4ClassRunner?
// TODO: @WebMvcTest?
// TODO: @Autowired vs @MockBean
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = TechnologyController.class)
public class TestTechnologyController {

    // TODO: Jackson, Hamcrest, Mockito, JUnit, SpringFramework
    // https://www.petrikainulainen.net/programming/spring-framework/unit-testing-of-spring-mvc-controllers-normal-controllers/

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TechnologyService technologyService;

    // TODO: content type json...
    // TODO: Why/when would I check the name of the returned view?

    // TODO: Negative cases (get on non existent / get on just deleted / etc.)
    // TODO: Urls that don't exist

    @Test
    public void getTechnologies() throws Exception {
        // Use Mockito to mock service layer
        when(technologyService.getTechnologies()).thenReturn(TestUtilities.createTechnologies());

        mockMvc.perform(get("/tech"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$", hasSize(2)))
               .andExpect(jsonPath("$[0].id", is(1)))
               .andExpect(jsonPath("$[0].title", is("a")))
               .andExpect(jsonPath("$[0].link", is("aa")))
               .andExpect(jsonPath("$[1].id", is(2)))
               .andExpect(jsonPath("$[1].title", is("b")))
               .andExpect(jsonPath("$[1].link", is("bb")));

        verify(technologyService, times(1)).getTechnologies();
        verifyNoMoreInteractions(technologyService);
    }

    @Test
    public void getTechnology() throws Exception {
        when(technologyService.getTechnology(1)).thenReturn(TestUtilities.createTechnology());

        mockMvc.perform(get("/tech/1"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.id", is(1)))
               .andExpect(jsonPath("$.title", is("a")))
               .andExpect(jsonPath("$.link", is("aa")));

        verify(technologyService, times(1)).getTechnology(anyInt());
        verifyNoMoreInteractions(technologyService);
    }

    @Test
    public void getTechnology_doesNotExist() throws Exception {
        doThrow(new TechnologyNotFoundException(9000)).when(technologyService).getTechnology(9000);

        mockMvc.perform(get("/tech/9000"))
               .andExpect(status().isNotFound())
               .andExpect(jsonPath("$", is("Technology not found id: 9000")));

        verify(technologyService, times(1)).getTechnology(anyInt());
        verifyNoMoreInteractions(technologyService);
    }

    @Ignore
    @Test
    public void updateTechnology() throws Exception {
        throw new Exception("Not Implemented Yet");
    }

    @Ignore
    @Test
    public void updateTechnology_doesNotExist() throws Exception {
        throw new Exception("Not Implemented Yet");
    }

    @Test
    public void deleteTechnology() throws Exception {
        doNothing().when(technologyService).deleteTechnology(1);

        mockMvc.perform(delete("/tech/1"))
               .andExpect(status().isNoContent())
               .andExpect(content().string(""));

        verify(technologyService, times(1)).deleteTechnology(anyInt());
        verifyNoMoreInteractions(technologyService);
    }

    @Ignore
    @Test
    public void deleteTechnology_doesNotExist() throws Exception {
        throw new Exception("Not Implemented Yet");
    }

    @Ignore
    @Test
    public void createTechnology() throws Exception {
        throw new Exception("Not Implemented Yet");
    }

    // TODO: Create already exists id?

}
