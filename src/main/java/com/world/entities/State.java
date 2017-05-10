package com.world.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class State {

    @Id
    private String initials;

    private String name;

    private String country;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "state")
    List<City> cityList;

    public String getName() {
        return name;
    }

    public String getCountry() {

        return country;
    }

    public List<City> getCityList() {
        return cityList;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public State(String initials, String name) {
        this.initials = initials;
        this.name = name;
    }

    protected State() {

    }
}
