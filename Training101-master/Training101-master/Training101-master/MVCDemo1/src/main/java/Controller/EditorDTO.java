package controller;

import entity.Editor;
import lombok.*;

@Data
@RequiredArgsConstructor(staticName = "of")
public class EditorDTO {
    private String cnpjDto;
    private String nameDto;


    public Editor convertToEditor(EditorDTO editorDto){
        Editor editor = Editor.of(editorDto.getCnpjDto(),editorDto.getNameDto());
        //editor.setCnpj(editorDto.getCnpjDto());
        //editor.setName(editorDto.getNameDto());
        return editor;
    }

}
