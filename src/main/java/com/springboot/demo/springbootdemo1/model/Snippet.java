package com.springboot.demo.springbootdemo1.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Auto-creates boilerplate getter, setter, and contructor methods you'd have to write yourself
@Data
@AllArgsConstructor
@NoArgsConstructor

//JPA - specific
@Entity
@Table(name = "snippets")
public class Snippet {

    //Set primary key as id field
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "language", nullable = false)
    private String language;
    @Column(name = "code", nullable = false)
    private String code;
}
