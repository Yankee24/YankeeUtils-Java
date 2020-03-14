package com.yangqi.utils.mysql;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Bean handler.
 *
 * @param <T> the type parameter
 * @author Yankee
 * @date 2020 /3/14 7:46
 */
public class BeanHandler<T> implements IResultSetHandler<List<T>> {
    // 创建字节码对象
    private Class<T> clazz;

    /**
     * Instantiates a new Bean handler.
     *
     * @param clazz the clazz
     */
    public BeanHandler(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public List<T> handler(ResultSet rs) {
        // 创建 List 存放装箱后的对象
        List<T> list = new ArrayList<>();
        try {
            // 获取类的属性描述符
            BeanInfo beanInfo = Introspector.getBeanInfo(clazz, Object.class);
            PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
            // 对结果集进行装箱操作
            while (rs.next()) {
                T obj = clazz.newInstance();
                for (PropertyDescriptor descriptor : descriptors) {
                    Object value = rs.getObject(descriptor.getName());
                    descriptor.getWriteMethod().invoke(obj, value);
                }
                list.add(obj);
            }
        } catch (IntrospectionException | SQLException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return list;
    }
}
