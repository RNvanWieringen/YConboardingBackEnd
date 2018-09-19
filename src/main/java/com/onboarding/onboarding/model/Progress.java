package com.onboarding.onboarding.model;

import javax.persistence.*;

@Entity
public class Progress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    private int stage; // 0 -> employee created, 1 -> employee invited, 2 -> forms downloaded, 3-> forms uploaded



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

}