package dio.homework.callendar;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;


public interface CallendarService {
    void addEvent(Event event);
    Event createEvent(String description, List<Person> attenders);
    Event createEvent(String title, String description, List<Person> attenders, GregorianCalendar startDate, GregorianCalendar endDate);
    Event createEvent(String title, String description, List<Person> attenders, GregorianCalendar startDate);
    Event removeEvent(String title);
    List<Event> getEventList();
    List<Event> getPersonEvents(Person person, GregorianCalendar startDate, GregorianCalendar endDate);
    List<Event> getPersonEvents(Person person);
    boolean isPersonFree(Person person, GregorianCalendar startDate, GregorianCalendar endDate);
}
