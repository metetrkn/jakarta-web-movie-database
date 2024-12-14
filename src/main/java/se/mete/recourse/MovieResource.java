// Packaging
package se.mete.recourse;


// Jakarta entities for interaction with database
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import se.mete.model.Movie; // Movie class-table
import se.mete.movieDatabase.MovieRepository; // Abstract layer to interact with database
import java.util.List; // List object defined default in util


/**
 * MovieResource class is a RESTful controller between clint and db
 * It handles HTTP CRUD <Create, Read, Update, Delete> requests
 */
@Path("/movies") // baseURL annotation
// MovieResource is a restfull web service intermediate, controller between client and database
public class MovieResource {
    // Dependency injection of MovieRepository
    @Inject
    private MovieRepository movieRepository;


    /**
     * Retrieves all movies from db
     *
     * @return a list of Movies in JSON format
     */
    @GET// HTTP GET Request for all movies
    @Produces(MediaType.APPLICATION_JSON)
    public List<Movie> getMovies() {
        return movieRepository.findMovies();
    }



    /**
     * Retrieves only one movie from the db based on matching ID
     *
     * @param id the ID of the movie to retrieve
     * @return a Response contains movies info in JSON format with status 200 if movie find otherwise status 400
     */
    @GET // HTTP GET request for each individual movie
    @Path("/{id}") // ID part in URL to detect each movie from database
    @Produces(MediaType.APPLICATION_JSON) // Returns movies data in JSON format
    public Response getMovie(@PathParam("id") Long id) {
        Movie movie = movieRepository.findMovie(id);
        if (movie == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(movie).build();
    }


    /**
     * Add only one movie to the db at a time
     *
     * @param movie as JSON format to add into db
     * @return a Response 201 with "Movie created" message
     */
    @POST// HTTP POST request for each individual movie
    @Consumes(MediaType.APPLICATION_JSON) // Expects from client to send data in JSON format
    public Response addMovie(Movie movie) {
        movieRepository.createMovie(movie);
        return Response.status(Response.Status.CREATED).entity("Movie created").build();
    }



    /**
     * Updates an existing movie in the db
     *
     * @param id the ID of the old movie
     * @param updatedMovie the new movie object
     * @return a Response 404 with message if movie doesn't found, otherwise updates movie and return 200 with message
     */
    @PUT // HTTP PUT request for each individual movie
    @Path("/{id}") // Updates movie which matches with ID from URL
    @Consumes(MediaType.APPLICATION_JSON) // Data from client expected in JSON format
    public Response updateMovie(@PathParam("id") Long id, Movie updatedMovie) {
        Movie existingMovie = movieRepository.findMovie(id);
        if (existingMovie == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Movie not found").build();
        }

        // Updates movie with given parameters
        existingMovie.setTitle(updatedMovie.getTitle()); // New title
        existingMovie.setGenre(updatedMovie.getGenre()); // New genre
        existingMovie.setReleaseYear(updatedMovie.getReleaseYear()); // New release year
        existingMovie.setDescription(updatedMovie.getDescription()); // New description
        existingMovie.setDirector(updatedMovie.getDirector()); // New regissör

        movieRepository.updateMovie(existingMovie); // Makes update on detected existing movie
        return Response.ok("Movie updated successfully").build(); // Returns 200 (Ok) and message
    }


    /**
     * Deletes a movie from db based on matching id
     *
     * @param id the ID of the movie to be deleted
     * @return a Response 404 with message if movie doesn't found, otherwise deletes the movie and return 200 with message
     */
    @DELETE // HTTP DELETE request for each individual movie
    @Path("/{id}") // Deletes movie with matching ID from URL
    public Response deleteMovie(@PathParam("id") Long id) {
        Movie existingMovie = movieRepository.findMovie(id);
        if (existingMovie == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Movie not found").build();
        }

        movieRepository.deleteMovie(id);
        return Response.ok("Movie deleted successfully").build();
    }
}