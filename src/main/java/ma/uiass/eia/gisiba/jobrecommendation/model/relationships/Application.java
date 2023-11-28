package ma.uiass.eia.gisiba.jobrecommendation.model.relationships;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ma.uiass.eia.gisiba.jobrecommendation.model.nodes.Job;
import ma.uiass.eia.gisiba.jobrecommendation.model.nodes.User;
import org.neo4j.ogm.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RelationshipEntity(type = "APPLIES_TO")
public class Application {
    @Id
    @GeneratedValue
    private Long applicationId;
    @Property
    private LocalDate applicationDate;
    @JsonIgnore
    @StartNode
    private User user;
    @EndNode   private List<Job> jobsAppliedTo;
}
