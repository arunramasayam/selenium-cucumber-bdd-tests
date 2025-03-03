 # Xaltsocnportal Assignment

This repository contains the automation testing suite for the **XALTSOCN Portal Assignment**, developed using **Selenium WebDriver, TestNG, and BDD Cucumber**.

## Technologies Used
- **Java JDK 21**
- **Maven** for dependency management
- **Selenium WebDriver** for browser automation
- **TestNG** as the test framework
- **Cucumber (BDD)** for behavior-driven testing

## Setup Instructions

### Prerequisites
Ensure you have the following installed:
- [Java JDK 21](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html)
- [Apache Maven](https://maven.apache.org/)
- IntelliJ IDEA or Eclipse (Recommended IDEs)

### Clone the Repository
```sh
git clone https://github.com/yourusername/xaltsocnportal-assignment.git
cd xaltsocnportal-assignment/Automation
```

### Run Tests
#### 1. Run Tests Using Maven
```sh
mvn clean test
```

#### 2. Run Tests Using TestNG (From IDE)
- Right-click on `testng.xml` and select **Run as TestNG Suite**

#### 3. Run Tests Using Cucumber (From IDE)
- Execute the runner class `CucumberTestRunner.java`

## Test Reports
- After test execution, reports are generated in:
  ```
  target/surefire-reports/      # Default TestNG reports
  target/cucumber-reports.html
  ```


