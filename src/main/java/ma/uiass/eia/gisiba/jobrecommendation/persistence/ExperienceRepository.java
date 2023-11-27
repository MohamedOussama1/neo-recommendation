package ma.uiass.eia.gisiba.jobrecommendation.persistence;

import ma.uiass.eia.gisiba.jobrecommendation.model.Experience;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;

public interface ExperienceRepository extends ReactiveNeo4jRepository<Experience, Long> {
}
