package dev.alanryan.meetup.api.group;

import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/groups")
class GroupController {

    private final List<Group> groups = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    @GetMapping
    List<Group> findAll() {
        return groups;
    }

    @GetMapping("/{id}")
    Group findById(@PathVariable Long id) {
        return groups.stream()
                .filter(g -> g.id().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Grupo não encontrado!"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Group create(@RequestBody Group group) {
        Group newGroup = new Group(
                idCounter.getAndIncrement(),
                group.name(),
                group.description(),
                group.city(),
                group.organizer(),
                group.createdDate() != null ? group.createdDate() : LocalDate.now()
        );
        groups.add(newGroup);
        return newGroup;
    }

    @PutMapping("/{id}")
    Group update(@PathVariable Long id, @RequestBody Group group) {
        Group existing = findById(id);
        Group updatedGroup = new Group(
                id,
                group.name(),
                group.description(),
                group.city(),
                group.organizer(),
                group.createdDate()
        );
        groups.remove(existing);
        groups.add(updatedGroup);
        return updatedGroup;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable Long id) {
        Group existing = findById(id);
        groups.remove(existing);
    }

    @PostConstruct
    private void init() {
        groups.add(new Group(
                idCounter.getAndIncrement(),
                "Yorozuya Java",
                "Um grupo de desenvolvedores que aceitam qualquer missão em Java — desde caçar bugs rebeldes até enfrentar legados do período Edo digital",
                "Edo",
                "Sakata Gintoki",
                LocalDate.of(2006, 4, 4)
        ));

        groups.add(new Group(
                idCounter.getAndIncrement(),
                "Shinsengumi Frontend React",
                "Esquadrão especializado em manter a ordem no frontend com React, combatendo estados descontrolados e componentes caóticos",
                "Edo",
                "Hijikata Toushirou",
                LocalDate.of(2008, 7, 15)
        ));

        groups.add(new Group(
                idCounter.getAndIncrement(),
                "Kabukicho Python Dojo",
                "Entusiastas de Python que treinam automação, ciência de dados e scripts rápidos como golpes de espada",
                "Kabukicho",
                "Katsura Kotarou",
                LocalDate.of(2009, 9, 9)
        ));

        groups.add(new Group(
                idCounter.getAndIncrement(),
                "Amanto Tech Community",
                "Comunidade tecnológica intergaláctica conectando samurais, alienígenas e devs freelancers em projetos fora da curva",
                "Edo",
                "Liderança Comunitária",
                LocalDate.of(2011, 1, 1)
        ));
    }
}
