package hello.model;

import javax.persistence.*;

@SuppressWarnings("WeakerAccess")
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Long version;

    private String firstName;
    private String lastName;

    protected Customer() {
    }

    public Customer( String firstName, String lastName ) {
        this();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, firstName='%s', lastName='%s', version=%d]",
                getId(), getFirstName(), getLastName(), getVersion() );
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Long getVersion() {
        return version;
    }
}

