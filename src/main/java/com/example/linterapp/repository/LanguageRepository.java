package com.example.linterapp.repository;

import com.example.linterapp.model.Language;

import java.util.List;
import java.util.Optional;

public interface LanguageRepository {
    Optional<Language> findById(int id);
    void save(Language language);
    List<Language> findAll();
}
