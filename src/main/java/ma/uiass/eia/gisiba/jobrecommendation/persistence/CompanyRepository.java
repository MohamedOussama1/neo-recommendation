package ma.uiass.eia.gisiba.jobrecommendation.persistence;

import lombok.RequiredArgsConstructor;
import ma.uiass.eia.gisiba.jobrecommendation.model.Company;
import ma.uiass.eia.gisiba.jobrecommendation.model.Company;
import org.springframework.data.neo4j.core.ReactiveNeo4jOperations;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.neo4j.cypherdsl.core.Cypher.*;
@Component
@RequiredArgsConstructor
public class CompanyRepository{

    private final ReactiveNeo4jOperations template;


    public Mono<Long> count() {
        return this.template.count(Company.class);
    }


    public Flux<Company> findAll() {
        return this.template.findAll(Company.class);
    }


    public Mono<Company> findById(Long id) {
        return this.template.findById(id, Company.class);
    }


    public Flux<Company> findByTitleContains(String title) {
        var companyNode = node("Company").named("c");
        return this.template.findAll(
                match(companyNode)
                        .where(companyNode.property("title").contains(literalOf(title)))
                        .returning(companyNode)
                        .build(),
                Company.class
        );
    }



    public Mono<Company> save(Company company) {
        return this.template.save(company);
    }


    public Flux<Company> saveAll(List<Company> data) {
        return this.template.saveAll(data);
    }


    public Mono<Void> deleteById(Long id) {
        return this.template.deleteById(id, Company.class);
    }


    public Mono<Void> deleteAll() {
        return this.template.deleteAll(Company.class);
    }
}
