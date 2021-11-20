<%@ page import="databaseConnection.ConexaoMySQL" %>
<%

    System.out.println(ConexaoMySQL.statusConection());

%>

<%

    ConexaoMySQL.getConexaoMySQL();

    System.out.println(ConexaoMySQL.statusConection());

%>