package com.jeffcaijf.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jeffcai on 2/21/17.
 */
public class Form {

    private List<Container> containers = new ArrayList<Container>();

    private String name;

    public Form() {
        name = "test";
        containers.add(new Section());
        containers.add(new Group());
        containers.add(new Section());
        containers.add(new Section());
        containers.add(new Group());
    }

    public List<Container> getContainers() {
        return containers;
    }

    public void setContainers(List<Container> containers) {
        this.containers = containers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
