package ma.uiass.eia.gisiba.jobrecommendation.model;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Node
public class User {
    @Id @GeneratedValue(GeneratedValue.UUIDGenerator.class)
    private final Long id;

    private final String firstName;
    private final String lastName;
    private final LocalDate birthday;
    private final String email;
    private final String address;
    private final char gender;
    @Relationship(type = "OFFERS")
    private List<Job> offeredJobs = new ArrayList<>();
    @Relationship(type = "APPLIES_TO")
    private List<Job> appliedJobs = new ArrayList<>();
    @Relationship(type = "WORKS_AS")
    private List<Job> currentJobs = new ArrayList<>();
    @Relationship(type = "HAS")
    private Skill skill;
    @Relationship(type = "HAS")
    private Interest interest;
    @Relationship(type = "HAS")
    private List<Experience> experience = new ArrayList<>();
    @Relationship(type = "HAS")
    private List<Education> education = new ArrayList<>();

    public User(Long id, String firstName, String lastName, LocalDate birthday, String email, String address, char gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.email = email;
        this.address = address;
        this.gender = gender;
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

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public List<Job> getOfferedJobs() {
        return offeredJobs;
    }

    public List<Job> getAppliedJobs() {
        return appliedJobs;
    }

    public List<Job> getCurrentJobs() {
        return currentJobs;
    }

    public Skill getSkill() {
        return skill;
    }

    public Interest getInterest() {
        return interest;
    }

    public char getGender() {
        return gender;
    }

    public List<Experience> getExperience() {
        return experience;
    }

    public List<Education> getEducation() {
        return education;
    }
}

