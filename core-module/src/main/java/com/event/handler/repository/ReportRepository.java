package com.event.handler.repository;

import com.event.handler.model.Report;
import java.util.UUID;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReportRepository extends MongoRepository<Report, UUID> {}
