package com.jeffcaijf.model;

/**
 * Created by jeffcai on 2/21/17.
 */
public class Section extends AbstractContainer {

    public void addItem(Item item) {
        getItems().add(item);
    }

    public Item getItem(String id) {
        return null;
    }

}
