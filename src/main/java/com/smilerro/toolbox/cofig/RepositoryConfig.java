package com.smilerro.toolbox.cofig;

import com.smilerro.toolbox.repository.impl.BaseRepositoryImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author ：Skf
 * @date ：Created in 2019/11/1 0001 16:46
 */
@Configuration
@EnableJpaRepositories(repositoryBaseClass = BaseRepositoryImpl.class,basePackages = "com.smilerro.toolbox.repository")
public class RepositoryConfig {
}
