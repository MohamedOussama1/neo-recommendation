package ma.uiass.eia.gisiba.jobrecommendation.persistence;

import lombok.RequiredArgsConstructor;
import ma.uiass.eia.gisiba.jobrecommendation.model.Skill;
import org.springframework.data.neo4j.core.ReactiveNeo4jOperations;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.neo4j.cypherdsl.core.Cypher.*;

@Component
@RequiredArgsConstructor
public class SkillRepository{
private final ReactiveNeo4jOperations template;


public Mono<Long> count() {
        return this.template.count(Skill.class);
        }


public Flux<Skill> findAll() {
        return this.template.findAll(Skill.class);
        }


public Mono<Skill> findById(Long id) {
        return this.template.findById(id, Skill.class);
        }


public Flux<Skill> findByTitleContains(String title) {
        var skillNode = node("Skill").named("s");
        return this.template.findAll(
        match(skillNode)
        .where(skillNode.property("title").contains(literalOf(title)))
        .returning(skillNode)
        .build(),
        Skill.class
        );
                }



public Mono<Skill> save(Skill skill) {
        return this.template.save(skill);
        }


public Flux<Skill> saveAll(List<Skill> data) {
        return this.template.saveAll(data);
        }


public Mono<Void> deleteById(Long id) {
        return this.template.deleteById(id, Skill.class);
        }


public Mono<Void> deleteAll() {
        return this.template.deleteAll(Skill.class);
        }
}
