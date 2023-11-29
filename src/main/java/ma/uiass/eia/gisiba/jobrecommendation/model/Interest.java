package ma.uiass.eia.gisiba.jobrecommendation.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
@Data
@ToString
public class Interest {
    @Id
    private  String title;
    public Interest(String title) {
        this.title = title;
    }
    public Interest(){}
}
