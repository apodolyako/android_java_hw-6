package com.example.notes;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class NotesListFragment extends Fragment {


    public static final String CURRENT_NOTE = "CurrentNote";
    private Notes[] notes = initNotes();
    private Notes currentNote;
//    private static int index;

    private boolean isLandscape;


    private Notes[] initNotes(){
        Notes[] notes = {
                        new Notes("20.06.2021", "Заметка №1", "Какая-то запись 1"),
                        new Notes("21.06.2021", "Заметка №2", "Какая-то запись 2"),
                        new Notes("22.06.2021","Заметка №3", "Какая-то запись 3"),
                        new Notes("24.06.2021", "Заметка №4", "Какая-то запись 4"),
                        new Notes("29.06.2021", "Заметка №5", "Какая-то запись 5")
                };
        return notes;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notes_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        initList((LinearLayout) view);
    }

    private void initList(LinearLayout view){
        TextView tv, tv1;

        tv = new TextView(getContext());
        tv.setText("    ДАТА    | Наименование");
        tv.setTextColor(getResources().getColor(R.color.green, getResources().newTheme()));
        tv.setTextSize(20);
        view.addView(tv);

        tv1 = new TextView(getContext());
        tv1.setText("--------------------------------------------");
        tv1.setTextColor(getResources().getColor(R.color.green, getResources().newTheme()));
        tv1.setTextSize(20);
        view.addView(tv1);

        for(int i = 0; i < notes.length; i++){
            String date = notes[i].getDate() + "  " + notes[i].getName();
            tv = new TextView(getContext());
            tv.setText(date);
            tv.setTextColor(getResources().getColor(R.color.black, getResources().newTheme()));
            tv.setTextSize(18);
            view.addView(tv);
            final int j = i;
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    currentNote = notes[j];
                      showDescription(notes[j]);
//                      index = j;

                }
            });

//            tv1 = new TextView(getContext());
//            tv1.setText("--------------------------------------------");
//            tv1.setTextColor(getResources().getColor(R.color.black, getResources().newTheme()));
//            tv1.setTextSize(20);
//            view.addView(tv1);
        }

    }

   //сохранение данных
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState){
        outState.putParcelable(CURRENT_NOTE, currentNote);
//        outState.putInt(CURRENT_NOTE, index);
        super.onSaveInstanceState(outState);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //Определяем можно ли будет рядом расположить текст заметки в другом фрагменте
        isLandscape = getResources().getConfiguration().orientation
                == Configuration.ORIENTATION_LANDSCAPE;

        //если не первое создание восстановим текущую позицию
        if(savedInstanceState != null){

//            index = savedInstanceState.getInt(CURRENT_NOTE);
//            showLandDescription(notes[index].getDescription());
            currentNote = savedInstanceState.getParcelable(CURRENT_NOTE);
            showLandDescription(currentNote);
        }else{
            currentNote = notes[0];
        }

        if(isLandscape){
            showLandDescription(currentNote);
        }
    }

    private void showDescription(Notes note){
        if(isLandscape){
            showLandDescription(note);
        } else {
            showPortableDescription(note);
        }
    }

    private void showLandDescription(Notes note) {
        // Создаем новый фрагмент с текущей позицией для вывода
        NotesDescriptionFragment detail = NotesDescriptionFragment.newInstance(note);

        //выполняем транзакцию по замене фрагмента
        FragmentManager fragmentManager =
                requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.description, detail);//замена фрагмента

        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fragmentTransaction.commit();

    }

    private void showPortableDescription(Notes note) {
        Intent intent = new Intent();
        intent.setClass(getActivity(),NotesDescriptionActivity.class );
        intent.putExtra(NotesDescriptionFragment.ARG_INDEX, note);
        startActivity(intent);
    }

}