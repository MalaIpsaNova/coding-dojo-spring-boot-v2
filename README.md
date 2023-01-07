Spring Boot Coding Dojo
---
### Change log
- added openapi (swagger) configuration, see http://localhost:8080/swagger-ui.html
- bump spring boot version to avoid recent security issues stated in National Vulnerability Database
- add postgres configuration
- reorder packages, introduce service layer, converters, model, repositories etc.
- add some Javadocs
- add some Unit Testing
- add application.properties file
- add yml file configuration and add to .gitignore

Welcome to the Spring Boot Coding Dojo!

### Introduction

This is a simple application that requests its data from [OpenWeather](https://openweathermap.org/) and stores the result in a database. The current implementation has quite a few problems making it a non-production ready product.

### The task

As the new engineer leading this project, your first task is to make it production-grade, feel free to refactor any piece
necessary to achieve the goal.

### How to deliver the code

Please send an email containing your solution with a link to a public repository.

>**DO NOT create a Pull Request with your solution** 

### Footnote
It's possible to generate the API key going to the [OpenWeather Sign up](https://openweathermap.org/appid) page.
