package com.project.main.repository;

import com.project.main.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String>,CustomUserRepository {
}

interface CustomUserRepository{

    List<User> findByPassword(String password);
}

@Repository
@RequiredArgsConstructor
class CustomUserRepositoryImpl implements CustomUserRepository{

    private final MongoTemplate mongoTemplate;

    @Override
    public List<User> findByPassword(String password){

        Query query=new Query();
        query.addCriteria(Criteria.where("password").is(password));
        return mongoTemplate.find(query,User.class);
    }



}