package dio.homework.callendar.datastore.dao;

import dio.homework.callendar.Person;
import dio.homework.callendar.datastore.DataStore;

/**
 * Created by Димон on 20.07.2014.
 */
public class PersonDaoImpl extends AbstractDao<Person> implements PersonDao {
    private DataStore<Person> dataStore;
    public PersonDaoImpl(DataStore<Person> dataStore) {
        this.dataStore = dataStore;
    }
    @Override
    protected DataStore<Person> getDataStore() {
        return this.dataStore;
    }
}
