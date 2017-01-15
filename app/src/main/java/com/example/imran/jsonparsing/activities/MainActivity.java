package com.example.imran.jsonparsing.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.imran.jsonparsing.R;
import com.example.imran.jsonparsing.R2;
import com.example.imran.jsonparsing.Services.MovieService;
import com.example.imran.jsonparsing.entities.Movie;
import com.example.imran.jsonparsing.infrastructure.BeastmovieApplication;
import com.squareup.otto.Subscribe;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    ProgressBar progressBar;
    TextView moviesummary;
    TextView movierating;
    ImageView moviepicture;
    TextView moviereleasedate;
    TextView movietitle;
    ImageView leftArrow;
    ImageView rightarrow;

    ArrayList<Movie> movies;
    int index;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        progressBar = (ProgressBar)findViewById(R.id.activity_main_layout_progressbar);
        moviesummary=(TextView)findViewById(R.id.moviesummary);
        movierating = (TextView)findViewById(R.id.rating);
        moviepicture =(ImageView)findViewById(R.id.activity_main_layout_moviepicture);
        moviereleasedate=(TextView)findViewById(R.id.releasedate);
        movietitle = (TextView)findViewById(R.id.movietitle);
        leftArrow=(ImageView)findViewById(R.id.leftarrow);
        rightarrow = (ImageView)findViewById(R.id.rightarrow);

        movies = new ArrayList<>();
        index = 0;
        bus.post(new MovieService.SearchMoviesRequest("now_playing"));
        if(movies.size()!= 0){
        updateui(movies.get(index));

    }}

    public void updateui(Movie movie){
        progressBar.setVisibility(View.VISIBLE);
        moviesummary.setText(movie.getMovieSummary());
        movierating.setText(Double.toString(movie.getMovieRating()));
        moviereleasedate.setText(movie.getReleaseDate());
        movietitle.setText(movie.getMovieTitle());

        Picasso.with(this).load(movie.getMoviePicture())
                .fit().centerCrop().into(moviepicture, new Callback() {
            @Override
            public void onSuccess() {
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onError() {

            }
        });



    }

    @OnClick(R.id.leftarrow)
    public void setupleftarrow(){
        if(index == 0){
            Toast.makeText(this,"This is the start of the movies!",Toast.LENGTH_SHORT).show();
        }else{
            index--;
            updateui(movies.get(index));
        }
    }

    @OnClick(R.id.rightarrow)
    public void setuprightarrow(){
        if(index == movies.size()-1){
            Toast.makeText(this,"This is the end of the movies!",Toast.LENGTH_SHORT).show();
        }else{
            index++;
            updateui(movies.get(index));
        }
    }


    @Subscribe
    public void getmoviemessage(MovieService.SearchMoviesResponse response){
        movies.clear();
        movies.addAll(response.movies);
    }
}
