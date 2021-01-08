package com.bowang.recommandationSystem.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class KeyWord {

    private String count;
    @SerializedName("positions_in_text")
    private List<Integer> position;
    private String keyword;
    private String relevance;

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public List<Integer> getPosition() {
        return position;
    }

    public void setPosition(List<Integer> position) {
        this.position = position;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getRelevance() {
        return relevance;
    }

    public void setRelevance(String relevance) {
        this.relevance = relevance;
    }
}
