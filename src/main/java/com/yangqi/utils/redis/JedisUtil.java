package com.yangqi.utils.redis;

import com.yangqi.utils.properties.PropertiesUtil;
import redis.clients.jedis.Jedis;

import java.util.Properties;

/**
 * 通过 Jedis 连接池获取 Jedis 对象
 * 此工具类基于 Jedis-3.0.0
 *
 * @author Yankee
 * @date 2020 /3/13 16:29
 */
public class JedisUtil {
    // Jedis
    private static Jedis jedis = null;
    // 解析配置文件
    private static Properties prop = PropertiesUtil.getProperties("redis.properties");

    /**
     * 创建 Jedis 连接对象
     */
    private static void createJedis() {
        // Jedis 连接配置
        String server = prop.getProperty("server");
        // 连接 Redis 实例超时时间
        int connectionTimeout = Integer.parseInt(prop.getProperty("connectionTimeout"));
        // 读写 Redis 实例超时时间
        int soTimeout = Integer.parseInt(prop.getProperty("soTimeout"));

        // 注意：这里超时时间不要太短，会有超时重试机制
        jedis = new Jedis(server, connectionTimeout, soTimeout);
    }


    /**
     * Gets jedis.
     *
     * @return the jedis
     */
    public static Jedis getJedis() {
        if (jedis == null) {
            createJedis();
        }
        return jedis;
    }
}
