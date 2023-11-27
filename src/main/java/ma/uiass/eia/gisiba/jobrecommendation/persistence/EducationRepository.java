package ma.uiass.eia.gisiba.jobrecommendation.persistence;

import ma.uiass.eia.gisiba.jobrecommendation.model.Education;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;

public interface EducationRepository extends ReactiveNeo4jRepository<Education, Long> {
}
