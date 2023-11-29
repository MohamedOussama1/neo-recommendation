package ma.uiass.eia.gisiba.jobrecommendation.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Node
@Data
@ToString
public class User {
    @Id
    private  Long id;
    private  String firstName;
    private  String lastName;
    private  LocalDate birthday;
    private  String email;
    private  String address;
    private  char gender;
    @Relationship(type = "OFFERS")
    private List<Job> offeredJobs = new ArrayList<>();
    @Relationship(type = "WORKS_AS")
    private List<Job> currentJobs = new ArrayList<>();
    @Relationship(type = "HAS")
    private List<Skill> skills;
    @Relationship(type = "HAS")
    private Interest interest;
    @Relationship(type = "HAS")
    private List<Experience> experience = new ArrayList<>();
    @Relationship(type = "HAS")
    private List<Education> education = new ArrayList<>();

    public User() {
    }

    public User(Long id, String firstName, String lastName, LocalDate birthday, String email, String address, char gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.email = email;
        this.address = address;
        this.gender = gender;
    }
}

