package school.simpleApp.simplewebbapp.repositories;

import org.springframework.data.repository.CrudRepository;
import school.simpleApp.simplewebbapp.model.Author;

//T - tip (Author) i ID je onaj Long id od Author-a
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
