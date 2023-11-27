package ma.uiass.eia.gisiba.jobrecommendation.persistence;

import ma.uiass.eia.gisiba.jobrecommendation.model.User;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveNeo4jRepository<User, Long> {
    Mono<User> findOneByFirstName(String firstName);
}
