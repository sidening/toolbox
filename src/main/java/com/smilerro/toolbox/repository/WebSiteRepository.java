package com.smilerro.toolbox.repository;

import com.smilerro.toolbox.entity.WebSite;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author ：Skf
 * @date ：Created in 2019/10/25 0025 14:00
 */
public interface WebSiteRepository extends MongoRepository<WebSite,String> {
}
