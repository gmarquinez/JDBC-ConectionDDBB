# JDBC Conecction DATABASE #

This is an example project that demonstrates how to connect to a JDBC database using Java.

## Requeriments

Requirements to run the program:

+ Java
+ Maven 
+ Git
+ Docker 


## Usage

+ Download or clone this repository.
+ Run the `dockercompose.yml` found in the root of the project.
+ Modify the JDBC_URL, USERNAME, and PASSWORD constants in the 
 DatabaseConnection class to match your database configuration if necessary.
+ Run the Main class (application.java) in this case to test the connection to the database.

## Database
The SQL files are located insisde the folder

1. `01_create_tables.sql` The script contains the tables for creating the database
2. `02_fill_tables.sql` This script is used to add data to the database tables. 

## Troubleshooting
+ If you encounter a "ClassNotFoundException" when running the program, make sure that the JDBC driver JAR file is added to the classpath.
+ If you encounter a "SQLException" when running the program, check your database configuration and make sure that the URL, username, and password are correct.

## Resources.
[Connect Java Applications to MariaDB Using JDBC](https://mariadb.com/resources/blog/how-to-connect-java-applications-to-mariadb-using-jdbc/) 


## Authors

+ [Juan Tur](https://github.com/jtur17) 
+ [Gema Marquínez ](https://github.com/gmarquinez)
