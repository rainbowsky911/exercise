package com.example.demo;


import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class TestHashSet {

    public static void main(String[] args) {

        String a = new String("A");
        String b = new String("A");
        Xiaoming c =new Xiaoming("A");
        Xiaoming d =new Xiaoming("A");

        Set set =new LinkedHashSet();
        set.add(a);
        set.add(b);
        set.add(c);
        set.add(d);

        System.out.println(set.size());
        System.out.println(a.equals(b));
        System.out.println(c.equals(d));

        for (Object o:set
             ) {
            System.out.println(o);

        }
    }
}

class Xiaoming{
    private  String val;

    public Xiaoming(String val) {
        this.val = val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Xiaoming xiaoming = (Xiaoming) o;
        return Objects.equals(val, xiaoming.val);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val);
    }

    @Override
    public String toString() {
        return "Xiaoming{" +
                "val='" + val + '\'' +
                '}';
    }
}
