package dio.homework.callendar;

import java.util.Date;
import java.util.List;

/**
 * Created by Димон on 06.07.2014.
 */
public interface CallendarService {
    void addEvent(Event event);
    Event createEvent(String description, List<Person> emails);
    Event createEvent(String title, String description, List<Person> attenders, Date startDate, Date endDate);
    Event removeEvent(String title);
    List<Event> getEventList();


}
