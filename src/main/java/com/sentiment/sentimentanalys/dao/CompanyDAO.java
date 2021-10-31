package com.sentiment.sentimentanalysis.dao;

import com.sentiment.sentimentanalysis.models.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CompanyDAO {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Company> findAll() {
        return mongoTemplate.findAll(Company.class);
    }

    public void saveAll(final List<Company> companies) {
        mongoTemplate.insertAll(companies);
    }

    public Company findById(final String companyId) {
        return mongoTemplate.findById(companyId, Company.class);
    }

}
