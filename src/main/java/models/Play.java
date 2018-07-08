package models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "plays")
public class Play {

    private int id;
    private String title;
    private GenreType genre;
    private int pop;
    private List<Character> characters;
    private Author author;
    private List<Theatre> theatres;

    public Play() {
    }

    public Play(String title, GenreType genre, int pop) {
        this.title = title;
        this.genre = genre;
        this.pop = pop;
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

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Enumerated(value = EnumType.STRING)
    public GenreType getGenre() {
        return genre;
    }

    public void setGenre(GenreType genre) {
        this.genre = genre;
    }

    @Column(name = "popularity")
    public int getPop() {
        return pop;
    }

    public void setPop(int pop) {
        this.pop = pop;
    }

    @OneToMany(mappedBy = "play", fetch = FetchType.LAZY)
    public List<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(Character character) {
        this.characters.add(character);
    }

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToMany
    @JoinTable(name = "plays_theatres",
            joinColumns = {@JoinColumn(name = "play_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "theatre_id", nullable = false, updatable = false)})
    public List<Theatre> getTheatres() {
        return theatres;
    }

    public void setTheatres(List<Theatre> theatres) {
        this.theatres = theatres;
    }

    public void addTheatre(Theatre theatre){
        this.theatres.add(theatre);
    }
}
