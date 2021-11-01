package com.sentiment.sentimentanalys.repository;



import com.sentiment.sentimentanalys.models.Company;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface CompanyRepository extends MongoRepository<Company, String>, CustomCompanyRepository {
}
