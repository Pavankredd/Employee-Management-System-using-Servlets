package Controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.Employee;
import Service.EmpService;

@WebServlet(value = "/submit")
public class EditEmp extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Get the parameters from the form
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String email = req.getParameter("emailid");
        String salary = req.getParameter("salary");

        // Convert string inputs to the required data types
        int ids = Integer.parseInt(id);
        int agess = Integer.parseInt(age);
        int salarys = Integer.parseInt(salary);

        // Create an Employee object with the updated details
        Employee e = new Employee(ids, name, agess, email, salarys);

        // Instantiate the EmpService to update the employee details
        EmpService empService = new EmpService();
        int res = empService.update(e);

        // If the update is successful, forward to the Welcome page
        if (res != 0) {
            RequestDispatcher rsdp = req.getRequestDispatcher("Welcome.html");
            rsdp.include(req, resp);
        } else {
            RequestDispatcher rsdp = req.getRequestDispatcher("editform.html"); // You can use a custom page like "errorMessage.jsp"
            rsdp.include(req, resp);
        }
    }
}