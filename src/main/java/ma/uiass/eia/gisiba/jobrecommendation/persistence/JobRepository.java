package ma.uiass.eia.gisiba.jobrecommendation.persistence;

import lombok.RequiredArgsConstructor;
import ma.uiass.eia.gisiba.jobrecommendation.model.Job;
import org.springframework.data.neo4j.core.ReactiveNeo4jOperations;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.neo4j.cypherdsl.core.Cypher.*;

@Component
@RequiredArgsConstructor
public class JobRepository  {
    private final ReactiveNeo4jOperations template;


    public Mono<Long> count() {
        return this.template.count(Job.class);
    }


    public Flux<Job> findAll() {
        return this.template.findAll(Job.class);
    }


    public Mono<Job> findById(Long id) {
        return this.template.findById(id, Job.class);
    }


    public Flux<Job> findByTitleContains(String title) {
        var postNode = node("Job").named("j");
        return this.template.findAll(
                match(postNode)
                        .where(postNode.property("title").contains(literalOf(title)))
                        .returning(postNode)
                        .build(),
                Job.class
        );
    }



    public Mono<Job> save(Job post) {
        return this.template.save(post);
    }


    public Flux<Job> saveAll(List<Job> data) {
        return this.template.saveAll(data);
    }


    public Mono<Void> deleteById(Long id) {
        return this.template.deleteById(id, Job.class);
    }


    public Mono<Void> deleteAll() {
        return this.template.deleteAll(Job.class);
    }
}


