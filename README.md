# Micro API

Micro API is all about REST API micro-services architecture.

It comprises a Spring Boot REST API built with Gradle and a PostgreSQL database. Both are ran inside of Docker
containers in a Docker stack.

Eventually this will have other components such as UI, Gateway, 2nd REST API, Auth, and Cache added to it.

## Requirements

Install Docker.

Enable Docker experimental features (swarm).

    docker swarm init
    docker network create --scope=swarm --driver overlay micro-network

This initializes swarm and creates a network that can span multiple hosts.

## Commands

### Docker Stack running REST API and Postgres

    # Produce local jar of Spring Boot application.
    ./gradlew build

    # Create the Docker image for our REST API.
    docker build -t bbs/rest_api .

    # Create the Docker image for our PostgreSQL.
    docker build -t bbs/db postgres/.

    # Start up the stack which starts both the containers.
    docker stack deploy -c micro-services-stack.yml micro-stack

    # Tear down the stack.
    docker stack rm micro-stack

### Other Useful Information

`./gradlew bootRun` - Use the Gradle Wrapper to build and run the Spring Boot application locally.

[Docker stack commands](https://docs.docker.com/engine/reference/commandline/stack/).

[Gradle commands](https://docs.gradle.org/current/userguide/tutorial_gradle_command_line.html).

## Other Tools

[Postman](https://www.getpostman.com/) - REST API GUI tool for development. "A powerful GUI platform to make your API
development faster & easier, from building API requests through testing, documentation and sharing."

[pgAdmin](https://www.pgadmin.org/) - PostgreSQL UI tool that you can connect to the PostgreSQL Docker container
while it's running in the stack. This makes admin and development easier than connecting to the Docker container on the
command line.

[Kitematic](https://kitematic.com/) - Docker UI tool that helps seeing what containers are running, easily
accessing the logs, and other useful things. This should automatically detect any running Docker containers and allow
you to easily access them.

---

Check out my [personal site](https://andrewboutin.com)!
