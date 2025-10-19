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
            width: 90%;
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

        .btn {
            padding: 5px 10px;
            margin: 2px;
            border: none;
            border-radius: 3px;
            cursor: pointer;
            color: white;
            text-decoration: none;
        }

        .btn-modifier { background-color: #f39c12; } /* orange */
        .btn-supprimer { background-color: #e74c3c; } /* rouge */
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
            <th>Receveur associé</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="d" items="${donneurs}">
            <tr>
                <td>${d.id}</td>
                <td>${d.nom}</td>
                <td>${d.prenom}</td>
                <td>${d.groupeSanguin}</td>
                <td>${d.statut}</td>
                <td>
                    <c:choose>
                        <c:when test="${not empty d.receveur}">
                            ${d.receveur.nom} ${d.receveur.prenom}
                        </c:when>
                        <c:otherwise>
                            Aucun
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <a href="donneur?action=edit&id=${d.id}" class="btn btn-modifier">Modifier</a>
                    <a href="donneur?action=supprimer&id=${d.id}" class="btn btn-supprimer" 
                       onclick="return confirm('Voulez-vous vraiment supprimer ce donneur ?')">Supprimer</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="donneur?action=form">Ajouter Donneur</a>
</body>
</html>
