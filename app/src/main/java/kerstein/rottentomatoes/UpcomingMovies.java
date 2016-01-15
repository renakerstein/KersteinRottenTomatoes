package kerstein.rottentomatoes;

import java.io.Serializable;

public class UpcomingMovies implements Serializable {

    private Movie[] movies;

    public Movie[] getMovies() {
        return movies;
    }
}
