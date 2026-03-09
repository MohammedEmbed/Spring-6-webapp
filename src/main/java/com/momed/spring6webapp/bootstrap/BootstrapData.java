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

        Author eric = new Author();
        eric.setLastName("Eric");
        eric.setFirstName("Evans");

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("2");

        Author tedSaved = authorRepository.save(ted);
        Book isaifSaved = bookRepository.save(isaif);
        Author ericSaved = authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);

        Publisher tedpub = new Publisher();
        tedpub.setPublisherName("Teddy Publishing");
        tedpub.setAddress("1378 Stemple Pass Rd");
        tedpub.setCity("Lincoln");
        tedpub.setState("MT");
        tedpub.setZip("59639");
        Publisher tedpubSaved = publisherRepository.save(tedpub);


        isaifSaved.setPublisher(tedpubSaved);
        dddSaved.setPublisher(tedpubSaved);


        tedSaved.getBooks().add(isaifSaved);
        ericSaved.getBooks().add(dddSaved);
        isaifSaved.getAuthors().add(tedSaved);
        dddSaved.getAuthors().add(ericSaved);

        authorRepository.save(ericSaved);
        authorRepository.save(tedSaved);
        bookRepository.save(dddSaved);
        bookRepository.save(isaifSaved);

        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
        System.out.println("Publisher Count: " + publisherRepository.count());

    }
}
