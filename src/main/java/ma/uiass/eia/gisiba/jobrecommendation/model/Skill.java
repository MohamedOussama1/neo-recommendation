package ma.uiass.eia.gisiba.jobrecommendation.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
@Data
@ToString
public class Skill {
    @Id
    private String title;
    public Skill(String title) {
        this.title = title;
    }
    public Skill(){
    }
}
