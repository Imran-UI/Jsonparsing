package com.example.imran.jsonparsing.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.imran.jsonparsing.R;
import com.example.imran.jsonparsing.R2;
import com.example.imran.jsonparsing.Services.MovieService;
import com.squareup.otto.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R2.id.maintext) TextView textview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //textview = (TextView)findViewById(R.id.maintext) ;
        ButterKnife.bind(this);
        bus.post(new MovieService.SearchMoviesRequest("query1"));


    }

    @Subscribe
    public void getmoviemessage(MovieService.SearchMoviesResponse response){
        textview.setText(response.modifiedquery);
    }
}
