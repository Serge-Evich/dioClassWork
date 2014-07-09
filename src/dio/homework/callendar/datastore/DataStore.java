package dio.homework.callendar.datastore;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 * Created by Dmitry on 09.07.2014.
 */
public interface DataStore<T extends Serializable> {

    T get(UUID id);
    List<T> getByName(String name);
    List<T> getAll();
    void save(T pojo);
    void update(T pojo);
    T remove(T pojo);

}
