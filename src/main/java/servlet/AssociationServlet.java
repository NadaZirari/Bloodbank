package servlet;


import service.AssociationService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.IOException;

public class AssociationServlet extends HttpServlet {

    private final AssociationService associationService = new AssociationService();

    @Override
    protected void doGet(HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("donneurs", associationService.donneursCompatibles(null)); // Tu peux passer un ID réel
        request.setAttribute("receveurs", associationService.receveursCompatibles(null));
        request.getRequestDispatcher("association.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws ServletException, IOException {
        Long idDonneur = Long.parseLong(request.getParameter("donneurId"));
        Long idReceveur = Long.parseLong(request.getParameter("receveurId"));

        associationService.associer(idDonneur, idReceveur);
        response.sendRedirect("association");
    }
}

