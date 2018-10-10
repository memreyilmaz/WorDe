package com.example.android.worde;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import static com.example.android.worde.DataNames.COL_ARTIKEL;
import static com.example.android.worde.DataNames.COL_EXAMPLE;
import static com.example.android.worde.DataNames.COL_FAVOURITE;
import static com.example.android.worde.DataNames.COL_LEVEL;
import static com.example.android.worde.DataNames.COL_NAME;
import static com.example.android.worde.DataNames.TABLE_NAME;

@Entity(tableName = TABLE_NAME)
public class Word {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = COL_LEVEL)
    private String mWordLevel;
    @ColumnInfo(name = COL_ARTIKEL)
    private String mWordArtikel;
    @NonNull
    @ColumnInfo(name = COL_NAME)
    private String mWordName;
    @NonNull
    @ColumnInfo(name = COL_EXAMPLE)
    private String mWordExample;
    @NonNull
    @ColumnInfo (name = COL_FAVOURITE)
    private Integer mWordFavourite;

    public Word(@NonNull String wordLevel, String wordArtikel,@NonNull String wordName,@NonNull String wordExample,@NonNull Integer wordFavourite) {
        this.mWordLevel = wordLevel;
        this.mWordArtikel = wordArtikel;
        this.mWordName = wordName;
        this.mWordExample = wordExample;
        this.mWordFavourite = wordFavourite;
    }

    @NonNull
    public String getWordLevel() {
        return mWordLevel;
    }
    public String getWordArtikel() {
        return mWordArtikel;
    }
    @NonNull
    public String getWordName() {
        return mWordName;
    }
    @NonNull
    public String getWordExample() {
        return mWordExample;
    }
    @NonNull
    public Integer getWordFavourite() {
        return mWordFavourite;
    }
}