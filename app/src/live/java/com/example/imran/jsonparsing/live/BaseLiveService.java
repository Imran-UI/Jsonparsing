package com.example.imran.jsonparsing.live;


import com.example.imran.jsonparsing.infrastructure.BeastmovieApplication;
import com.squareup.otto.Bus;

public class BaseLiveService {

    protected BeastmovieApplication application;
    protected Bus bus;

    public BaseLiveService(BeastmovieApplication application) {
        this.application = application;
        bus = application.getBus();
        bus.register(this);
    }
}
