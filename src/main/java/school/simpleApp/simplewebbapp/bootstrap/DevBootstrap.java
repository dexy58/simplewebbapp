package school.simpleApp.simplewebbapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import school.simpleApp.simplewebbapp.model.Author;
import school.simpleApp.simplewebbapp.model.Book;
import school.simpleApp.simplewebbapp.repositories.AuthorRepository;
import school.simpleApp.simplewebbapp.repositories.BookRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){
        //Eric
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book ("Domain Driven Design", "1234","Harper Collins");
        eric.getBook().add(ddd);
        ddd.getAuthor().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        //Rod
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "23444", "Worx");
        rod.getBook().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }
}
