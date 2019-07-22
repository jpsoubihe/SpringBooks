package controller;
import entity.Editor;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import entity.Livro;
import repository.EditorRepository;
import repository.LivroRepository;

import java.util.List;

@RestController
@RequestMapping("/") // It'll be executed when we access localhost:8080/
public class LivroController {

    private LivroRepository livroRepository;
    private EditorRepository editorRepository;

    @Autowired
    public LivroController(LivroRepository livroRepository, EditorRepository editorRepository) {
        this.livroRepository = livroRepository;
        this.editorRepository = editorRepository;
    }

    public LivroController(EditorRepository editorRepository) {
        this.editorRepository = editorRepository;
    }
    @GetMapping("/editores/{autor}") // It'll be executed when we access localhost:8080/ + some author when a GET method is invocated
    public ResponseEntity<List<Livro>> listaLivros(@PathVariable("autor") String autor){
        return ResponseEntity.ok(livroRepository.findByAutor(autor));
    }
//    public String listaLivros(@PathVariable("autor") String autor, Model model) {
//        List<Livro> listaLivros = livroRepository.findByAutor(autor); // Finds the books written by a respective author
//        if (listaLivros != null) {
//            model.addAttribute("livros", listaLivros);
//        }
//        return listaLivros.toString();
//    }

    @GetMapping("/editores") // It'll be executed when we access localhost:8080/ + some author when a GET method is invocated
    public ResponseEntity<List<Editor>> listaLivros2() {
        return ResponseEntity.ok(editorRepository.findAll()); // Finds the books written by a respective author
    }

    //@PostMapping("/editores/{autor}")// It'll be executed when we access localhost:8080/ + some author when a POST method is invocated
    //public Livro livro(@RequestBody String titulo,String isbn,String autor, String editorId){

      //  return livroRepository.save(l);
    //}

    @PostMapping("/editores") // It'll be executed when we access localhost:8080/ + some author when a GET method is invocated
    public EditorDTO createEditorPost(@RequestBody String editorId, String name){

        EditorDTO editorDto = new EditorDTO(editorId,name);


        return convertToDto(editorDto);
    }
}
