package com.lbsation.auto_open.configuartion;

import com.lbsation.auto_open.model.ConfigModel;
import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Slf4j
public class ConfigFile {
//    private static String propFile = "C:\\emsProject\\corba_exam\\auto_open\\src\\main\\resources\\config/application-autoOpen.yaml";
    private static String propFile = "/home/agwems/AGWEMS/yaml/application-autoOpen.yaml";
//    private static String propFile = "/home/emsuser/AGWEMS/yaml/application-autoOpen.yaml";

    public static ConfigModel getConfig() {
        Properties prop = new Properties();
        try {

            FileInputStream fis = new FileInputStream(propFile);
            // 프로퍼티 파일 로딩
            prop.load(new java.io.BufferedInputStream(fis));
        } catch (
                IOException e) {
            System.out.println("COFIG 파일 로드 실패");
        }

        ConfigModel configModel = new ConfigModel();
        configModel.setOrbPort(prop.getProperty("ORB_PORT"));
        configModel.setOrbServerHost(prop.getProperty("ORB_SERVER_HOST"));
        configModel.setServerPort(prop.getProperty("SERVER_PORT"));
        configModel.setServerHost(prop.getProperty("SERVER_HOST"));
        configModel.setOrbInitialHost(prop.getProperty("ORB_INITIALHOST"));

        configModel.setNameComponent(prop.getProperty("ORB_NAMECOMPONENT"));


        configModel.setDbIp(prop.getProperty("DB_IP"));
        configModel.setDbPort(prop.getProperty("DB_PORT"));
        configModel.setDbName(prop.getProperty("DB_NAME"));
        configModel.setDbUser(prop.getProperty("DB_USER"));
        configModel.setDbPw(prop.getProperty("DB_PW"));
        configModel.setDbPw(prop.getProperty("DB_PW"));

        configModel.setJavaHome(prop.getProperty("JAVA_HOME"));
        configModel.setRedisNodes(prop.getProperty("REDIS_NODES"));
        log.info("{}", configModel);
        return configModel;
    }
}
