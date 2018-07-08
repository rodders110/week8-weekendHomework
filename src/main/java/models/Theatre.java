package models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "theatres")
public class Theatre {

    private int id;
    private String name;
    private String Address;
    private List<Play> plays;

    public Theatre() {
    }

    public Theatre(String name, String address) {
        this.name = name;
        Address = address;
        this.plays = new ArrayList<Play>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "address")
    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToMany
    @JoinTable(name = "plays_theatres",
            joinColumns = {@JoinColumn(name = "theatre_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "play_id", nullable = false, updatable = false)})
    public List<Play> getPlays() {
        return plays;
    }


    public void setPlays(List<Play> plays) {
        this.plays = plays;
    }

    public void addPlay(Play play){
        this.plays.add(play);
    }
}
