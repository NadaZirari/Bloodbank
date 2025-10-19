package servlet;


import service.ReceveurService;
import model.Receveur;
import model.SituationReceveur;
import service.ReceveurService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.time.LocalDate;

public class ReceveurServlet extends HttpServlet {

    private final ReceveurService receveurService = new ReceveurService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("receveurs", receveurService.listerTous());
        request.getRequestDispatcher("listeReceveurs.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String telephone = request.getParameter("telephone");
        String cin = request.getParameter("cin");
        String date = request.getParameter("dateNaissance");
        String sexe = request.getParameter("sexe");
        String groupe = request.getParameter("groupeSanguin");
        String situationStr = request.getParameter("situation"); // récupéré du formulaire

        LocalDate dateNaissance = LocalDate.parse(date);
        SituationReceveur situation = SituationReceveur.valueOf(situationStr); // conversion en enum

        Receveur r = new Receveur(nom, prenom, telephone, cin, dateNaissance, sexe, groupe, situation);
        receveurService.ajouterReceveur(r);

        response.sendRedirect("receveur");
    }

}
