package com.mohsinayub.notekeeper;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;

import java.util.List;

public class NoteListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_list);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(
                view -> startActivity(new Intent(this, NoteActivity.class))
        );

        initializeDisplayContent();
    }

    private void initializeDisplayContent() {
        ListView listNotes = findViewById(R.id.list_notes);

        List<NoteInfo> notes = DataManager.getInstance().getNotes();
        NotesListAdapter adapterNotes = new NotesListAdapter(this, notes);
        listNotes.setAdapter(adapterNotes);

        listNotes.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(this, NoteActivity.class);
            NoteInfo note = (NoteInfo) listNotes.getItemAtPosition(position);
            intent.putExtra(NoteActivity.NOTE_INFO, note);
            startActivity(intent);
        });
    }
}