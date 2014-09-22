package dio.rmiclient;

import dio.homework.callendar.CallendarService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.rmi.RemoteException;
import java.util.logging.Logger;
/**
 * Created by Димон on 29.07.2014.
 */
//local code review (vtegza): should not inner module @ 9/22/2014
public class ClientMain {
    public static final Logger logger = Logger.getAnonymousLogger();

    public static void main(String[] args) throws RemoteException {

        ApplicationContext context = new ClassPathXmlApplicationContext("clientApplicationContext.xml");
        CallendarService service = (CallendarService) context.getBean("calendarService");

        String[] reservedCalendarNames = {"New Year", "Meeting10", "code review"};

        for (String name : reservedCalendarNames)
            //local code review (vtegza): prefer creating method with one parameter instead of pathing null @ 9/22/2014
            service.addEvent(service.createEvent(name, null));


         logger.info("Created event in data store: " + service.getEventList());

    }
}
