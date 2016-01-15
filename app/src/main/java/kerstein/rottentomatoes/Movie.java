package kerstein.rottentomatoes;

import java.io.Serializable;

public class Movie implements Serializable {

    private String title;
    private String mpaa_rating;
    private String runtime;
    private ReleaseDate release_dates;
    private AbridgedCast[] abridged_cast;
    private Rating ratings;
    private Posters posters;
    private Links links;
    private String synopsis;

    public String getTitle() {
        return title;
    }

    public String getMpaa_rating() {
        return mpaa_rating;
    }

    public String getRuntime() {
        return runtime;
    }

    public ReleaseDate getReleaseDates() {
        return release_dates;
    }

    public AbridgedCast[] getAbridgedCast() {
        return abridged_cast;
    }

    public Rating getRatings() {
        return ratings;
    }

    public Posters getPosters() {
        return posters;
    }

    public Links getLinks() {
        return links;
    }

    public String getSynopsis() {
        return synopsis;
    }
}
