package dio.homework.callendar;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


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

    public String toString() {
        return dataStore.toString();
    }
}
