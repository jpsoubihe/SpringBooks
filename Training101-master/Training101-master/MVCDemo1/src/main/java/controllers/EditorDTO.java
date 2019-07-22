package controllers;

import lombok.*;

@Builder
@Getter
@Setter
public class EditorDTO {
    private Long idDto;
    private String nameDto;

//    public ResponseEntity<List<Editor>> findEditors(EditorRepository editorRepository){
//        return ResponseEntity.ok(editorRepository.findAll());
//    }



}
