package ma.uiass.eia.gisiba.jobrecommendation.model;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.time.LocalDate;

@Node
public class Experience {
    @Id @GeneratedValue(GeneratedValue.UUIDGenerator.class)
    private final Long id;
    private final LocalDate startDate;
    private final LocalDate endDate;
    @Relationship(type = "WAS_IN")
    private Company company;
    @Relationship(type = "REQUIRED")
    private Skill skill;

    public Experience(Long id, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
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
