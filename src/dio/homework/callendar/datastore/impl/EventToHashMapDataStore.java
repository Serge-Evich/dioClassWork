package dio.homework.callendar.datastore.impl;

import dio.homework.callendar.Event;
import dio.homework.callendar.datastore.DataStore;

import java.util.*;

/**
 * Created by Dmitry on 09.07.2014.
 */
public class EventToHashMapDataStore implements DataStore<Event> {
    private Map<UUID, Event> dataStore = new HashMap<>();

    public Event get(UUID uuid) {
        return dataStore.get(uuid);
    }

    public List<Event> getAll() {
        return new ArrayList<Event>(dataStore.values());
    }

    public List<Event> getByName(String name) {
        Set<Event> set = new HashSet<>(dataStore.values());
        List<Event> list = new ArrayList<>();
        for (Event event : set) {
            if (name.equals(event.getTitle()))
                list.add(event);
        }
        return list;
    }

    public void save(Event event) {
        if (event.getId() == null) {
            event = new Event.Builder(event).id(generateUUID()).build();
            dataStore.put(event.getId(), event);
        } else if (!dataStore.containsKey(event.getId())) {
            dataStore.put(event.getId(), event);
        }
    }

    public Event remove(Event event) {
        if (dataStore.containsValue(event)) {
            return dataStore.remove(event);
        }
        return null;
    }

    public void update(Event event) {
        if (dataStore.containsKey(event.getId())) {
            dataStore.put(event.getId(), event);
        } else
            save(event);
    }

    private UUID generateUUID() {
        return UUID.randomUUID();
    }

}
