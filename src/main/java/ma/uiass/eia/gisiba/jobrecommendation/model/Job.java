package ma.uiass.eia.gisiba.jobrecommendation.model;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;

@Node
public class Job {
    @Id
    private final String title;
    private final String description;
    private final double estimatedSalary;
    private final int estimatedMonths;
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

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public double getEstimatedSalary() {
        return estimatedSalary;
    }

    public int getEstimatedMonths() {
        return estimatedMonths;
    }

    public Company getCompany() {
        return company;
    }

    public List<Skill> getRequiredSkills() {
        return requiredSkills;
    }
}
