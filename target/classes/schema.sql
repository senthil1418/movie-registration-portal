CREATE DATABASE IF NOT EXISTS movie_registration_portal;

USE movie_registration_portal;

CREATE TABLE IF NOT EXISTS movie (
  id INT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(255) NOT NULL,
  genre VARCHAR(255) NOT NULL,
  release_date DATE NOT NULL
);