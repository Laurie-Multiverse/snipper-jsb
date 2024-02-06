package com.springboot.demo.springbootdemo1.payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SnippetDto {
    private long id;

    @NotEmpty
    @Size(min = 2, message = "Language of snippet code requires a minimum of TWO characters")
    private String language;

    @NotEmpty
    @Size(min = 2, message = "Code snippet requires a minimum of TWO characters")
    private String code;
}
