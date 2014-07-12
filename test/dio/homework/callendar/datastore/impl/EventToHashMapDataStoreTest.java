package dio.homework.callendar.datastore.impl;

import dio.homework.callendar.CallendarServiceImpl;
import dio.homework.callendar.Event;
import dio.homework.callendar.datastore.DataStore;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertTrue;

public class EventToHashMapDataStoreTest {
    private DataStore<Event> testDataStore;
    private List<String> attenders1;
    private List<String> attenders2;
    Date startDate;
    Date endDate;
    Event event1;
    Event event2;
    Event event3;
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
        testDataStore = new EventToHashMapDataStore();
    }
    @Test
    public void testSave() throws Exception {
        List<Event> expectedResult = new ArrayList<>();
        expectedResult.add(event1);
        expectedResult.add(event2);
        testDataStore.save(event1);
        testDataStore.save(event2);
        List<Event> testValue = new ArrayList<>(testDataStore.getAll());
        System.out.println(event1);
        System.out.println(event2);
        assertTrue(expectedResult.containsAll(testValue));
    }
    @Test
    public void testAddEvent_Duplicates() throws Exception {
        List<Event> expectedResult = new ArrayList<>();
        expectedResult.add(event1);
        testDataStore.save(event1);
        testDataStore.save(event1);
        List<Event> testValue = new ArrayList<>(testDataStore.getAll());
        System.out.println(expectedResult);
        System.out.println(testValue);
        assertTrue(testValue.equals(expectedResult));
    }

}
