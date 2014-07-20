package dio.homework.callendar;

import dio.homework.callendar.datastore.service.EventService;
import dio.homework.callendar.datastore.service.EventServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;
import static org.junit.Assert.assertArrayEquals;
import static org.mockito.Mockito.*;

public class CallendarServiceImplTest {
    private CallendarService testCallendarService;
    private EventService testEventService;
    private List<Person> attenders1;
    private List<Person> attenders2;
    private Date startDate;
    private Date endDate;
    private Event event1;
    private Event event2;
    private Event event3;
    private Person person1;
    private Person person2;
    private Person person3;
    private Person person4;
    private Person person5;
    private Person person6;
    private Person person7;
    private Person person8;
    private Person person9;
    private Person person10;
    private Person person11;
    @Before
    public void setup() {
        startDate = new Date();
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        testCallendarService = context.getBean("calendarService", CallendarServiceImpl.class);
        attenders1 = new ArrayList<>();

        attenders1.add();
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
        testEventService = mock(EventServiceImpl.class);
        testCallendarService = new CallendarServiceImpl(testEventService);
    }

    @Test
    public void testAddEvent() {
//        List<Event> expectedResult = new ArrayList<>();
//        expectedResult.add(event1);
//        expectedResult.add(event2);
//        testCallendarService.addEvent(event1);
//        testCallendarService.addEvent(event2);
//        List<Event> testValue = new ArrayList<>(testCallendarService.getEventList());
//        System.out.println(event1);
//        System.out.println(event2);
//        assertTrue(expectedResult.containsAll(testValue));
        testCallendarService.addEvent(event1);
        verify(testEventService).create(event1);
    }
    @Test
    public void testAddEvent_Duplicates() throws Exception {
        List<Event> expectedResult = new ArrayList<>();
        expectedResult.add(event1);
        testCallendarService.addEvent(event1);
        testCallendarService.addEvent(event1);
        List<Event> testValue = new ArrayList<>(testCallendarService.getEventList());
        System.out.println(expectedResult);
        System.out.println(testValue);
        assertTrue(testValue.equals(expectedResult));
    }

    //local code review (vtegza): test failing @ 07.07.14
    @Test
    public void testCreateEvent() throws Exception {

        Event testValue = testCallendarService.createEvent("desc", attenders1);
        Event expectedResult = new Event.Builder()
                .id(testValue.getId())
                .description("desc")
                .attenders(attenders1)
                .build();
        assertTrue(expectedResult.equals(testValue));


    }
    @Test
    public void testRemoveEvent() {
        Event expectedResult = event1;
        List<Event> testList = new ArrayList<>();
        testList.add(event1);
        when(testEventService.findAll()).thenReturn(testList);
        when(testEventService.delete(event1)).thenReturn(event1);
        Event testValue = testCallendarService.removeEvent(event1.getTitle());
        Assert.assertEquals(expectedResult, testValue);
    }

    @Test
    public  void testFreeTimeCheck() {

    }






}
