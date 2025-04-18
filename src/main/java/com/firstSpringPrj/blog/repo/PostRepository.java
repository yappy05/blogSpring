package com.firstSpringPrj.blog.repo;

import com.firstSpringPrj.blog.models.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface PostRepository extends MongoRepository<Post, String> {

}
