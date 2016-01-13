package kerstein.rottentomatoes;

import android.content.Context;
import android.media.Image;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.text.SimpleDateFormat;


public class MovieDetailPageAdapter extends PagerAdapter implements Serializable {

    private Movie[] movies;
    private int position;
    private ImageView image;
    private ImageView smallImage;
    private TextView title;
    private TextView critics_score;
    private TextView audience_score;
    private TextView synopsis;
    private TextView rating;
    private TextView runtime;
    private TextView date;
    private ImageView popcorn;
    private ImageView tomato;


    public MovieDetailPageAdapter(Movie[] movies, int position){
        this.movies=movies;
        this.position=position;



    }

    @Override
    public int getCount() {
        return movies.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        LayoutInflater inflater = LayoutInflater.from(container.getContext());
        View view = inflater.inflate(R.layout.movie_pager_item, null);


        image= (ImageView)view.findViewById(R.id.imageV);
        critics_score= (TextView) view.findViewById(R.id.criticts);
        audience_score= (TextView) view.findViewById(R.id.audience);
        title= (TextView) view.findViewById(R.id.Vtitle);
        synopsis= (TextView) view.findViewById(R.id.synopsis);
        rating= (TextView) view.findViewById(R.id.rate);
        runtime= (TextView) view.findViewById(R.id.time);
        date = (TextView) view.findViewById(R.id.date);
        smallImage= (ImageView)view.findViewById(R.id.smallImage);
        popcorn= (ImageView) view.findViewById(R.id.popcorn);
        tomato =(ImageView) view.findViewById(R.id.tomato);

        Movie movie = movies[position];


        Picasso.with(container.getContext()).load(movie.getPosters().getProfile()).into(image);
        Picasso.with(container.getContext()).load(movie.getPosters().getProfile()).into(smallImage);
        tomato.setImageResource(R.drawable.tomato);
        popcorn.setImageResource(R.drawable.popcorn);
        critics_score.setText("Rotten Tomatoes \nCritic Score \n " + String.valueOf(movie.getRatings().getCritics_score()) + "%  \n");
        audience_score.setText("Flixster User \nScore \n "+String.valueOf(movie.getRatings().getAudience_score()) + "%\n");
        title.setText(movie.getTitle()+"\n");
        synopsis.setText(movie.getSynopsis()+"\n");
        rating.setText("Rated  "+movie.getMpaa_rating()+"\n");
        runtime.setText("Running Time  "+movie.getRuntime() + " min.\n");
        date.setText("Theater Release Date  "+movie.getReleaseDates().getTheater()+"\n");

        container.addView(view);
        return view;

    }


    public void destroyItem(ViewGroup container, int position, Object object){
        container.removeView((View) object);
    }

}
