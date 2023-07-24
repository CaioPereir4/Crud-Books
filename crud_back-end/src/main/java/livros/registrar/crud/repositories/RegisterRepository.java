package livros.registrar.crud.repositories;

import livros.registrar.crud.models.RegisterBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterRepository extends JpaRepository<RegisterBook,Long> {
}
