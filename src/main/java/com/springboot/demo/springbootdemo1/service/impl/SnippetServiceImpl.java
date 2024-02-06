package com.springboot.demo.springbootdemo1.service.impl;

import com.springboot.demo.springbootdemo1.exception.ResourceNotFoundException;
import com.springboot.demo.springbootdemo1.model.Snippet;
import com.springboot.demo.springbootdemo1.payload.SnippetDto;
import com.springboot.demo.springbootdemo1.repository.SnippetRepository;
import com.springboot.demo.springbootdemo1.service.SnippetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SnippetServiceImpl implements SnippetService {

    private SnippetRepository snippetRepository;

    // @Autowired -> as of Spring3 this annotation is implicit and can be ignored
    public SnippetServiceImpl(SnippetRepository snippetRepository) {
        this.snippetRepository = snippetRepository;
    }

    @Override
    public List<SnippetDto> getAllSnippets() {
        List<Snippet> snippets = snippetRepository.findAll();
        return snippets.stream().map(snippet -> mapToSnippetDto(snippet)).collect(Collectors.toList());
    }

    @Override
    public SnippetDto getSnippetById(long id) {
        Snippet snippet = snippetRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Snippet", "id", id));
        return mapToSnippetDto(snippet);
    }

    @Override
    public SnippetDto createSnippet(SnippetDto snippetDto) {
        Snippet snippet = mapToSnippet(snippetDto);
        Snippet createdSnippet = snippetRepository.save(snippet);
        return mapToSnippetDto(createdSnippet);
    }

    private Snippet mapToSnippet(SnippetDto snippetDto){
        Snippet snippet = new Snippet();
        snippet.setCode(snippetDto.getCode());
        snippet.setLanguage(snippetDto.getLanguage());
        snippet.setId(snippetDto.getId());

        return snippet;
    }

    private SnippetDto mapToSnippetDto(Snippet snippet){
        SnippetDto snippetDto = new SnippetDto();
        snippetDto.setCode(snippet.getCode());
        snippetDto.setLanguage(snippet.getLanguage());
        snippetDto.setId(snippet.getId());

        return snippetDto;
    }
}
