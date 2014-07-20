package dio.homework.callendar.datastore.service;

import dio.homework.callendar.Event;
import dio.homework.callendar.Person;

import java.util.List;
import java.util.Date;

import dio.homework.callendar.datastore.dao.EventDao;
import dio.homework.callendar.datastore.dao.EventDaoImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.UUID;
import static org.mockito.Mockito.*;

public class EventServiceImplTest {
    private EventDao testEventDao;
    private List<Person> attenders1;
    private List<Person> attenders2;
    private Date startDate;
    private Date endDate;
    private Event event1;
    private Event event2;
    private Event event3;
    private EventService testEventService;
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
        testEventDao = mock(EventDaoImpl.class);
        testEventService = new EventServiceImpl(testEventDao);
    }
    @Test
    public void testCreate() {
        testEventService.create(event1);
        verify(testEventDao, times(1)).create(event1);
    }
    @Test
    public void testFindOne() {
        Event expectedResult = event1;
        when(testEventDao.findOne(event1.getId())).thenReturn(event1);
        Event testValue = testEventService.findOne(event1.getId());
        Assert.assertEquals(testValue, expectedResult);
    }
    @Test
    public void testFindAll() {
        List<Event> expectedResult = new ArrayList<>();
        List<Event> testValue;
        expectedResult.add(event1);
        expectedResult.add(event2);
        expectedResult.add(event3);
        when(testEventDao.findAll()).thenReturn(expectedResult);
        testValue = testEventService.findAll();
        Assert.assertEquals(expectedResult, testValue);
    }
    @Test
    public void testUpdate() {
        testEventService.update(event1);
        verify(testEventDao, times(1)).update(event1);
    }
    @Test
    public void testDelete() {
        Event expectedResult = event1;
        Event testValue;
        when(testEventDao.delete(event1)).thenReturn(event1);
        testValue = testEventService.delete(event1);
        Assert.assertEquals(expectedResult, testValue);
    }
}
