package ma.uiass.eia.gisiba.jobrecommendation.model.nodes;

import ma.uiass.eia.gisiba.jobrecommendation.model.relationships.Application;
import org.neo4j.ogm.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NodeEntity
public class User {
    @Id @GeneratedValue()
    private  Long id;

    private  String firstName;
    private  String lastName;
    private  LocalDate birthday;
    private  String email;
    private  String address;
    private  char gender;
    @Relationship(type = "OFFERS")
    private List<Job> offeredJobs = new ArrayList<>();
    @Relationship(type = "APPLIES_TO")
    private Application appliedTo;
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setOfferedJobs(List<Job> offeredJobs) {
        this.offeredJobs = offeredJobs;
    }

    public void setAppliedTo(Application appliedTo) {
        this.appliedTo = appliedTo;
    }

    public void setCurrentJobs(List<Job> currentJobs) {
        this.currentJobs = currentJobs;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public void setInterest(Interest interest) {
        this.interest = interest;
    }

    public void setExperience(List<Experience> experience) {
        this.experience = experience;
    }

    public void setEducation(List<Education> education) {
        this.education = education;
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

    public List<Job> getCurrentJobs() {
        return currentJobs;
    }

    public Application getAppliedTo() {
        return appliedTo;
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

