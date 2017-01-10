package com.example.imran.jsonparsing.infrastructure;

import android.app.Application;

import com.squareup.otto.Bus;

public class BeastmovieApplication extends Application{

    private Bus bus;

    public BeastmovieApplication() {

        bus = new Bus();
    }

    public Bus getBus() {
        return bus;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
