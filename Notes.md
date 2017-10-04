init sql script ran in alphabetical order - use dockerfile to copy them into specific dir
postgres db & user auto created from docker yaml env vars
serial sql - instead of int takes care of auto increment
application.properties jdbc:postgresql://localhost:5432/test_db when hitting from outside - jdbc:postgresql://db:5432/test_db when hitting from same docker network (use container name)

1) Spring Boot running locally using Gradle

2) Sping Boot running locally w/ Gradle + Postgres running w/ Docker Compose

3) Spring Boot & Postgres running w/ Docker Stack
