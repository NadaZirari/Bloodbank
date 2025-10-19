package servlet;

import service.DonneurService;
import model.Donneur;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.time.LocalDate;

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

        double poids = Double.parseDouble(poidsStr);
        LocalDate dateNaissance = LocalDate.parse(date);

        Donneur d = new Donneur(nom, prenom, telephone, cin, dateNaissance, poids, sexe, groupe);
        donneurService.ajouterDonneur(d);

        response.sendRedirect("donneur");
    }
}

