package ru.netology.entity;

//import java.util.Objects;

import java.util.Objects;

import static java.util.Objects.*;

public class Location {

    private final String city;

    private final Country country;

    private final String street;

    private final int building;

    public Location(String city, Country country, String street, int building) {
        this.city = city;
        this.country = country;
        this.street = street;
        this.building = building;
    }

    public String getCity() {
        return city;
    }

    public Country getCountry() {
        return country;
    }

    public String getStreet() {
        return street;
    }

    public int getBuiling() {
        return building;
    }

    @Override
    public boolean equals (Object o){
        if(this==o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(city, location.getCity())
                &&(Objects.equals(country,location.getCountry()))
                &&(Objects.equals(street,location.getStreet()))&&building==location.getBuiling();
    }

    @Override
    public int hashCode() {
        int total = 31;
        total = total*31+(city==null?0:city.hashCode());
        total = total*31+(country==null?0:country.hashCode());
        total = total*31+(street==null?0:street.hashCode());
        total = total*31+building;
        return total;
    }

    @Override
    public String toString(){
        StringBuilder output= new StringBuilder();
        if (city == null) {
            output.append("null, ");
        } else {
            output.append(this.getCity());
            output.append(", ");
        }
        if (country==null) output.append("null, ");
        else {
            output.append(country);
            output.append(", ");
        }
        if (street==null) output.append("null, ");
        else {
            output.append(street);
            output.append(", ");
        }
        output.append(building);
        return output.toString();
    }
}
