package com.springboot.demo.springbootdemo1.controller;

import com.springboot.demo.springbootdemo1.payload.SnippetDto;
import com.springboot.demo.springbootdemo1.service.SnippetService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/snippets")
public class SnippetController {
    private SnippetService snippetService;

    public SnippetController(SnippetService snippetService) {
        this.snippetService = snippetService;
    }

    @GetMapping
    public ResponseEntity<List<SnippetDto>> getAllSnippets(){
        List<SnippetDto> snippets = snippetService.getAllSnippets();
        return ResponseEntity.ok(snippets);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SnippetDto> getSnippetById(@PathVariable(value = "id") long id) {
        SnippetDto snippet = snippetService.getSnippetById(id);
        return ResponseEntity.ok(snippet);
    }

    @PostMapping
    public ResponseEntity<SnippetDto> createSnippet(@Valid @RequestBody SnippetDto snippetDto) {
        SnippetDto newSnippet = snippetService.createSnippet(snippetDto);
        return new ResponseEntity<>(newSnippet, HttpStatus.CREATED);
    }
}
