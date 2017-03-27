<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="Js/bootstrap.min.css">
  <script src="Js/jquery.min.js"></script>
  <script src="Js/bootstrap.min.js"></script>
  
</head>
<body>

<nav class="navbar navbar-inverse" id="my-navbar">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse">
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
      </button>
    </div>
    <div class="collapse navbar-collapse" id="navbar-collapse">
    <ul class="nav navbar-nav">
      <li><a href="Mca.jsp">Previous</a></li>
      <li class="active"><a href="Students.jsp">Students Info</a></li>
    </ul>
    </div>
   </div>
</nav>

<table align="center" border=2 width=1100 height=1200>
 
     <%
   try{
       Class.forName("com.mysql.jdbc.Driver");
       Connection  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mahiproject","root","password");
       Statement st=con.createStatement();
       String RollNo= "14711F0001";
       PreparedStatement ps=con.prepareStatement("select count(*) from student where RollNo=?");
       ps.setString(1, RollNo);
       /* ResultSet rs=st.executeQuery("select RollNo,Name,Branch,Address,StudentYear,Contact,Semester from student"); */
       ResultSet rs=ps.executeQuery();
       while(rs.next()){
    	   int ct=rs.getInt(1);
    	   System.out.println("Hello : "+ct);
    %>
     
    <tr>
     <td> <%=RollNo %> <font color="red"> (<%=ct %>) </font> </td>
    </tr>
 
    <% }
  
 
       }
 catch(Exception se)
 {
   se.printStackTrace();
 } 
 %>
 
 </table>
 <br>
 
</body>
</html>
