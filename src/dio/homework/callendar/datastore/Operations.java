package dio.homework.callendar.datastore;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 * Created by Dmitry on 09.07.2014.
 */
//local code review (vtegza): no need for such Generic - tou could put exact type here @ 08.08.14
public interface Operations<T extends Serializable> {
    T findOne(UUID id);

    List<T> findAll();

    void create(T entity);

    void update(T entity);

    T delete(T entity);
}
