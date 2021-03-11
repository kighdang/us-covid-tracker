# US Covid Data Tracker
App to pull data from the COVID Tracking Project's Data API and populate a postgres database

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Pre-requisites](#pre-requisites)
* [Setup](#setup)
* [Usage](#usage)
* [What's next](#whats-next)
* [Acknowledgements](#acknowledgements) 

## General info
This project was started to help me become familiar with Java Spring Boot. It sends a GET request to the COVID Data Tracking Project's Data API and populates a postgres database with the JSON data that is returned. 

## Technologies
* Java (Spring Boot)
* SQL (postgres)
* TomCat Web Server 
* Postman

## Pre-requisites
* The user has all of the technologies listed above installed on their computer

## Setup
1. Ensure that all of the technologies listed above have been installed 
2. Download the repository into a directory on your computer
3. Create a database schema named 'covid' with a table named 'states'. The 'states' table should have a column named 'name' as the primary key and a column named 'total_cases'.
  *  Log in to the postgres database that you have created using the `psql` command. 
  *  Enter in the command `CREATE TABLE states(name VARCHAR(25) PRIMARY KEY, total_cases int);` to create the table and its columns.
  
4. Run the Java Spring Boot app using the command `java -jar target/demo-0.0.1-SNAPSHOT.jar`

## Usage
At the moment, the app only populates/updates the database with data from the COVID Tracking Project's Data API. To have the database update:
* Launch Postman 
* Send a get request to http://localhost:8080/app/v1. 

Then use the command `SELECT * FROM states;` to query the states table for the data in the database.

## What's next 
* Some code that will instantiate the 'states' table so that the user does not have to do it themselves to setup
* Some frontend to display the data 

## Acknowledgements
<a href="https://covidtracking.com/">The COVID Tracking Project
