package com.yangqi.utils.mysql;

import java.sql.ResultSet;

/**
 * 结果集接口
 *
 * @param <T> the type parameter
 * @author Yankee
 * @date 2020 /3/14 7:30
 */
public interface IResultSetHandler<T> {
    /**
     * Handler t.
     *
     * @param rs the rs
     * @return the t
     */
    T handler(ResultSet rs);
}
