package ma.uiass.eia.gisiba.jobrecommendation;

import org.neo4j.cypherdsl.core.renderer.Dialect;
import org.neo4j.cypherdsl.core.renderer.Configuration;
import org.neo4j.driver.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
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
            session.run("MATCH (j:Job) return j.title as title").list()
                    .forEach(e -> System.out.println(e.get("title")));
        }
    }
}
