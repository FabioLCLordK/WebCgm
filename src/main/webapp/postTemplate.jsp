<%-- 
    Document   : post
    Created on : 21 mar 2023, 15:03:09
    Author     : LordKazor
--%>

<%@page import="java.util.List"%>
<%@page import="flc.progettoserveletcgm.PostDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
       
        <h1>Pagina dei post</h1>
        <% List<PostDTO> posts = (List<PostDTO>) request.getAttribute("posts"); %>
        <% if(posts.isEmpty()){ %>
        <p> Non sono stati pubblicati posts</p> 
        <% } else { %>
            <ul>
                <% for(PostDTO post: posts){ %>
                <li>
                    <h2> <%= post.getTitle() %></h2>
                    <p> <%= post.getDescription() %></p>

                </li>
                <% } %>
            </ul>
        <% } %>
        <%%> <!-- scriptlet --> 
    </body>
</html>
