# Airline Management System

The **Airline Management System** is a Java Swing desktop application designed to manage passengers, flights, reservations, journey details, boarding passes, and ticket cancellations. This version has been prepared for academic submission with a reproducible build process, portable dependencies, a database setup script, and a clearly documented application entry point.

## Project Overview

The application represents a basic airline reservation workflow. An operator can sign in, register passenger information, view available flights, book a journey, retrieve reservation details, generate a boarding pass, and cancel a reservation when necessary.

The project follows a modular desktop architecture. Java Swing and AWT are used to build the graphical user interface, JDBC manages communication with the database, MySQL stores the application data, and Apache Ant builds the NetBeans project. The main application class is `airlinemanagementsystem.AirlineManagementSystem`.

## Features

The system provides the following features:

- Username and password authentication
- Passenger registration with personal and contact information
- Flight listing and route-based flight searches
- Reservation creation with unique PNR and ticket numbers
- Journey-detail searches using a PNR number
- Boarding-pass display
- Ticket cancellation with a recorded cancellation entry
- A reusable JDBC-based table model for displaying database records
- Database configuration through environment variables

## Technology Stack

| Layer | Technology |
|---|---|
| User interface | Java Swing and AWT |
| Programming language and runtime | Java 17 or later |
| Database | MySQL 8 or a compatible server |
| Database connectivity | JDBC with MySQL Connector/J |
| Build system | Apache Ant and NetBeans project configuration |
| Calendar component | JCalendar |

## Project Structure

```text
AirlineManagementSystem/
├── database/schema.sql                         Database schema and sample data
├── lib/                                        Portable third-party JAR files
├── src/airlinemanagementsystem/
│   ├── AirlineManagementSystem.java            Application entry point
│   ├── Login.java                              Authentication screen
│   ├── Home.java                               Main navigation screen
│   ├── AddCustomer.java                        Passenger registration screen
│   ├── FlightInfo.java                         Flight listing screen
│   ├── BookFlight.java                         Reservation screen
│   ├── JourneyDetails.java                     PNR lookup screen
│   ├── BoardingPass.java                       Boarding-pass screen
│   ├── Cancel.java                             Ticket-cancellation screen
│   ├── Conn.java                               JDBC connection helper
│   └── ResultSetTableModel.java                JDBC-to-Swing table adapter
├── nbproject/                                  NetBeans build configuration
├── build.xml                                   Apache Ant build file
└── dist/                                       Generated JAR file
```

## Requirements

To build and run the project, install the following software:

- Java Development Kit 17 or later
- Apache Ant
- MySQL 8 or a compatible MySQL server

The required Java libraries are included in the `lib/` directory. As a result, the project does not depend on absolute file paths from the original developer’s computer.

## Database Setup

Follow these steps to prepare the database:

1. Start the MySQL server.
2. Open MySQL Workbench or the MySQL command-line client.
3. Execute the `database/schema.sql` script.
4. The script will create the `airlinemanagementsystem` database and its tables.
5. The script will also insert sample flight records and a demo login account.

The default demonstration credentials are:

```text
Username: admin
Password: admin123
```

If your MySQL installation uses different connection details, set the following environment variables before starting the application:

```bash
export AIRLINE_DB_URL='jdbc:mysql://localhost:3306/airlinemanagementsystem?serverTimezone=UTC'
export AIRLINE_DB_USER='root'
export AIRLINE_DB_PASSWORD='your_mysql_password'
```

The application reads these values at runtime instead of storing a machine-specific database password in the source code.

## Building and Running the Application

Open a terminal in the project’s root directory and run:

```bash
ant clean jar
java -cp "lib/*:dist/AirlineManagementSystem.jar" airlinemanagementsystem.AirlineManagementSystem
```

On Windows, use a semicolon to separate the classpath entries:

```bat
ant clean jar
java -cp "lib/*;dist/AirlineManagementSystem.jar" airlinemanagementsystem.AirlineManagementSystem
```

The project can also be opened in NetBeans as an existing Ant project. When running the application, start the `AirlineManagementSystem` class instead of launching an individual screen.

## Academic Submission Notes

This project is intended for educational use. The authentication system is deliberately simple so that the application workflow is easy to demonstrate. It should not be used in a production environment without additional security improvements.

A production-ready version should hash passwords, implement role-based access control, use proper date and time data types, maintain an audit log, and move database operations into a dedicated service layer.

The submitted version includes several improvements to the original project. These improvements include a corrected application launcher, removal of the unavailable `rs2xml` dependency, replacement of absolute Windows library paths with portable project-relative paths, addition of a complete database schema, configurable database connections, and prepared-statement-based login verification.

## Limitations and Future Scope

The application currently uses a traditional Swing interface and retains some legacy absolute-position layout code from the original project. Future improvements could include the following:

- Replacing absolute positioning with modern layout managers
- Adding stronger input validation
- Hashing and securely managing passwords
- Using typed date fields in the database
- Adding transaction handling for booking and cancellation operations
- Introducing role-based access control
- Adding automated unit and integration tests
- Developing a REST API and a web-based client

## License

This project is provided for educational purposes.


