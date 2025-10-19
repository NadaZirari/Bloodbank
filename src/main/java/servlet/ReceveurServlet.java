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
        String action = request.getParameter("action");
        String idParam = request.getParameter("id");

        if ("form".equals(action)) {
            request.setAttribute("situations", SituationReceveur.values());
            request.getRequestDispatcher("receveurForm.jsp").forward(request, response);
        }   else if
        ("edit".equals(action) && idParam != null) {
            Long id = Long.parseLong(idParam);
            Receveur r = receveurService.chercher(id); 
            request.setAttribute("receveur", r);
            request.setAttribute("situations", SituationReceveur.values());
            request.getRequestDispatcher("receveurForm.jsp").forward(request, response);
            }
        else if ("supprimer".equals(action) && idParam != null) {
            Long id = Long.parseLong(idParam);
            receveurService.supprimer(id);  
            response.sendRedirect("receveur"); 
        }
        else { 
            request.setAttribute("receveurs", receveurService.listerTous());
            request.getRequestDispatcher("listeReceveurs.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 String idParam = request.getParameter("id");
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String telephone = request.getParameter("telephone");
        String cin = request.getParameter("cin");
        String date = request.getParameter("dateNaissance");
        String sexe = request.getParameter("sexe");
        String groupe = request.getParameter("groupeSanguin");

        LocalDate dateNaissance = LocalDate.parse(date);
        String situationStr = request.getParameter("situation");
        SituationReceveur situation = SituationReceveur.valueOf(request.getParameter("situation"));

        if (idParam != null && !idParam.isEmpty()) { // modification
            Long id = Long.parseLong(idParam);
            Receveur r = new Receveur(id, nom, prenom, telephone, cin, dateNaissance, sexe, groupe, situation);
            receveurService.mettreAJour(r); // méthode à créer dans ton service
        } else { // ajout
            Receveur r = new Receveur(nom, prenom, telephone, cin, dateNaissance, sexe, groupe, situation);
            receveurService.ajouterReceveur(r);
        }

        response.sendRedirect("receveur");

}
}