<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: lam
  Date: 08/11/2019
  Time: 09:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>list</title>
</head>
<body>
<%
  class UserManage {
    private String name = "";
    private String dateOfBirth = "";
    private String adress = "";

    UserManage(String lam, String s, String paris) {
    }

    UserManage(String name, String dateOfBirth, String adress, String imgURL) {
      this.name = name;
      this.dateOfBirth = dateOfBirth;
      this.adress = adress;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getDateOfBirth() {
      return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
      this.dateOfBirth = dateOfBirth;
    }

    public String getAdress() {
      return adress;
    }

    public void setAdress(String adress) {
      this.adress = adress;
    }
  }
  List<UserManage> userManages = new ArrayList<>();
%>
<%
  UserManage lam = new UserManage("lam", "30/06/1995","Paris");
  UserManage hieu = new UserManage("hieu", "30/06/1996","Paris");
  UserManage tuan = new UserManage("tuan", "30/06/1965","Paris");
  userManages.add(lam);
  userManages.add(hieu);
  userManages.add(tuan);

  String name = request.getParameter("name");
%>
<html>
<head>
  <link rel="stylesheet" type="text/css" href="style.css"/>
  <title>Information</title>
</head>
<body>
<fieldset>
  <legend>Customer</legend>
  <table>
    <tr>
      <th>Name</th>
      <th>Date of birth</th>
      <th>Address</th>
      <th>Image</th>
    </tr>
    <%
      for (UserManager userManager : userManagers) {
        if (name.equals(userManager.getName())) { %>
    <tr>
      <td><%=userManager.getName()%>
      </td>
      <td><%=userManager.getDateOfBirth()%>
      </td>
      <td><%=userManager.getAddress()%>
      </td>
      <td><img class="image" width="200" src="<%=userManager.getImgURL()%>"/></td>
    </tr>


    <%
        }
      }
      userManagers.clear();
    %>
  </table>
</fieldset>
</body>
</html>