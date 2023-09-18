package com.reports.svc.impl;

import com.reports.svc.ConnectionSvc;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Service
public class ConnectionSvcImpl implements ConnectionSvc {

    @Value("${spring.datasource.url}")
    private String dataBaseUrl;
    @Value("${spring.datasource.username}")
    private String dataBaseUserName;
    @Value("${spring.datasource.password}")
    private String dataBasePassword;


    @Override
    public Connection getConnection() throws SQLException {
        String url = dataBaseUrl;
        String user = dataBaseUserName;
        String password = dataBasePassword;
        return DriverManager.getConnection(url, user, password);
    }
}
