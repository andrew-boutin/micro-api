FROM java:8
VOLUME /tmp
ADD 'build/libs/api-0.0.1-SNAPSHOT.jar' 'app.jar'
EXPOSE 8080
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-jar","/app.jar"]