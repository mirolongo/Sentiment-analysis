package com.sentiment.sentimentanalys.repository;

public interface CustomCompanyRepository {

    void partialUpdate(final String companyId, final String fieldName, final Object fieldValue);
    void delete(String companyId);
}