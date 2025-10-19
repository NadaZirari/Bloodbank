package servlet;


import service.AssociationService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.IOException;

public class AssociationServlet extends HttpServlet {

    private final AssociationService associationService = new AssociationService();

    @Override
    protected void doGet(HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws ServletException, IOException {
    	String receveurIdParam = request.getParameter("receveurId");
        if (receveurIdParam != null) {
            Long receveurId = Long.parseLong(receveurIdParam);
            request.setAttribute("donneurs", associationService.donneursCompatibles(receveurId));
            request.setAttribute("receveurId", receveurId);
        }

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

