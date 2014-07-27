package dio.homework.callendar.datastore;

import com.sun.xml.internal.txw2.annotation.XmlElement;
import dio.homework.callendar.Event;
import dio.homework.callendar.Person;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Димон on 24.07.2014.
 */
@XmlRootElement
@XmlType(name = "event")
public class EventAdapter {
    private String description;
    private UUID id;
    private List<PersonAdapter> attenders;
    private String title;
    private Date startDate;
    private Date endDate;

    public EventAdapter() {

    }

    public String getDescription() {
        return description;
    }

    @XmlElement()
    public void setDescription(String description) {
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    @XmlElement()
    public void setId(UUID id) {
        this.id = id;
    }
    @XmlElement()
    public List<PersonAdapter> getAttenders() {
        return attenders;
    }

    public void setAttenders(List<PersonAdapter> attenders) {
        this.attenders = attenders;
    }

    public String getTitle() {
        return title;
    }
    @XmlElement()
    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStartDate() {
        return startDate;
    }
    @XmlElement()
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }
    @XmlElement()
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

}
