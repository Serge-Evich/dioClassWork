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

    public Event createEvent(String description, List<String> emails) {
        return new Event.Builder().description(description).attenders(emails).build();
    }

    public Event createEvent(String title, String description, List<String> attenders, Date startDate, Date endDate) {
        return new Event.Builder()
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

}
