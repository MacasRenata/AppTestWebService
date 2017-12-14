package com.example.macas.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class CreateNoteActivity extends AppCompatActivity {

    private class NoteSaverTask extends AsyncTask<Note, Void, Void> {

        @Override
        public Void doInBackground(Note... params) {
            NoteDao dao = new NoteDao();

            dao.createNote(params[0]);
            return null;
        }

        @Override
        public void onPostExecute(Void notes) {
            Intent intent = new Intent();

            intent.putExtra("note", note);
            setResult(Activity.RESULT_OK, intent);
            finish();
        }
    }


    private Note note;

    private EditText dateEdit;
    private EditText titleEdit;
    private EditText textEdit;
    private Button saveButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_note);


        this.note = new Note();
        this.dateEdit = (EditText) findViewById(R.id.dateEdit);
        this.dateEdit.setText(note.getDateString());

        this.titleEdit = (EditText) findViewById(R.id.titleEdit);

        this.textEdit = (EditText) findViewById(R.id.textEdit);

        this.saveButton = (Button) findViewById(R.id.saveButton);
        this.saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveNote();
            }
        });

    }
    private void saveNote() {
        this.note.setTitle(this.titleEdit.getText().toString());
        this.note.setText(this.textEdit.getText().toString());

        new NoteSaverTask().execute(this.note);
    }
}
