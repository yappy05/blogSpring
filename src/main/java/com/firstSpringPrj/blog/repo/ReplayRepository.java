package com.firstSpringPrj.blog.repo;

import com.firstSpringPrj.blog.models.Replay;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReplayRepository extends MongoRepository<Replay, String> {
}
