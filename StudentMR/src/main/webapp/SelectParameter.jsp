<%-- 
    Document   : SelectUniversity
    Created on : 28 Sep, 2020, 8:43:32 PM
    Author     : moxan
--%>

<%@page import="java.util.Set"%>
<%@page import="com.myutils.Retriever"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Select Background</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    </head>
    <body>
        <br><br>
        <div class="container w-75 m-auto shadow p-3 mb-5 bg-white rounded">
            <div class="alert alert-light text-secondary w-50 m-auto " role="alert">
                Select <text class="text-primary">Background</text> From below Dropdown
            </div>
            <br>
            <select id="universityname" class="form-control form-control-sm w-50 m-auto" onchange="navigateToUni()" >
                <option></option>
                <option>CS</option>
                <option>NCS</option>
                <option>__ALL__</option>
            </select><!-- comment --></div>
    </body>
    <script>
        function navigateToUni()
        {
            uname = document.getElementById("universityname");

            window.location.href = "/StudentMR/DisplayReport.jsp?bckg=" + uname.value;
        }
    </script>
</html>
