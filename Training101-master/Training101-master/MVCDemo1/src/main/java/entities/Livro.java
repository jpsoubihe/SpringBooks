package entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Builder
@Getter
@Setter
@Entity
public class Livro { //entities class - describes a table of data

    @Id // sinalize a primary key named Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Used a lot on primary keys. Gives the JPA the responsability for generate unique keys
    private Long id;

    @Column(name = "titulo", nullable = false) // Describing properties of the attributes contained in the repositories
    private String titulo;

    @Column(name = "isbn", nullable = false, unique = true)// Describing properties of the attributes contained in the repositories
    private String isbn;

    @Column(name = "autor", nullable = false)// Describing properties of the attributes contained in the repositories
    private String autor;

    @Column(name="description", nullable = true)// Describing properties of the attributes contained in the repositories
    private String description;

    @ManyToOne
    @JoinColumn(name="editorId", nullable = false)// Describing properties of the attributes contained in the repositories
    private Editor editor;
}
