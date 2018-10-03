<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018.5.8
  Time: 下午 9:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  当前在线用户人数: ${userNumber}<br>
  <%
      ArrayList<entity.User> userList =(ArrayList<entity.User>)request.getServletContext().getAttribute("userList");
      if (userList != null)
      {
          for (int i = 0; i < userList.size() ; i++)
          {
              entity.User user = userList.get(i);
  %>
  IP : <%=user.getIpString()%>, FirstTime : <%= user.getFirstTimeString()%>, SessionId :<%= user.getSessionIdString()%><br>
  <%
          }
      }
  %>
  </body>
</html>
