
package model;

import java.io.IOException;
import java.io.PrintWriter;
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
public class ProductServlet extends HttpServlet {
    
    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        
                
        String action = request.getParameter("action");
        
        if (action == null) {               
            action = "ProductServlet";  // default action        
        }
       
        if (action.equals("add")) {
            insertProduct(request, response);
        } 
        else if (action.equals("delete")) {
            deleteProduct(request, response);
        }
         ArrayList Products = ProductDB.getProducts();
            request.setAttribute("Products", Products);
            
            getServletContext()
                .getRequestDispatcher("/JSP/productList.jsp")
                .forward(request, response); 
    }


    public void insertProduct(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		// get parameters from the request
                String productCode = request.getParameter("productCode");
		String name = request.getParameter("name");
		String version = request.getParameter("version");
                String releaseDate = request.getParameter("releaseDate");
		
                // store data in Product object
                Product product = new Product(productCode, name, version, releaseDate);
		ProductDB.insert(product);
		
                request.setAttribute("product", product);
                
                getServletContext()
                .getRequestDispatcher("/JSP/productList.jsp")
                .forward(request, response); 
	}
           
           
           public void deleteProduct(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		
                String productCode = request.getParameter("productCode");
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
