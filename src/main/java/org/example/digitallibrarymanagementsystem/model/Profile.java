package org.example.digitallibrarymanagementsystem.model;

import jakarta.persistence.*;

import javax.print.attribute.standard.JobImpressions;
import java.util.Objects;

@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bio;
    private String website;
    @OneToOne
    @JoinColumn(name = "author_id")
    private Author author;

    public Profile(){

    }

    public Profile(String bio, String website, Author author) {
        this.bio = bio;
        this.website = website;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return Objects.equals(id, profile.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", bio='" + bio + '\'' +
                ", website='" + website + '\'' +
                ", author=" + author +
                '}';
    }
}
