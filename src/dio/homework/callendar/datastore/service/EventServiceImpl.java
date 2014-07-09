package dio.homework.callendar.datastore.service;

import dio.homework.callendar.Event;
import dio.homework.callendar.datastore.Operations;
import dio.homework.callendar.datastore.dao.EventDao;


/**
 * Created by Dmitry on 09.07.2014.
 */
public class EventServiceImpl extends AbstractService<Event> implements EventService {
    private EventDao eventDao;
    public EventServiceImpl(EventDao eventDao) {
        this.eventDao = eventDao;
    }
    @Override
    protected EventDao getDao() {
        return eventDao;
    }
}
