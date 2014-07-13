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
        assertTrue(testValue.containsAll(expectedResult));
    }
    @Test
    public void testSave_Duplicates() throws Exception {
        List<Event> expectedResult = new ArrayList<>();
        expectedResult.add(event1);
        testDataStore.save(event1);
        testDataStore.save(event1);
        List<Event> testValue = new ArrayList<>(testDataStore.getAll());
        System.out.println(expectedResult);
        System.out.println(testValue);
        assertTrue(testValue.equals(expectedResult));
    }
    @Test
    public void testGet() throws Exception {
        Event expectedResult = event1;
        UUID event1uuid = event1.getId();
        testDataStore.save(event3);
        testDataStore.save(event1);
        testDataStore.save(event2);
        Event testValue = testDataStore.get(event1uuid);
        System.out.println(expectedResult);
        System.out.println(testValue);
        assertTrue(testValue.equals(expectedResult));

    }
    @Test
    public void testGetByName() throws Exception {
        List<Event> expectedResult = new ArrayList<>();
        String expectedResultName = event1.getTitle();
        expectedResult.add(event1);
        testDataStore.save(event2);
        testDataStore.save(event1);
        testDataStore.save(event3);
        List<Event> testValue = testDataStore.getByName(expectedResultName);
        System.out.println(expectedResult);
        System.out.println(testValue);
        assertTrue(testValue.equals(expectedResult));

    }
    @Test
    public void testGetAll() throws Exception {
        List<Event> expectedResult = new ArrayList<>();
        expectedResult.add(event1);
        expectedResult.add(event2);
        expectedResult.add(event3);
        testDataStore.save(event1);
        testDataStore.save(event2);
        testDataStore.save(event3);
        List<Event> testValue = new ArrayList<>(testDataStore.getAll());
        assertTrue(expectedResult.containsAll(testValue));
        assertTrue(testValue.containsAll(expectedResult));
    }
    @Test
    public void testUpdate() throws Exception {
        Event expectedResult = new Event.Builder(event1)
                .description("UpdatedEvent1")
                .build();
        String event1title = event1.getTitle();
        testDataStore.save(event1);
        testDataStore.save(event2);
        testDataStore.save(event3);
        testDataStore.update(expectedResult);
        List<Event> event1List = testDataStore.getByName(event1title);
        Event testValue = event1List.get(0);
        assertTrue(expectedResult.equals(testValue));
    }
    @Test
    public void testRemove() throws Exception {

        testDataStore.save(event2);
        testDataStore.save(event1);
        testDataStore.save(event3);
        List<Event> event1List = testDataStore.getByName(event1.getTitle());
        Event removedEvent = testDataStore.remove(event1);
        assertTrue(event1List.get(0).equals(removedEvent));
        event1List = testDataStore.getByName(event1.getTitle());
        assertTrue(event1List.isEmpty());
    }


}
