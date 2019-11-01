package com.smilerro.toolbox.repository.impl;

import com.smilerro.toolbox.repository.BaseRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * @author ：Skf
 * @date ：Created in 2019/11/1 0001 16:41
 */
@SuppressWarnings("all")
public class BaseRepositoryImpl<T , ID>
        extends SimpleJpaRepository<T, ID>
        implements BaseRepository<T, ID> {

    private final JpaEntityInformation<T, ?> entityInformation;
    private final EntityManager em;

    public BaseRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation,entityManager);
        this.entityInformation = entityInformation;
        this.em = entityManager;
    }

    public BaseRepositoryImpl(Class<T> domainClass, EntityManager em) {
        this(JpaEntityInformationSupport.getEntityInformation(domainClass, em), em);
    }

    protected Class<T> getEntityClass() {
        return entityInformation.getJavaType();
    }

    /**
     * 通过hql语句进行查询
     * @param hql
     * @return
     */
    @Override
    public List<T> queryByHql(String hql) {
        Query query = em.createQuery(hql ,getEntityClass());
        List<T> resultList = query.getResultList();
        return resultList;
    }
    /**
     * 通过hql语句查询单个对象
     * @param hql
     * @return
     */
    @Override
    public T queryOneByHql(String hql) {
        List<T> ts = queryByHql(hql);
        return (ts!=null&&ts.size()>0)?ts.get(0):null;
    }
}
