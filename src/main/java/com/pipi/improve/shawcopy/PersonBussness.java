package com.pipi.improve.shawcopy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pipi on 2016/9/8.
 */
public class PersonBussness {
    private Person p;

    public void testListCopy(){
        List<Person> perList = new ArrayList<Person>();
        perList.add(new Person(1));
        List<Person> perList2 = new ArrayList<Person>();
        perList2.add(perList.get(0));
        perList2.get(0).setId(2);

        System.out.print("P.id="+perList.get(0).getId()+"   p2.id="+perList2.get(0).getId());
    }
    public void testCopy(){
        Person p = new Person(1);
        p.setId(1);
        p.setName("shaobo");
        Person p2 =p;
        p2.setId(2);
        p2.setName("guangjing");
        System.out.print("P.id="+p.getId()+p.getName()+"   p2.id="+p2.getId()+p2.getName());
    }
}

