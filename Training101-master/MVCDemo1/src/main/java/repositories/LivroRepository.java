package repositories;

import entities.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro,Long> { // We have to create an interface that extends the JpaRepository to use the methods for data manipulation

    /**
     * Encontra todos os livros de um mesmo autor.
     *
     * @param autor
     * @return lista de livros
     */
    List<Livro> findByAutor(String autor); //to search attributes we have a pattern for Spring recognization 'findByATTRIBUTE(T t)'

    /**
     * Encontra um livro a partir do seu título.
     * Retorna uma lista pois podem existir
     * mais de um livro com mesmo título.
     *
     * @param titulo
     * @return lista de livros
     */
    List<Livro> findByTitulo(String titulo);

    /**
     * Encontra um livro a partir de seu isbn, como o isbn é único,
     apenas um livro pode ser encontrado.
     *
     * @param isbn
     * @return livro
     */
    Livro findByIsbn(String isbn);

    List<Livro> findByEditorId(Long editor);

}
