// Packaging
package se.mete.movieDatabase;


// Importing Jakarta entities
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import se.mete.model.Movie; // Importing Movie class which is table
import java.util.List; // Default list class


// Contexts and Dependency Injection<CDI>, create once use in entire app
@ApplicationScoped
// Transactions starts automatically before method execution and commit after method
// To ensure data persistence
@Transactional



/**
 * The MovieRepository class provides an abstract layer to handle data operations.
 * It is responsible for CRUD operations in the db.
 * Uses transactions and ensures data persistence.
 */
public class MovieRepository {
    // Injects EntityManager object which interact with database
    @PersistenceContext
    private EntityManager entityManager;


    /**
     * Returns all movies from db
     *
     * @return a list of Movie entities
     */
    public List<Movie> findMovies() {
        return entityManager.createQuery("SELECT m FROM Movie m", Movie.class).getResultList();
    }


    /**
     * Returns just one movie from db
     *
     * @return only one Movie entity.
     */
    public Movie findMovie(Long id) {
        return entityManager.find(Movie.class, id);
    }


    /**
     * Creates one movie in table,db
     *
     * @param movie to be persisted in the db
     */
    // Create one movie into database
    public void createMovie(Movie movie) {
        entityManager.persist(movie);
    }


    /**
     * Updates one existing movie in table,db
     *
     * @param movie to be updated in the db
     */
    // Update one movie which is already in database
    public void updateMovie(Movie movie) {
        entityManager.merge(movie);
    }


    /**
     * Deletes one movie in table,db
     *
     * @param id the ID of the movie to be deleted
     */
    // Delete one movie from database
    public void deleteMovie(Long id) {
        Movie movie = findMovie(id);
        if (movie != null) {
            entityManager.remove(movie);
        }
    }
}