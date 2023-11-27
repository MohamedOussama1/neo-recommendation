package ma.uiass.eia.gisiba.jobrecommendation;

import ma.uiass.eia.gisiba.jobrecommendation.persistence.UserRepository;
import org.neo4j.cypherdsl.core.renderer.Dialect;
import org.neo4j.cypherdsl.core.renderer.Configuration;
import org.neo4j.driver.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication
@EnableNeo4jRepositories
public class JobRecommendationApplication implements CommandLineRunner {
    @Autowired
    Driver driver;
    @Bean
    Configuration cypherDslConfiguration() {
        return Configuration.newConfig()
                .withDialect(Dialect.NEO4J_5).build();
    }
    public static void main(String[] args) {
        SpringApplication.run(JobRecommendationApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        try (var session = driver.session()){
            session.run("MATCH (m:Movie) RETURN m.title as title").list()
                    .forEach(e -> System.out.println(e.get("title")));
        }
    }
}
