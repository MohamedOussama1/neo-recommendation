package ma.uiass.eia.gisiba.jobrecommendation.model;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
public class Company {
    @Id
    private final String title;
    private final String address;
    private final String email;
    private final String phoneNumber;

    public Company(String title, String address, String email, String phoneNumber) {
        this.title = title;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    public String getTitle() {
        return title;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

}
