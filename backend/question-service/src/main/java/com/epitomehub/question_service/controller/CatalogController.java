package com.epitomehub.question_service.controller;

import com.epitomehub.question_service.dto.QuestionDto;
import com.epitomehub.question_service.dto.TechnologyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CatalogController {
    private final JdbcTemplate jdbcTemplate;

    @GetMapping("/technologies")
    public List<TechnologyDto> technologies() {
        return jdbcTemplate.query("select id, name, category from technologies where active = true order by name", (rs, i) ->
            new TechnologyDto(rs.getLong("id"), rs.getString("name"), rs.getString("category")));
    }

    @GetMapping("/questions")
    public List<QuestionDto> questions() {
        return jdbcTemplate.query("select id, title, body, question_type, difficulty from questions where active = true limit 100", (rs, i) ->
            new QuestionDto(rs.getLong("id"), rs.getString("title"), rs.getString("body"), rs.getString("question_type"), rs.getString("difficulty")));
    }

    @GetMapping("/questions/{id}")
    public QuestionDto question(@PathVariable Long id) {
        return jdbcTemplate.queryForObject("select id, title, body, question_type, difficulty from questions where id = ?", (rs, i) ->
            new QuestionDto(rs.getLong("id"), rs.getString("title"), rs.getString("body"), rs.getString("question_type"), rs.getString("difficulty")), id);
    }
}
