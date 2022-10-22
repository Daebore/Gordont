package com.backendstreetboys.gordont;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.backendstreetboys.gordont.databinding.ActivityQuestViewBinding;

public class Quest_view extends AppCompatActivity {

    private ActivityQuestViewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityQuestViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setContentView(R.layout.activity_quest_view);
    }

    public void onRadioButtonClicked(Persona persona){



    }


}