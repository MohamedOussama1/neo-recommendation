package ma.uiass.eia.gisiba.jobrecommendation.persistence;

import ma.uiass.eia.gisiba.jobrecommendation.model.Company;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;

public interface CompanyRepository extends ReactiveNeo4jRepository<Company, String> {
}
