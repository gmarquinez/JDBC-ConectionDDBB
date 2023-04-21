DROP DATABASE IF EXISTS biblioteca;
CREATE DATABASE biblioteca;
USE biblioteca;

CREATE TABLE biblioteca(
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL
);

CREATE TABLE libros(
   id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
   id_biblioteca INT,
   isbn VARCHAR(20) NOT NULL,
   titulo VARCHAR(100) NOT NULL,
   autor VARCHAR(100) NOT NULL,
   editorial VARCHAR(100) NOT NULL,
   numcopias INT NOT NULL,
   numcopiasdisponibles INT NOT NULL,
   FOREIGN KEY (id_biblioteca) REFERENCES biblioteca (id)
 );

CREATE TABLE personas (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  id_biblioteca INT,
  nombre VARCHAR(30) NOT NULL,
  apellido VARCHAR(30) NOT NULL,
  nif VARCHAR(9),
  contrasenya VARCHAR(100),
  FOREIGN KEY (id_biblioteca) REFERENCES biblioteca (id)
);