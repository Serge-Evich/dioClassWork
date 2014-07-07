package dio.homework.callendar;




import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Event {


    private final String description;
    private final UUID id;
    private final List<String> attenders;
    private final String title;
    private final Date startDate;
    private final Date endDate;

    private Event(Builder builder) {
//        this.id = builder.id;
        this.attenders = builder.attenders;
        this.description = builder.description;
        this.title = builder.title;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;

    }

    public String getDescription() {
        return this.description;
    }

    public UUID getId() {
        return this.id;
    }

    public List<String> getAttenders() {
        return this.attenders;
    }

    public String getTitle() {
        return this.title;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public Date getEndDate() {
        return this.endDate;
    }




    public static class Builder {
        private String description;
        private UUID id;
        private List<String> attenders;
        private String title;
        private Date startDate;
        private Date endDate;

        public Builder() {
            id = UUID.randomUUID();
            description = "";
            title = "";
            attenders = new ArrayList<>();
            startDate = new Date();
            endDate = new Date();
        }
        public Builder(Event event) {
            this.attenders = event.attenders;
            this.description = event.description;
            this.id = event.id;
            this.title = event.title;
            this.endDate = event.endDate;
            this.startDate = event.startDate;
        }

        public Builder attenders(List<String> list) {
            this.attenders = list;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

//        public Builder id(Long id) {
//            this.id = id;
//            return this;
//        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder endDate(Date endDate) {
            this.endDate = endDate;
            return this;
        }

        public Builder startDate(Date startDate) {
            this.startDate = startDate;
            return this;
        }

        public Event build() {
            return new Event(this);
        }
    }
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Event{");
//        sb.append("id'").append(id).append('\'');
        sb.append(" title=").append(title + "\n");
        sb.append(", description=").append(description + "\n");
        sb.append(", startDate=").append(startDate + "\n");
        sb.append(", endDate=").append(endDate + "}" + "\n");

        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = description.hashCode();
//        result = 31 * result + id.hashCode();
        result = 31 * result + attenders.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + startDate.hashCode();
        result = 31 * result + endDate.hashCode();
        return result;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (!id.equals(event.id)) return false;
        if (!attenders.equals(event.attenders)) return false;
        if (!description.equals(event.description)) return false;
        if (!endDate.equals(event.endDate)) return false;
        if (!startDate.equals(event.startDate)) return false;
        if (!title.equals(event.title)) return false;

        return true;
    }
}
