package ma.uiass.eia.gisiba.jobrecommendation.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import java.time.LocalDate;

@Node
@Data
@ToString
public class Experience {
    @Id
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
}
