package com.lbsation.auto_open.configuartion;

import com.lbsation.auto_open.CorbaDemoApplication;
import com.lbsation.auto_open.model.ConfigModel;
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
//    private static String propFile = "C:\\emsProject\\corba_exam\\auto_open\\src\\main\\resources\\config/application-autoOpen.yaml";
    public static Connection dbConnect()  {


        ConfigModel config = CorbaDemoApplication.getConfigModel();

        final String driver = "org.mariadb.jdbc.Driver";
        final String DB_IP = config.getDbIp();
        final String DB_PORT = config.getDbPort();
        final String DB_NAME = config.getDbName();
        final String DB_USER = config.getDbUser();
        final String DB_PW = config.getDbPw();
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
