<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Liste des Donneurs</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #fff5f5; /* beige clair */
            color: #333;
            margin: 20px;
        }

        h2 {
            color: #b71c1c; /* rouge foncé sang */
            text-align: center;
        }

        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
        }

        th, td {
            padding: 12px 15px;
            border: 1px solid #e0e0e0;
            text-align: center;
        }

        th {
            background-color: #b71c1c;
            color: #fff;
        }

        tr:nth-child(even) {
            background-color: #ffeaea;
        }

        tr:hover {
            background-color: #ffcccc;
        }

        a {
            display: block;
            width: 200px;
            margin: 20px auto;
            padding: 10px;
            text-align: center;
            background-color: #b71c1c;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            transition: background 0.3s ease;
        }

        a:hover {
            background-color: #e53935;
        }
    </style>
</head>
<body>
    <h2>Liste des Donneurs</h2>
    <table>
        <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Prénom</th>
            <th>Groupe</th>
            <th>Statut</th>
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
