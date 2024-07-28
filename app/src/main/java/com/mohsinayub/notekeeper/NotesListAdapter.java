package com.mohsinayub.notekeeper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class NotesListAdapter extends BaseAdapter {

    private List<NoteInfo> notes;
    private Context context;

    public NotesListAdapter(Context context, List<NoteInfo> notes) {
        this.context = context;
        this.notes = notes;
    }

    @Override
    public int getCount() {
        return notes.size();
    }

    @Override
    public Object getItem(int position) {
        return notes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater
                    .from(context).inflate(R.layout.list_note, parent, false);
        }

        TextView noteTitleView = convertView.findViewById(R.id.text_title);
        TextView noteTextView = convertView.findViewById(R.id.text_details);

        NoteInfo note = (NoteInfo) getItem(position);

        noteTitleView.setText(note.getCourse().getTitle());
        noteTextView.setText(note.getText());

        return convertView;
    }
}
