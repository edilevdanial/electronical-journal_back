package com.example.intc_backend.model;

import javax.persistence.*;

@Entity
@Table(name = "vacancy")
public class Vacancy {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "position")
    private String position;
    @Column(name = "salary")
    private Long salary;
    @Column(name = "type_busy")
    private String typeBusy;
    @Column(name = "graphic_work")
    private String graphicWork;
    @Column(name = "description")
    private String description;
    @Column(name = "experience_age")
    private Long experienceAge;
    @Column(name = "company_address")
    private String companyAddress;
    @Column(name = "link")
    private String link;

    public String getGraphicWork() {
        return graphicWork;
    }

    public void setGraphicWork(String graphicWork) {
        this.graphicWork = graphicWork;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getExperienceAge() {
        return experienceAge;
    }

    public void setExperienceAge(Long experienceAge) {
        this.experienceAge = experienceAge;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public String getTypeBusy() {
        return typeBusy;
    }

    public void setTypeBusy(String typeBusy) {
        this.typeBusy = typeBusy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
