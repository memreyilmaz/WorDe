package com.example.android.worde.database;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WordRepository {
    private WordDao mWordDao;
    private final ExecutorService mIoExecutor;
    private static volatile WordRepository sInstance = null;

    public static WordRepository getInstance(Application application) {
        if (sInstance == null) {
            synchronized (WordRepository.class) {
                if (sInstance == null) {
                    WordDatabase db = WordDatabase.getInstance(application);
                    sInstance = new WordRepository(db.wordDao(),
                            Executors.newSingleThreadExecutor());
                }
            }
        }
        return sInstance;
    }
    public WordRepository(WordDao dao, ExecutorService executor) {
        mIoExecutor = executor;
        mWordDao = dao;
    }
    public LiveData<Word> getWordById(int id){
        return mWordDao.getWordById(id);
    }
    public LiveData<List<Word>> getWordsByLevels(String level){
        return mWordDao.getWordsByLevels(level);
    }
    public LiveData<List<Word>> getFavouriteWords(){
        return mWordDao.getFavouriteWords();
    }
    public void setFavouriteStatus(int favourite, int id){
        updateWordAsyncTask(favourite, id);
       // new insertAsyncTask(mWordDao).execute(favourite, id);
    }

    private void updateWordAsyncTask(int favourite, int id) {

        new AsyncTask<Void, Void, Void>() {
           @Override
           protected Void doInBackground(Void... voids) {
               mWordDao.addOrRemoveFavourite(favourite, id);
               return null;
           }
       }.execute();
    }

    /*private static class insertAsyncTask extends AsyncTask<Integer, Void, Void> {

        private WordDao mAsyncTaskDao;

        insertAsyncTask(WordDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Integer... ıntegers) {
            mAsyncTaskDao.addOrRemoveFavourite(ıntegers[0], ıntegers[1]);
            return null;
        }
    }*/


    public Word getFirstWordOnDb() {
        try {
            return mIoExecutor.submit(mWordDao::getFirstWordOnDb).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return null;
        }
    }


    public Word getLastWordOnDb() {
        try {
            return mIoExecutor.submit(mWordDao::getLastWordOnDb).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Word getFirstWordOfLevel(String level) {
        try {
            return (Word) mIoExecutor.submit((Runnable) mWordDao.getFirstWordOnSelectedLevelForTablet(level)).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return null;
        }
    }
}