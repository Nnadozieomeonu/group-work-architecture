package com.groupjn.orderservice.memento;

import java.util.ArrayList;

public class Caretaker {

    ArrayList<Memento> savedArticles = new ArrayList<>();

    public void addMemento(Memento m){
        savedArticles.add(m);
    }

    public Memento getMemento(int index){
        return savedArticles.get(index);
    }
}
