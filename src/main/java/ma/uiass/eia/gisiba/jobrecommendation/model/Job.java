package ma.uiass.eia.gisiba.jobrecommendation.model;

import ma.uiass.eia.gisiba.jobrecommendation.model.Company;
import ma.uiass.eia.gisiba.jobrecommendation.model.Skill;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

@NodeEntity
public class Job {
    @Id
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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEstimatedSalary(double estimatedSalary) {
        this.estimatedSalary = estimatedSalary;
    }

    public void setEstimatedMonths(int estimatedMonths) {
        this.estimatedMonths = estimatedMonths;
    }

    public void setRequiredSkills(List<Skill> requiredSkills) {
        this.requiredSkills = requiredSkills;
    }

    public void setCompany(Company company) {
        this.company = company;
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
