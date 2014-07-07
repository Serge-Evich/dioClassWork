package dio.homework.callendar;

import java.util.Date;
import java.util.List;
import java.util.Collection;

/**
 * Created by Димон on 06.07.2014.
 */
public interface CallendarService {
    void addEvent(Event event);
    Event createEvent(String description, List<String> emails);
    Event createEvent(String title, String description, List<String> attenders, Date startDate, Date endDate);
    //void removeEvent(T event);
    Collection<Event> getEventCollection();

}
