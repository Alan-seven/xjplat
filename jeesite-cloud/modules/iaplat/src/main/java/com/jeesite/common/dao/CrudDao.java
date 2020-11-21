package com.jeesite.common.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CrudDao<T> extends QueryDao<T> {
    List<T> findList(T paramT);

    long updateStatusByEntity(@Param("param1") T paramT1, @Param("param2") T paramT2);

    long insertBatch(@Param("param1") List<T> paramList);

    long insert(T paramT);

    long updateByEntity(@Param("param1") T paramT1, @Param("param2") T paramT2);

    long findCount(T paramT);

    long updateStatus(T paramT);

    long update(T paramT);

    int phyDeleteByEntity(T paramT);

    T getByEntity(T paramT);

    int phyDelete(T paramT);

    long delete(T paramT);

    long deleteByEntity(T paramT);

    T get(T paramT);
}
