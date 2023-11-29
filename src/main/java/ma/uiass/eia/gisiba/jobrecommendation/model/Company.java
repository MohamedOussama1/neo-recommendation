package ma.uiass.eia.gisiba.jobrecommendation.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.neo4j.ogm.annotation.NodeEntity;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
@Data
@ToString
public class Company {
    @Id
    private Long id;
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


}
