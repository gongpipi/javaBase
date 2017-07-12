package com.pipi.improve.collections.List;

/**
 * Created by pipi on 2017/7/5.
 */
public class Course {

    private String name;

    private int jscore;

    private int ascore;

    public Course(String name, int jscore, int ascore) {
        this.name = name;
        this.jscore = jscore;
        this.ascore = ascore;
    }

    @Override
    public String toString() {
        String ss = "[name = "+name+", jscore"+ jscore+"]";
        return ss;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getJscore() {
        return jscore;
    }

    public void setJscore(int jscore) {
        this.jscore = jscore;
    }

    public int getAscore() {
        return ascore;
    }

    public void setAscore(int ascore) {
        this.ascore = ascore;
    }
}
