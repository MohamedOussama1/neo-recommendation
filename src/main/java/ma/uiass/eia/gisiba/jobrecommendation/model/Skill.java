package ma.uiass.eia.gisiba.jobrecommendation.model;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
public class Skill {
    @Id
    private final String title;
    public Skill(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }
}
