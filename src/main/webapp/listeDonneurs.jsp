<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head><title>Liste Donneurs</title></head>
<body>
<h2>Liste des Donneurs</h2>
<table border="1">
    <tr>
        <th>ID</th><th>Nom</th><th>Prénom</th><th>Groupe</th><th>Statut</th>
    </tr>
    <c:forEach var="d" items="${donneurs}">
        <tr>
            <td>${d.id}</td>
            <td>${d.nom}</td>
            <td>${d.prenom}</td>
            <td>${d.groupeSanguin}</td>
            <td>${d.statut}</td>
        </tr>
    </c:forEach>
</table>
<a href="donneurForm.jsp">Ajouter Donneur</a>
</body>
</html>
