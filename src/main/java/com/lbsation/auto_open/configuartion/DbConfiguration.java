package com.lbsation.auto_open.configuartion;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

public class DbConfiguration {
    private static String propFile = "/home/agwems/AGWEMS/yaml/application-autoOpen.yaml";
    public static Connection dbConnect()  {
        Properties prop = new Properties();


        // 프로퍼티 파일 스트림에 담기
        try{

            FileInputStream fis = new FileInputStream(propFile);
            // 프로퍼티 파일 로딩
            prop.load(new java.io.BufferedInputStream(fis));
        }
        catch (IOException e){
            System.out.println("COFIG 파일 로드 실패");
        }

        final String driver = "org.mariadb.jdbc.Driver";
        final String DB_IP = prop.getProperty("DB_IP");
        final String DB_PORT = prop.getProperty("DB_PORT");
        final String DB_NAME = prop.getProperty("DB_NAME");
        final String DB_USER = prop.getProperty("DB_USER");
        final String DB_PW = prop.getProperty("DB_PW");
        final String DB_URL =
                "jdbc:mariadb://" + DB_IP + ":" + DB_PORT + "/" + DB_NAME;

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PW);
            if (conn != null) {
                System.out.println("DB 접속 성공");
                return conn;
            }

        } catch (ClassNotFoundException e) {
            System.out.println("드라이버 로드 실패");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("DB 접속 실패");
            e.printStackTrace();
        }
        return null;
    }
}
