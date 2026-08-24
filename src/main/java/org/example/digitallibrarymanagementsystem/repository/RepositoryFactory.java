package org.example.digitallibrarymanagementsystem.repository;

import org.example.digitallibrarymanagementsystem.model.Author;
import org.example.digitallibrarymanagementsystem.model.Book;
import org.example.digitallibrarymanagementsystem.model.Category;
import org.example.digitallibrarymanagementsystem.model.Profile;

public class RepositoryFactory {

    public static <T,ID> GenericRepository<T,ID> CreateRepository(Class<?> entityType){
        if (entityType== Book.class){
            return (GenericRepository<T, ID>) new BookRepository();
        }
        if (entityType== Author.class){
            return (GenericRepository<T, ID>) new AuthorRepository();
        }
        if (entityType== Category.class){
            return (GenericRepository<T, ID>) new CategoryRepository();
        }
        if (entityType== Profile.class){
            return (GenericRepository<T, ID>) new ProfileRepository();
        }
        throw new IllegalArgumentException(
                "Unknown entity type"
        );
    }
}
