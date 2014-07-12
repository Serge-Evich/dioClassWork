package dio.homework.callendar;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertArrayEquals;

public class CallendarServiceImplTest {
    private CallendarService testCallendarService;
    private List<String> attenders1;
    private List<String> attenders2;
    Date startDate;
    Date endDate;
    Event event1;
    Event event2;
    @Before
    public void setup() {
        startDate = new Date();
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        testCallendarService = context.getBean("callendarService", CallendarServiceImpl.class);
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
                .title("test1")
                .attenders(attenders1)
                .description("test event1")
                .startDate(startDate)
                .endDate(endDate)
                .build();
        event2 = new Event.Builder(event1)
                .description("test event2")
                .title("test2")
                .attenders(attenders2)
                .build();
    }

    @Test
    public void testAddEvent() throws Exception {
        List<Event> expectedResult = new ArrayList<>();
        expectedResult.add(event1);
        expectedResult.add(event2);
        testCallendarService.addEvent(event1);
        testCallendarService.addEvent(event2);
        List<Event> testValue = new ArrayList<>(testCallendarService.getEventList());
        System.out.println(event1);
        System.out.println(event2);
        assertTrue(expectedResult.containsAll(testValue));
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
        Event expectedResult = new Event.Builder()
                .description("desc")
                .attenders(attenders1)
                .build();
        Event testValue = testCallendarService.createEvent("desc", attenders1);
        assertTrue(expectedResult.equals(testValue));
    }






}
