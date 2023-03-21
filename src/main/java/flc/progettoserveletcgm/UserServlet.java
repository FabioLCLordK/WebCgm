package flc.progettoserveletcgm;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//non ci sarà un main, poiché le classi che estendono servlet non ne hanno bisogno

@WebServlet(name = "UserServlet", urlPatterns = {"/user"})
public class UserServlet extends HttpServlet{
    
    List<UserDTO> lista;

    @Override
    public void init() throws ServletException {
        lista = new ArrayList<UserDTO>();
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        
        //String getContextPath()
        //resp.getOutputStream()
        
        //tramite get parameter posso richiedere i valori associati a determinate chiavi
//        System.out.println(req.getParameter("firstname"));
//        System.out.println(req.getParameter("age"));

        /* lista html
        <ul>
        <li>Coffee</li>
        <li>Tea</li>
        <li>Milk</li>
        </ul>
       
        */
        
         /*
        <!DOCTYPE html>
        <html>
            <head>
                <meta charset = "UTF-8">
                <meta name = "viewport" content = "Width=device-width, initial-scale=1.0">
                <title>Home</title>
            </head>''')
           
            <body>
                <h1> Ecco la lista utenti </hi>
                <ul>
                    for (UserDTO user: this.lista) {
                        writer.println("<li>"+ user.getFirstname() + user.getLastname() + "</li>");
                    }
                </ul>
            </body>
        </html>
        
        */  
         
        String headstart=("<!DOCTYPE html> <html> <head>"+
                "<meta charset = \"UTF-8\">"+
                "<meta name = \"viewport\" content = \"Width=device-width, initial-scale=1.0\">"+
                "<title>Home</title>"+
            "</head>");
        String bodystart=(" <body><h1> Ecco la lista utenti </hi> <ul>");
        String bodyclose=(" </ul>\n" +
            "</body>");  
        String headclose=("</html>");
        
        //faccio una prova a introdurre un altro fil hmtl che non userò
        String crazyhtml=("<!DOCTYPE html> <HTML>\n" +
                            "<HEAD>\n" +
                            "   <TITLE>Esempio 3</TITLE>\n" +
                            "</HEAD>\n" +
                            "<BODY BACKGROUND=\"titto_green_paper.jpg\">\n" +
                            "\n" +
                            "<CENTER><H1>Esempio 3: uso di tabelle e di un contatore</H1></CENTER>\n" +
                            "\n" +
                            "<UL> <!-- a questa UL (unordered list) non corrispondera' nessun \n" +
                            "          LI (list item), il suo scopo e' solo quello di indentare\n" +
                            "          il testo della pagina -->\n" +
                            "\n" +
                            "<P>    <!-- P sta per paragraph, impone di saltare una linea -->\n" +
                            "<FONT SIZE=+2>esempio di tabella:</FONT>\n" +
                            "<P>\n" +
                            "<CENTER><TABLE BORDER COLS=2 WIDTH=\"90%\">\n" +
                            "        <TR>\n" +
                            "            <TD>Riga 1 - Colonna 1</TD>\n" +
                            "            <TD>Una tabella pu&ograve; contenere qualsiasi cosa. \n" +
                            "                Questa che segue è\n" +
                            "                una lista.\n" +
                            "                <P>\n" +
                            "                <UL>\n" +
                            "                    <LI>elemento 1</LI>\n" +
                            "                    <LI>elemento 2</LI>\n" +
                            "               </UL>\n" +
                            "           </TD>\n" +
                            "       </TR>\n" +
                            "\n" +
                            "       <TR>\n" +
                            "           <TD>La tabella può contenere altre tabelle:<P>\n" +
                            "               <TABLE BORDER COLS=2 WIDTH=\"100%\">\n" +
                            "                 <TR>\n" +
                            "                     <TD>seconda tabella elem. (1,1)</TD>\n" +
                            "                     <TD>seconda tabella elem. (1,2)</TD>\n" +
                            "                 </TR>\n" +
                            "               </TABLE><P>\n" +
                            "           </TD>\n" +
                            "           <TD>La tabella pu&ograve; contenere immagini \n" +
                            "               <IMG SRC=\"dragon.gif\" HEIGHT=50 WIDTH=66>\n" +
                            "               questa è un'immagine GIF animato, il cui\n" +
                            "               colore di sfondo è il trasparente.\n" +
                            "           </TD>\n" +
                            "      </TR>\n" +
                            "      </TABLE>\n" +
                            "</CENTER>\n" +
                            "\n" +
                            "<P>\n" +
                            "<FONT SIZE=+2>i bordi della tabella possono essere invisibili:</FONT>\n" +
                            "<P>\n" +
                            "<CENTER><TABLE COLS=2 WIDTH=\"50%\">\n" +
                            "        <TR>\n" +
                            "            <TD>Riga 1 - Colonna 1: questo &egrave; un esempio di tabella i\n" +
                            "                cui bordi sono invisibili\n" +
                            "            </TD>\n" +
                            "            <TD>Riga 1 - Colonna 2: il testo viene posizionato all'interno \n" +
                            "                di ogni casella, rispettando i mutui rapporti tra le \n" +
                            "                caselle\n" +
                            "            </TD>\n" +
                            "        </TR>\n" +
                            "        <TR>\n" +
                            "            <TD>Riga 2 - Colonna 1: questo sistema pu&ograve; essere usato per\n" +
                            "                ottenere effetti di formattazione (allineamenti, \n" +
                            "                incolonnamenti) altrimenti impossibili per un linguaggio \n" +
                            "                che fa uso di marcatori logici e non fisici.\n" +
                            "            </TD>\n" +
                            "            <TD><CENTER>questo</CENTER>\n" +
                            "                <CENTER>testo</CENTER>\n" +
                            "                <CENTER>è</CENTER>\n" +
                            "                <CENTER>centrato</CENTER>\n" +
                            "            </TD>\n" +
                            "       </TR>\n" +
                            "       </TABLE>\n" +
                            "</CENTER>\n" +
                            "\n" +
                            "<HR WIDTH=\"100%\">  <!-- HR = hard line -->\n" +
                            "<BR><FONT SIZE=+2>questa pagina è stata acceduta \n" +
                            "    <IMG SRC=\"http://www.inf.uniroma3.it/cgi-bin/nph-count?width=5&link=esempio_2.html\" \n" +
                            "         HEIGHT=20 \n" +
                            "         WIDTH=75>\n" +
                            "volte.</FONT>\n" +
                            "\n" +
                            "</UL> <!-- fine dell'indentatura -->\n" +
                            "\n" +
                            "</BODY>\n" +
                            "</HTML>");
        
        
        PrintWriter writer= resp.getWriter(); 
                
        //MODO PARTICOLARE mio    
        writer.println(headstart);
        writer.println(bodystart);
            for (UserDTO user: this.lista) {
                            writer.println("<li>"+ user.getFirstname() + user.getLastname() + "</li>");
                        }
        writer.println(bodyclose);
        writer.println(headclose);
        
        
        writer.println(crazyhtml);
        
        
       
        //modo vecchio
        /*
        writer.println("<!DOCTYPE html>");
        writer.println("<html>");
            writer.println("<head>");
                writer.println("<meta charset = \"UTF-8\">");
                writer.println("<meta name = \"viewport\" content = \"Width=device-width, initial-scale=1.0\">");
                writer.println("<title>Home</title>");
            writer.println("</head>");
           
            writer.println("<body>");
                writer.println("<h1> Ecco la lista utenti </hi>");
                writer.println("<ul>");
                    for (UserDTO user: this.lista) {
                        writer.printf("<li>%s %s</li>\n", user.getFirstname(), user.getLastname());
                    }
                writer.println("</ul>");
            writer.println("</body>");
        writer.println("</html>");
        */

        resp.setContentType("text/html");
        resp.setStatus(HttpServletResponse.SC_OK);
        
       // writer.flush();
    }
    
    @Override 
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    // 'coolant:, l'HttpServletRequest String firstname = request.getParameter("firstnal; String age = request.getParameter("d,P' ); 
    
    //leggiamo l'httpServletRequest
    //String age = req.getParameter("age");
    
    //registro l'utente
    String firstname= req.getParameter("firstname");
    String lastname= req.getParameter("lastname");
    String email= req.getParameter("email");
    String password= req.getParameter("password");
    
    this.lista.add(new UserDTO(firstname, lastname, email, password));
    
    doGet(req, res);
    } 
    
    @Override 
    public void destroy(){ 
    }
}
