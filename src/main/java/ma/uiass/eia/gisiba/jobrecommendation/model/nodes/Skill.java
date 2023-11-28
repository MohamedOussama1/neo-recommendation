package ma.uiass.eia.gisiba.jobrecommendation.model.nodes;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Skill {
    @Id
    private String title;
    public Skill(String title) {
        this.title = title;
    }
    public Skill(){
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
