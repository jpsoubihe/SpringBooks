package services;

import controllers.EditorDTO;
import controllers.KeyNotFoundException;
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

    public Editor DtoToEditorConverter(EditorDTO editorDto) {
        return Editor.builder()
                .name(editorDto.getNameDto())
                .build();
    }

    public EditorDTO EditorToDtoConverter(Editor editor) {
        return EditorDTO.builder()
                .idDto(editor.getId())
                .nameDto(editor.getName())
                .build();
    }

    public Editor postEditors(String editor) {
        return editorRepository.save(Editor.builder().name(editor).build());
    }

    public ResponseEntity<List<Editor>> findEditors() {
        return ResponseEntity.ok(editorRepository.findAll());
    }

    public Editor findEditorById(Long id) {
        return editorRepository.findById(String.valueOf(id))
                .orElseThrow(() -> new KeyNotFoundException("OMG")); // Gives an alternative for a Id unknown search
    }

}
