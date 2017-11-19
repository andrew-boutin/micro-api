package com.bbs.restapi;

import com.bbs.restapi.domain.Technology;

import java.util.Arrays;
import java.util.List;

/**
 * Created by aboutin on 10/11/17.
 */
public class TestUtilities {
    public static Technology createTechnology() {
        return new Technology(1, "a", "aa");
    }

    public static List<Technology> createTechnologies() {
        return Arrays.asList(new Technology(1, "a", "aa"), new Technology(2, "b", "bb"));
    }
}
