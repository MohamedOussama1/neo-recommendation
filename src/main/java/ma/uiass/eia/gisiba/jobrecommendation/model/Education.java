package ma.uiass.eia.gisiba.jobrecommendation.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.time.LocalDate;

@Node
@Data
@ToString
public class Education {
    @Id
    @GeneratedValue
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
}
