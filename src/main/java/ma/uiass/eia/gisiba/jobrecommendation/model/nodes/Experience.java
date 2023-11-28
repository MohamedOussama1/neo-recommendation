package ma.uiass.eia.gisiba.jobrecommendation.model.nodes;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.time.LocalDate;

@NodeEntity
public class Experience {
    @Id
    @GeneratedValue
    private  Long id;
    private  LocalDate startDate;
    private  LocalDate endDate;
    @Relationship(type = "WAS_IN")
    private Company company;
    @Relationship(type = "REQUIRED")
    private Skill skill;

    public Experience(Long id, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    public Experience(){
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Company getCompany() {
        return company;
    }

    public Skill getSkill() {
        return skill;
    }
}
