package dio.homework.callendar;

import dio.homework.callendar.datastore.service.EventService;

import java.util.*;


public class CallendarServiceImpl implements CallendarService {
    private EventService eventService;
    public CallendarServiceImpl(EventService eventService) {
        this.eventService = eventService;
    }
    @Override
    public void addEvent(Event event) {
        eventService.create(event);
    }
    @Override
    public Event createEvent(String description, List<Person> emails) {
        return new Event.Builder().id(generateUUID()).description(description).attenders(emails).build();
    }
    @Override
    public Event createEvent(String title, String description, List<Person> attenders, GregorianCalendar startDate, GregorianCalendar endDate) {
        return new Event.Builder()
                .id(generateUUID())
                .title(title)
                .description(description)
                .attenders(attenders)
                .startDate(startDate)
                .endDate(endDate)
                .build();
    }
    @Override
    public Event createEvent(String title, String description, List<Person> attenders, GregorianCalendar initDate) {
        GregorianCalendar startDate = new GregorianCalendar(initDate.get(GregorianCalendar.YEAR)
                , initDate.get(GregorianCalendar.MONTH)
                , initDate.get(GregorianCalendar.DAY_OF_MONTH));
        GregorianCalendar endDate = new GregorianCalendar(initDate.get(GregorianCalendar.YEAR)
                , initDate.get(GregorianCalendar.MONTH)
                , initDate.get(GregorianCalendar.DAY_OF_MONTH)
                , 23, 59, 60);
        return new Event.Builder()
                .id(generateUUID())
                .title(title)
                .description(description)
                .attenders(attenders)
                .startDate(startDate)
                .endDate(endDate)
                .build();
    }
    @Override
    public List<Event> getEventList() {
        return eventService.findAll();
    }
    @Override
    public Event removeEvent(String title) {
        List<Event> list = eventService.findAll();
        for (Event event : list) {
            if (event.getTitle().equals(title)) {
               return eventService.delete(event);
            }
        }
        return null;
    }
    @Override
    public List<Event> getPersonEvents(Person person, GregorianCalendar startDate, GregorianCalendar endDate) {
        List<Event> allEvents = getEventList();
        List<Event> personEvents = new ArrayList<>();
        for (Event e : allEvents) {
            List<Person> personList = e.getAttenders();
            if (personList.contains(person)
                    && ((startDate.compareTo(e.getStartDate()) >= 0) || (endDate.compareTo(e.getEndDate()) <= 0)))
                personEvents.add(e);
        }
        return personEvents;
    }
    private UUID generateUUID() {
        return UUID.randomUUID();
    }

}
