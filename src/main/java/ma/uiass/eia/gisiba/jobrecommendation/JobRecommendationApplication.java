package ma.uiass.eia.gisiba.jobrecommendation;

import ma.uiass.eia.gisiba.jobrecommendation.model.nodes.Job;
import ma.uiass.eia.gisiba.jobrecommendation.persistence.GetSessionFactory;
import ma.uiass.eia.gisiba.jobrecommendation.persistence.JobRepository;
import ma.uiass.eia.gisiba.jobrecommendation.persistence.UserRepository;
import org.neo4j.cypherdsl.core.renderer.Dialect;
import org.neo4j.cypherdsl.core.renderer.Configuration;
import org.neo4j.driver.Driver;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

import java.time.LocalDate;

@SpringBootApplication
public class JobRecommendationApplication implements CommandLineRunner {
//    @Autowired
//    Driver driver;
    @Bean
    Configuration cypherDslConfiguration() {
        return Configuration.newConfig()
                .withDialect(Dialect.NEO4J_5).build();
    }
    SessionFactory sessionFactory = GetSessionFactory.getSessionFactory();
    public static void main(String[] args) {
        SpringApplication.run(JobRecommendationApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        try (var session = driver.session()){
//            session.run("MATCH (m:Movie) RETURN m.title as title").list()
//                    .forEach(e -> System.out.println(e.get("title")));
//        }
        Session session = sessionFactory.openSession();
        try (var transaction = session.beginTransaction()){
            Job job = new Job("Software Engineer", "Develop applicaiton using Spring and Angular", 2000, 12);
            session.save(job);
            transaction.commit();
        }
    }
}
