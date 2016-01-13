package kerstein.rottentomatoes;

import java.io.Serializable;

/**
 * Created by elka on 1/12/2016.
 */
public class UpcomingMovies implements Serializable {

    private Movie[] movies;

    public Movie[] getMovies() {
        return movies;
    }
}
