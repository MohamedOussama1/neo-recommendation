package ma.uiass.eia.gisiba.jobrecommendation.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;

@Node
@Data
@ToString
public class Job {
    @Id
    private Long id;
    private  String title;
    private  String description;
    private  double estimatedSalary;
    private  int estimatedMonths;
    @Relationship(type = "REQUIRES")
    List<Skill> requiredSkills = new ArrayList<>();
    @Relationship(type = "CONCERNS")
    Company company;

    public Job(String title, String description, double estimatedSalary, int estimatedMonths) {
        this.title = title;
        this.description = description;
        this.estimatedSalary = estimatedSalary;
        this.estimatedMonths = estimatedMonths;
    }
    public Job(){
    }
}
