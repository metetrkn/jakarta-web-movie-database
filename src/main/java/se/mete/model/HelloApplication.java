// Package that class belongs to
package se.mete.model;

// Importing from Jakarta Api Restfull
import jakarta.ws.rs.ApplicationPath;
// Parent class that comes from Restfull web applications
import jakarta.ws.rs.core.Application;

/**
 * Annotation to specify base URL  localhost:8080/api/....
 * HelloApplication inherits the parent 'Application' from Jakarta Restful web services
 */
@ApplicationPath("/api")
public class HelloApplication extends Application {

}