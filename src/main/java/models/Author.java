package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "authors")
public class Author {

    private int id;
    private String name;
    private List<Play> works;


    public Author() {
    }

    public Author(String name) {
        this.name = name;
        this.works = new ArrayList<Play>();
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


    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    public List<Play> getWorks() {
        return works;
    }

    public void setWorks(List<Play> works) {
        this.works = works;
    }

    public void addPlay(Play play){
        works.add(play);
    }
}
