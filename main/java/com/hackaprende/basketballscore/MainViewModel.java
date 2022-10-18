package com.hackaprende.basketballscore;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    private final MutableLiveData<Integer> localScore = new MutableLiveData<>();
    private final MutableLiveData<Integer> visitorScore = new MutableLiveData<>();

    public MainViewModel() {
        resetScores();
    }

    public LiveData<Integer> getLocalScore() {
        return localScore;
    }

    public LiveData<Integer> getVisitorScore() {
        return visitorScore;
    }

    void resetScores() {
        localScore.setValue(0);
        visitorScore.setValue(0);
    }

    void addPointsToScore(int points, Boolean isLocal) {
        if (isLocal) {
            localScore.setValue(localScore.getValue() + points);
        } else {
            visitorScore.setValue(visitorScore.getValue() + points);
        }
    }

    void decreaseLocal() {
        if (localScore.getValue() > 0) {
            localScore.setValue(localScore.getValue() - 1);
        }
    }

    void decreaseVisitor() {
        if (visitorScore.getValue() > 0) {
            visitorScore.setValue(visitorScore.getValue() - 1);
        }
    }
}
