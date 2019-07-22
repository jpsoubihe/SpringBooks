package repository;

import entity.Editor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EditorRepository extends JpaRepository<Editor,String> {

    List<Editor> findByName(String name);
}
