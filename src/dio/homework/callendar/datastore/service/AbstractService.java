package dio.homework.callendar.datastore.service;

import dio.homework.callendar.datastore.Operations;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 * Created by Dmitry on 09.07.2014.
 */
public abstract class AbstractService<T extends Serializable> implements Operations<T> {

    public T findOne(UUID id) {
        return getDao().findOne(id);
    }

    public List<T> findAll() {
        return getDao().findAll();
    }

    public void create(T pojo) {
        getDao().create(pojo);
    }

    public void update(T pojo) {
        getDao().update(pojo);
    }

    public T delete(T pojo) {
        return getDao().delete(pojo);
    }
    protected abstract Operations<T> getDao();
}
