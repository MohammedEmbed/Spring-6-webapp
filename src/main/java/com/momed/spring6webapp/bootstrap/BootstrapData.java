package com.momed.spring6webapp.bootstrap;

import com.momed.spring6webapp.domain.Author;
import com.momed.spring6webapp.domain.Book;
import com.momed.spring6webapp.domain.Publisher;
import com.momed.spring6webapp.repositories.AuthorRepoistory;
import com.momed.spring6webapp.repositories.BookRepository;
import com.momed.spring6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepoistory authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepoistory authorRepoistory, BookRepository bookrepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepoistory;
        this.bookRepository = bookrepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author ted = new Author();
        ted.setLastName("Kaczynski");
        ted.setFirstName("Ted");

        Book isaif = new Book();
        isaif.setTitle("Industrial Society and Its Future");
        isaif.setIsbn("1");

        Author tedSaved = authorRepository.save(ted);
        Book isaifSaved = bookRepository.save(isaif);

        Author eric = new Author();
        ted.setLastName("Eric");
        ted.setFirstName("Evans");

        Book ddd = new Book();
        isaif.setTitle("Domain Driven Design");
        isaif.setIsbn("2");

        Author ericSaved = authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);

        tedSaved.getBooks().add(isaifSaved);
        ericSaved.getBooks().add(dddSaved);

        authorRepository.save(ericSaved);
        authorRepository.save(tedSaved);

        Publisher tedpub = new Publisher();
        tedpub.setAddress("1378 Stemple Pass Rd");
        tedpub.setCity("Lincoln");
        tedpub.setState("MT");
        tedpub.setZip("59639");

        publisherRepository.save(tedpub);

        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
        System.out.println("Publisher Count: " + publisherRepository.count());

    }
}
