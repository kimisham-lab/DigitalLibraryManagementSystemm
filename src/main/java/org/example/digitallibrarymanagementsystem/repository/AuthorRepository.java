package org.example.digitallibrarymanagementsystem.repository;

import org.example.digitallibrarymanagementsystem.model.Author;
import org.example.digitallibrarymanagementsystem.util.HibernateUtil;
import org.glassfish.jaxb.core.v2.model.core.ID;

import java.util.Optional;

public class AuthorRepository implements GenericRepository<Author, ID> {
    @Override
    public Author save(Author author) {
        HibernateUtil.inTxReturn(entityManager -> {
            entityManager.persist(author);
            return author;
        });
        return null;
    }

    @Override
    public Optional<Author> findById(Author author, ID id) {
        return Optional.ofNullable(HibernateUtil.inTxReturn(entityManager ->
                entityManager.find(Author.class, id)));
    }

    @Override
    public void update(Author author, ID id) {
        HibernateUtil.inTxReturn(entityManager -> {
            Author author1 = entityManager.find(Author.class, id);
            if (author == null) {
                return null;
            }
            author1.setName(author.getName());
            author1.setBirthDate(author.getBirthDate());
            author1.setProfile(author.getProfile());

            return author1;
        });
    }

    @Override
    public void delete(ID id) {
        HibernateUtil.inTxReturn(entityManager -> {
            Author author = entityManager.find(Author.class, id);
            if (author == null) {
                System.out.println("Author Not Found");
            }
            entityManager.remove(author);
            return null;
        });
    }
}
