package com.capgemini.blablacap.models;


public class CommentWithName {
    String name;
    String text;

    public CommentWithName(){

    }
    
    public CommentWithName(String text, String name){

        this.text = text;
        this.name = name;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
