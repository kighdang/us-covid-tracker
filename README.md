# US Covid Data Tracker
App to pull data from the COVID Tracking Project's Data API and populate a postgres database

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Pre-requisites](#pre-requisites)
* [Setup](#setup)
* [Usage](#usage)
* [What's next](#whats-next)

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
2. Create a database schema named 'covid' with a table named 'states'. The 'states' table should have a column named 'name' as the primary key and a column named 'total_cases'.
  *  Log in to the postgres database that you have created using the `psql` command. 
  *  Enter in the command `CREATE TABLE states(name VARCHAR(25) PRIMARY KEY, total_cases int);` to create the table and its columns.
  
4. Run the Java Spring Boot app with the command ` 

## Usage
At the moment, the app only populates/updates the database with data from the COVID Tracking Project's Data API. The command will query the database to display the data

## What's next 
* Some code that will instantiate the 'states' table so that the user does not have to do it themselves to setup
* Some frontend to display the data 

