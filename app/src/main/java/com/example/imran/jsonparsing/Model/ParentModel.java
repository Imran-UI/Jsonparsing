package com.example.imran.jsonparsing.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ParentModel {

    @SerializedName("results")
    public List<MovieModel> movieinfos;

}
