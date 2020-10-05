<%-- 
    Document   : average
    Created on : 29-May-2019, 10:45:21 AM
    Author     : awarsyle
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Week 4 Demo: Average</title>
    </head>
    <body>
        <h1>Average</h1>
        <div>
            <form action="average" method="POST">
                Enter a number: <input type="text" name="number"><br>
                <input type="submit" value="Submit">
            </form>
        </div>
        <div>
            Average: ${average}
        </div>
    </body>
</html>
