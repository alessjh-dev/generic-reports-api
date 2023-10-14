package com.reports.svc.impl;

import com.reports.svc.ConnectionSvc;
import com.reports.svc.ReportsSvc;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Service
public class ReportsSvcImpl implements ReportsSvc {

    @Autowired
    ConnectionSvc connectionSvc;

    private static final String REPORT_PATH = "src/main/resources/reports/";
    private static final String REPORT_EXTENSION = ".jasper";
    private static final String REPORT_CONNECTION = "REPORT_CONNECTION";
    private static final String REPORT_PARAMS = "PARAMS";

    @Override
    public byte[] generateReport(String reportName, Map<String, Object> reportParams) throws JRException, SQLException {
        Map<String, Object> params = new HashMap<>();
        Connection connection = connectionSvc.getConnection();
        params.put(REPORT_CONNECTION, connection);
        params.put(REPORT_PARAMS, reportParams);
        JasperPrint jasperPrint = JasperFillManager
                .fillReport(REPORT_PATH.concat(reportName).concat(REPORT_EXTENSION), params, connection);
        return JasperExportManager.exportReportToPdf(jasperPrint);
    }
}
