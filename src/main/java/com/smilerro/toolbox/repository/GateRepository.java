package com.smilerro.toolbox.repository;

import com.smilerro.toolbox.entity.Gate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author ：Skf
 * @date ：Created in 2019/10/28 0028 9:49
 */
public interface GateRepository extends BaseRepository<Gate,String> {
    List<Gate> findAllByStatusOrderByNumAsc(Integer status);
}
