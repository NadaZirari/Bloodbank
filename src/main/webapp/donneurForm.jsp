<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="model.StatutDonneur" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>${donneur != null ? "Modifier Donneur" : "Ajouter Donneur"}</title>
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

        form {
            width: 400px;
            margin: 0 auto;
            padding: 20px;
            background-color: #ffeaea;
            border-radius: 8px;
            box-shadow: 0 2px 8px rgba(0,0,0,0.1);
        }

        label {
            display: block;
            margin-top: 10px;
            font-weight: bold;
        }

        input[type="text"],
        input[type="number"],
        input[type="date"],
        select {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        button {
            margin-top: 15px;
            width: 100%;
            padding: 10px;
            background-color: #b71c1c;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            transition: background 0.3s ease;
        }

        button:hover {
            background-color: #e53935;
        }

        .checkbox-group {
            margin-top: 5px;
        }
    </style>
</head>
<body>
<h2>${donneur != null ? "Modifier Donneur" : "Ajouter Donneur"}</h2>

<form action="donneur" method="post">

    <c:if test="${donneur != null}">
        <input type="hidden" name="id" value="${donneur.id}">
    </c:if>

    <label>Nom:</label>
    <input type="text" name="nom" value="${donneur.nom}" required>

    <label>Prénom:</label>
    <input type="text" name="prenom" value="${donneur.prenom}" required>

    <label>Téléphone:</label>
    <input type="text" name="telephone" value="${donneur.telephone}" required>

    <label>CIN:</label>
    <input type="text" name="cin" value="${donneur.cin}" required>

    <label>Date de naissance:</label>
    <input type="date" name="dateNaissance" value="${donneur.dateNaissance}" required>

    <label>Poids:</label>
    <input type="number" step="0.1" name="poids" value="${donneur.poids}" required>

    <label>Sexe:</label>
    <select name="sexe" required>
        <option value="Homme" ${donneur.sexe == 'Homme' ? 'selected' : ''}>Homme</option>
        <option value="Femme" ${donneur.sexe == 'Femme' ? 'selected' : ''}>Femme</option>
    </select>

    <label>Groupe sanguin:</label>
    <select name="groupeSanguin">
        <option value="O-" ${donneur.groupeSanguin == 'O-' ? 'selected' : ''}>O-</option>
        <option value="O+" ${donneur.groupeSanguin == 'O+' ? 'selected' : ''}>O+</option>
        <option value="A-" ${donneur.groupeSanguin == 'A-' ? 'selected' : ''}>A-</option>
        <option value="A+" ${donneur.groupeSanguin == 'A+' ? 'selected' : ''}>A+</option>
        <option value="B-" ${donneur.groupeSanguin == 'B-' ? 'selected' : ''}>B-</option>
        <option value="B+" ${donneur.groupeSanguin == 'B+' ? 'selected' : ''}>B+</option>
        <option value="AB-" ${donneur.groupeSanguin == 'AB-' ? 'selected' : ''}>AB-</option>
        <option value="AB+" ${donneur.groupeSanguin == 'AB+' ? 'selected' : ''}>AB+</option>
    </select>

    <label>Contre-indications médicales :</label>
    <div class="checkbox-group">
        <input type="checkbox" name="maladies" value="hepatite"> Hépatite B/C<br>
        <input type="checkbox" name="maladies" value="viH"> VIH<br>
        <input type="checkbox" name="maladies" value="diabete"> Diabète insulino-dépendant<br>
        <input type="checkbox" name="maladies" value="grossesse"> Grossesse<br>
        <input type="checkbox" name="maladies" value="allaitement"> Allaitement
    </div>

    <button type="submit">
        ${donneur != null ? "Enregistrer les modifications" : "Ajouter"}
    </button>
</form>

</body>
</html>
