package com.example.android.worde;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

public class WordViewModel extends AndroidViewModel {

    private WordRepository mRepository;

    private LiveData<List<Word>> mAllWords;

    public WordViewModel(Application application) {
        super(application);
        mRepository = new WordRepository(application);
        mAllWords = mRepository.getAllWords();
    }

    /*public WordViewModel(WordRepository repository) {
        //super(repository);
        mRepository = repository;
    }*/

    LiveData<List<Word>> getAllWords() {
       // mAllWords = mRepository.getAllWords();
        return mAllWords;
    }
}