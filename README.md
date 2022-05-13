# easylearn_books_be

[![Codacy Badge](https://app.codacy.com/project/badge/Grade/a46eb33a8a4a4d87853a3aeaad137d60)](https://www.codacy.com/gh/nicugnm/easylearn_books_be/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=nicugnm/easylearn_books_be&amp;utm_campaign=Badge_Grade)
[![Codacy Badge](https://app.codacy.com/project/badge/Coverage/a46eb33a8a4a4d87853a3aeaad137d60)](https://www.codacy.com/gh/nicugnm/easylearn_books_be/dashboard?utm_source=github.com&utm_medium=referral&utm_content=nicugnm/easylearn_books_be&amp;utm_campaign=Badge_Grade)

EasyLearn-Books-Backend is part of EasyLearn and is the microservice which controlls books modifications of the backend application.

Stack used for the project is:

* Java 17
* Spring with Spring Boot, 2.6.7
* Spring Native 0.11.4 & GraalVM Support
* Postgres Database 14.1
* Flyway
* Docker with docker-compose and Dockerfile
* DAOs
<!--* Mocked Tests are maked with Mockito and JUnit 5
* JaCoCo Plugin 0.8.8
* MapStruct Plugin 1.4.2-Final
* OpenFeign 3.1.1
* DTOs-->
* Codacy for analyze, quality code and coverage tests
* Github Actions

When I writed code, I was careful to avoid some [pitfalls](https://thorben-janssen.com/lombok-hibernate-how-to-avoid-common-pitfalls/):
- Don’t Use @EqualsAndHashCode
- Be Careful with @ToString (Not use on @OneToMany and @ManyToOne)
- Avoid @Data
- Every Entity class should implement Serializable
