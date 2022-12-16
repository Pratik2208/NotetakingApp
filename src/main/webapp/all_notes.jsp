<%@ page import="org.hibernate.Session" %>
<%@ page import="com.helper.factoryProvider" %>
<%@ page import="javax.persistence.Query" %>
<%@ page import="java.util.List" %>
<%@ page import="com.entities.Note" %>
<%@ page import="java.io.PrintWriter" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Notes : Note Taker</title>
    <%@include file="all_js_css.jsp"%>

</head>
<body>
   <div class="container">
       <%@include file="navbar.jsp"%>
       <br>
       <h1>ALL NOTES :</h1>

       <div class="row">
           <div class="col-12">
               <%
                   Session session1 = factoryProvider.getFactory().openSession();
                   org.hibernate.query.Query query = session1.createQuery("from Note ");

                   List<Note> list =query.list();

                   for(Note note:list){
               %>
               <div class="card mt-3">
                   <img class="card-img-top pl-4 pt-4" style="max-width: 100px;" src="img/note.png" alt="Card image cap">
                   <div class="card-body">
                       <h5 class="card-title"><%= note.getTitle()%></h5>
                       <p class="card-text"> <%= note.getContent()%></p>

                       <div class="container text-center ">
                           <a href="DeleteServlet?note_id=<%=note.getId()%>" class="btn btn-danger">Delete</a>
                       </div>
                   </div>
               </div>
               <%
                   }
                   session1.close();
               %>
           </div>
       </div>
   </div>
</body>
</html>
