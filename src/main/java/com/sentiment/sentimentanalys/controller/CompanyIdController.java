package com.sentiment.sentimentanalysis.controllers;

import com.sentiment.sentimentanalysis.dao.CompanyIdDAO;
import com.sentiment.sentimentanalysis.models.CompanyId;
import com.sentiment.sentimentanalysis.repository.CompanyIdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Objects;


@RestController
public class CompanyIdController {

    @Autowired
    private CompanyIdRepository companyIdRepository;

    @Autowired
    private CompanyIdDAO companyIdDAO;
    //Add a new company ISIN to the database via POST
    @PostMapping("/companyisin")
    public void addCompany(@RequestBody final List<CompanyId> companyIds) {
        companyIdDAO.saveAll(companyIds);

    }
    //Show all company ISIN from the database via GET
    @GetMapping("/companyisin")
    public List<CompanyId> findCompanyId() {
        return companyIdDAO.findAll();
    }

    //Show  specific  company ISIN from the database via Post using ID
    @GetMapping("/companyisin/{companyId}")
    public CompanyId findCompanyId(@PathVariable final String companyId) {
        return companyIdDAO.findById(companyId);
    }

    //Update a specific field in collection company ISIN in the database via PATCH
    @PatchMapping("/companyisin/{companyId}")
    public void partialUpdateCompany(@PathVariable final String companyId, @RequestBody final CompanyId company)
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        for (final Field field : CompanyId.class.getDeclaredFields()) {
            final String fieldName = field.getName();
            if (fieldName.equals("id")) {
                continue;
            }
            final Method getter = CompanyId.class.getDeclaredMethod("get" + StringUtils.capitalize(fieldName));
            final Object fieldValue = getter.invoke(company);

            if (Objects.nonNull(fieldValue)) {
                companyIdRepository.partialUpdate(companyId, fieldName, fieldValue);
            }
        }
    }
    //Delete a company ISIN in the database via DELETE-ID
    @DeleteMapping("/company-id-delete/{companyId}")
    public void delete(@PathVariable("companyId") String companyId) {
        companyIdRepository.delete(companyId);
    }
}

