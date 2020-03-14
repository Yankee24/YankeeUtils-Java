package com.yangqi.utils.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * The type Properties util.
 *
 * @author Yankee
 * @date 2020 /3/13 15:56
 */
public class PropertiesUtil {
    private static Properties prop = new Properties();


    /**
     * Gets string by key.
     *
     * @param key      the key
     * @param propName the prop name
     * @return the string by key
     */
    public static String getStringByKey(String key, String propName) {
        // 获取 Properties 对象
        prop = getProperties(propName);
        // 获取对应 key 的 value 值
        return prop.getProperty(key);

    }

    /**
     * Gets properties.
     *
     * @param propName the prop name
     * @return the properties
     */
    public static Properties getProperties(String propName) {
        InputStream inputStream = ClassLoader.getSystemResourceAsStream(propName);
        // 加载配置文件
        try {
            prop.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 返回 Properties 对象
        return prop;
    }
}
