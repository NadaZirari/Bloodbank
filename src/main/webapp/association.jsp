<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Association Donneur - Receveur</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css" rel="stylesheet">
    <style>
        body {
            background: linear-gradient(to right, #f9f9f9, #eef3f7);
            font-family: 'Segoe UI', sans-serif;
        }
        .page-header {
            background-color: #e63946;
            color: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
        }
        table {
            border-radius: 10px;
            overflow: hidden;
        }
        thead {
            background-color: #1d3557;
            color: white;
        }
        .btn-primary {
            background-color: #457b9d;
            border: none;
        }
        .btn-primary:hover {
            background-color: #1d3557;
        }
        .btn-secondary {
            background-color: #adb5bd;
            border: none;
        }
        .alert-warning {
            background-color: #fff3cd;
            color: #856404;
            font-weight: 500;
        }
        .card {
            border-radius: 12px;
            box-shadow: 0 4px 8px rgba(0,0,0,0.05);
        }
    </style>
</head>
<body>

<div class="container mt-5">
    <div class="page-header text-center mb-5">
        <h2><i class="bi bi-heart-pulse"></i> Donneurs Compatibles</h2>
        <p class="mb-0">Sélectionnez un donneur compatible pour le receveur choisi</p>
    </div>

    <div class="card p-4 bg-white">
        <c:if test="${empty donneurs}">
            <div class="alert alert-warning text-center">
                <i class="bi bi-exclamation-triangle-fill"></i> Aucun donneur compatible trouvé pour ce receveur.
            </div>
        </c:if>

        <c:if test="${not empty donneurs}">
            <table class="table table-striped align-middle text-center">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nom</th>
                        <th>Prénom</th>
                        <th>Groupe Sanguin</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="donneur" items="${donneurs}">
                        <tr>
                            <td>${donneur.id}</td>
                            <td>${donneur.nom}</td>
                            <td>${donneur.prenom}</td>
                            <td>
                                <span class="badge bg-danger fs-6">${donneur.groupeSanguin}</span>
                            </td>
                            <td>
                                <form action="association" method="post" class="d-inline">
                                    <input type="hidden" name="receveurId" value="${receveurId}">
                                    <input type="hidden" name="donneurId" value="${donneur.id}">
                                    <button type="submit" class="btn btn-primary btn-sm">
                                        <i class="bi bi-link-45deg"></i> Associer
                                    </button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>

        <div class="text-center mt-4">
            <a href="receveur?action=list" class="btn btn-secondary">
                <i class="bi bi-arrow-left"></i> Retour à la liste des receveurs
            </a>
        </div>
    </div>
</div>

</body>
</html>
