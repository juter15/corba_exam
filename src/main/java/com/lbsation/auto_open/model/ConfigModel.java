package com.lbsation.auto_open.model;

import lombok.Data;
import lombok.ToString;

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

    private String orbServerPort;
    private String orbServerHost;

    private String nameComponent;

    private String redisNodes;
    private String javaHome;
    public String[] getNameComponent(){
        return this.nameComponent.split(",");
    }

    public String[] getRedisNodes(){
        return this.redisNodes.split(",");
    }
}
