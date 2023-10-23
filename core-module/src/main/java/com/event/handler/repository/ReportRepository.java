package com.event.handler.repository;

import com.event.handler.entity.Report;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReportRepository extends MongoRepository<Report, Long> {}
