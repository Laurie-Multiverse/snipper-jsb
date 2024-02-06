package com.springboot.demo.springbootdemo1.repository;

import com.springboot.demo.springbootdemo1.model.Snippet;
import org.springframework.data.jpa.repository.JpaRepository;

// No need to add explicit @Repository annotation as this is included in extension of JPA Repository
public interface SnippetRepository extends JpaRepository<Snippet, Long> {
}
