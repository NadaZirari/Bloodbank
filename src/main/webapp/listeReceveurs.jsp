<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Liste des Receveurs</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Lien Bootstrap Icons -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
    
    <style>
        body {
            background-color: #f89c9e; !important;
        }
        h2 {
            color: #2c3e50;
        }
        .table-hover tbody tr:hover {
            background-color: #f1f1f1;
        }
        .badge-crt { background-color: #e74c3c; }   /* CRITIQUE - rouge */
        .badge-urg { background-color: #f39c12; }   /* URGENT - orange */
        .badge-nrm { background-color: #27ae60; }   /* NORMAL - vert */
        .badge-etat { font-size: 0.9em; padding: 0.4em; }
        .btn-sm { margin-right: 5px; }
    </style>
</head>
<body>
<div class="container mt-5">
     <div class="d-flex justify-content-between align-items-center mb-4">
        <h2>Liste des Receveurs</h2>
<a href="receveur?action=form" class="btn btn-success">Ajouter un Receveur</a>

    </div>
    <table class="table table-striped table-hover align-middle">
        <thead class="table-dark">
        <tr>
            <th>Nom</th>
            <th>Prénom</th>
            <th>Téléphone</th>
                        <th>Date de Naissance</th>
            <th>Sexe</th>
            <th>Groupe Sanguin</th>
            <th>Situation</th>
            <th>État</th>
            <th>Actions</th>
                        <th>Associateur</th>
            
            
        </tr>
        </thead>
        <tbody>
        <c:forEach var="r" items="${receveurs}">
            <tr>
                <td>${r.nom}</td>
                <td>${r.prenom}</td>
                <td>${r.telephone}</td>
                <td>${r.dateNaissance}</td>
                <td>${r.sexe}</td>
                <td>${r.groupeSanguin}</td>
                <td>
                    <c:choose>
                        <c:when test="${r.situation == 'CRITIQUE'}">
                            <span class="badge badge-crt">${r.situation}</span>
                        </c:when>
                        <c:when test="${r.situation == 'URGENT'}">
                            <span class="badge badge-urg">${r.situation}</span>
                        </c:when>
                        <c:otherwise>
                            <span class="badge badge-nrm">${r.situation}</span>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>
    <span class="badge badge-etat" style="background-color:#e74c3c; color:white;">${r.etat}</span>
</td>
                
                <td>
    <a href="receveur?action=edit&id=${r.id}" class="btn btn-sm btn-outline-warning">
        <i class="bi bi-pencil"></i>
    </a>

    <a href="receveur?action=supprimer&id=${r.id}" class="btn btn-sm btn-outline-danger">
    <i class="bi bi-trash"></i>
</a>
    

                    
                </td>
                 <td>
<a href="association?receveurId=${r.id}" class="btn btn-sm btn-success">Associer</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
