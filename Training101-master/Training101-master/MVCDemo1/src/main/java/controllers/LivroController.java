
package controllers;

import entities.Editor;
import entities.Livro;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.EditorService;
import services.LivroService;

import java.util.List;

@RestController
@Builder
@Setter
@Getter
@RequestMapping("/") // It'll be executed when we access localhost:8080/
public class LivroController {

    EditorService editorService;
    LivroService livroService;

    @Autowired
    public LivroController(EditorService editorService, LivroService livroService) {
        this.editorService = editorService;
        this.livroService = livroService;
    }

    @GetMapping("/editores/{editorId}/livros") // Search books from an editor
    public ResponseEntity<List<Livro>> listaLivrosEditora(@PathVariable("editorId") Long editorId) {
        return ResponseEntity.ok(livroService.findEditorBooks(editorId));
    }

    //@PostMapping("/editores/{editorId}/livros") // Post a book from the respective editor ?????
    //public Livro postBook(@RequestBody LivroDTO livroDto) {
    //@PathVariable(value = "editorId") Long editorId;
    //return postLivro();
    //}

    @GetMapping("/editores")
    // It'll be executed when we access localhost:8080/ + some author when a GET method is invocated
    public ResponseEntity<List<Editor>> listEditors() {
        return editorService.findEditors(); // Finds the books written by a respective author
    }

    @PostMapping("/editores")
    // It'll be executed when we access localhost:8080/ + some author when a GET method is invocated
    public Editor postEditor(@RequestBody Editor editorDto) {
        Editor editor = editorService.DtoToEditorConverter(editorDto);
        //System.out.println(editor);
        return editorService.postEditors(editor);
    }

    @GetMapping("/editores/{editorId}")
    public Editor listEditors(@PathVariable Long editorId) {
        return editorService.findEditorById(editorId); // Finds the books written by a respective author
    }

    @GetMapping("/editores/{editorId}/livros/{livroId}")
    public Livro searchBook(@PathVariable Long editorId, Long livroId) {
        return livroService.findBooksWithId(livroId); // Finds the books written by a respective author
    }
}

}