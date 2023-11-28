package ma.uiass.eia.gisiba.jobrecommendation.persistence;

import ma.uiass.eia.gisiba.jobrecommendation.model.Interest;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;

public interface InterestRepository extends ReactiveNeo4jRepository<Interest, String> {
}
