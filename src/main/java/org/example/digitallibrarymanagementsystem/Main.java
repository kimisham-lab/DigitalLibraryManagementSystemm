package org.example.digitallibrarymanagementsystem;

import jakarta.persistence.Id;
import jakarta.persistence.Persistence;
import org.example.digitallibrarymanagementsystem.enumes.StockStatus;
import org.example.digitallibrarymanagementsystem.model.*;
import org.example.digitallibrarymanagementsystem.repository.BookRepository;
import org.example.digitallibrarymanagementsystem.repository.GenericRepository;
import org.example.digitallibrarymanagementsystem.repository.RepositoryFactory;
import org.glassfish.jaxb.core.v2.model.core.ID;

import java.util.List;

public class Main {
    static void main(String[] args) {
        Persistence.createEntityManagerFactory("Digital_Library");
        //3 Books and category
        Book book1 = new Book.Builder()
                .title("The Great Gatsby")
                .isbn("9780743273565")
                .publicationYear(2004)
                .price(12.99)
                .stockStatus(StockStatus.IN_STOCK)
                .publisherAddress(new PublisherAddress(
                        "new york",
                        "123 Fifth",
                        10001))
                .build();
        GenericRepository<Book,Long> bookRepository =
                RepositoryFactory.CreateRepository(Book.class);
        bookRepository.save(book1);
        Book book2 = new Book.Builder()
                .title("1984")
                .isbn("9780451524935")
                .publicationYear(1949)
                .price(15.50)
                .stockStatus(StockStatus.OUT_OF_STOCK)
                .publisherAddress(new PublisherAddress(
                        "London",
                        "45 Oxford Street",
                        20))
                .build();
        bookRepository.save(book2);
        Book book3 = new Book.Builder()
                .title("The Hobbit")
                .isbn("9780547928227")
                .publicationYear(2012)
                .price(18.75)
                .stockStatus(StockStatus.COMING_SOON)
                .publisherAddress(new PublisherAddress(
                        "Boston",
                        "80 Boylston Street",
                        30))
                .build();
        bookRepository.save(book3);
        //=================================================================
        Category category = new Category("classic", List.of(book1, book2, book3));
        book1.setCategory(category);
        book2.setCategory(category);
        book3.setCategory(category);
        //3 Author with profile
        Author author1 = new Author.Builder()
                .name("F. Scott Fitzgerald")
                .birthDate(1896 / 9 / 24)
                .build();
        Profile profile1 = new Profile("American novelist and short-story writer.",
                "https://www.fscottfitzgerald.com", author1);
        author1.setProfile(profile1);
        book1.setAuthors(List.of(author1));
        //============================================================================
        Author author2 = new Author.Builder()
                .name("George Orwell")
                .birthDate(1903 / 6 / 25)
                .build();
        Profile profile2 = new Profile("English novelist, essayist and critic.",
                "https://www.orwellfoundation.com", author2);
        author2.setProfile(profile2);
        book2.setAuthors(List.of(author2));
        //===========================================================================
        Author author3 = new Author.Builder()
                .name("J. R. R. Tolkien")
                .birthDate(1892 / 3)
                .build();
        Profile profile3 = new Profile("English writer, poet and philologist.",
                "https://www.tolkien.co.uk", author3);
        author3.setProfile(profile3);
        book3.setAuthors(List.of(author3));
        //=============================================================================

    }
}
