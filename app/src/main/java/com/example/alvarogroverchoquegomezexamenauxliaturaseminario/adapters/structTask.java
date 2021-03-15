package com.example.alvarogroverchoquegomezexamenauxliaturaseminario.adapters;

public class structTask {
    private String title;
    private String description;
    private String isDone;

    public structTask(String title, String description, String isDone) {
        this.title = title;
        this.description = description;
        this.isDone = isDone;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsDone() {
        return isDone;
    }

    public void setIsDone(String isDone) {
        this.isDone = isDone;
    }
}
