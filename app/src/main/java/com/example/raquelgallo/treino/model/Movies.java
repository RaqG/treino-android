package com.example.raquelgallo.treino.model;

import com.example.raquelgallo.treino.R;

/**
 * Created by Raquel Gallo on 14/12/2017.
 */

public class Movies {

    private int id;
    private String title;
    private int movieYear;

    public Movies(int id, String title, int movieYear) {
        this.id = id;
        this.title = title;
        this.movieYear = movieYear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getMovieYear() {
        return movieYear;
    }

    public void setMovieYear(int movieYear) {
        this.movieYear = movieYear;
    }

    public int getImage(int position) {
        switch (position) {
            case 0:
                return R.mipmap.piratas_do_caribe;
            case 1:
                return R.mipmap.senhor_dos_aneis;
            case 2:
                return R.mipmap.jogos_vorazes;
            case 3:
                return R.mipmap.star_wars;
            case 4:
                return R.mipmap.star_trek;
            default:
                return R.drawable.ic_launcher_background;
        }
    }

    @Override
    public String toString() {
        return "Movies{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", txtAno=" + movieYear +
                '}';
    }
}