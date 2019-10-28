package com.smilerro.toolbox.repository;

import com.smilerro.toolbox.entity.Gate;
import com.smilerro.toolbox.entity.WebSite;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author ：Skf
 * @date ：Created in 2019/10/25 0025 14:00
 */
public interface WebSiteRepository extends JpaRepository<WebSite,String> {

    List<WebSite> findByCategory_Gate(Gate gate);
}
