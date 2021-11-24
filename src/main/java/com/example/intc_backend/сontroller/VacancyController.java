package com.example.intc_backend.сontroller;

import com.example.intc_backend.dto.NewsDto;
import com.example.intc_backend.dto.NewsSaveRequestDto;
import com.example.intc_backend.dto.VacancyDto;
import com.example.intc_backend.dto.VacancySaveRequestDto;
import com.example.intc_backend.model.Vacancy;
import com.example.intc_backend.service.NewsService;
import com.example.intc_backend.service.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VacancyController {

    private final VacancyService vacancyService;

    @Autowired
    public VacancyController(VacancyService vacancyService) {
        this.vacancyService = vacancyService;
    }

    @PostMapping(value = "create-vacancy")
    public ResponseEntity<?> createVacanyc(@RequestBody VacancySaveRequestDto vacancySaveRequestDto) {
        System.out.println(vacancySaveRequestDto.toString());
        vacancyService.save(vacancySaveRequestDto);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/vacancy/{id}")
    public ResponseEntity<VacancyDto> findVacancyById(@PathVariable(name = "id") Long id) {
        VacancyDto vacancyDto = vacancyService.findById(id);

        return ResponseEntity.ok(vacancyDto);
    }

    @PostMapping(value = "/vacancy/{id}")
    public ResponseEntity<VacancyDto> updateVacancyById(@PathVariable(name = "id") Long id, @RequestParam(name = "companyName") String companyName, @RequestParam(name = "companyAddress") String companyAddress, @RequestParam(name = "experienceAge") Long experienceAge, @RequestParam(name = "position") String position, @RequestParam(name = "salary") Long salary, @RequestParam(name = "graphic") String graphic, @RequestParam(name = "description") String description) {
        VacancyDto vacancyDto = vacancyService.findById(id);
        if (!companyName.equals("null")) {
            vacancyDto.setCompanyName(companyName);
        }
        if (!description.equals("null")) {
            vacancyDto.setDescription(description);
        }
        if (!position.equals("null")) {
            vacancyDto.setPosition(position);
        }
        if (!graphic.equals("null")) {
            vacancyDto.setGraphic(graphic);
        }
        if (salary != null) {
            vacancyDto.setSalary(salary);
        }
        if (!companyAddress.equals("null")) {
            vacancyDto.setCompanyAddress(companyAddress);
        }
        if (experienceAge != null) {
            vacancyDto.setExperienceAge(experienceAge);
        }

        vacancyService.updateVacancy(vacancyDto);

        return ResponseEntity.ok(vacancyDto);
    }

    @GetMapping(value = "/all/vacancy")
    public ResponseEntity<List<VacancyDto>> findAllVacancyList() {
        List<VacancyDto> userDtoList = vacancyService.findAll();

        return ResponseEntity.ok(userDtoList);
    }


}
