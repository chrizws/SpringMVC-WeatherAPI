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

https://github.com/user-attachments/assets/d205b85c-2b17-4813-a374-5abe1a01a1c4

- Deleting a row and record

https://github.com/user-attachments/assets/ee631c5c-d6aa-4472-b51e-824cc05799de

- Pagination

https://github.com/user-attachments/assets/d3254e18-d161-4a1f-b8fb-7f9c7236cffa

- Searching the table

https://github.com/user-attachments/assets/e34745e8-9cb0-457a-9c8d-bc37e289a618

- Sorting a column

https://github.com/user-attachments/assets/cfd35f54-6f5d-40e5-8794-f8406e645eb7




