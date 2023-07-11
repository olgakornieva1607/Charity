# Charity

Charity is a web application for donations.
The aim of the project is to create a platform where anyone can donate unwanted items to trusted institutions.

## Project Inspiration

Users often have items at home that they no longer need but are still in good condition. They want to donate these items to people who can make use of them, but they don't know how to do it easily.

While there are several available solutions, many of them require additional effort or lack trustworthiness. 
Verified locations may require travel, which is time-consuming or not feasible. 
On the other hand, local containers or collections are unverified, 
and there is no guarantee that the donated items will actually reach those in need.

## Technologies Used
- Java EE
- Spring Boot
- Spring Security
- Spring Data JPA
- Hibernate
- JSP
- MySQL

## Features

Administrator profile:
- login,
- management (CRUD) of administrators,
- management (CRUD) of trusted institutions,
- viewing, editing, deleting registered users,
- overview of donations.

User profile:
- registration,
- login,
- adding donations only after logging in,
- editing own profile,
- changing password.


## Project Setup

To set up and run the project locally, follow the instructions below:

- Clone the project repository from GitHub.
- Install the necessary dependencies and libraries specified in the project configuration.
- Configure the database connection and credentials in the application properties file.
- Build and run the project using your preferred IDE or build tools.
- Access the application through http://localhost:8080/
  

## Project Status

The project is currently in the development phase. 


## Room for Improvement

- viewing, editing, deleting donations,
- indicate that a donation has been given to someone (archiving),
- possibility to define donation statuses (deposited/received/transferred),
- confirmation of account activation by sending a message to the email address provided during registration,
- handling forgotten passwords,
- validation of two identical passwords,
- validation of the handling of administrators (e.g. no possibility of deleting the last existing administrator).

Home page

![index](https://github.com/olgakornieva1607/Charity/assets/108759950/d2e0dc85-d100-4be9-9d27-641f86eee18a)

Registration

![register](https://github.com/olgakornieva1607/Charity/assets/108759950/cb8b954d-75c0-4d94-84ee-e1f5b428426f)

Login

![login](https://github.com/olgakornieva1607/Charity/assets/108759950/dac56a2a-6e23-4d4b-a685-64030030c598)

Donate things you don't need.

Step 1: Mark what you want to donate

![form1](https://github.com/olgakornieva1607/Charity/assets/108759950/ec600f3e-a12a-46d6-a431-bc2884855e35)

Step 2: Enter the number of bags

![form2](https://github.com/olgakornieva1607/Charity/assets/108759950/34f1574b-92f9-44fe-a4e7-b336813bfd94)

Step 3: Select the institution you want to help

![form3](https://github.com/olgakornieva1607/Charity/assets/108759950/0fcf640b-f833-42c6-8c60-d71dd2595265)

Step 4: Enter the address and date for courier collection

![form4](https://github.com/olgakornieva1607/Charity/assets/108759950/330234f8-b59a-4f7a-869c-2762731394cd)

Step 5: The summury

![form5](https://github.com/olgakornieva1607/Charity/assets/108759950/e906706b-a8fe-4f47-bb33-2df47890f4b5)

Thank you for sending the form!

![form6](https://github.com/olgakornieva1607/Charity/assets/108759950/0cc3061b-d3a7-43ec-aa3d-4f6902f4ca94)


Administrator panel

<img width="1424" alt="admin panel" src="https://github.com/olgakornieva1607/Charity/assets/108759950/06f6df68-a12d-4dff-9611-e0013fbb153c">

User panel

<img width="1431" alt="user panel" src="https://github.com/olgakornieva1607/Charity/assets/108759950/ba53d398-6ebf-4842-a234-9860a91b8707">
















