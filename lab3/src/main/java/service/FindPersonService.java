package service;

import entity.Person;
import repository.PersonDao;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class FindPersonService {

    @EJB
    PersonDao personDao;

    public Person findPerson(String id){
        return personDao.findPerson(id);
    }
}
