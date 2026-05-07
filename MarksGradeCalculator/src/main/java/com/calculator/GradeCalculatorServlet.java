package com.calculator;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/CalculateGrade")
public class GradeCalculatorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("index.html");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String[] marksStr = request.getParameterValues("marks");
        
        if (marksStr == null || marksStr.length == 0) {
            response.sendRedirect("index.html");
            return;
        }

        int[] marks = new int[marksStr.length];
        int total = 0;
        boolean failedInSubject = false;

        try {
            for (int i = 0; i < marksStr.length; i++) {
                marks[i] = Integer.parseInt(marksStr[i]);
                total += marks[i];
                if (marks[i] < 40) {
                    failedInSubject = true;
                }
            }
        } catch (NumberFormatException e) {
            out.println("<h3>Invalid input. Please enter numeric values for marks.</h3>");
            return;
        }

        double percentage = total / 500.0 * 100;
        String grade;
        String status = failedInSubject ? "FAIL" : "PASS";

        if (failedInSubject || percentage < 40) {
            grade = "F";
            status = "FAIL";
        } else if (percentage >= 90) {
            grade = "O";
        } else if (percentage >= 80) {
            grade = "A+";
        } else if (percentage >= 70) {
            grade = "A";
        } else if (percentage >= 60) {
            grade = "B+";
        } else if (percentage >= 50) {
            grade = "B";
        } else {
            grade = "C";
        }

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Result Card</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; margin: 40px; background-color: #f4f4f9; }");
        out.println(".result-container { max-width: 600px; background: #fff; padding: 20px; border-radius: 8px; box-shadow: 0 0 10px rgba(0,0,0,0.1); margin: auto; }");
        out.println("h2 { text-align: center; color: #333; }");
        out.println("table { width: 100%; border-collapse: collapse; margin-top: 20px; }");
        out.println("th, td { border: 1px solid #ddd; padding: 12px; text-align: left; }");
        out.println("th { background-color: #007bff; color: white; }");
        out.println(".summary-row { font-weight: bold; background-color: #f8f9fa; }");
        out.println(".pass { color: green; font-weight: bold; }");
        out.println(".fail { color: red; font-weight: bold; }");
        out.println(".back-link { display: block; text-align: center; margin-top: 20px; text-decoration: none; color: #007bff; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='result-container'>");
        out.println("<h2>Student Result Card</h2>");
        out.println("<p><strong>Student Name:</strong> " + name + "</p>");
        out.println("<table>");
        out.println("<tr><th>Subject</th><th>Marks Obtained</th></tr>");
        for (int i = 0; i < marks.length; i++) {
            out.println("<tr><td>Subject " + (i + 1) + "</td><td>" + marks[i] + "</td></tr>");
        }
        out.println("<tr class='summary-row'><td>Total Marks</td><td>" + total + " / 500</td></tr>");
        out.println("<tr class='summary-row'><td>Percentage</td><td>" + String.format("%.2f", percentage) + "%</td></tr>");
        out.println("<tr class='summary-row'><td>Grade</td><td>" + grade + "</td></tr>");
        out.println("<tr class='summary-row'><td>Status</td><td class='" + status.toLowerCase() + "'>" + status + "</td></tr>");
        out.println("</table>");
        out.println("<a href='index.html' class='back-link'>Go Back</a>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}
