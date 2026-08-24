package org.example.digitallibrarymanagementsystem.repository;

import org.example.digitallibrarymanagementsystem.model.Book;
import org.example.digitallibrarymanagementsystem.util.HibernateUtil;
import org.glassfish.jaxb.core.v2.model.core.ID;

import java.util.Optional;

public class BookRepository implements GenericRepository<Book, ID> {
    @Override
    public Book save(Book book) {
        HibernateUtil.inTxReturn(entityManager -> {
            entityManager.persist(book);
            return book;
        });
        return null;
    }

    @Override
    public Optional<Book> findById(Book book, ID id) {
        return Optional.ofNullable(HibernateUtil.inTxReturn(entityManager ->
                entityManager.find(Book.class, id)));
    }

    @Override
    public void update(Book book, ID id) {
        HibernateUtil.inTxReturn(entityManager -> {
            Book book1 = entityManager.find(Book.class, id);
            if (book1 == null) {
                return null;
            }
            book1.setTitle(book.getTitle());
            book1.setIsbn(book.getIsbn());
            book1.setPublicationYear(book.getPublicationYear());
            book1.setPrice(book.getPrice());
            book1.setStockStatus(book.getStockStatus());
            book1.setPublisherAddress(book.getPublisherAddress());

            return book1;
        });
    }

    @Override
    public void delete(ID id) {
        HibernateUtil.inTxReturn(entityManager -> {
            Book book = entityManager.find(Book.class, id);
            if (book == null) {
                System.out.println("Book Not Found");
            }
            entityManager.remove(book);
            return null;
        });
    }
}
