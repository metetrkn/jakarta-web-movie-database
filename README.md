# Movie Management API

This is a RESTful API for managing movies using Jakarta EE (Jakarta REST, Jakarta Persistence, and Jakarta JSON). The API allows you to create, read, update, and delete movie records in a database.

## Project Structure

- **`HelloApplication`**: Configures the base URL for the API (`/api`).
- **`Movie`**: Represents the movie entity mapped to a database table.
- **`MovieRepository`**: Handles CRUD operations with the database.
- **`MovieResource`**: Exposes the API endpoints for interacting with movie data.

## Endpoints
    
### 1. Get All Movies
**HTTP Method**: `GET`  
**URL**: `/api/movies`  
**Response**: Returns a list of all movies in JSON format.  
**Example Response**:
```json
[
  {
    "id": 1,
    "title": "Inception",
    "genre": "Sci-Fi",
    "releaseYear": 2010,
    "description": "A thief who steals corporate secrets through the use of dream-sharing technology.",
    "director": "Christopher Nolan"
  },
  ...
]
```


### 2. Get Movie by ID
**HTTP Method**: `GET`
**URL**: `/api/movies/{id}`
**Response**: `Returns the movie details for the specified ID.`
**Example Response**:
```json
[
    {
    "id": 1,
    "title": "Inception",
    "genre": "Sci-Fi",
    "releaseYear": 2010,
    "description": "A thief who steals corporate secrets through the use of dream-sharing technology.",
    "director": "Christopher Nolan"
    },
  ...
]
```


### 3. Add a New Movie
**HTTP Method**: `POST`  
**URL**: `/api/movies`  
**Request Body**: JSON object containing movie details.  
**Example Request**:
```json
{
  "title": "Interstellar",
  "genre": "Sci-Fi",
  "releaseYear": 2014,
  "description": "A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.",
  "director": "Christopher Nolan"
}
```
Response:
Returns 201 Created with a success message: "Movie created".


### 4. Update an Existing Movie
**HTTP Method**: `PUT`  
**URL**: `/api/movies/{id}`  
**Request Body**: JSON object containing updated movie details.  
**Example Request**:
```json
{
  "title": "Interstellar",
  "genre": "Sci-Fi",
  "releaseYear": 2014,
  "description": "An epic journey to save humanity.",
  "director": "Christopher Nolan"
}
```
Response:
Returns 200 OK with a success message: "Movie updated successfully".
If the movie is not found, returns 404 Not Found.


### 5. Delete a Movie
**HTTP Method**: `DELETE`  
**URL**: `/api/movies/{id}`  
**Response**:  
Returns `200 OK` with a success message: `"Movie deleted successfully"`.  
If the movie is not found, returns `404 Not Found`.

## Dependencies

- **Jakarta RESTful Web Services (JAX-RS)** for creating RESTful services.
- **Jakarta Persistence (JPA)** for interacting with the database.
- **Jakarta JSON Binding** for serializing and deserializing JSON data.
- A **relational database** (e.g., MySQL, PostgreSQL, etc.) for storing movie data.

## Setup Instructions

1. Clone the repository.
2. Configure the database connection in your application server (e.g., WildFly, Payara).
3. Build and deploy the application to your server.
4. Access the API through `http://localhost:8080/api/movies`.

## Technologies Used

- **Jakarta EE**
- **JDK 11**
- **JPA  vers. 9.1(Java Persistence API)** 
- **JAX-RS (Jakarta API for RESTful Web Services)**
- **JSON Binding (Jakarta JSON)**

### Credits

This project was developed by Mete Turkan.


### License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

