package com.example.macas.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ViewNoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_note);

        Note note = (Note) super.getIntent().getSerializableExtra("note");
        TextView dateText = (TextView) findViewById(R.id.dateText);
        TextView titleText = (TextView) findViewById(R.id.titleText);
        TextView textText = (TextView) findViewById(R.id.textText);

        dateText.setText(note.getDateString());
        titleText.setText(note.getTitle());
        textText.setText(note.getText());
    }
}
