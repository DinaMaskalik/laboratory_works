package controller;

import entity.Hotel;
import service.DeleteService;
import service.FindHotelService;
import service.HomeService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Hotel Servlet", urlPatterns = "/hotel")
public class HotelServlet extends HttpServlet {

    private List<Hotel> hotels = null;

    @EJB
    private HomeService homeService;

    @EJB
    private FindHotelService findHotelService;

    @EJB
    private DeleteService deleteService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        hotels = null;
        String btn_delete = req.getParameter("btn_delete");

        if(btn_delete!=null){
            deleteService.deleteHotel(btn_delete);
        }

        req.setAttribute("hotels", homeService.getAllHotel());

        getServletContext().getRequestDispatcher("/hotel.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        hotels = findHotelService
                .findHotel(
                        Double.parseDouble(req.getParameter("maxCost"))
                );

        req.setAttribute("findHotels", hotels);
        req.setAttribute("hotels", homeService.getAllHotel());

        getServletContext().getRequestDispatcher("/hotel.jsp").forward(req, resp);

    }
}
