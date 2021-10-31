package com.sentiment.sentimentanalysis.controllers;

import com.sentiment.sentimentanalysis.dao.CompanyDAO;
import com.sentiment.sentimentanalysis.models.Company;
import com.sentiment.sentimentanalysis.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Objects;

@RestController
public class CompanyController {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private CompanyDAO companyDAO;


    //Add a new company to the database via POST
    @PostMapping("/companies")
    public void addCompany(@RequestBody final List<Company> companies) {
        companyDAO.saveAll(companies);

    }
    //Show all company from the database via GET
    @GetMapping("/companies")
    public List<Company> findCompanies() {
        return companyDAO.findAll();
    }


    //Show  specific  company from the database via Post using ID
    @GetMapping("/companies/{companyId}")
    public Company findCompany(@PathVariable final String companyId) {
        return companyDAO.findById(companyId);
    }

    //Update a specific field in collection company in the database via PATCH
    @PatchMapping("/companies/{companyId}")
    public void partialUpdateCompany(@PathVariable final String companyId, @RequestBody final Company company)
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        for (final Field field : Company.class.getDeclaredFields()) {
            final String fieldName = field.getName();
            if (fieldName.equals("id")) {
                continue;
            }
            final Method getter = Company.class.getDeclaredMethod("get" + StringUtils.capitalize(fieldName));
            final Object fieldValue = getter.invoke(company);

            if (Objects.nonNull(fieldValue)) {
                companyRepository.partialUpdate(companyId, fieldName, fieldValue);
            }
        }
    }

    //Delete a company in the database via DELETE-ID
    @DeleteMapping("/company-delete/{companyId}")
    public void delete(@PathVariable("companyId") String companyId) {
        companyRepository.delete(companyId);
    }
}


