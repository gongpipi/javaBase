package com.pipi.Interview;

import java.util.*;

/**
 * Created by pipi on 2017/7/5.
 */
public class RandomSet <T> {

    private Set set;

    public RandomSet() {
        this.set = new HashSet<T>();
    }

    public void add(T t){
        set.add(t);
    }

    public boolean remove(T t){
        return set.remove(t);
    }

    public T randomGet(){
        T [] tarray = (T [])set.toArray();
        if(tarray.length == 0) {
            return null;
        }
        Random random = new Random();
        int index = Math.abs(random.nextInt() % tarray.length);
        return tarray[index];
    }
}
