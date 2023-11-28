package ma.uiass.eia.gisiba.jobrecommendation.persistence;

import ma.uiass.eia.gisiba.jobrecommendation.model.Skill;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;

public interface SkillRepository extends ReactiveNeo4jRepository<Skill, String> {
}
