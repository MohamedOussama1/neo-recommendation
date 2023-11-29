package ma.uiass.eia.gisiba.jobrecommendation.controller;

import lombok.RequiredArgsConstructor;
import ma.uiass.eia.gisiba.jobrecommendation.model.Skill;
import ma.uiass.eia.gisiba.jobrecommendation.persistence.SkillRepository;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("skills")
@RestController
@RequiredArgsConstructor
public class SkillController {
    private final SkillRepository skillRepository;
    @GetMapping("")
    public Flux<Skill> all() {
        return this.skillRepository.findAll();
    }

    @PostMapping(value = "", consumes = "text/plain")
    public Mono<Skill> create(@RequestBody Skill skill) {
        return this.skillRepository.save(skill);
    }

    @GetMapping("/{id}")
    public Mono<Skill> get(@PathVariable("id") Long id) {
        return Mono.just(id)
                .flatMap(skillRepository::findById)
                .switchIfEmpty(Mono.error(new Exception()));
    }

    @PutMapping("/{id}")
    public Mono<Skill> update(@PathVariable("id") Long id, @RequestBody Skill skill) {
        return this.skillRepository.findById(id)
                .map(s -> {
                    s.setTitle(skill.getTitle());
                    return s;
                })
                .flatMap(this.skillRepository::save);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable("id") Long id) {
        return this.skillRepository.deleteById(id);
    }
}
