package com.example.imran.jsonparsing.live;


import com.example.imran.jsonparsing.infrastructure.BeastmovieApplication;
import com.squareup.otto.Bus;

public class BaseLiveService {

    protected BeastmovieApplication application;
    protected Bus bus;
    protected Moviewebservices api;

    public BaseLiveService(BeastmovieApplication application, Moviewebservices api) {
        this.application = application;
        this.api = api;
        bus = application.getBus();
        bus.register(this);
    }
}
