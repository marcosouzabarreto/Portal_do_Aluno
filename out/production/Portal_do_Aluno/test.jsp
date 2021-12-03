<%@ page import="databaseConnection.ConexaoMySQL" %>

<%

    ConexaoMySQL.getConexaoMySQL();

    System.out.println(ConexaoMySQL.statusConection());

%>