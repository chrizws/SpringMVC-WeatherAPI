# Spring MVC - Open Weather API

## Description

A simple web application created to demonstrate the use of interacting with OpenWeather API. 
Spring MVC was used to create REST endpoints that can retrieve, persist, and delete data locally. 


## Features

- Initial loading fetches all existing records from the database and populates it in the table
- Searching for a location also persists the entity into database
- OpenWeather API only returns forecast upto 3 days and details are populated dynamically by clicking the row
- Deleting a record on the front end also cascades the changes in the database
- Sorting, pagination, and table searching are implemented by DataTable

## Requirements
- API settings in applications.properties
```
weather.api = {key}
weather.url = http://api.weatherapi.com/
```
- add persistence.xml to change database information
```
<!--The driver class name"/-->
<property name="jakarta.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver" />
<!--The connection url"/-->
<property name="jakarta.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/weather" />
<!--DB login credentials"/-->
<property name="jakarta.persistence.jdbc.user" value="root" />
<property name="jakarta.persistence.jdbc.password" value="password" />
```

## Front-End
- HTML
- CSS
- JavaScript
- jQuery
- DataTable

## Back-End
- Spring MVC
- Hibernate ORM
- OpenFeign
- MySQL

## Examples
- Searching and inserting
  
https://github.com/user-attachments/assets/6eb584a0-060e-4311-a3c3-b938c1c4305d

- Deleting a row and record
  
https://github.com/user-attachments/assets/829501c8-9651-48de-b885-f9071d5e2e5e

- Searching and sorting
  
https://github.com/user-attachments/assets/0e6b64aa-abfd-4d91-b0eb-bb598c70e060

