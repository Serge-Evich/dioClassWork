package dio.homework.callendar;

import dio.homework.callendar.datastore.service.EventService;

import java.util.*;


public class CallendarServiceImpl implements CallendarService {
    private EventService eventService;
    public CallendarServiceImpl(EventService eventService) {
        this.eventService = eventService;
    }
    public void addEvent(Event event) {
        eventService.create(event);
    }

    public Event createEvent(String description, List<Person> emails) {
        return new Event.Builder().id(generateUUID()).description(description).attenders(emails).build();
    }

    public Event createEvent(String title, String description, List<Person> attenders, Date startDate, Date endDate) {
        return new Event.Builder()
                .id(generateUUID())
                .title(title)
                .description(description)
                .attenders(attenders)
                .startDate(startDate)
                .endDate(endDate)
                .build();
    }

    public List<Event> getEventList() {
        return eventService.findAll();
    }

    public Event removeEvent(String title) {
        List<Event> list = eventService.findAll();
        for (Event event : list) {
            if (event.getTitle().equals(title)) {
               return eventService.delete(event);
            }
        }
        return null;
    }
    private UUID generateUUID() {
        return UUID.randomUUID();
    }

}
