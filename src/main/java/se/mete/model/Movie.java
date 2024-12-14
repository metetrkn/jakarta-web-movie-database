// Packaging class
package se.mete.model;

// Importing Jakarta json binding and persistence api's
import jakarta.json.bind.annotation.JsonbPropertyOrder;
import jakarta.persistence.*;


// Class definition
// Table schema
@JsonbPropertyOrder({"title","genre","releaseYear","description","director"})
@Entity // States that this class will be mapped into JPA table
@Table(name = "movies") // Name of table in database


public class Movie {
    // Defining id column
    @Id // Id for each row
    @GeneratedValue(strategy = GenerationType.AUTO) // Generates id automatic
    @Column(name = "id", nullable = false) //  Name of column is id and can be empty
    private Long id; // Id, unique and Long type of object


    private String title;         // Movies title
    private String genre;         // Movies genre
    private int releaseYear;      // Movies release year
    private String description;   // Description about film
    private String director;      // Directors name


    // Default empty constructor which is needed for Java Persistance API
    public Movie() {
    }


    // Parameterized constructor to create actual Movie class with its parameters
    public Movie(String title, String genre, int releaseYear, String description, String director) {
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.description = description;
        this.director = director;
    }


    // Getters och setters of Movie classes paramaters
    public Long getId() {// för att hämta id
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}