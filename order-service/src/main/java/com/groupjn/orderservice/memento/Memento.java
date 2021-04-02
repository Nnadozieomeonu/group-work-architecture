package com.groupjn.orderservice.memento;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Memento {

    private String article;

    public Memento(String articleSave){
        article = articleSave;
    }

    public String getSavedArticle(){
        return article;
    }


}
