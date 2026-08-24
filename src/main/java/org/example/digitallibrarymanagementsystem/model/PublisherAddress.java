package org.example.digitallibrarymanagementsystem.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class PublisherAddress {

    private String city;
    private String street;
    private int postalCod;

    public PublisherAddress(){

    }

    public PublisherAddress(String city, String street, int postalCod) {
        this.city = city;
        this.street = street;
        this.postalCod = postalCod;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getPostalCod() {
        return postalCod;
    }

    public void setPostalCod(int postalCod) {
        this.postalCod = postalCod;
    }

    @Override
    public String toString() {
        return "PublisherAddress{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", postalCod=" + postalCod +
                '}';
    }
}
