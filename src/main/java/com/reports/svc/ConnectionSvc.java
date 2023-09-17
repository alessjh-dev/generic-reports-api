package com.reports.svc;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionSvc {
    Connection getConnection() throws SQLException;
}
