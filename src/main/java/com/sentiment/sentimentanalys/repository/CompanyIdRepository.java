package com.sentiment.sentimentanalysis.repository;

import com.sentiment.sentimentanalysis.models.CompanyId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CompanyIdRepository extends MongoRepository<CompanyId, String>, CustomCompanyIdRepository {
}
