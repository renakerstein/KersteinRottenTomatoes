package kerstein.rottentomatoes;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MoviesViewHolder extends RecyclerView.ViewHolder {

    private ImageView image;
    private TextView title;
    private TextView criticScore;
    private TextView audienceScore;
    private TextView rating;
    private TextView cast;
    private TextView runtime;
    private ImageView popcorn;
    private ImageView tomato;
    private transient Context context;

    public MoviesViewHolder(View itemView, Context context) {
        super(itemView);
        this.context=context;
        image = (ImageView) itemView.findViewById(R.id.image);
        title = (TextView) itemView.findViewById(R.id.title);
        popcorn= (ImageView) itemView.findViewById(R.id.popcorn);
        tomato =(ImageView) itemView.findViewById(R.id.tomato);
        criticScore = (TextView) itemView.findViewById(R.id.criticts_score);
        audienceScore = (TextView) itemView.findViewById(R.id.audience_score);
        rating= (TextView) itemView.findViewById(R.id.rating);
        cast = (TextView) itemView.findViewById(R.id.cast);
        runtime = (TextView) itemView.findViewById(R.id.runtime);

}

    public void bind(Movie movie) {

        tomato.setImageResource(R.drawable.tomato);
        popcorn.setImageResource(R.drawable.popcorn);
        Picasso.with(context).load(movie.getPosters().getProfile()).into(image);
        title.setText(movie.getTitle());
        criticScore.setText(String.valueOf(movie.getRatings().getCritics_score()) + "%   ");
        audienceScore.setText(String.valueOf(movie.getRatings().getAudience_score()) + "%");
        cast.setText(movie.getAbridgedCast()[0].getName() + ", " + movie.getAbridgedCast()[1].getName());
        rating.setText(movie.getMpaa_rating()+",  ");
        runtime.setText(movie.getRuntime() + " min.\n");



    }
}

