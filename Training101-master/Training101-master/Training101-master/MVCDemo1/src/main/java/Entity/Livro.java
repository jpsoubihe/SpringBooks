package entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Livro { //entity class - describes a table of data

    @Id // sinalize a primary key named Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Used a lot on primary keys. Gives the JPA the responsability for generate unique keys
    private Long id;

    @Column(name = "titulo", nullable = false) // Describing properties of the attributes contained in the repository
    private String titulo;

    @Column(name = "isbn", nullable = false, unique = true)// Describing properties of the attributes contained in the repository
    private String isbn;

    @Column(name = "autor", nullable = false)// Describing properties of the attributes contained in the repository
    private String autor;

    @Column(name="description", nullable = true)// Describing properties of the attributes contained in the repository
    private String description;

    @ManyToOne
    @JoinColumn(name="editorId", nullable = false)// Describing properties of the attributes contained in the repository
    private Editor editor;
}
