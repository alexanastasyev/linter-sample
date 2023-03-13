package com.example.linterapp.repository;

import com.example.linterapp.model.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;

@Repository
public class LanguageRepositoryImpl implements LanguageRepository {

    private final JdbcTemplate jdbc;

    @Autowired
    public LanguageRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbc = jdbcTemplate;
    }

    @Override
    public Optional<Language> findById(int id) {
        Language language = jdbc.queryForObject("SELECT id, name, description FROM languages WHERE id = ?", this::mapRowToLanguage, id);
        return Optional.ofNullable(language);
    }

    @Override
    public void save(Language language) {
        jdbc.update("INSERT INTO languages(id, name, description) VALUES (?, ?, ?)",
                language.getId(), language.getName(), language.getDescription());
    }

    @Override
    public List<Language> findAll() {
        String query = "SELECT id, name, description FROM languages";
        return jdbc.query(query, this::mapRowToLanguage);
    }

    private Language mapRowToLanguage(ResultSet resultSet, int rowNumber) throws SQLException {
        return new Language(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getString("description")
        );
    }
}
