package com.springboot.demo.springbootdemo1.service;

import com.springboot.demo.springbootdemo1.payload.SnippetDto;

import java.util.List;

public interface SnippetService {
    List<SnippetDto> getAllSnippets();
    SnippetDto getSnippetById(long id);
    SnippetDto createSnippet(SnippetDto snippetDto);

}
