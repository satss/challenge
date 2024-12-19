# Quotes Challenge
The application is a simple CR application for managing quotes, built with Spring Boot and MYSQL8.

## Pre-requisites
* docker
* docker-compose
* java 21 jdk

## Running the application
* Run `docker-compose up -d` to start the mysql instance
    * The mysql instance will be initialized with a challenge database and schemas (authors and quotes) are loaded via `db_init/setup.sql` script
* Run `mvn spring-boot:run` to start the application

## Docs
  * Currently, the http requests are inside docs folder, for now we have created two users, one with permission to write and read and another to read only.


## Test
 * Tests are not included as of right now


