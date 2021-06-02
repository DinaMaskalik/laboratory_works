package service;

import entity.Hotel;
import repository.HotelDao;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class HomeService {

    @EJB
    HotelDao hotelDao;

    public List<Hotel> getAllHotel(){
        return hotelDao.getAllHotel();
    }


}
