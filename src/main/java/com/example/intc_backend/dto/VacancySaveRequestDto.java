package com.example.intc_backend.dto;

public class VacancySaveRequestDto {
    private String companyName;
    private String position;
    private Long salary;
    private String typeBusy;
    private String graphicWork;
    private String description;
    private String companyAddress;
    private Long experienceAge;
    private String link;

    public String getGraphicWork() {
        return graphicWork;
    }

    public void setGraphicWork(String graphicWork) {
        this.graphicWork = graphicWork;
    }

    public String getTypeBusy() {
        return typeBusy;
    }

    public void setTypeBusy(String typeBusy) {
        this.typeBusy = typeBusy;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public Long getExperienceAge() {
        return experienceAge;
    }

    public void setExperienceAge(Long experienceAge) {
        this.experienceAge = experienceAge;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
