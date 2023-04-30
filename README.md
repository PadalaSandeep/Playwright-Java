
# Playwright-Java-TestNG-AllureReporting

The project aims to automate end-to-end tests for a web application using Playwright-Java, TestNG, and Allure Reporting. Playwright-Java is a Java library that provides fast, reliable, and stable automation of web pages across all modern browsers, and is based on the popular Node.js Playwright library. Java is used as the programming language to write the test scripts, while TestNG is a testing framework that provides various features such as parallel execution, test dependencies, and assertions. Allure Reporting is a tool that generates comprehensive and interactive reports with rich visuals and insights. The project utilizes the combination of these tools to automate test cases for web application functionality, ensuring its quality and reliability. With Allure Reporting, the test results are presented in a visually appealing manner, allowing stakeholders to quickly grasp the state of the application's testing. The project thus enables the development team to detect defects early in the development cycle, reduce the testing time, and improve overall software quality.

## Features

- Allure Reporting with screenshots
- Parallel execution
- End-to-End testing
- Page object model
- Data management using json format


## Tech Stack

**Frameworks:** Playwright, TestNG

**Language:** Java

**Reporting:** Allure-Reporting


## Usage/Examples

```java
public class SamplePlaywrightTest extends BaseTest {

    @Test
    public void testSearch() {
        Page page = PlaywrightObjectsHolder.getPage();
        page.navigate("https://www.google.com/");
        page.fill("#searchform input[name='q']", "Playwright");
        page.press("#searchform input[name='q']", "Enter");
        assertEquals(page.title(), "Playwright - Google Search");
    }
}
```

