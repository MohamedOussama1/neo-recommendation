package ma.uiass.eia.gisiba.jobrecommendation.controller;

import lombok.RequiredArgsConstructor;
import ma.uiass.eia.gisiba.jobrecommendation.model.Job;
import ma.uiass.eia.gisiba.jobrecommendation.persistence.JobRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/jobs")
@RequiredArgsConstructor
public class JobController {
    private final JobRepository jobRepository;
    @GetMapping("")
    public Flux<Job> all() {
        return this.jobRepository.findAll();
    }

    @PostMapping(value = "", consumes = "text/plain")
    public Mono<Job> create(@RequestBody Job job) {
        return this.jobRepository.save(job);
    }

    @GetMapping("/{id}")
    public Mono<Job> get(@PathVariable("id") Long id) {
        return Mono.just(id)
                .flatMap(jobRepository::findById)
                .switchIfEmpty(Mono.error(new Exception()));
    }

    @PutMapping("/{id}")
    public Mono<Job> update(@PathVariable("id") Long id, @RequestBody Job job) {
        return this.jobRepository.findById(id)
                .map(j -> {
                    j.setTitle(job.getTitle());
                    j.setEstimatedSalary(job.getEstimatedSalary());
                    j.setDescription(job.getDescription());
                    j.setCompany(job.getCompany());
                    j.setRequiredSkills(job.getRequiredSkills());
                    return j;
                })
                .flatMap(this.jobRepository::save);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable("id") Long id) {
        return this.jobRepository.deleteById(id);
    }
}
