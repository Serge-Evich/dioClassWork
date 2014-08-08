package dio.homework.callendar;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Димон on 06.07.2014.
 */
//local code review (vtegza): clean up @ 08.08.14
public class Main {
    public static final Logger logger = Logger.getAnonymousLogger();
    public static void main (String[] args) throws IOException {
//        List<Person> emails = new ArrayList<>();
//
//
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        CallendarService callendarService = context.getBean("calendarService", CallendarServiceImpl.class);
//        StringBuffer stringBuffer = new StringBuffer();
//
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        while (true) {
//            String s = bufferedReader.readLine();
//            if (!s.isEmpty())
//                stringBuffer.append(s).append(" ");
//            else
//                break;
//
//        }
//        for (String desc : stringBuffer.toString().split(" ")) {
//            callendarService.addEvent(callendarService.createEvent(desc, emails));
//        }
//        for (Event e : callendarService.getEventList()) {
//            System.out.println(e);
//        }
//
//    }
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    logger.info("Service started");



    }
}
