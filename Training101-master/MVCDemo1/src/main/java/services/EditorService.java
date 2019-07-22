package services;

import controllers.EditorDTO;
import controllers.KeyNotFoundException;
import controllers.LivroDTO;
import entities.Editor;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import repositories.EditorRepository;
import java.util.List;


@Builder
@Data
@Service
public class EditorService {

    private EditorRepository editorRepository;

    @Autowired
    public EditorService(EditorRepository editorRepository) {
        this.editorRepository = editorRepository;
    }

    public Editor DtoToEditorConverter(String editorName) {
        return Editor.builder()
                .name(editorName)
                .build();
    }

    public EditorDTO EditorToDtoConverter(Editor editor) {
        return EditorDTO.builder()
                .idDto(editor.getId())
                .nameDto(editor.getName())
                .build();
    }

    public Editor postEditors(Editor editor) {
        return editorRepository.save(editor);
    }

    public ResponseEntity<List<Editor>> findEditors() {
        return ResponseEntity.ok(editorRepository.findAll());
    }

    public Editor findEditorById(Long id) {
        return editorRepository.findById(id)
                .orElseThrow(() -> new KeyNotFoundException("OMG")); // Gives an alternative for a Id unknown search
    }
}
