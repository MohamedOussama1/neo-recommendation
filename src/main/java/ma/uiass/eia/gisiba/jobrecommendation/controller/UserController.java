package ma.uiass.eia.gisiba.jobrecommendation.controller;

import lombok.RequiredArgsConstructor;
import ma.uiass.eia.gisiba.jobrecommendation.model.User;
import ma.uiass.eia.gisiba.jobrecommendation.persistence.UserRepository;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/users")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;
    @GetMapping("")
    public Flux<User> all() {
        return this.userRepository.findAll();
    }

    @PostMapping("")
    public Mono<User> create(@RequestBody User user) {
        return this.userRepository.save(user);
    }

    @GetMapping("/{id}")
    public Mono<User> get(@PathVariable("id") Long id) {
        return Mono.just(id)
                .flatMap(userRepository::findById)
                .switchIfEmpty(Mono.error(new Exception()));
    }

    @PutMapping("/{id}")
    public Mono<User> update(@PathVariable("id") Long id, @RequestBody User user) {
        return this.userRepository.findById(id)
                .map(u -> {
                    u.setFirstName(user.getFirstName());
                    u.setLastName(user.getLastName());
                    u.setEmail(user.getEmail());
                    u.setGender(user.getGender());
                    u.setAddress(user.getAddress());
                    u.setSkills(user.getSkills());
                    u.setBirthday(user.getBirthday());
                    u.setEducation(user.getEducation());
                    u.setExperience(user.getExperience());
                    return u;
                })
                .flatMap(this.userRepository::save);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable("id") Long id) {
        return this.userRepository.deleteById(id);
    }
}
