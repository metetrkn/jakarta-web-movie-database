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

// Abstract layer to handle with data until data become persistence in database
public class MovieRepository {
    // Injects EntityManager object which interact with database
    @PersistenceContext
    private EntityManager entityManager;

    // Returns all movies from database
    public List<Movie> findMovies() {
        return entityManager.createQuery("SELECT m FROM Movie m", Movie.class).getResultList();
    }

    // Returns one movie from database
    public Movie findMovie(Long id) {
        return entityManager.find(Movie.class, id);
    }

    // Create one movie into database
    public void createMovie(Movie movie) {
        entityManager.persist(movie);
    }

    // Update one movie which is already in database
    public void updateMovie(Movie movie) {
        entityManager.merge(movie);
    }

    // Delete one movie from database
    public void deleteMovie(Long id) {
        Movie movie = findMovie(id);
        if (movie != null) {
            entityManager.remove(movie);
        }
    }
}