package com.coderhouse.controlleradvice.model;

public class Mensaje {
    private Long id;
    private String description;

    public Mensaje(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
