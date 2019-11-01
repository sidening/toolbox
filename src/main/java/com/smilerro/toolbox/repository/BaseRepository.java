package com.smilerro.toolbox.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

/**
 * @author ：Skf
 * @date ：Created in 2019/11/1 0001 16:39
 */
@NoRepositoryBean
public interface BaseRepository<T,ID> extends JpaRepository<T,ID> {
    /**
     * 通过hql语句进行查询
     * @param hql
     * @return
     */
    List<T> queryByHql(String hql);

    /**
     * 通过hql语句查询单个对象
     * @param hql
     * @return
     */
    T queryOneByHql(String hql);
}
