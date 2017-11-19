# Micro-services Architecture REST API

This comprises a Spring Boot REST API built with Gradle and a PostgreSQL database. Both are ran inside of Docker
containers in a Docker stack.

Eventually this will have other components such as UI, Gateway, 2nd REST API, Auth, and Cache added to it.

## Requirements

Install Docker.

Enable Docker experimental features (swarm).

Run `docker swarm init` - Initialize a swarm.

Run `docker network create --scope=swarm --driver overlay micro-network` - Creates a network that can span multiple
hosts.

## Commands

### Docker Stack running REST API and Postgres

1. `./gradlew build` - Produce local .jar of the Spring Boot application.
2. `docker build -t bbs/rest_api .` - Create the Docker image for our REST API.
3. `docker build -t bbs/db postgres/.` - Create the Docker image for our PostgreSQL.
4. `docker stack deploy -c micro-services-stack.yml micro-stack` Start up the stack which starts both the containers.

- `docker stack rm micro-stack` - Tear down the stack.

### Other Useful Information

`./gradlew bootRun` - Use the Gradle Wrapper to build and run the Spring Boot application locally.

[Docker stack commands](https://docs.docker.com/engine/reference/commandline/stack/).

[Gradle commands](https://docs.gradle.org/current/userguide/tutorial_gradle_command_line.html).

## Other

[Postman](https://www.getpostman.com/) - REST API GUI tool for development. "A powerful GUI platform to make your API
development faster & easier, from building API requests through testing, documentation and sharing."

[pgAdmin](https://www.pgadmin.org/) - PostgreSQL UI tool that you can connect to the PostgreSQL Docker container
while it's running in the stack. This makes admin and development easier than connecting to the Docker container on the
command line.

[Kitematic](https://kitematic.com/) - Docker UI tool that helps seeing what containers are running, easily
accessing the logs, and other useful things. This should automatically detect any running Docker containers and allow
you to easily access them.
