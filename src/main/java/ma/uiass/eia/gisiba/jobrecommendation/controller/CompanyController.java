package ma.uiass.eia.gisiba.jobrecommendation.controller;

import lombok.RequiredArgsConstructor;
import ma.uiass.eia.gisiba.jobrecommendation.model.Company;
import ma.uiass.eia.gisiba.jobrecommendation.persistence.CompanyRepository;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/company")
@RequiredArgsConstructor
public class CompanyController{
    private final CompanyRepository companyRepository;
    @GetMapping("")
    public Flux<Company> all() {
        return this.companyRepository.findAll();
    }

    @PostMapping("")
    public Mono<Company> create(@RequestBody Company company) {
        return this.companyRepository.save(company);
    }

    @GetMapping("/{id}")
    public Mono<Company> get(@PathVariable("id") Long id) {
        return Mono.just(id)
                .flatMap(companyRepository::findById)
                .switchIfEmpty(Mono.error(new Exception()));
    }

    @PutMapping("/{id}")
    public Mono<Company> update(@PathVariable("id") Long id, @RequestBody Company company) {
        return this.companyRepository.findById(id)
                .map(c -> {
                    c.setTitle(company.getTitle());
                    c.setEmail(company.getEmail());
                    c.setPhoneNumber(company.getPhoneNumber());
                    c.setAddress(company.getAddress());
                    return c;
                })
                .flatMap(this.companyRepository::save);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable("id") Long id) {
        return this.companyRepository.deleteById(id);
    }
}
