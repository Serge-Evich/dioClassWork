package dio.homework.callendar.datastore;

import javax.xml.bind.annotation.XmlElement;
import dio.homework.callendar.Event;
import dio.homework.callendar.Person;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.*;

/**
 * Created by Димон on 24.07.2014.
 */
@XmlRootElement
@XmlType(name = "event")
public class EventAdapter {
    private String description;
    private String id;
    private List<PersonAdapter> attenders;
    private String title;
    private GregorianCalendar startDate;
    private GregorianCalendar endDate;

    public EventAdapter() {

    }
    public EventAdapter(Event event) {
        this.id = event.getId().toString();
        this.title = event.getTitle();
        this.description = event.getDescription();
        this.startDate = event.getStartDate();
        this.endDate = event.getEndDate();

        this.attenders = new ArrayList<>();
        if (event.getAttenders() != null ) {
            for (Person person : event.getAttenders()) {
                this.attenders.add(new PersonAdapter(person));
            }

        }
    }

    @XmlElement(name = "person")
    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }

    public List<PersonAdapter> getAttenders() {
        return attenders;
    }

    public void setAttenders(List<PersonAdapter> attenders) {
        this.attenders = attenders;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public GregorianCalendar getStartDate() {
        return startDate;
    }

    public void setStartDate(GregorianCalendar startDate) {
        this.startDate = startDate;
    }

    public GregorianCalendar getEndDate() {
        return endDate;
    }

    public void setEndDate(GregorianCalendar endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EventAdapter that = (EventAdapter) o;

        if (attenders != null ? !attenders.equals(that.attenders) : that.attenders != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = description != null ? description.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (attenders != null ? attenders.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("EventAdapter{");
        sb.append("description='").append(description).append('\'');
        sb.append(", id='").append(id).append('\'');
        sb.append(", attenders=").append(attenders);
        sb.append(", title='").append(title).append('\'');
        sb.append(", startDate=").append(startDate);
        sb.append(", endDate=").append(endDate);
        sb.append('}');
        return sb.toString();
    }
}
