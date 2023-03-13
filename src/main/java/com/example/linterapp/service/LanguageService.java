package com.example.linterapp.service;

import com.example.linterapp.model.Language;

import java.util.List;

public interface LanguageService {
    void add(Language language);
    Language getById(Integer id);
    List<Language> getAll();
}
