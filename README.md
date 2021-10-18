# API Transation Manager - A REST API in Java 11, Spring, Hibernate and PostgreSQL

This is a REST API project, based on a challenge proposed by the company Somapay, which consists of creating a REST API that has functionalities to create companies, create employees, show company balance, show employee balance and transfer money from company to employee, using Java 11, Spring and PostgreSQL. However, some new features were created such as: Show all companies, show all company employees, delete company and delete company employee. To test all endpoints I chose to use Postman, here is the list of all endpoints:
<br/>
- Create company(Method POST): <code>localhost:8080/companies</code>
<br/>
- Show all companies(Method GET): <code>localhost:8080/companies</code>
<br/>
- Show a company(Method GET): <code>localhost:8080/companies/{id}</code>
<br/>
- Delete a company(Method DELETE): <code>localhost:8080/companies/{id}</code>
<br/>
- Create a employee(Method POST): <code>localhost:8080/companies/{id}/employees</code>
<br/>
- Show all employees(Method GET): <code>localhost:8080/companies/{id}/employess</code>
<br/>
- Show a employee(Method GET): <code>localhost:8080/companies/{id1}/employess/{id2}</code>
<br/>
- Delete a employee(Method DELETE): <code>localhost:8080/companies/{id1}/employess/{id2}</code>
<br/>
- Transferring company balance to an employee(Method PUT): <code>localhost:8080/companies/{id1}/employess/{id2}</code>
<br/>

Import the <code>somapay-api.postman_collection.json</code> file into your Postman to run.
<br/>

I learned a lot from this challenge! Hope you like it!

<br/>

## :zap: Starting

Before starting it is necessary some adjustments to connect to the Database:

In the following files: "transationmanager/src/main/resources/application-dev.properties", and "transationmanager/src/main/resources/application-test.properties" change:
<br/>

spring.datasource.url=jdbc:postgresql://localhost:5432/somapay_api
<br/>
spring.datasource.username=postgres
<br/>
spring.datasource.password=741852
<br/>

for:
<br/>

spring.datasource.url=jdbc:postgresql://localhost:5432/{your_data_base}
<br/>
spring.datasource.username={your_username}
<br/>
spring.datasource.password={your_password}

<br/>

## 🛠 Technologies

- [Java11](https://docs.oracle.com/en/java/javase/11/)
- [Spring](https://spring.io/)
- [Hibernate](https://hibernate.org/)
- [PostegreSQL](https://www.postgresql.org/)

<br/>

## :bust_in_silhouette: Author

<br/>

<a href="https://github.com/arthur-david">
<img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/53877762?v=4" width="100px;" alt=""/>
<br/>
<sub><b>Arthur David</b></sub></a>


Created with dedication by Arthur David ❤️ Contact me 👋🏽!

[![Linkedin Badge](https://img.shields.io/badge/-Arthur-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/arthur-david-bb9214142/)](https://www.linkedin.com/in/arthur-david-bb9214142/) 
[![Gmail Badge](https://img.shields.io/badge/-arthurdavid000@gmail.com-c14438?style=flat-square&logo=Gmail&logoColor=white&link=mailto:arthurdavid000@gmail.com)](mailto:arthurdavid000@gmail.com)