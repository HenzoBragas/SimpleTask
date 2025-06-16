package org.example.model;

public class Task {
    private static int proxId = 1;

    private  int id;
    private String name;
    private String description;
    private boolean completed;


    public Task(String name, String description) {
        this.id = proxId++;
        this.name = name;
        this.description = description;
        this.completed = false;
    }

    public int getId() {
        return id;
    }
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markAsCompleted() {
        this.completed = true;
    }

    public void unmarkAsCompleted(){
        this.completed = false;
    }
}
