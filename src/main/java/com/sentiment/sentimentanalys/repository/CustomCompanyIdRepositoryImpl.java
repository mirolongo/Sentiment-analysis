package com.sentiment.sentimentanalys.repository;


import com.sentiment.sentimentanalys.models.CompanyId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.BasicUpdate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public class CustomCompanyIdRepositoryImpl implements CustomCompanyIdRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void partialUpdate(String companyId, String fieldName, Object fieldValue) {
        mongoTemplate.findAndModify(BasicQuery.query(Criteria.where("id").is(companyId)),
                BasicUpdate.update(fieldName, fieldValue), FindAndModifyOptions.none(), CompanyId.class);
    }

    @Override
    public void delete(String companyId) {
        Query query = Query.query(Criteria.where("id").is(companyId));
        mongoTemplate.findAndRemove(query, CompanyId.class);
    }
}
