
package model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 */
public class TechnicianServlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            
            
        String url = "/index.html";
        
        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "join";  // default action
        }

        if (action.equals("join")) {
            url = "/index.html";    
        } 
        else if (action.equals("add")) {
            // get parameters from the request
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String password = request.getParameter("password");

            // store data in Technician object
            Technician technician = new Technician(firstName, lastName, email, phone, password);

          
            TechnicianDB.insert(technician);
            
            request.setAttribute("technician", technician);
            
        }  
        
        else if (action.equals("delete")) {
                try {
                    deleteTechnician(request, response);
                } catch (SQLException ex) {
                    Logger.getLogger(TechnicianServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            
        }
        
        ArrayList Technicians = TechnicianDB.getTechnician();
        request.setAttribute("Technicians", Technicians);

            getServletContext()
                .getRequestDispatcher("/JSP/technician_list.jsp")
                .forward(request, response); 
    }
    
   
    
    public void deleteTechnician(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		
                String productCode = request.getParameter("firstName");
		
                ProductDB.deleteProduct(productCode);
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

    
