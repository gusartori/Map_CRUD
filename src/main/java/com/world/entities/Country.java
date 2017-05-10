package com.world.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Country {

    @Id
    private String initials;

    private String name;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "country")
    private List<State> stateList;

    public String getInitials() {
        return initials;
    }

    public String getName() {
        return name;
    }

    public List<State> getStateList() {
        return stateList;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStateList(List<State> stateList) {
        this.stateList = stateList;
    }

    public Country(String initials, String name) {
        this.initials = initials;
        this.name = name;
    }

    protected Country() {
    }
}
