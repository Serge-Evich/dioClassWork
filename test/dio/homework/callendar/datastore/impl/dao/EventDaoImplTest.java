package dio.homework.callendar.datastore.impl.dao;

import dio.homework.callendar.Event;
import dio.homework.callendar.Person;
import dio.homework.callendar.datastore.DataStore;

import java.util.List;
import java.util.Date;

import dio.homework.callendar.datastore.dao.EventDao;
import dio.homework.callendar.datastore.dao.EventDaoImpl;
import dio.homework.callendar.datastore.impl.EventToHashMapDataStore;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.UUID;
import static org.mockito.Mockito.*;
/**
 * Created by Димон on 13.07.2014.
 */
public class EventDaoImplTest {
    private DataStore<Event> testDataStore;
    private List<Person> attenders1;
    private List<Person> attenders2;
    private Date startDate;
    private Date endDate;
    private Event event1;
    private Event event2;
    private Event event3;
    private EventDao testEventDao;
    @Before
    public void setup() {
        startDate = new Date();
        attenders1 = new ArrayList<>();
        attenders1.add("user1@mail.ru");
        attenders1.add("user2@mail.ru");
        attenders1.add("user3@mail.ru");
        attenders1.add("user4@mail.ru");
        attenders1.add("user5@mail.ru");
        attenders2 = new ArrayList<>();
        attenders2.add("hacker1@gmail.com");
        attenders2.add("hacker2@gmail.com");
        attenders2.add("hacker3@gmail.com");
        attenders2.add("hacker4@gmail.com");
        attenders2.add("hacker5@gmail.com");
        endDate = new Date();
        event1 = new Event.Builder()
                .id(UUID.randomUUID())
                .title("test1")
                .attenders(attenders1)
                .description("test event1")
                .startDate(startDate)
                .endDate(endDate)
                .build();
        event2 = new Event.Builder(event1)
                .id(UUID.randomUUID())
                .description("test event2")
                .title("test2")
                .attenders(attenders2)
                .build();
        event3 = new Event.Builder(event2)
                .id(UUID.randomUUID())
                .description("test event3")
                .title("test3")
                .attenders(attenders2)
                .build();
        testDataStore = mock(EventToHashMapDataStore.class);
        testEventDao = new EventDaoImpl(testDataStore);
    }
    @Test
    public void testCreate() {
        testEventDao.create(event1);
        verify(testDataStore, times(1)).save(event1);
    }
    @Test
    public void testFindOne() {
        when(testDataStore.get(event1.getId())).thenReturn(event1);
        Event testValue = testEventDao.findOne(event1.getId());
        Assert.assertEquals(testValue, event1);
    }
    @Test
    public void testFindAll() {
        List<Event> expectedResult = new ArrayList<>();
        List<Event> testValue;
        expectedResult.add(event1);
        expectedResult.add(event2);
        expectedResult.add(event3);
        when(testDataStore.getAll()).thenReturn(expectedResult);
        testValue = testEventDao.findAll();
        Assert.assertEquals(expectedResult, testValue);
    }
    @Test
    public void testUpdate() {
        testEventDao.update(event1);
        verify(testDataStore, times(1)).update(event1);
    }
    @Test
    public void testDelete() {
        Event expectedResult = event1;
        Event testValue;
        when(testDataStore.remove(event1)).thenReturn(event1);
        testValue = testEventDao.delete(event1);
        Assert.assertEquals(expectedResult, testValue);
    }
}
