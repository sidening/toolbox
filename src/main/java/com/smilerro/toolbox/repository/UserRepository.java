package com.smilerro.toolbox.repository;

import com.smilerro.toolbox.entity.User;
import com.smilerro.toolbox.entity.WebSite;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author ：Skf
 * @date ：Created in 2019/10/25 0025 14:00
 */
public interface UserRepository extends MongoRepository<User,String> {
    User findByUsernameAndPassword(String username ,String password);
}
