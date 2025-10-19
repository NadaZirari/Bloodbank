<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="model.SituationReceveur" %>
<%@ page import="java.util.Arrays" %>
<!DOCTYPE html>
<html>
<head>
    <title>Ajouter Receveur</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #fdf6e3;
        }
        .container {
            max-width: 600px;
            margin-top: 50px;
            padding: 30px;
            background-color: #ffffff;
            border-radius: 12px;
            box-shadow: 0 4px 15px rgba(0,0,0,0.1);
        }
        h2 {
            color: #2c3e50;
            margin-bottom: 25px;
        }
        .form-label {
            font-weight: 500;
        }
        .btn-submit {
            width: 100%;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Ajouter un Receveur</h2>
    <form action="receveur" method="post">
        <div class="mb-3">
            <label class="form-label">Nom</label>
            <input type="text" name="nom" class="form-control" required>
        </div>
        <div class="mb-3">
            <label class="form-label">Prénom</label>
            <input type="text" name="prenom" class="form-control" required>
        </div>
        <div class="mb-3">
            <label class="form-label">Téléphone</label>
            <input type="text" name="telephone" class="form-control" required>
        </div>
        <div class="mb-3">
            <label class="form-label">CIN</label>
            <input type="text" name="cin" class="form-control" required>
        </div>
        <div class="mb-3">
            <label class="form-label">Date de naissance</label>
            <input type="date" name="dateNaissance" class="form-control" required>
        </div>
        <div class="mb-3">
            <label class="form-label">Sexe</label>
            <select name="sexe" class="form-select">
                <option>Homme</option>
                <option>Femme</option>
            </select>
        </div>
        <div class="mb-3">
            <label class="form-label">Groupe sanguin</label>
            <select name="groupeSanguin" class="form-select">
                <option>O-</option>
                <option>O+</option>
                <option>A-</option>
                <option>A+</option>
                <option>B-</option>
                <option>B+</option>
                <option>AB-</option>
                <option>AB+</option>
            </select>
        </div>
        <div class="mb-4">
            <label class="form-label">Situation médicale</label>
            <select name="situation" class="form-select">
                <c:forEach var="s" items="${T(model.SituationReceveur).values()}">
                    <option value="${s}">${s}</option>
                </c:forEach>
            </select>
        </div>
        <button type="submit" class="btn btn-primary btn-submit">Ajouter le Receveur</button>
    </form>
</div>
</body>
</html>
