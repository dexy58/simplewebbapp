package school.simpleApp.simplewebbapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import school.simpleApp.simplewebbapp.model.Author;
import school.simpleApp.simplewebbapp.model.Book;
import school.simpleApp.simplewebbapp.model.Publisher;
import school.simpleApp.simplewebbapp.repositories.AuthorRepository;
import school.simpleApp.simplewebbapp.repositories.BookRepository;
import school.simpleApp.simplewebbapp.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        Publisher publisher = new Publisher();
        publisher.setName("foo");
        publisherRepository.save(publisher);

        //Eric
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book ("Domain Driven Design", "1234", publisher);
        eric.getBook().add(ddd);
        ddd.getAuthor().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        //Rod
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "23444", publisher);
        rod.getBook().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }
}
