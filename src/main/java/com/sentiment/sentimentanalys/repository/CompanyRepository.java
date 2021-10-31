package com.sentiment.sentimentanalysis.repository;

import com.sentiment.sentimentanalysis.models.Company;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CompanyRepository extends MongoRepository<Company, String>, CustomCompanyRepository {
}
