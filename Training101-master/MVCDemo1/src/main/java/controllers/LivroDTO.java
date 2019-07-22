package controllers;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Builder
@Getter
@Setter
@Entity
public class LivroDTO {
    private Long id;
    private String titulo;
    private String isbn;
    private String autor;
    private String description;
    private Long editorId;
}

