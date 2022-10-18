package com.hackaprende.basketballscore;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.hackaprende.basketballscore.databinding.ActivityScoreBinding;

public class ScoreActivity extends AppCompatActivity {

    public static final String LOCAL_SCORE_KEY = "local_score";
    public static final String VISITOR_SCORE_KEY = "visitor_score";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityScoreBinding binding = ActivityScoreBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int localScore = getIntent().getExtras().getInt(LOCAL_SCORE_KEY);
        int visitorScore = getIntent().getExtras().getInt(VISITOR_SCORE_KEY);

        binding.scoreText.setText(getString(R.string.local_visitor_score_format, localScore,
                visitorScore));

        if (localScore > visitorScore) {
            binding.whoWonText.setText(getString(R.string.local_won));
        } else if (visitorScore > localScore) {
            binding.whoWonText.setText(getString(R.string.visitor_won));
        } else {
            binding.whoWonText.setText(getString(R.string.it_was_a_tie));
        }
    }
}