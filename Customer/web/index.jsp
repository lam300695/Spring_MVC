<%--
  Created by IntelliJ IDEA.
  User: lam
  Date: 08/11/2019
  Time: 09:18
  To change this template use File | Settings | File Templates.
--%>
<<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  class UserManager {
    private String name = "";
    private String dateOfBirth = "";
    private String address = "";
    private String imgURL = "";
    UserManager() {
    }
    UserManager(String name, String dateOfBirth, String address, String imgURL) {
      this.name = name;
      this.dateOfBirth = dateOfBirth;
      this.address = address;
      this.imgURL = imgURL;
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
    public String getAddress() {
      return address;
    }
    public void setAddress(String address) {
      this.address = address;
    }
    public String getImgURL() {
      return imgURL;
    }
    public void setImgURL(String imgURL) {
      this.imgURL = imgURL;
    }
  }
  List<UserManager> userManagers = new ArrayList<>();
%>
<% UserManager dat = new UserManager("Dat", "22/22/2022", "Bãi rác", "https://cdn-images-1.medium.com/max/1600/1*DXDjCM8iOevaBO6vtYGjmA@2x.jpeg");
  UserManager lam = new UserManager("Lam", "11/11/1111", "Codegym", "https://vignette.wikia.nocookie.net/naruto/images/b/bb/Itachi.png/revision/latest?cb=20160125182202");
  UserManager nham = new UserManager("Nham", "33/33/3333", "Ngõ chợ Khâm Thiên", "http://www.dumpaday.com/wp-content/uploads/2016/05/Funny-3.jpg");
  UserManager nham1 = new UserManager("Nham", "33/33/3333", "Ngõ chợ Khâm Thiên", "http://www.dumpaday.com/wp-content/uploads/2016/05/Funny-3.jpg");
  UserManager nham2 = new UserManager("Nham", "33/33/3333", "Ngõ chợ Khâm Thiên", "http://www.dumpaday.com/wp-content/uploads/2016/05/Funny-3.jpg");
  UserManager nham3 = new UserManager("Nham", "33/33/3333", "Ngõ chợ Khâm Thiên", "http://www.dumpaday.com/wp-content/uploads/2016/05/Funny-3.jpg");
  userManagers.add(dat);
  userManagers.add(lam);
  userManagers.add(nham);
  userManagers.add(nham1);
  userManagers.add(nham2);
  userManagers.add(nham3);
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
