package kerstein.rottentomatoes;

import java.io.Serializable;

public class Rating implements Serializable {

    private int critics_score;
    private int audience_score;

    public int getCritics_score() {
        return critics_score;
    }

    public int getAudience_score() {
        return audience_score;
    }
}
