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



/**
 * The Movie class represents a movie entity with its details such as title, genre, release year, description, and director.
 * It is mapped to "movies" table and its columns in the db.
 */
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


    /**
     * Default empty constructor which is needed for Java Persistance API
     */
    public Movie() {
    }


    /**
     * Parameterized constructor to create actual Movie class with its parameters
     *
     * @param title = String, name of movie
     * @param genre = String, type of movie
     * @param releaseYear = int, release year of movie
     * @param description = String, short description about movie
     * @param director = String, director of the movie
     */
    public Movie(String title, String genre, int releaseYear, String description, String director) {
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.description = description;
        this.director = director;
    }


    /**
     * Get method of ID in table
     *
     * @return ID
     */
    // Getters och setters of Movie classes paramaters
    public Long getId() {// för att hämta id
        return id;
    }


    /**
     * Get method of the movie's title
     *
     * @return title
     */
    public String getTitle() {
        return title;
    }


    /**
     * Sets the title of the movie
     *
     * @param title Movie's title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }


    /**
     * Get method of movies genre
     *
     * @return genre
     */
    public String getGenre() {
        return genre;
    }


    /**
     * Sets the genre of the movie
     *
     * @param genre Movie's genre to set
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }


    /**
     * Get method of movie's release year
     *
     * @return releaseYear
     */
    public int getReleaseYear() {
        return releaseYear;
    }


    /**
     * Sets the release year of the movie
     *
     * @param releaseYear Movie's release year to set
     */
    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }


    /**
     * Get method of movie's description
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }


    /**
     * Sets the description of the movie
     *
     * @param description Movies description to set.
     */
    public void setDescription(String description) {
        this.description = description;
    }


    /**
     * Get method of movie's director
     *
     * @return director
     */
    public String getDirector() {
        return director;
    }


    /**
     * Sets the director's name.
     *
     * @param director Director's name to set.
     */
    public void setDirector(String director) {
        this.director = director;
    }
}