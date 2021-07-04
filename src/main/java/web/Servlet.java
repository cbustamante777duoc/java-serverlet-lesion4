
package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletHeaders")
public class Servlet extends HttpServlet{
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
    
        String metodoHttp = request.getMethod();
        out.print("<html>");
        out.print("<head>");
        out.print("<title> headers HTTP </title>");
        out.print("</head>");             
        out.print("<body>");
        out.print("<h1> headers con http </h1>");
        out.print("metodo http:"+metodoHttp);
        
        String uri = request.getRequestURI();
        
        out.print("<br>");
        
        out.print("uri solicitda: "+uri);
        
        //impresion de todos los cabeceros disponibles
        Enumeration cabeceros = request.getHeaderNames();
        
        out.print("<br>");
        out.print("<br>");
        while (cabeceros.hasMoreElements()) {            
            String nombreCabeceros = (String) cabeceros.nextElement();
            out.print("<b>"+nombreCabeceros+"</b>: ");
            out.print(request.getHeader(nombreCabeceros));
            out.print("<br>");
        }
        
        out.print("</body>");
        out.print("</html>");
        out.close();
    }
}
