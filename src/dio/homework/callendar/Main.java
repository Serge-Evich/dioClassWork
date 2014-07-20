package dio.homework.callendar;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Димон on 06.07.2014.
 */
public class Main {

    public static void main (String[] args) throws IOException {
        List<Person> emails = new ArrayList<>();
        emails.add("user1@mail.com");
        emails.add("user2@mail.com");
        emails.add("user3@mail.com");
        emails.add("user4@mail.com");
        emails.add("user5@mail.com");
        emails.add("user6@mail.com");
        emails.add("user7@mail.com");
        emails.add("user8@mail.com");
        emails.add("user9@mail.com");

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        CallendarService callendarService = context.getBean("calendarService", CallendarServiceImpl.class);
        StringBuffer stringBuffer = new StringBuffer();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String s = bufferedReader.readLine();
            if (!s.isEmpty())
                stringBuffer.append(s).append(" ");
            else
                break;

        }
        for (String desc : stringBuffer.toString().split(" ")) {
            callendarService.addEvent(callendarService.createEvent(desc, emails));
        }
        for (Event e : callendarService.getEventList()) {
            System.out.println(e);
        }

    }
}
