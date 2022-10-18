package com.hackaprende.basketballscore;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.hackaprende.basketballscore.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        viewModel.getLocalScore().observe(this, localScoreInteger -> {
            binding.localScoreText.setText(String.valueOf(localScoreInteger));
        });

        viewModel.getVisitorScore().observe(this, visitorScoreInteger -> {
            binding.visitorScoreText.setText(String.valueOf(visitorScoreInteger));
        });

        setupButtons();
    }

    private void setupButtons() {
        binding.localMinusButton.setOnClickListener(v -> {
            viewModel.decreaseLocal();
        });

        binding.localPlusButton.setOnClickListener(v -> {
            addPointsToScore(1, true);
        });

        binding.localTwoPointsButton.setOnClickListener(v -> {
            addPointsToScore(2, true);
        });

        binding.visitorMinusButton.setOnClickListener(v -> {
            viewModel.decreaseVisitor();
        });

        binding.visitorPlusButton.setOnClickListener(v -> {
            addPointsToScore(1, false);
        });

        binding.visitorTwoPointsButton.setOnClickListener(v -> {
            addPointsToScore(2, false);
        });

        binding.restartButton.setOnClickListener(v -> {
            resetScores();
        });

        binding.resultsButton.setOnClickListener(v -> {
            startScoreActivity();
        });
    }

    private void resetScores() {
        viewModel.resetScores();
    }

    private void addPointsToScore(int points, Boolean isLocal) {
        viewModel.addPointsToScore(points, isLocal);
    }

    private void startScoreActivity() {
        Intent intent = new Intent(this, ScoreActivity.class);
        intent.putExtra(ScoreActivity.LOCAL_SCORE_KEY, viewModel.getLocalScore().getValue());
        intent.putExtra(ScoreActivity.VISITOR_SCORE_KEY, viewModel.getVisitorScore().getValue());
        startActivity(intent);
    }
}