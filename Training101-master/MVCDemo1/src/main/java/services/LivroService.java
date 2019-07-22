package services;

import controllers.KeyNotFoundException;
import controllers.LivroDTO;
import entities.Editor;
import entities.Livro;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.LivroRepository;
import java.util.List;

@Builder
@Setter
@Getter
@Data
@Service
public class LivroService {

    private LivroRepository livroRepository;
    private EditorService editorService;

    @Autowired
    public LivroService(LivroRepository livroRepository,EditorService editorService) {
        this.livroRepository = livroRepository;
        this.editorService = editorService;
    }

    public Livro create(Long editorId,LivroDTO dto) {
        Livro livro = convertDtoToLivro(dto); // Create an entities Livro WITHOUT Editor!

        Editor editor = editorService.findEditorById(editorId); // Now we extract the editor correspondent with the editorService

        livro.setEditor(editor);

        return livroRepository.save(livro);
    }

    public Livro convertDtoToLivro(LivroDTO livroDto) {
        return Livro.builder()
                .autor(livroDto.getAutor())
                .description(livroDto.getDescription())
                .isbn(livroDto.getIsbn())
                .titulo(livroDto.getTitulo())
                .id(livroDto.getId())
                .editor(editorService.findEditorById(livroDto.getEditorId()))
                .build();
    }

    public Livro findBooksWithId(Long livroId){
        return livroRepository.findById(livroId).orElseThrow(()->new KeyNotFoundException("No correspondent Id"));
    }

    public List<Livro> findAllBooks(){
        return livroRepository.findAll();
    }

    public List<Livro> findAuthorBooks(String author){
        return livroRepository.findByAutor(author);
    }

    public List<Livro> findEditorBooks(Long editorId){
        return livroRepository.findByEditorId(editorId);
    }
}
