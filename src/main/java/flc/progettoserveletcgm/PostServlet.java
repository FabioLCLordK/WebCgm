package flc.progettoserveletcgm;

import static com.sun.tools.javac.tree.TreeInfo.name;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PostServlet", urlPatterns = {"/post"})
public class PostServlet extends  HttpServlet{
    
    private List<PostDTO> posts;

    @Override
    public void init() throws ServletException {
        posts= new ArrayList<>();
        posts.add(new PostDTO("Sono andato al mare", "Mi sono scottato"));
        posts.add(new PostDTO("Sono andato in montagna", "Mi sono scottato"));
        posts.add(new PostDTO("Sono rimasto a casa", "Mo sto fresco"));
        }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        request.setAttribute("posts", posts);
        
        RequestDispatcher dispatcher= request.getRequestDispatcher("/postTemplate.jsp");
        dispatcher.forward(request, response);
    }
    
    
}
