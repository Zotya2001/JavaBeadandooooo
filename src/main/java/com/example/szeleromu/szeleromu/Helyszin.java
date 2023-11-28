package com.example.szeleromu.szeleromu;

import jakarta.persistence.*;

@Entity
@Table(name = "helyszin")
public class Helyszin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, nullable = false)
    private String nev;

    @Column(name = "megyeid", nullable = false)
    private Integer megyeId;

    // Getters and setters
    // ...

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public Integer getMegyeId() {
        return megyeId;
    }

    public void setMegyeId(Integer megyeId) {
        this.megyeId = megyeId;
    }
}
