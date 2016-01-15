package kerstein.rottentomatoes;

import java.io.Serializable;

public class Reviews implements Serializable {

    private Review[] reviews;

    public Review[] getReviews() {
        return reviews;
    }
}
