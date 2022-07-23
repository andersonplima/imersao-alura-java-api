package com.alura.linguagens.api;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LanguageController {
    @Autowired
    private LanguageRepository repository;

    @GetMapping("/languages/preferred")
    public String preferred() {
        return repository.findAll()
            .stream()
            .sorted(Comparator.comparingInt(l -> l.Ranking()))
            .map(l -> l.Title())
            .findFirst()
            .get();
    }

    @GetMapping("/languages")
    public List<Language> getLanguages() {
        return repository.findAll();
    }

    @PostMapping("/languages")
    public ResponseEntity<Language> postLanguage(@RequestBody Language language) {
        var insertedLanguage = repository.insert(language);
        return ResponseEntity.status(HttpStatus.CREATED).body(insertedLanguage);
    }
}
