package org.example.digitallibrarymanagementsystem.model;


import jakarta.persistence.*;
import org.example.digitallibrarymanagementsystem.enumes.StockStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String isbn;
    private int publicationYear;
    private double price;
    @Enumerated(EnumType.STRING)
    private StockStatus stockStatus;
    @Embedded
    private PublisherAddress publisherAddress;
    @ManyToMany
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn (name = "author_id")
    )
    private List<Author> authors = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

    public Book(){

    }

    public  Book(Builder builder) {
        this.title = builder.title;
        this.isbn =builder. isbn;
        this.publicationYear = builder.publicationYear;
        this.price = builder.price;
        this.stockStatus = builder.stockStatus;
        this.publisherAddress = builder.publisherAddress;
        this.authors = builder.authors;
        this.category = builder.category;
    }
    public static class Builder{
        private String title;
        private String isbn;
        private int publicationYear;
        private double price;
        private StockStatus stockStatus;
        private PublisherAddress publisherAddress;
        private List<Author> authors = new ArrayList<>();
        private Category category;

        public Builder title(String title){
            this.title=title;
            return this;
        }
        public Builder isbn(String isbn){
            this.isbn=isbn;
            return this;
        }
        public Builder publicationYear(int publicationYear){
            this.publicationYear=publicationYear;
            return this;
        }
        public Builder price(double price){
            this.price=price;
            return this;
        }
        public Builder stockStatus(StockStatus stockStatus) {
            this.stockStatus=stockStatus;
            return this;
        }
        public Builder publisherAddress(PublisherAddress publisherAddress){
            this.publicationYear=publicationYear;
            return this;
        }
        public Builder authors(List<Author> authors){
            this.authors=authors;
            return this;
        }
        public Builder category(Category category){
            this.category=category;
            return this;
        }
        public Book build(){
            return new Book(this);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public StockStatus getStockStatus() {
        return stockStatus;
    }

    public void setStockStatus(StockStatus stockStatus) {
        this.stockStatus = stockStatus;
    }

    public PublisherAddress getPublisherAddress() {
        return publisherAddress;
    }

    public void setPublisherAddress(PublisherAddress publisherAddress) {
        this.publisherAddress = publisherAddress;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", publicationYear=" + publicationYear +
                ", price=" + price +
                ", stockStatus=" + stockStatus +
                ", publisherAddress=" + publisherAddress +
                '}';
    }
}
