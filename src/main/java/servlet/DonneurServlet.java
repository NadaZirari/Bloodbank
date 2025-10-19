package servlet;

import service.DonneurService;
import model.Donneur;
import model.StatutDonneur;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;

public class DonneurServlet extends HttpServlet {

    private final DonneurService donneurService = new DonneurService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("donneurs", donneurService.listerTous());
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
        Donneur d = new Donneur(nom, prenom, telephone, cin, dateNaissance,
                poids, sexe, groupe,
                StatutDonneur.DISPONIBLE, false);
        donneurService.ajouterDonneur(d);

        response.sendRedirect("donneur");
    }

}

