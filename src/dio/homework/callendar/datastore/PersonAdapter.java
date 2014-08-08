package dio.homework.callendar.datastore;

import dio.homework.callendar.Person;

import javax.xml.bind.annotation.XmlType;

@XmlType(name = "person")
public class PersonAdapter {
    private String uuid;
    private String firstName;
    private String surName;
    private String email;
    private Integer phoneNumber;

    public PersonAdapter() {
    }

    public PersonAdapter(Person person) {
        this.uuid = person.getUuid().toString();
        this.firstName = person.getFirstName();
        this.surName = person.getSurName();
        this.email = person.getEmail();
        this.phoneNumber = person.getPhoneNumber();

    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    //local code review (vtegza): no need in equals/hashcode if used only for jaxb @ 08.08.14
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonAdapter that = (PersonAdapter) o;

        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(that.phoneNumber) : that.phoneNumber != null) return false;
        if (surName != null ? !surName.equals(that.surName) : that.surName != null) return false;
        if (uuid != null ? !uuid.equals(that.uuid) : that.uuid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = uuid != null ? uuid.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (surName != null ? surName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("PersonAdapter{");
        sb.append("uuid='").append(uuid).append('\'');
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", surName='").append(surName).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", phoneNumber=").append(phoneNumber);
        sb.append('}');
        return sb.toString();
    }
}
