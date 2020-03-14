package com.yangqi.utils.redis;

import com.yangqi.utils.properties.PropertiesUtil;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

/**
 * The type Jedis pool util.
 *
 * @author Yankee
 * @date 2020 /3/13 16:15
 */
public class JedisPoolUtil {
    // JedisCluster
    private static JedisCluster jedisCluster = null;
    // 解析配置文件
    private static Properties prop = PropertiesUtil.getProperties("redis.properties");

    /**
     * 创建 JedisCluster
     * JedisCluter 不需要单独构建连接池，其已经基于连接池实现
     */
    private static void createJedisCluster() {
        // JedisCluster 连接配置
        String[] serverArray = prop.getProperty("servers").split(",");
        // 连接 RedisCluster 实例超时时间
        int connectionTimeout = Integer.parseInt(prop.getProperty("connectionTimeout"));
        // 读写 RedisCluster 实例超时时间
        int soTimeout = Integer.parseInt(prop.getProperty("soTimeout"));
        // 连接 RedisCluster 实例失败重试次数
        int maxAttempts = Integer.parseInt(prop.getProperty("maxAttempts"));

        // Jedis 连接池配置
        // 建立连接池配置参数
        JedisPoolConfig config = new JedisPoolConfig();
        // 设置最大连接数
        config.setMaxTotal(Integer.parseInt(prop.getProperty("maxTotal")));
        // 设置最大阻塞时间，单位是毫秒
        config.setMaxWaitMillis(Integer.parseInt(prop.getProperty("maxWaitMillis")));
        // 设置最大空闲连接数
        config.setMaxIdle(Integer.parseInt(prop.getProperty("maxIdle")));
        // 设置最小空闲连接数
        config.setMinIdle(Integer.parseInt(prop.getProperty("minIdle")));
        // Jedis 实例是否可用
        boolean testOnBorrow = !prop.getProperty("testOnBorrow").equals("false");
        config.setTestOnBorrow(testOnBorrow);
        // 从连接池获取不到则连接阻塞
        boolean blockWhenExhausted = !prop.getProperty("blockWhenExhausted").equals("false");
        config.setBlockWhenExhausted(blockWhenExhausted);
        // 连接对象后进先出
        boolean lifo = !prop.getProperty("lifo").equals("false");
        config.setLifo(lifo);
        // 归还连接到连接池测试连接
        boolean testOnReturn = !prop.getProperty("testOnReturn").equals("false");
        config.setTestOnReturn(testOnReturn);
        // 测试连接池空闲的连接
        boolean testWhileIdle = !prop.getProperty("testWhileIdle").equals("false");
        config.setTestWhileIdle(testWhileIdle);
        // 测试连接池空闲连接的时间间隔，testWhileIdle = true 时生效
        config.setTimeBetweenEvictionRunsMillis(Integer.parseInt(prop.getProperty("timeBetweenEvictionRunsMillis")));

        // 存储 RedisCluster 集群的服务器地址
        Set<HostAndPort> nodes = new HashSet<>();
        for (String ipPort : serverArray) {
            String[] ipPortPair = ipPort.split(":");
            nodes.add(new HostAndPort(ipPortPair[0].trim(), Integer.parseInt(ipPortPair[1].trim())));
        }

        // 注意：这里超时时间不要太短，会有超时重试机制
        jedisCluster = new JedisCluster(nodes, connectionTimeout, soTimeout, maxAttempts, config);
    }

    /**
     * Gets jedis cluster.
     *
     * @return the jedis cluster
     */
    public static JedisCluster getJedisCluster() {
        if (jedisCluster == null) {
            createJedisCluster();
        }
        return jedisCluster;
    }
}
