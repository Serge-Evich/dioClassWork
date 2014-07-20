package dio.homework.callendar.datastore.service;

import dio.homework.callendar.Person;
import dio.homework.callendar.datastore.Operations;
import dio.homework.callendar.datastore.dao.PersonDao;
import dio.homework.callendar.datastore.dao.PersonDaoImpl;

/**
 * Created by Димон on 20.07.2014.
 */
public class PersonServiceImpl extends AbstractService<Person> implements PersonService {
    private PersonDao personDao;
    public PersonServiceImpl(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Override
    protected PersonDao getDao() {
        return this.personDao;
    }
}
