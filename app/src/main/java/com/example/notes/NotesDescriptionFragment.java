package com.example.notes;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class NotesDescriptionFragment extends Fragment {

    public static final String ARG_INDEX = "note";

    private Notes note;

    public static NotesDescriptionFragment newInstance(Notes note) {
        NotesDescriptionFragment fragment = new NotesDescriptionFragment();

        //передача параметров
        Bundle args = new Bundle();
        args.putParcelable(ARG_INDEX, note);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            note = getArguments().getParcelable(ARG_INDEX);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_notes_description, container, false);

        TextView tv = view.findViewById(R.id.note_description);
        tv.setText(note.getDescription());

        return view;

    }
}