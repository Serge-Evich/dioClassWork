package dio.homework.callendar;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by Димон on 20.07.2014.
 */
public class Person implements Serializable {
    private final UUID uuid;
    private final String firstName;
    private final String surName;
    private final String email;
    private final Integer phoneNumber;

    private Person(Builder builder) {
        this.uuid = builder.uuid;
        this.firstName = builder.firstName;
        this.surName = builder.surName;
        this.email = builder.email;
        this.phoneNumber = builder.phoneNumber;
    }
    public UUID getUuid() {
        return this.uuid;
    }
    public String getFirstName() {
        return this.firstName;
    }
    public String getSurName() {
        return this.surName;
    }

    public String getEmail() {
        return this.email;
    }

    public Integer getPhoneNumber() {
        return this.phoneNumber;
    }

    public static class Builder {
        private UUID uuid;
        private String firstName;
        private String surName;
        private String email;
        private Integer phoneNumber;

        public Builder() {
            //local code review (vtegza): generate default values outside pojo class @ 9/22/2014
            uuid = UUID.randomUUID();
            firstName = "John";
            surName = "Doe";
            email = "";
            phoneNumber = 0;
        }
        public Builder(Person person) {
            this.uuid = person.uuid;
            this.firstName = person.firstName;
            this.surName = person.surName;
            this.email = person.email;
            this.phoneNumber = person.phoneNumber;
        }
        public Person build() {
            return new Person(this);
        }
        public Builder uuid(UUID uuid) {
            this.uuid = uuid;
            return this;
        }
        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder surName(String surName) {
            this.surName = surName;
            return this;
        }
        public Builder email(String email) {
            this.email = email;
            return this;
        }
        public Builder phoneNumber(Integer phoneNumber) {
            this.phoneNumber  = phoneNumber;
            return this;
        }


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (!email.equals(person.email)) return false;
        if (!firstName.equals(person.firstName)) return false;
        if (!phoneNumber.equals(person.phoneNumber)) return false;
        if (!surName.equals(person.surName)) return false;
        if (!uuid.equals(person.uuid)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = uuid.hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + surName.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + phoneNumber.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Person{");
        sb.append("uuid=").append(uuid);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", surName='").append(surName).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", phoneNumber=").append(phoneNumber);
        sb.append('}');
        return sb.toString();
    }
}
