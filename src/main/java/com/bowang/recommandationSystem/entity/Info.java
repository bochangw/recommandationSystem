package com.bowang.recommandationSystem.entity;

import java.util.List;

public class Info {
    User user;
    List<String> keyWords;
    List<Item> jobs;

    public Info(User user, List<String> keyWords, List<Item> jobs) {
        this.user = user;
        this.keyWords = keyWords;
        this.jobs = jobs;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<String> getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(List<String> keyWords) {
        this.keyWords = keyWords;
    }

    public List<Item> getJobs() {
        return jobs;
    }

    public void setJobs(List<Item> jobs) {
        this.jobs = jobs;
    }
}
