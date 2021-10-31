package com.sentiment.sentimentanalysis.repository;

import com.sentiment.sentimentanalysis.models.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.BasicUpdate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public class CustomCompanyRepositoryImpl implements CustomCompanyRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void partialUpdate(String companyId, String fieldName, Object fieldValue) {
        mongoTemplate.findAndModify(BasicQuery.query(Criteria.where("id").is(companyId)),
                BasicUpdate.update(fieldName, fieldValue), FindAndModifyOptions.none(), Company.class);
    }

    @Override
    public void delete(String companyId) {
        Query query = Query.query(Criteria.where("id").is(companyId));
        mongoTemplate.findAndRemove(query, Company.class);
    }
}
