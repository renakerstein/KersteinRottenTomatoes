package kerstein.rottentomatoes;

public class CurrentUpcoming {

    private Movies current;

    private UpcomingMovies upcoming;

    public CurrentUpcoming(Movies current, UpcomingMovies upcoming) {
        this.current = current;
        this.upcoming = upcoming;
    }


    public UpcomingMovies getUpcoming() {
        return upcoming;
    }

    public Movies getCurrent() {
        return current;
    }
}
