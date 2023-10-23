package com.event.handler.repository;

import com.event.handler.model.Report;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ReportRepository extends MongoRepository<Report, UUID> {}
