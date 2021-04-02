package com.groupjn.orderservice.memento;

public class TestMemento {

    Caretaker caretaker = new Caretaker();
    Originator originator = new Originator();

    String text;

    int saveFile = 0;

    int currentArticle = 0;

    public void save(){
        originator.set(text);
        caretaker.addMemento(originator.storeInMemento());
        saveFile++;
        currentArticle++;
        System.out.println("Save Files "+saveFile);

    }

    public void undo(){
        if(currentArticle >= 1){
            currentArticle--;
            String oldText = originator.restoreFromMemento(caretaker.getMemento(currentArticle));
            text =  oldText;
        }
    }

    public void redo(){
        if((saveFile - 1) > currentArticle){
            currentArticle++;

            String textBoxString = originator.restoreFromMemento(caretaker.getMemento(currentArticle));

            text = textBoxString;
        }
    }


}
