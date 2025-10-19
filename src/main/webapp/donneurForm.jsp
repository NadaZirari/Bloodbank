<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="model.StatutDonneur" %>
<%@ page import="java.util.Arrays" %>
<!DOCTYPE html>
<html>
<head>
    <title>Ajouter Donneur</title>
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
    </style>
</head>
<body>
<h2>Ajouter Donneur</h2>
<form action="donneur" method="post">
    <label>Nom:</label>
    <input type="text" name="nom" required>

    <label>Prénom:</label>
    <input type="text" name="prenom" required>

    <label>Téléphone:</label>
    <input type="text" name="telephone" required>

    <label>CIN:</label>
    <input type="text" name="cin" required>

    <label>Date de naissance:</label>
    <input type="date" name="dateNaissance" required>

    <label>Poids:</label>
    <input type="number" step="0.1" name="poids" required>

    <label>Sexe:</label>
    <select name="sexe">
        <option>Homme</option>
        <option>Femme</option>
    </select>

    <label>Groupe sanguin:</label>
    <select name="groupeSanguin">
        <option>O-</option>
        <option>O+</option>
        <option>A-</option>
        <option>A+</option>
        <option>B-</option>
        <option>B+</option>
        <option>AB-</option>
        <option>AB+</option>
    </select>
<label>Contre-indications médicales :</label>
    <div class="checkbox-group">
        <input type="checkbox" name="maladies" value="hepatite"> Hépatite B/C<br>
        <input type="checkbox" name="maladies" value="viH"> VIH<br>
        <input type="checkbox" name="maladies" value="diabete"> Diabète insulino-dépendant<br>
        <input type="checkbox" name="maladies" value="grossesse"> Grossesse<br>
        <input type="checkbox" name="maladies" value="allaitement"> Allaitement
    </div>

    <button type="submit">Ajouter</button>
</form>
</body>
</html>
