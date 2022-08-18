package com.ghibliemovies.bean;

import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class MovieCollection {
    private List<GhibliMovie> collection;

    public List<GhibliMovie> getCollection() {
        return collection;
    }

    public void setCollection(List<GhibliMovie> collection) {
        this.collection = collection;
    }
}
