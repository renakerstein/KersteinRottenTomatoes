package kerstein.rottentomatoes;

import java.io.Serializable;

public class Review  implements Serializable {

    private String critic;
    private String date;
    private String publication;
    private String quote;

    public String getCritic() {
        return critic;
    }

    public String getDate() {
        return date;
    }

    public String getPublication() {
        return publication;
    }

    public String getQuote() {
        return quote;
    }
}
