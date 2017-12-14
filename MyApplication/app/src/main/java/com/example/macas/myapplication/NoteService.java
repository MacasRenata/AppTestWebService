package com.example.macas.myapplication;

/**
 * Created by macas on 14/12/17.
 */

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface NoteService {

    @GET("note")
    @Headers("x-apikey: a99c54bd6bfa3fb07ef171c1a43f51f29785e")
    Call<List<Note>> listNotes();

    @POST("note")
    @Headers("x-apikey: a99c54bd6bfa3fb07ef171c1a43f51f29785e")
    Call<Note> createNote(@Body Note note);

}
