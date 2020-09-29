<%-- 
    Document   : DisplayReport
    Created on : 28 Sep, 2020, 7:52:18 PM
    Author     : moxan
--%>

<%@page import="net.sf.jasperreports.engine.JasperPrintManager"%>
<%@page import="com.myutils.Retriever"%>
<%@page import="net.sf.jasperreports.engine.JasperRunManager"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.POJO.StudentRc"%>
<%@page import="net.sf.jasperreports.engine.JasperPrint"%>
<%@page import="net.sf.jasperreports.engine.JasperFillManager"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="net.sf.jasperreports.engine.data.JRBeanCollectionDataSource"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
        String uname = request.getParameter("uname");
         List<StudentRc> li = (new Retriever()).getStudentList(uname);
         
         
         JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(li);
        Map<String, Object> parameters = new HashMap<String, Object>();
        String jpath = "D:\\LAB\\SEMVII\\BDA\\Lab10\\StudentMR\\src\\main\\resources\\JStudentReport.jasper";
        //JasperPrint jasperPrint = JasperFillManager.fillReport(jpath, parameters, beanColDataSource);
        JasperPrintManager jprm;
        
        byte bytes[] = JasperRunManager.runReportToPdf(jpath, parameters,beanColDataSource);
        response.setContentType("application/pdf");
            response.setContentLength(bytes.length);
            ServletOutputStream outStream = response.getOutputStream();
            outStream.write(bytes, 0, bytes.length);
            outStream.flush();
            outStream.close();
        %>
    </body>
</html>
