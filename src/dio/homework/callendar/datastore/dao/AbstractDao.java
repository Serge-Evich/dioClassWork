package dio.homework.callendar.datastore.dao;

import dio.homework.callendar.datastore.DataStore;
import dio.homework.callendar.datastore.Operations;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 * Created by Dmitry on 09.07.2014.
 */
//local code review (vtegza): replace with delegation, - datastore as private final field @ 08.08.14
public abstract class AbstractDao<T extends Serializable> implements Operations<T> {


    public T findOne(UUID id) {
        return getDataStore().get(id);
    }

    public List<T> findAll() {
       return getDataStore().getAll();
    }

    public void create(T pojo) {
        getDataStore().save(pojo);
    }

    public void update(T pojo) {
        getDataStore().update(pojo);
    }

    public T delete(T pojo) {
        return getDataStore().remove(pojo);
    }

    protected abstract DataStore<T> getDataStore();
}
