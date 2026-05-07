# Marks Grade Calculator

## Student Details

| Field         | Details                          |
|---------------|----------------------------------|
| Name          | Pankaj Kittad                    |
| USN           | 2BL24CS412                       |
| Branch        | Computer Science & Engineering   |
| Semester      | VI Semester                      |
| Subject       | Advanced Java Programming        |
| Problem No.   | Problem 11                       |

## Problem Statement

This application is a Marks Grade Calculator built using Java Servlets. It allows a user to input a student's name and marks for five different subjects. The Servlet calculates the total marks, percentage, and assigns a grade based on predefined thresholds. It also determines the Pass/Fail status, marking the student as "FAIL" if any subject mark is below 40.

## Technologies Used

- Java (Servlets - Jakarta Servlet 5.0)
- HTML, CSS (inline)
- Apache Tomcat 10
- Eclipse IDE

## How to Run This Project

1. Clone this repository or download the ZIP.
2. Import the project into Eclipse as a Dynamic Web Project.
3. Add Apache Tomcat 10 as the server in Eclipse.
4. Right-click project → Run As → Run on Server.
5. Open browser and go to: `http://localhost:8080/MarksGradeCalculator/index.html`

## Screenshots

### Input Form
<img width="1600" height="1000" alt="image" src="https://github.com/user-attachments/assets/6ce128ce-12a0-4004-bdc1-a3e5303b281e" />


### Output / Result Page
<img width="1600" height="1000" alt="image" src="https://github.com/user-attachments/assets/53a473af-b5af-49c5-b335-7a4deaf2676a" />


## Servlet Concept Practiced

This project demonstrates the use of **doGet/doPost** methods in a Java Servlet. The `doPost` method handles the form submission and processing of marks, while the `doGet` method provides a fallback mechanism to redirect users to the input form if the servlet is accessed directly via a URL.
