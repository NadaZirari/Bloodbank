<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head><title>Ajouter Donneur</title></head>
<body>
<h2>Ajouter Donneur</h2>
<form action="donneur" method="post">
    Nom: <input type="text" name="nom" required><br>
    Prénom: <input type="text" name="prenom" required><br>
    Téléphone: <input type="text" name="telephone" required><br>
    CIN: <input type="text" name="cin" required><br>
    Date de naissance: <input type="date" name="dateNaissance" required><br>
    Poids: <input type="number" step="0.1" name="poids" required><br>
    Sexe: <select name="sexe"><option>Homme</option><option>Femme</option></select><br>
    Groupe sanguin: <input type="text" name="groupeSanguin" required><br>
    <button type="submit">Ajouter</button>
</form>
</body>
</html>
