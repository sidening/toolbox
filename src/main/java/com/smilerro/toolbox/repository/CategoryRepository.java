package com.smilerro.toolbox.repository;

import com.smilerro.toolbox.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author ：Skf
 * @date ：Created in 2019/10/28 0028 10:17
 */
public interface CategoryRepository extends BaseRepository<Category , String> {

    List<Category> findByGate_Id(String gateId);
}
