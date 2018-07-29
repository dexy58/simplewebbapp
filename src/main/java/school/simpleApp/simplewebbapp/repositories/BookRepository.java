package school.simpleApp.simplewebbapp.repositories;

import org.springframework.data.repository.CrudRepository;
import school.simpleApp.simplewebbapp.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
