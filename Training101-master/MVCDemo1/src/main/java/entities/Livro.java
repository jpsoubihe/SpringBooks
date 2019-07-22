package entities;

import lombok.*;

import javax.persistence.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Livro { //entities class - describes a table of data

    @Id // sinalize a primary key named Id
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
