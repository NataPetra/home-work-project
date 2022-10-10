<html>
<head>
  <meta charset="utf-8">
  <title>Home</title>
  <style>
   #centerLayer {
    position: absolute;
    width: 280px;
    height: 180px;
    left: 50%;
    top: 50%;
    margin-left: -150px;
    margin-top: -100px;
    background: #fc0;
    border: solid 1px black;
    padding: 10px;
    overflow: auto;
   }
   h3 {
   text-align: center;
   }
   body {
   background: url(img/flowers.jpg);
   background-size: 100%;
   }
  </style>
 </head>
 <body>
  <div id="centerLayer">
    <h3>This is main page</h3><br>
    <a href="${pageContext.request.contextPath}/firstExample">Info about servlet (task 8)</a><br>
    <a href="${pageContext.request.contextPath}/counterText">Servlet with counter text (task 9)</a><br>
    <a href="${pageContext.request.contextPath}/jsp/form-for-personal-info.jsp">Personal info (task 10)</a><br>
    <a href="${pageContext.request.contextPath}/userAgent">User-Agent (task 11)</a><br>
    <a href="${pageContext.request.contextPath}/counterImg">Servlet with counter img (task 12)</a><br>


  </div>
 </body>
</html>