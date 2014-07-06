package dio.homework.callendar;

import java.util.*;


public class CallendarServiceImpl implements CallendarService<Event> {
    private Map<Long, Event> dataStore = new HashMap<>();
    public void addEvent(Event event) {
        if (!dataStore.containsValue(event)) {
            dataStore.put(generateUUID(), event);
        }
    }

    public Event createEvent(String description, List<String> emails) {
        return new Event.Builder().description(description).attenders(emails).build();
    }
    private Long generateUUID() {
        UUID uuid = UUID.randomUUID();
        return uuid.getMostSignificantBits();
    }

    public Collection<Event> getEventCollection() {
        return dataStore.values();
    }

    public String toString() {
        return dataStore.toString();
    }
}
