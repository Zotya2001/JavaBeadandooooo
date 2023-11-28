package com.example.szeleromu.szeleromu;

import jakarta.persistence.*;

@Entity
@Table(name = "torony")
public class Torony {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer darab;

    @Column(nullable = false)
    private Integer teljesitmeny;

    @Column(nullable = false)
    private Integer kezdev;

    @Column(name = "helyszinid", nullable = false)
    private Integer helyszinId;

    // Getters and setters
    // ...

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDarab() {
        return darab;
    }

    public void setDarab(Integer darab) {
        this.darab = darab;
    }

    public Integer getTeljesitmeny() {
        return teljesitmeny;
    }

    public void setTeljesitmeny(Integer teljesitmeny) {
        this.teljesitmeny = teljesitmeny;
    }

    public Integer getKezdev() {
        return kezdev;
    }

    public void setKezdev(Integer kezdev) {
        this.kezdev = kezdev;
    }

    public Integer getHelyszinId() {
        return helyszinId;
    }

    public void setHelyszinId(Integer helyszinId) {
        this.helyszinId = helyszinId;
    }
}

