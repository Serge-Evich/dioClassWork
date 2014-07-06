package dio.homework.callendar;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Димон on 06.07.2014.
 */
public class Main {

    public static void main(String[] descriptions) {
        List<String> emails = new ArrayList<>();
        emails.add("user1@mail.com");
        emails.add("user2@mail.com");
        emails.add("user3@mail.com");
        emails.add("user4@mail.com");
        emails.add("user5@mail.com");
        emails.add("user6@mail.com");
        emails.add("user7@mail.com");
        emails.add("user8@mail.com");
        emails.add("user9@mail.com");
        CallendarService<Event> callendarService = new CallendarServiceImpl();
//        String[] test = {"1", "2", "3", "4", "5", "6", "7", "8"};
//        descriptions = test;
        for (String desc : descriptions) {
            callendarService.addEvent(callendarService.createEvent(desc, emails));
        }
//        System.out.println(callendarService);

    }
}
