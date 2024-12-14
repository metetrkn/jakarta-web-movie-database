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


// baseURL annotation
@Path("/movies")
// MovieResource is a restfull web service intermediate, controller between client and database
public class MovieResource {
    // Dependency injection of MovieRepository
    @Inject
    private MovieRepository movieRepository;


    // Read all movies at once from database
    @GET// HTTP GET Request for all movies
    @Produces(MediaType.APPLICATION_JSON) // Output in JSON format
    public List<Movie> getMovies() {
        return movieRepository.findMovies(); //  movieRepository objects method to get all movies as a list object
    }


    // Read a movie from database
    @GET // HTTP GET request for each individual movie
    @Path("/{id}") // ID part in URL to detect each movie from database
    @Produces(MediaType.APPLICATION_JSON) // Returns movies data in JSON format
    public Response getMovie(@PathParam("id") Long id) { // ID part from URL extracted and give as an parameter to getMovie method
        Movie movie = movieRepository.findMovie(id); // Checks movie in db and returns it in movie variable
        if (movie == null) { // If movie doesnt found, return 404 error
            return Response.status(Response.Status.NOT_FOUND).build();
        } // Otherwise
        return Response.ok(movie).build(); // Return movie with 200
    }


    // Creates a new movie in db
    @POST// HTTP POST request for each individual movie
    @Consumes(MediaType.APPLICATION_JSON) // Expects from client to send data in JSON format
    public Response addMovie(Movie movie) {
        movieRepository.createMovie(movie); // Adds one movie into database
        return Response.status(Response.Status.CREATED).entity("Movie created").build(); // Returns 201 and message if successful
    }


    // Updating one existing movie
    @PUT // HTTP PUT request for each individual movie
    @Path("/{id}") // Updates movie which matches with ID from URL
    @Consumes(MediaType.APPLICATION_JSON) // Data from client expected in JSON format
    public Response updateMovie(@PathParam("id") Long id, Movie updatedMovie) { // ID from URL extracted and given as paramater into this method
        Movie existingMovie = movieRepository.findMovie(id); // First checks if any movie existed in db based on given ID
        if (existingMovie == null) { // If there is no, we can not update not existing movie, returns 404 error and message
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


    // Deleting an existing movie
    @DELETE // HTTP DELETE request for each individual movie
    @Path("/{id}") // Deletes movie with matching ID from URL
    public Response deleteMovie(@PathParam("id") Long id) { // Gives ID from URL as parameter into method
        Movie existingMovie = movieRepository.findMovie(id); // Checks if there is a ID matching movie in db
        if (existingMovie == null) { // If there is no, returns message and 404
            return Response.status(Response.Status.NOT_FOUND).entity("Movie not found").build();
        }


        movieRepository.deleteMovie(id); // Deletes movie from mathcing ID
        return Response.ok("Movie deleted successfully").build(); // Return 200(OK) and deletes movies
    }
}