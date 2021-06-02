package service;

import repository.HotelDao;

import javax.ejb.EJB;
import javax.ejb.Stateful;

@Stateful
public class DeleteService {

    @EJB
    HotelDao hotelDao;

    public void deleteHotel(String id){
        hotelDao.deleteHotel(id);
    }
}
