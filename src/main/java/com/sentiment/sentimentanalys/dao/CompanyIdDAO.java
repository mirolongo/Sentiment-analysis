package com.sentiment.sentimentanalysis.dao;

import com.sentiment.sentimentanalysis.models.CompanyId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CompanyIdDAO {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<CompanyId> findAll() {
        return mongoTemplate.findAll(CompanyId.class);
    }

    public void saveAll(final List<CompanyId> companies) {
        mongoTemplate.insertAll(companies);
    }

    public CompanyId findById(final String companyId) {
        return mongoTemplate.findById(companyId, CompanyId.class);
    }
}
