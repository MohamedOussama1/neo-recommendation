package ma.uiass.eia.gisiba.jobrecommendation.model;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.time.LocalDate;

@Node
public class Education {
    @Id @GeneratedValue(GeneratedValue.UUIDGenerator.class)
    private final Long id;
    private final String school;
    private final LocalDate startDate;
    private final LocalDate endDate;
    @Relationship(type = "DEVELOPPED")
    private Skill skill;

    public Education(Long id, String school, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.school = school;
        this.startDate = startDate;
        this.endDate = endDate;
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
