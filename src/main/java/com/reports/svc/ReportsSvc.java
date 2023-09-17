package com.reports.svc;
import net.sf.jasperreports.engine.JRException;

import java.sql.SQLException;
import java.util.Map;

public interface ReportsSvc {
    byte[] generateReport(String reportName, Map<String, Object> reportParams) throws JRException, SQLException;
}
