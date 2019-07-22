package entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Data
@RequiredArgsConstructor(staticName = "of")
@Entity
public class Editor {
    @Id
    private String cnpj;
    @JoinColumn(name = "name")
    private String name;
}
