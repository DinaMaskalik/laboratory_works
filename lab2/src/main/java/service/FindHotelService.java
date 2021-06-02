package service;

import entity.Hotel;
import repository.HotelDao;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class FindHotelService {

    @EJB
    HotelDao hotelDao;

    public List<Hotel> findHotel(double cost){
        return hotelDao.findHotel(cost);
    }
}
