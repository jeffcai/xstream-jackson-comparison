package com.jeffcaijf.model;

/**
 * Created by jeffcai on 2/21/17.
 */
public interface Container {

    void addItem(Item item);

    Item getItem(String id);

}
