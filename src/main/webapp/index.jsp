<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Blood Bank Management</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h1 class="text-center mb-4">Bienvenue sur le Système de Gestion de Banque de Sang</h1>

        <div class="row justify-content-center">
            <div class="col-md-4 mb-3">
                <a href="donneur" class="btn btn-primary btn-lg w-100">Gérer les Donneurs</a>
            </div>
            <div class="col-md-4 mb-3">
<a href="receveur?action=list" class="btn btn-success btn-lg w-100">Gérer les Receveurs</a>
            </div>
            <div class="col-md-4 mb-3">
                <a href="association" class="btn btn-warning btn-lg w-100">Associer Donneurs & Receveurs</a>
            </div>
        </div>
    </div>
</body>
</html>
