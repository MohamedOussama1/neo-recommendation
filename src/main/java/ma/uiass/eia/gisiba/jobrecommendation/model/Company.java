package ma.uiass.eia.gisiba.jobrecommendation.model;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
@NodeEntity
public class Company {
    @Id
    private  String title;
    private  String address;
    private  String email;
    private  String phoneNumber;

    public Company(String title, String address, String email, String phoneNumber) {
        this.title = title;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    public Company(){}

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
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
