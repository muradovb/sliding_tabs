package com.example.bayrammuradovmustafa.fragmenttask;

public class MyModel {

    //properties
    int icon;
    String text;


    //constructor
    public MyModel() {
        icon=0;
        text="";
    }

    //methods

    public void setIcons(int newIcon) {
        icon=newIcon;
    }

    public void setText(String newText) {
        text=newText;
    }

    public int getIcons() {
        return icon;
    }

    public String getText() {
        return text;
    }


}
