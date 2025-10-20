package servlet;

import service.DonneurService;
import model.Donneur;
import model.StatutDonneur;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class DonneurServlet extends HttpServlet {

    private final DonneurService donneurService = new DonneurService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String idParam = request.getParameter("id");

        if ("form".equals(action)) { // <-- ajouter cette condition
            // On prépare l'affichage du formulaire
            request.getRequestDispatcher("donneurForm.jsp").forward(request, response);
            return;
        }

        if ("supprimer".equals(action) && idParam != null) {
            long id = Long.parseLong(idParam);
            donneurService.supprimer(id);
            response.sendRedirect("donneur");
            return;
        }

        if ("edit".equals(action) && idParam != null) {
            long id = Long.parseLong(idParam);
            Donneur donneur = donneurService.chercher(id);

            request.setAttribute("donneur", donneur);
            request.getRequestDispatcher("donneurForm.jsp").forward(request, response);
            return;
        }
        // Sinon, afficher la liste des donneurs
        List<Donneur> donneurs = donneurService.listerTous();
        for (Donneur d : donneurs) {
            d.setReceveur(donneurService.getReceveurPourDonneur(d.getId()));
        }
        request.setAttribute("donneurs", donneurs);

        request.getRequestDispatcher("listeDonneurs.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String telephone = request.getParameter("telephone");
        String cin = request.getParameter("cin");
        String date = request.getParameter("dateNaissance");
        String poidsStr = request.getParameter("poids");
        String sexe = request.getParameter("sexe");
        String groupe = request.getParameter("groupeSanguin");

        String idParam = request.getParameter("id");

        // Récupération des maladies cochées
        String[] maladies = request.getParameterValues("maladies");
        boolean aContreIndication = (maladies != null && maladies.length > 0);

        double poids = Double.parseDouble(poidsStr);
        LocalDate dateNaissance = LocalDate.parse(date);

        // Calcul de l'âge
        int age = Period.between(dateNaissance, LocalDate.now()).getYears();

        // Calcul automatique du statut
        StatutDonneur statut = StatutDonneur.DISPONIBLE;
        if (age < 18 || age > 65 || poids < 50 || aContreIndication) {
            statut = StatutDonneur.NON_ELIGIBLE;
        }

        // Création du donneur avec statut et contre-indication
     
        Donneur d = new Donneur(
                nom,
                prenom,
                telephone,
                cin,
                dateNaissance,
                poids,
                sexe,
                groupe,
                statut,           // utiliser le statut calculé
                aContreIndication // utiliser le vrai état de contre-indication
        );

        if (idParam != null && !idParam.isEmpty()) {
            // --- C’est une modification ---
            long id = Long.parseLong(idParam);
            d.setId(id);
            donneurService.mettreAJour(d);
        } else {
        donneurService.ajouterDonneur(d);
        }
        response.sendRedirect("donneur");
    }

}

