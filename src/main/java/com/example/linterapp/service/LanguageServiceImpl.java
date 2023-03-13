package com.example.linterapp.service;

import com.example.linterapp.model.Language;
import com.example.linterapp.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageServiceImpl implements LanguageService {

    private final LanguageRepository languageRepository;

    @Autowired
    public LanguageServiceImpl(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public void add(Language language) {
        languageRepository.save(language);
    }

    @Override
    public Language getById(Integer id) {
        return languageRepository.findById(id).orElseThrow(() -> new RuntimeException());
    }

    @Override
    public List<Language> getAll() {
        return languageRepository.findAll();
    }
}
