package com.example.intc_backend.dto;

public class VacancySaveRequestDto {
    private String companyName;
    private String position;
    private Long salary;
    private String description;
    private String graphic;
    private String companyAddress;
    private Long experienceAge;

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

    public String getGraphic() {
        return graphic;
    }

    public void setGraphic(String graphic) {
        this.graphic = graphic;
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
