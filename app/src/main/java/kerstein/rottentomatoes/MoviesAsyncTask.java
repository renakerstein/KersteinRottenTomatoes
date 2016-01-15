package kerstein.rottentomatoes;


import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;

public class MoviesAsyncTask extends android.os.AsyncTask<String, Void, CurrentUpcoming> implements Serializable {

    private ViewPager viewPager;
    private Movies currentMovies;
    private UpcomingMovies upcoming;
    private CurrentUpcoming cp;
    private Context context;

    public MoviesAsyncTask(ViewPager viewPager, Context context) {
        this.context = context;
        this.viewPager = viewPager;

    }

    @Override
    protected CurrentUpcoming doInBackground(String... params) {
        try {
            URL url = new URL("http://api.rottentomatoes.com/api/public/v1.0/lists/movies/box_office.json?apikey=cart6246nbex6fqchrj5t4b8&limit=25");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // read it in
            InputStream in = connection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            Gson gson = new Gson();
            currentMovies = gson.fromJson(br, Movies.class);
            br.close();

            url = new URL("http://api.rottentomatoes.com/api/public/v1.0/lists/movies/upcoming.json?apikey=cart6246nbex6fqchrj5t4b8&limit=25");
            connection = (HttpURLConnection) url.openConnection();

            // read it in
            in = connection.getInputStream();
            br = new BufferedReader(new InputStreamReader(in));

            gson = new Gson();
            upcoming = gson.fromJson(br, UpcomingMovies.class);
            br.close();
        } catch (IOException e) {

        }
        cp = new CurrentUpcoming(currentMovies, upcoming);

        return cp;
    }


    @Override
    protected void onPostExecute(CurrentUpcoming movie) {
        super.onPostExecute(movie);
        Movie[] currentMovies = movie.getCurrent().getMovies();
        Movie[] upcoming = movie.getUpcoming().getMovies();
        MovieMainPagerAdapter adapter = new MovieMainPagerAdapter(movie, context);
        viewPager.setAdapter(adapter);
    }
}

