package com.example.imran.jsonparsing.activities;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.imran.jsonparsing.infrastructure.BeastmovieApplication;
import com.squareup.otto.Bus;

public class BaseActivity extends AppCompatActivity{

    protected BeastmovieApplication application;
    protected Bus bus;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        application = (BeastmovieApplication)getApplication();
        bus=application.getBus();
        bus.register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bus.unregister(this);
    }
}
