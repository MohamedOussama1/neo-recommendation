package ma.uiass.eia.gisiba.jobrecommendation;

import ma.uiass.eia.gisiba.jobrecommendation.model.Job;
import ma.uiass.eia.gisiba.jobrecommendation.model.Company;
import ma.uiass.eia.gisiba.jobrecommendation.model.Skill;
import ma.uiass.eia.gisiba.jobrecommendation.persistence.JobRepository;
import org.neo4j.cypherdsl.core.renderer.Dialect;
import org.neo4j.cypherdsl.core.renderer.Configuration;
import org.neo4j.driver.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.core.Neo4jTemplate;
import org.springframework.data.neo4j.core.ReactiveDatabaseSelectionProvider;
import org.springframework.data.neo4j.core.transaction.ReactiveNeo4jTransactionManager;
import org.springframework.data.neo4j.repository.config.ReactiveNeo4jRepositoryConfigurationExtension;
import org.springframework.transaction.ReactiveTransactionManager;

@SpringBootApplication
public class JobRecommendationApplication implements CommandLineRunner {
    @Autowired
    JobRepository jobRepository;
    @Autowired
    Neo4jTemplate neo4jTemplate;
//    @Bean(name = "reactiveTransactionManager")
//    public ReactiveNeo4jTransactionManager reactiveTransactionManager() {
//        return new ReactiveNeo4jTransactionManager(driver);
//    }
    @Bean(ReactiveNeo4jRepositoryConfigurationExtension.DEFAULT_TRANSACTION_MANAGER_BEAN_NAME)
    public ReactiveTransactionManager reactiveTransactionManager(
            Driver driver,
            ReactiveDatabaseSelectionProvider databaseNameProvider) {
        return new ReactiveNeo4jTransactionManager(driver, databaseNameProvider);
    }
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
        Job job = new Job("C# Developer", "Develop Rust applications", 20000, 12);
        Company company = new Company("C# foundation", "lihi", "rust.com", "00029291");
//        companyRepository.save(company);
//        Skill skill = new Skill("Rust");
//        Skill skill1 = new Skill("Neo4j");
//        Skill skill2 = new Skill("Javascript");
//        job.setCompany(company);
//        job.getRequiredSkills().add(skill);
//        job.getRequiredSkills().add(skill1);
//        job.getRequiredSkills().add(skill2);
//        neo4jTemplate.save(job);
    }
}
