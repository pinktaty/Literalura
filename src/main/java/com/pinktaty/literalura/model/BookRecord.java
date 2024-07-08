package com.pinktaty.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookRecord(
        @JsonAlias("title") String title,
        @JsonAlias("authors") List<AuthorRecord> author,
        @JsonAlias("languages") String[] languages

) { }
