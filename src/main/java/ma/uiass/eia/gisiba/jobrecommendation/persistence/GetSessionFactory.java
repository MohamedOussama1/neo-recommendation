package ma.uiass.eia.gisiba.jobrecommendation.persistence;

import org.neo4j.ogm.config.ClasspathConfigurationSource;
import org.neo4j.ogm.config.Configuration;
import org.neo4j.ogm.config.ConfigurationSource;
import org.neo4j.ogm.driver.Driver;
import org.neo4j.ogm.session.SessionFactory;

public class GetSessionFactory {
    private static SessionFactory sessionFactory;
    private GetSessionFactory(){}
    public static SessionFactory getSessionFactory(){
        Configuration configuration = new Configuration.Builder()
                .uri("bolt://localhost:7687")
                .connectionPoolSize(150)
                .database("neo4j")
//                .credentials("username", "password")
                .build();
        if (sessionFactory == null)
            sessionFactory = new SessionFactory(configuration, "ma/uiass/eia/gisiba/jobrecommendation/model");
        return sessionFactory;
    }
}
