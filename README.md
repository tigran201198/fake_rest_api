# Fake REST API Test Framework

This repository represents a **Test Task for Fake Rest API** designed to demonstrate basic project setup, structure, and functionality.

## Table of Contents

- [Project Overview](#project-overview)
- [Architecture Overview](#architecture-overview)
- [Tools Used](#tools-used)
- [Project Setup](#project-setup)
- [Running the Tests](#running-the-tests)
- [CI Pipeline](#ci-pipeline)

## Project Overview
This is test demo project to verify certain functionality of Fake Rest API web service. It uses Java, Gradle, RestAssured, Cucumber and JUnit to manage and run the test scenarios. The main task is to build a maintainable and extendable test automation framework following SOLID, DRY, and KISS principles as well as add comprehensive reporting and CI pipeline.

## Architecture Overview
The project follows a layered architecture to ensure modularity, scalability, and ease of maintenance. The main components of the test automation framework are described below:

### 1. **BDD Layer**
This layer contains all the features and scenarios written using Cucumber. Each scenario is created based on the following principles:
- **Atomic**: Each scenario checks specific flow of the rest endpoint and tests the smallest part of the functionality possible (Given/When/Then or Arrange/Act/Assert).
- **Independent**: Each scenario sets up test data independently making sure they can be executed in isolation.
- **Parametrization**: Some of the scenarios are created as scenario outlines making sure various input conditions producing similar outcomes are flexible.
- **Thread safe**: All the scenarios do not rely on each other in terms of test data and execution making sure test data is individual for each of them. This prevents scenarios from race condition when running them in parallel.
### 2. **Step Definitions**
This layer maps all the BDD steps from Cucumber Scenarios to Java executable code. Each of the step is atomic and performs a single action. The data is shared between steps using build-in Cucumber dependency injection tool Picocontainer. There is a hooks class, where current scenario is set to scenario context to ensure proper injection of the scenario to ApiClient to have API interactions logged.
### 3. **API Clients**
This layer is based on high level API client performing base CRUD operations with different types of entities available in the web service. It is configured to be generic to be extended by specific API clients for each entity type configuring data type to be operated with and base path of the resources for the domain.
### 4. **Test Data Generators**
This layer generates test entities with randomized values. Is accessed in Step Definitions layer storing data in test context and calling API Clients based on data populated.
### 5. **Utilities Layer**
- **Environment Properties**: helps to retrieve various properties from different configurations using Owner framework. Is extendable if any new environments or additional configurations are available in the future.
- **Random Utils**: helps to generate thread-safe random data to be populated in the API provided for numeric and alphabetic values.
- **Reflection Utils**: helps to override object properties based on the values shared from feature scenarios.
- **Scenario Filter**: helps to log API interactions including requests and responses sent/received to/from API endpoints to scenario and appear in test reports later.
### 6. **Configuration Layer**
Creates configuration instances representing different values from property files based on the environment currently selected for test run. Uses Owner framework for it.
### 7. **Reporting**
- **Gradle Cucumber Report**: plugin is used as a reporter for the framework. It automatically runs after **test** task of Gradle and generates pretty HTML report based on JSON test results written by default Cucumber reporter.

## Tools Used

- **Java 21**: Core programming language.
- **Gradle 8.5**: Dependency management and build automation tool, might not be installed on the work station, and code be executed using Gradle wrapper (Gradlew file).
- **JUnit**: Test framework used for executing test cases.
- **Cucumber**: BDD framework used for writing test cases in BDD format.
- **Gradle Cucumber Reporting**: Reporting tool to generate detailed reports on the Cucumber test results.
- **RestAssured**: REST Client for Java allowing to work with HTTP methods of REST based web services.
- **Git**: Distributed version control system that tracks versions of files
- **Lombok**: Annotations library to automatically generate boilerplate methods as getters, setters, constructors, etc.
- **AssertJ**: Assertions library for fluent assertions.
- **Owner**: Framework for simplification of working with property files.
- **Apache Commons Lang3**: Utilities to work with strings, and reflection.

## Project Setup

### Prerequisites

Make sure you have the following installed on your machine:

- Java 21
- Git (to clone the repository)

### Clone the Repository

To clone the repository, use the following command:

```bash
git clone https://github.com/tigran201198/fake_rest_api.git
cd fake_rest_api 
```
### Install dependencies, run all scenarios and generate test report
```bash
./gradlew clean build test
```

### Access HTML report (Open overview-features.html in browser)
```bash
cd build/cucumber-report/cucumber-html-reports
```

## CI Pipeline
The project uses GitHub Actions for CI pipeline. It is triggered on each push and runs every midnight including the following steps:

- Checkout the code.
- Set up JDK 21.
- Grant execute permissions for gradlew.
- Run all tests.
- Publish Cucumber HTML reports. The report can be downloaded as a build artifact.
- The pipeline configuration can be viewed in the .github/workflows folder.
