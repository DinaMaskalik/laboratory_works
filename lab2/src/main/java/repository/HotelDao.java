package repository;

import entity.Hotel;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionUtil;

import javax.ejb.Stateful;
import java.util.List;

@Stateful
public class HotelDao {

    public List<Hotel> getAllHotel() {
        final Session session = HibernateSessionUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        List<Hotel> hotels = null;

        try {
            if (session.isDirty())
                session.flush();
            transaction = session.beginTransaction();
            hotels = session.createQuery("from Hotel ", Hotel.class).list();
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
        } finally {
            session.close();
        }

        return hotels;
    }


    public List<Hotel> findHotel(double cost) {
        final Session session = HibernateSessionUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        List<Hotel> hotels = null;

        try {
            if (session.isDirty())
                session.flush();
            transaction = session.beginTransaction();
            hotels = session
                    .createQuery("from Hotel h where h.reservation = '1' and h.price <=" + cost, Hotel.class)
                    .list();
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
        } finally {
            session.close();
        }

        return hotels;
    }

    public void deleteHotel(String id) {
        final Session session =
                HibernateSessionUtil.getSessionFactory().openSession();

        Transaction transaction = null;

        try {
            if (session.isDirty())
                session.flush();

            transaction = session.beginTransaction();
            Hotel hotel = session.get(Hotel.class, id);
            session.delete(hotel);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
        } finally {
            session.close();
        }
    }
}
