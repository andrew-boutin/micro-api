# Micro-services Architecture REST API

This comprises a Spring Boot REST API built with Gradle and a PostgreSQL database. Both are ran inside of Docker
docker containers in a Docker stack.

Eventually this will have other components such as UI, Gateway, Auth, Cache added to it.

## Requirements

Install Docker.

Enable Docker experimental features (swarm).

Run `docker swarm init`

Run `docker network create --scope=swarm --driver overlay micro-network`

## Commands

### Docker Stack running REST API and Postgres

`./gradlew build` - Build our REST API .jar.

`docker build -t bbs/rest_api .` - Create the Docker image for our REST API.

`docker build -t bbs/db postgres/.` - Create the Docker image for our PostgreSQL.

`docker stack deploy -c micro-services-stack.yml micro-stack` Start up the stack which starts both the containers.

`docker stack rm micro-stack` - Tear down the stack.

### Other Useful Commands

`./gradlew build` - Produce local .jar of the Spring Boot application.

`./gradlew bootRun` - Use the Gradle Wrapper to build and run the Spring Boot application locally.

[Docker stack commands](https://docs.docker.com/engine/reference/commandline/stack/).

[Gradle commands](https://docs.gradle.org/current/userguide/tutorial_gradle_command_line.html).

## Other

[pgAdmin](https://www.pgadmin.org/) is a PostgreSQL UI tool that you can connect to the PostgreSQL Docker container
while it's running in the stack. This makes admin and development easier than connecting to the Docker container on the
command line.

[Kitematic](https://kitematic.com/) is a Docker UI tool that helps seeing what containers are running, easily
accessing the logs, and other useful things. This should automatically detect any running Docker containers and allow
you to easily access them.

## TODO

- get rid of duplicated init script copying (yml and dockerfile)
- makefile: tear down stack, build gradle, build postgres, build rest api, docker stack
- Git repo
- Gitignore duplicated..
- Get working using postgres/Dockerfile
- Get auto db generation working from .sql script
- Get working with rest api in compose as well.
- Verify attributes in properties file are actually needed.
- Do we really need /tmp in rest api container?
- Upgrade container to Java 9 and gradle file
- Change to yaml props
- pgAdmin instructions sub page w/ link on here to there
