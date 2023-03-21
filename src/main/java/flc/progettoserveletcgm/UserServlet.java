package flc.progettoserveletcgm;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//non ci sarà un main, poiché le classi che estendono servlet non ne hanno bisogno

@WebServlet(name = "UserServlet", urlPatterns = {"/user"})
public class UserServlet extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        
        //String getContextPath()
        //resp.getOutputStream()
        
        //tramite get parameter posso richiedere i valori associati a determinate chiavi
        System.out.println(req.getParameter("firstname"));
        System.out.println(req.getParameter("age"));
        
        
        PrintWriter writer = resp.getWriter();
        writer.print("Pagina dell'utente e altre blablabla");
        
        resp.setContentType("text/plain");
        resp.setStatus(HttpServletResponse.SC_OK);
        
        writer.flush();
    }
}
