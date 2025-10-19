<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="model.SituationReceveur" %>
<%@ page import="java.util.Arrays" %>
<!DOCTYPE html>
<html>
<head>
    <title>Ajouter Receveur</title>
</head>
<body>
<h2>Ajouter Receveur</h2>
<form action="receveur" method="post">
    Nom: <input type="text" name="nom" required><br>
    Prénom: <input type="text" name="prenom" required><br>
    Téléphone: <input type="text" name="telephone" required><br>
    CIN: <input type="text" name="cin" required><br>
    Date de naissance: <input type="date" name="dateNaissance" required><br>
    Sexe: 
    <select name="sexe">
        <option>Homme</option>
        <option>Femme</option>
    </select><br>
    Groupe sanguin: 
    <select name="groupeSanguin">
        <option>O-</option>
        <option>O+</option>
        <option>A-</option>
        <option>A+</option>
        <option>B-</option>
        <option>B+</option>
        <option>AB-</option>
        <option>AB+</option>
    </select><br>
    Situation médicale:
    <select name="situation">
        <c:forEach var="s" items="${T(model.SituationReceveur).values()}">
            <option value="${s}">${s}</option>
        </c:forEach>
    </select><br>
    <button type="submit">Ajouter</button>
</form>
</body>
</html>
