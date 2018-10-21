package com.udacity.gradle.builditbigger.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import org.drulabs.jokelib.JokeFetcher;

import javax.inject.Named;

/** An endpoint class we are exposing */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class MyJokesEndpoint {

    @ApiMethod(name = "getJokes", httpMethod = "get")
    public MyBean getJokes() {
        MyBean response = new MyBean();
        response.setData(JokeFetcher.getJokeList());
        return response;
    }

}
