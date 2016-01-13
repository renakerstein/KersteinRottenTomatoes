package kerstein.rottentomatoes;

import java.io.Serializable;

public class Movies  implements Serializable {

    private Movie[] movies;

    public Movie[] getMovies() {
        return movies;
    }
}
