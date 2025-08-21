# Selenium Cucumber BDD Automation Framework  

![Java](https://img.shields.io/badge/Java-21-blue.svg)
![TestNG](https://img.shields.io/badge/TestNG-Framework-brightgreen.svg)
![Selenium](https://img.shields.io/badge/Selenium-WebDriver-orange.svg)
![Cucumber](https://img.shields.io/badge/Cucumber-BDD-yellowgreen.svg)
![ExtentReports](https://img.shields.io/badge/Reports-Extent%20%26%20Cucumber-purple.svg)

## Overview  
This repository contains a **UI Test Automation Framework** built using **Selenium WebDriver, Cucumber (BDD), and TestNG**, with Maven for dependency management and HTML reporting.  

The framework is designed to:  
- Support **Behavior-Driven Testing (BDD)** with feature files.  
- Provide **cross-browser automation** using Selenium WebDriver.  
- Integrate with **TestNG** for parallel execution.  
- Generate detailed **HTML reports** (Cucumber + Extent).  
- Be **modular, maintainable, and easy to extend** for new test cases.  

---

## Tech Stack  
- **Java JDK 21**  
- **Maven** (build & dependency management)  
- **Selenium WebDriver** (UI automation)  
- **TestNG** (test execution & parallel runs)  
- **Cucumber (BDD)** (Gherkin feature files)  
- **Extent Reports / Cucumber HTML Reports** (reporting)  

---

## Project Structure  
```bash
+---src
|   +---main
|   |   +---java
|   |   |   \---com
|   |   |       \---xalts
|   |   |           |   DriverManager.java     
|   |   |           |   Main.java
|   |   |           |   
|   |   |           \---pages
|   |   |                   CommonAuthPage.java
|   |   |                   CommonMethods.java 
|   |   |                   Homepage.java      
|   |   |                   SignIn.java        
|   |   |                   SignUp.java        
|   |   |
|   |   \---resources
|   |
|   \---test
|       +---java
|       |   +---runners
|       |   |       CucumberTestRunner.java    
|       |   |       
|       |   \---stepDefinitions
|       |           CommonSteps.java
|       |           Hooks.java
|       |           SignInSteps.java
|       |           SignOutSteps.java
|       |           SignUpSteps.java
|       |
|       \---resources
|           |   testng.xml
|           |
|           \---features
|                   SignIn.feature
|                   SignUp.feature
```

## Setup Instructions  

### Prerequisites  
Ensure you have the following installed:  
- Java JDK 21+  
- Apache Maven  
- IntelliJ IDEA / Eclipse (Recommended IDEs)  

### Clone the Repository  
```sh
git clone https://github.com/arunramasayam/selenium-cucumber-bdd-tests
cd selenium-cucumber-bdd-tests
```  

### Run Tests  

#### 1. Run Tests Using Maven  
```sh
mvn clean test
```  

#### 2. Run Tests Using TestNG (From IDE)  
- Right-click on `testng.xml` → **Run as TestNG Suite**  

#### 3. Run Tests Using Cucumber (From IDE)  
- Run the `CucumberTestRunner.java` class  

---

## Test Reports  

- **Default TestNG Reports** → `target/surefire-reports/`  
- **Cucumber Report (HTML)** → `docs/cucumber-reports.html`  
- you can also view existing test reports online here:  
  ```
  https://<your-username>.github.io/selenium-cucumber-bdd-tests/cucumber-reports.html
  ```  

---

## Example Test Flow  
1. **Feature File** → Defines test scenario in Gherkin syntax.  
2. **Step Definitions** → Maps feature steps to Java methods.  
3. **Page Objects** → Encapsulates web page elements and actions.  
4. **Runner** → Executes scenarios with Cucumber + TestNG.  
5. **Reports** → Generates HTML reports for easy visualization.  

---

## Author  
**Arun Reddy**  
QA Automation Engineer | Selenium | Cucumber | TestNG | Java  
