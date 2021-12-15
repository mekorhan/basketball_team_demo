package com.producter.demo.model;

import com.producter.demo.constants.GeneralEnumerationDefinition;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    private GeneralEnumerationDefinition.Positions position;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public GeneralEnumerationDefinition.Positions getPosition() {
        return position;
    }

    public void setPositions(GeneralEnumerationDefinition.Positions positions) {
        this.position = positions;
    }
}
