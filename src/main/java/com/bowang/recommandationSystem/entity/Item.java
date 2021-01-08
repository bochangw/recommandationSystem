package com.bowang.recommandationSystem.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Item {
    @Id
    private String id;
    private String jobType;
    private String link;
    private String created;
    private String company;
    private String companyUrl;
    private String location;
    private String title;

    public Item() {
    }

    public Item(Job job) {
        this.id = job.getJobID();
        this.jobType = job.getJobType();
        this.link = job.getJobType();
        this.created = job.getCreated();
        this.company = job.getCompany();
        this.companyUrl = job.getCompanyUrl();
        this.location = job.getLocation();
        this.title = job.getTitle();
    }

    public Item(String id, String jobType, String link, String created,
                String company, String companyUrl, String location, String title) {
        this.id = id;
        this.jobType = jobType;
        this.link = link;
        this.created = created;
        this.company = company;
        this.companyUrl = companyUrl;
        this.location = location;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}
