package ma.uiass.eia.gisiba.jobrecommendation.persistence;

import ma.uiass.eia.gisiba.jobrecommendation.model.Job;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;

public interface JobRepository extends ReactiveNeo4jRepository<Job, String> {
}
