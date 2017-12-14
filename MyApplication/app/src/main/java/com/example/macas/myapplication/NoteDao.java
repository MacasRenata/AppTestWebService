package com.example.macas.myapplication;

/**
 * Created by macas on 14/12/17.
 */

import android.util.Log;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Converter;
import retrofit2.Converter.Factory;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class NoteDao {

    private static final String TAG = NoteDao.class.getSimpleName();

    private static final String BASE_URL = "https://notes-5aa5.restdb.io/rest/";

    private NoteService service;

    public NoteDao() {
        Factory jsonFactory = GsonConverterFactory.create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(jsonFactory)
                .build();

        this.service = retrofit.create(NoteService.class);
    }

    public List<Note> readAllNotes() {
        Call<List<Note>> call = this.service.listNotes();
        List<Note> notes = null;

        try {
            Response<List<Note>> res = call.execute();

            if (res.isSuccessful()) {
                notes = res.body();
            } else {
                String errorBody = res.errorBody().string();
                int errorCode = res.code();
                String errorMessage = res.message();

                Log.e(TAG, "Request not successful - "
                        + errorBody + ": "
                        + errorCode
                        + "(" + errorMessage + ")");
            }
        } catch (IOException exc){
            Log.e(TAG, "IO error during REST operation.", exc);
        }
        return notes;
    }

    public Note createNote(Note note) {
        Call<Note> call = this.service.createNote(note);
        Note newNote = null;

        try {
            Response<Note> res = call.execute();

            if (res.isSuccessful()) {
                newNote = res.body();
            } else {
                String errorBody = res.errorBody().string();
                int errorCode = res.code();
                String errorMessage = res.message();

                Log.e(TAG, "Request not successful - "
                        + errorBody + ": "
                        + errorCode
                        + " (" + errorMessage + ")");
            }
        } catch (IOException exc) {
            Log.e(TAG, "IO error during REST operation.", exc);
        }
        return newNote;
    }
}
