package com.jeffcaijf.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jeffcai on 2/21/17.
 */
public abstract class AbstractContainer implements Container {

    private List<Item> items = new ArrayList<Item>();

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
