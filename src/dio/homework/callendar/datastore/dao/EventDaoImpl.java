package dio.homework.callendar.datastore.dao;

import dio.homework.callendar.Event;
import dio.homework.callendar.datastore.DataStore;

/**
 * Created by Dmitry on 09.07.2014.
 */
public class EventDaoImpl extends AbstractDao<Event> implements EventDao {
    private DataStore<Event> dataStore;
    public EventDaoImpl(DataStore<Event> dataStore) {
        this.dataStore = dataStore;
    }
    @Override
    protected DataStore<Event> getDataStore() {
        return dataStore;
    }
}
