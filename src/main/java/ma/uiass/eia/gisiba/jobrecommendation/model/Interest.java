package ma.uiass.eia.gisiba.jobrecommendation.model;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Interest {
    @Id
    private  String title;

    public Interest(String title) {
        this.title = title;
    }
    public Interest(){}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
