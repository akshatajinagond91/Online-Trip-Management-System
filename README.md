# 🎯 Online Trip Management System



# REST API for an Online Trip Management System

- We have developed this REST API for an Online Trip Management System. This API performs all the fundamental CRUD operations of any Trip Management Application platform with user validation at every step.
- This project is developed by team of 3 Back-End Developers during project week in Masai School.

## Tech Stack

- Java
- Spring Framework
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- PostMan
- Swagger
- Lombok


<p>
   
   
   
   
   <img src="https://img.icons8.com/color/64/000000/mysql.png" />
   <img src="https://img.icons8.com/color/64/000000/java.png" />
   <img src="https://logodix.com/logo/34937.png" alt="aws" width="60" height="60"/>
    <br> </br>
    
   <img src="https://www.vectorlogo.zone/logos/git-scm/git-scm-icon.svg" alt="git" width="60" height="60" />
   <a>_</a>
   <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRbl9B2yl7iTuYk4JCAFSTuytuYidlQk_h4pmyt_1EJrwyyIsk5Qcwlh6q2_pbATZr2_lg&usqp=CAU" alt="laravel" width="60" height="60"/>
    <a>_</a>
   <img src="https://design.jboss.org/hibernate/logo/final/hibernate_logo_whitebkg_stacked_256px.png" alt="git" width="60" height="60" />
    <a>_</a>
   <img src="https://w7.pngwing.com/pngs/330/684/png-transparent-spring-framework-software-framework-model-view-controller-web-framework-java-pepper-robot-text-logo-opensource-software-thumbnail.png" alt="git" width="60" height="60" />
   <a>_</a>
   <img src="https://res.cloudinary.com/startup-grind/image/upload/c_fill,dpr_2.0,f_auto,g_center,h_1080,q_100,w_1080/v1/gcs/platform-data-dsc/events/spring-boot-1_5zDxm9B.jpg" alt="git" width="60" height="60" />
   
</p>

## Modules

- Login, Logout Module
- User Module
- Admin Module
- Booking Management Module
- Feedback Module
- Report Module
- Trip Package Management Module
- Route Mangement Module

## Features

- User and Admin authentication & validation with session uuid having.
- Admin Features:
  - Administrator Role of the entire application
  - Only registered admins with valid session token can add/update/delete Package,Hotel,Route or customer from main database.
  - Admin can access the details of different Routes, Bus, Packages, TicketDetails,Feedback,Customer,Reports,etc.
- User Features:
  - A user can register himself or herself on the platform.
  - He/She can check the Packages and Hotels availabilty.
  - If Trip Package is available, can book the trip package by providing payment details.
  - After booking, he will get booking details for the whole Package inside this there will be all details regarding the ticket details ,total cost, etc.
  - If the customer want can cancel the booking.

## Contributors

- [@Akshata Jinagond]
- [@Mayank Dagar]
- [@Yash Bhindia]

## Installation & Run

- Before running the API server, you should update the database config inside the [application.properties] file.
- Update the port number, username and password as per your local database config.

```
    server.port=8888

    spring.datasource.url=jdbc:mysql://localhost:3306/tmsdb;
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.username=root
    spring.datasource.password=root

```


ER diagram=========
![image](https://user-images.githubusercontent.com/105930703/201670525-6a67228a-b2af-49db-a409-acf8e34595e2.png)


## API Root Endpoint

`https://localhost:8080/`

`http://localhost:8080/swagger-ui/`

## API Module Endpoints

### Login Module

- `POST //api/adminlogin` : Admin can login with mobile number and password provided at the time of registation
<!--

### User Module

- `POST /customer/login` : Logging in customer with valid mobile number & password
- `GET /customer/availablecabs` : Getting the list of all the available cabs
- `GET /customers/cabs` : Getting All the cabs
- `GET /customers/checkhistory` : Getting the history of completed tr
- `PUT /customer/update/{mobile}` : Updates customer details based on mobile number
- `PATCH /customer/updatepassword/{mobile}` : Updates customer's password based on the given mobile number
- `POST /customer/booktrip` : Customer can book a cab
- `POST /customer/updatetrip` : Customer can modify or update the trip
- `POST /customer/logout` : Logging out customer based on session token
- `DELETE /customer/delete` : Deletes logged in user
- `DELETE /customer/complete/{tripid}` : Completed the trip with the given tripid
- `DELETE /customer/canceltrip` : Cancel the trip with the given tripid

### Admin Module

- `POST /admin/register` : Register a new admin with proper data validation and admin session
- `POST /admin/login` : Admin can login with mobile number and password provided at the time of registation
- `GET /admin/logout` : Logging out admin based on session token
- `GET /admin/listoftripsbycustomer` : Get list of trips of by a customer id
- `GET /admin/listoftrips` : Get list of trips of all the trips
- `GET /admin/listocustomers` : Get list of all the customers
- `GET /admin/listodrivers` : Get list of all the drivers
- `PUT /admin/update/{username}` : Updates admin detaisl by passed user name
- `DELETE /admin/delete` : Deletes the admin with passed id -->

### Sample API Response for Admin Login

`POST localhost:8080/login/adminlogin`

- Request Body

```
    {
        "mobileNo": "7056319981",
        "password": "Clickme@007"
    }
```

- Response

```
   CurrentAdminSession(id=11, adminId=10, uuid=ZaVLaK, localDateTime=2022-08-17T11:13:42.772910500)

```


### E-R Diagram Of Online Trim Management System Application

---

![Blank diagram](https://user-images.githubusercontent.com/99980405/201159077-e91af9d3-6e61-4e0c-b6c3-840e2e0678a8.png)

---

