package com.sentiment.sentimentanalys.repository;

import com.sentiment.sentimentanalys.models.CompanyId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CompanyIdRepository extends MongoRepository<CompanyId, String>, CustomCompanyIdRepository {
}
