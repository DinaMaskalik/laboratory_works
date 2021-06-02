package controller;

import entity.Person;
import service.FindPersonService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Person Servlet", urlPatterns = "/person")
public class PersonServlet extends HttpServlet {

    private Person person = null;

    @EJB
    private FindPersonService findPersonService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        person = null;

        getServletContext().getRequestDispatcher("/person.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        person = findPersonService
                .findPerson(
                        req.getParameter("id")
                );

        if (person != null) {

            req.setAttribute("findPersonId", "Person ID: " + person.getId());
            req.setAttribute("findPersonName", "Person name: " + person.getName());
            req.setAttribute("findPersonEmail", "Person email: " + person.getEmail());
            req.setAttribute("findPersonState", "Person state: " + person.getState());
        }else {
            req.setAttribute("findPersonId", "Not found");
        }

        getServletContext().getRequestDispatcher("/person.jsp").forward(req, resp);

    }
}
