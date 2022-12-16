package com.lbsation.auto_open.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;

@Data
@ToString
public class ConfigModel {
    private String dbIp;
    private String dbPort;
    private String dbName;
    private String dbUser;
    private String dbPw;

    private String orbPort;
    private String orbInitialHost;
    private String orbServerHost;

    private String ServerPort;
    private String serverHost;

    private String nameComponent;

    private String redisNodes;
    private String javaHome;

    private static String test;
    @Value("${test}")
    private void setTest(String test){
        System.out.println("test"+ test);
        ConfigModel.test = test;
    }
    public static String getTest(){
        return ConfigModel.test;
    }
    public String[] getNameComponent(){
        return this.nameComponent.split(",");
    }

    public String[] getRedisNodes(){
        return this.redisNodes.split(",");
    }
}
