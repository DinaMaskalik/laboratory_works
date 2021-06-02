package repository;

import entity.Person;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionUtil;

import javax.ejb.Stateful;
import java.util.List;

@Stateful
public class PersonDao {

    public Person findPerson(String id) {
        final Session session = HibernateSessionUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        Person person = null;

        try {
            if (session.isDirty())
                session.flush();
            transaction = session.beginTransaction();
            person = session.get(Person.class, id);

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
        } finally {
            session.close();
        }

        return person;
    }

}
