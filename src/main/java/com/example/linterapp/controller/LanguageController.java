package com.example.linterapp.controller;

import com.example.linterapp.model.Language;
import com.example.linterapp.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/languages")
public class LanguageController {

    private final LanguageService languageService;

    @Autowired
    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping
    public ResponseEntity<List<Language>> getAll() {
        return ResponseEntity.ok(languageService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Language> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(languageService.getById(id));
    }

    @PostMapping
    public ResponseEntity add(@RequestBody Language language) {
        languageService.add(language);
        return new ResponseEntity(HttpStatus.OK);
    }

}
