package ma.uiass.eia.gisiba.jobrecommendation.persistence;

import lombok.RequiredArgsConstructor;
import ma.uiass.eia.gisiba.jobrecommendation.model.User;
import org.springframework.data.neo4j.core.ReactiveNeo4jOperations;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.neo4j.cypherdsl.core.Cypher.*;
@Component
@RequiredArgsConstructor
public class UserRepository{
private final ReactiveNeo4jOperations template;


    public Mono<Long> count() {
        return this.template.count(User.class);
    }


    public Flux<User> findAll() {
        return this.template.findAll(User.class);
    }


    public Mono<User> findById(Long id) {
        return this.template.findById(id, User.class);
    }


    public Flux<User> findByTitleContains(String title) {
        var userNode = node("User").named("u");
        return this.template.findAll(
                match(userNode)
                        .where(userNode.property("title").contains(literalOf(title)))
                        .returning(userNode)
                        .build(),
                User.class
        );
    }



    public Mono<User> save(User user) {
        return this.template.save(user);
    }


    public Flux<User> saveAll(List<User> data) {
        return this.template.saveAll(data);
    }


    public Mono<Void> deleteById(Long id) {
        return this.template.deleteById(id, User.class);
    }


    public Mono<Void> deleteAll() {
        return this.template.deleteAll(User.class);
    }
}
