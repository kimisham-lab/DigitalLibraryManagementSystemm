package org.example.digitallibrarymanagementsystem.repository;

import org.example.digitallibrarymanagementsystem.model.Category;
import org.example.digitallibrarymanagementsystem.util.HibernateUtil;
import org.glassfish.jaxb.core.v2.model.core.ID;
import org.hibernate.boot.beanvalidation.HibernateTraversableResolver;

import java.util.Optional;

public class CategoryRepository implements GenericRepository<Category, ID>{

    @Override
    public Category save(Category category) {
        HibernateUtil.inTxReturn(entityManager -> {
            entityManager.persist(category);
            return category;
        });
        return null;
    }

    @Override
    public Optional<Category> findById(Category category, ID id) {
        return Optional.ofNullable(HibernateUtil.inTxReturn(entityManager ->
                entityManager.find(Category.class,id)));
    }

    @Override
    public void update(Category category, ID id) {
        HibernateUtil.inTxReturn(entityManager -> {
            Category category1=entityManager.find(Category.class,id);
            if (category1==null){
                return null;
            }
            category1.setName(category.getName());
            category1.setBooks(category.getBooks());

            return category1;
        });
    }

    @Override
    public void delete(ID id) {
        HibernateUtil.inTxReturn(entityManager -> {
            Category category=entityManager.find(Category.class,id);
            if (category == null) {
                System.out.println("Category Not Found");
            }
            entityManager.remove(category);
            return null;
        });
    }
}
