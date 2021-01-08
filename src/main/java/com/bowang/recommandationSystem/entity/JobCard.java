package com.bowang.recommandationSystem.entity;

public class JobCard implements Comparable<JobCard> {
    String itemID;
    Double similarity;

    public JobCard(String itemID, Double similarity) {
        this.itemID = itemID;
        this.similarity = similarity;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public Double getSimilarity() {
        return similarity;
    }

    public void setSimilarity(Double similarity) {
        this.similarity = similarity;
    }

    @Override
    public int compareTo(JobCard o) {
        return o.similarity.compareTo(this.similarity);
    }
}
