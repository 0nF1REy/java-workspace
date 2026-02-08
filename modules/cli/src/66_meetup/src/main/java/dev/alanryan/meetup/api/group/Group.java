package dev.alanryan.meetup.api.group;

import java.time.LocalDate;

record Group(
        Long id,
        String name,
        String description,
        String city,
        String organizer,
        LocalDate createdDate
) {}
