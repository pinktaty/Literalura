package com.pinktaty.literalura.model;
import com.fasterxml.jackson.annotation.JsonAlias;

public record AuthorRecord(
        @JsonAlias("name") String name,
        @JsonAlias("birth_year") int birthYear,
        @JsonAlias("death_year") int deathYear
) { }
