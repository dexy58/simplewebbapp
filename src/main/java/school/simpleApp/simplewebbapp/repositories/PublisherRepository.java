package school.simpleApp.simplewebbapp.repositories;

import org.springframework.data.repository.CrudRepository;
import school.simpleApp.simplewebbapp.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
