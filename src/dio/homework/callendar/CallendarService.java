package dio.homework.callendar;

import java.util.List;
import java.util.Collection;

/**
 * Created by Димон on 06.07.2014.
 */
public interface CallendarService<T> {
    void addEvent(T event);
    T createEvent(String description, List<String> emails);
    //void removeEvent(T event);
    Collection<T> getEventCollection();
}
