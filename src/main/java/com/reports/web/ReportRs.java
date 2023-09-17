package com.reports.web;

import com.reports.svc.ReportsSvc;
import lombok.SneakyThrows;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Map;

@RestController
@RequestMapping("/reports")
public class ReportRs {

    @Autowired
    ReportsSvc reportsSvc;
    private static final String PDF = ".pdf";
    private static final String ATTACHMENT = "attachment";

    @PostMapping("/{report-name}")
    public ResponseEntity<byte[]> generateRequestReport(@PathVariable("report-name") String reportName,
                                                        @RequestBody Map<String, Object> params) throws JRException, SQLException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData(ATTACHMENT, reportName.concat(PDF));
        return new ResponseEntity<>(reportsSvc.generateReport(reportName, params), headers, HttpStatus.OK);
    }
}
