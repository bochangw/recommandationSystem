package com.bowang.recommandationSystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.annotations.SerializedName;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Job {

    @SerializedName("id")
    private String jobID;
    @SerializedName("type")
    private String jobType;
    @SerializedName("url")
    private String link;
    @SerializedName("created_at")
    private String created;
    @SerializedName("company")
    private String company;
    @SerializedName("company_url")
    private String companyUrl;
    @SerializedName("location")
    private String location;
    @SerializedName("title")
    private String title;
    @SerializedName("description")
    private String description;
    private KeyWord[] keyWords;

    public Job(String jobID, String jobType, String link, String created, String company, String companyUrl, String location, String title, String description) {
        this.jobID = jobID;
        this.jobType = jobType;
        this.link = link;
        this.created = created;
        this.company = company;
        this.companyUrl = companyUrl;
        this.location = location;
        this.title = title;
        this.description = description;
    }

    public KeyWord[] getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(KeyWord[] keyWords) {
        this.keyWords = keyWords;
    }

    public String getJobID() {
        return jobID;
    }

    public void setJobID(String jobID) {
        this.jobID = jobID;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompanyUrl() {
        return companyUrl;
    }

    public void setCompanyUrl(String companyUrl) {
        this.companyUrl = companyUrl;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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
}
