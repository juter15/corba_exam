package com.lbsation.auto_open.configuartion;

import com.lbsation.auto_open.CorbaDemoApplication;
import com.lbsation.auto_open.model.ConfigModel;
import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.*;
import redis.clients.jedis.util.Pool;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
@Slf4j
public class RedisConfiguration {

//    private static String propFile = "C:\\emsProject\\corba_exam\\auto_open\\src\\main\\resources\\config/application-autoOpen.yaml";


    public static JedisCluster jedisCluster() {
        ConfigModel config = CorbaDemoApplication.getConfigModel();
//        try {
//            Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
//
//            jedisClusterNodes.add(new HostAndPort("61.98.79.244", 7000));
//            jedisClusterNodes.add(new HostAndPort("61.98.79.244", 7001));
//            jedisClusterNodes.add(new HostAndPort("61.98.79.244", 7002));
//
//            return new JedisCluster(jedisClusterNodes);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
        String[] redisNodes = config.getRedisNodes();
        System.out.println("CONFIG: " + redisNodes);
        Set<HostAndPort> jedisClusterNodes = new HashSet<>();
        for (String node : redisNodes) {
            String[] nodeSplit = node.split(":");
            jedisClusterNodes.add(new HostAndPort(nodeSplit[0], Integer.parseInt(nodeSplit[1])));

        }


        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(40);
        jedisPoolConfig.setMinIdle(10);
        jedisPoolConfig.setMaxWait(Duration.ofMillis(5));
        return new JedisCluster(jedisClusterNodes, Duration.ZERO.getNano());
    }




}
