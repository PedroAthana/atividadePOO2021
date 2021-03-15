
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "JurosSimplesServlet1", urlPatterns = {"/juros-simples.html"})
public class JurosSimplesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html; charset=UTF-8");
        try (PrintWriter out = response.getWriter()){
        	
        	try {
        		double vp = Double.parseDouble(request.getParameter("VP"));
	        	String VP = String.format("%.2f", vp);

        		Float juros = Float.parseFloat(request.getParameter("Juros"));
	        	String Juros = String.format("%.0f", juros);

        		double meses = Double.parseDouble(request.getParameter("Meses"));
	        	String Meses = String.format("%.2f", meses);

        		double Vf = (vp * (1 + (juros / 100) * meses));
	        	String VF = String.format("%.2f", Vf);
	        	
	        	out.println("		<h5>" +VP+ " (1 + " +Juros+ "% * " +Meses+ ") = " +VF+ "</h5>");
			} catch (Exception e) {
				if((e.getLocalizedMessage() ==("empty String")) || (e.getLocalizedMessage() ==("For input string: \"\""))) {
					out.println("<script>\n"
							+ "	alert(\"Preencha todos os campos e tente novamente.\");\n"
							+ " location= './index.html';\n"
							+ "</script>");
				}
			}
           	out.println("	</div>\n"
        			+ "</body>\n"
        			+ "</html>");
        	
        }
    }

   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
       processRequest(request, response);
   }

   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
       processRequest(request, response);
   }

   @Override
   public String getServletInfo() {
       return "Short description";
   }

}