# Music Hub Java Application

This console application allows users to interact through a menu to manage singer and song data. Users can register singer information, song details and search for songs by singers

## Features

1. **Register Singer Data**: Users can register information about singers including their name, genre, and other details.

2. **Register Song Data**: Users can add details of songs including title, release year, and singer information.

3. **Search Songs by Singers**: Users can search for songs based on the singer's name.

Technologies Used

Java 17 with Spring Data JPA

Database: PostgreSQL

## Setup

Create a `.env` file in the root directory of the application and add the following database connection configuration:

```properties
DB_HOST=
DB_NAME=
DB_USERNAME=
DB_PASSWORD=
```

**Ensure that the database connection details in the .env file are correctly filled in before running the application.**

* DB_HOST: It is the host or the IP address of the database server that the application will connect to in order to access the data. Typically, this could be something like localhost if the database is on the same machine as the application, or the IP address of the database server if it is on a remote server.
* DB_NAME: This value corresponds to the specific name of the database that contains the tables and data that the application needs to function correctly.
* DB_USERNAME: It is the username that the application will use to connect to the database.
* DB_PASSWORD: It is the password associated with the username specified above.