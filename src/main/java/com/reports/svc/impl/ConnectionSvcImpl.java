package com.reports.svc.impl;

import com.reports.svc.ConnectionSvc;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Service
public class ConnectionSvcImpl implements ConnectionSvc {

    @Override
    public Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://bubble.db.elephantsql.com:5432/evaiffuq";
        String user = "evaiffuq";
        String password = "ClmO7TGgDrhiuaWe7dg82zgWdW1kdkV1";
        return DriverManager.getConnection(url, user, password);
    }
}
