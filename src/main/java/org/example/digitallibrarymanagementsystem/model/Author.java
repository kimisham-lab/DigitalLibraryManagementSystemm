package org.example.digitallibrarymanagementsystem.model;


import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(name = "birth_date")
    private int birthDate;
    @OneToOne(mappedBy = "author",
    cascade = CascadeType.ALL,
    orphanRemoval = true)
    private Profile profile;
    @ManyToMany(mappedBy = "authors")
    private List<Book> bookList;

    public Author() {

    }

    public Author(Builder builder) {
        this.name = builder.name;
        this.birthDate = builder.birthDate;
        this.profile = builder.profile;
        this.bookList = builder.bookList;
    }

    public static class Builder {

        private String name;
        private int birthDate;
        private Profile profile;
        private List<Book> bookList;

        public Builder name(String name){
            this.name=name;
            return this;
        }
        public Builder birthDate(int birthDate){
            this.birthDate=birthDate;
            return this;
        }
        public Builder profile(Profile profile){
            this.profile=profile;
            return this;
        }
        public Builder bookList(List<Book> bookList){
            this.bookList=bookList;
            return this;
        }
        public Author build(){
            return new Author(this);
        }
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int  getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(int birthDate) {
        this.birthDate = birthDate;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(id, author.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", profile=" + profile +
                '}';
    }
}
