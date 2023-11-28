package ma.uiass.eia.gisiba.jobrecommendation.model;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.time.LocalDate;

@NodeEntity
public class Education {
    @Id
    @GeneratedValue()
    private  Long id;
    private  String school;
    private  LocalDate startDate;
    private  LocalDate endDate;
    @Relationship(type = "DEVELOPPED")
    private Skill skill;

    public Education(Long id, String school, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.school = school;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    public Education(){}

    public void setId(Long id) {
        this.id = id;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public Long getId() {
        return id;
    }

    public String getSchool() {
        return school;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Skill getSkill() {
        return skill;
    }
}
