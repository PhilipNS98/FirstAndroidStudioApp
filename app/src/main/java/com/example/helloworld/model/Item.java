package com.example.helloworld.model;

public class Item {
    private String text;
    private int image;

    public Item(String text, int image) {
        this.text = text;
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "item{" +
                "text='" + text + '\'' +
                ", image=" + image +
                '}';
    }
}
