package ci.digitalacademy.monetab.repositories;


import ci.digitalacademy.monetab.models.NoteFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteFileRepository extends JpaRepository<NoteFile, Long> {
}
