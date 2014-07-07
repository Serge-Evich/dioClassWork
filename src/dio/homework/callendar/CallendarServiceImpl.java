package dio.homework.callendar;

import java.util.*;


public class CallendarServiceImpl implements CallendarService {
    private Map<UUID, Event> dataStore = new HashMap<>();
    public void addEvent(Event event) {
        if (!dataStore.containsValue(event)) {
            dataStore.put(event.getId(), event);
        }
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

    public Collection<Event> getEventCollection() {
        return dataStore.values();
    }

    public String toString() {
        return dataStore.toString();
    }
}
