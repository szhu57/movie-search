/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;


import client.NewJerseyClient;
import entity.Moviedb;
import flickr.Flickr;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;


//import net.sf.json.JSONObject;

/**
 *
 * @author hp\
 * 
 * 
 * 
 * this is movie servlet its function is controller
 * 
 * for one thing it receive request form the broser, for another invoke the JesrseyClient to 
 * response the request.
 */
@WebServlet(name = "MovieServlet", urlPatterns = {"/MovieServlet"})
public class MovieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws  IOException {
     // fix the Chinese charactor
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        
        String method = request.getParameter("method");
        
        System.out.print("Servlet -------->"+method);
        
        if(method!=null){
            
            if(method.equals("local")){
                
                    searchByLocal(request,response);
                
            }else if(method.equals("flickr")){
                
                searchByFlickr(request,response);
            }
            
        }
          
        
    }
    public void searchByFlickr(HttpServletRequest request,HttpServletResponse response){
        String movieTitle = request.getParameter("moviename");
        
        Flickr flickr = Flickr.getInstance();
        ImageIcon icon = (ImageIcon) flickr.search(movieTitle);
        
        
        
        System.out.println("i am "+  icon);
        
        
    }

    public void searchByLocal(HttpServletRequest request, HttpServletResponse response) throws JSONException {
        
        String movieTitle = request.getParameter("moviename");
        
        System.out.println("input info----------------------->"+movieTitle);
        String page ="";
        JSONObject jo = null;
     
     try{
          jo= initJSON(movieTitle); // to get the movie object using the initial method;
          
          System.out.println("job is exception---- job --------------test");
     }catch(Exception e){
       System.out.println("Movie is not found");
     }
     
     if(jo==null){
         String message = "Not found";
         request.setAttribute("moviename", movieTitle);
         request.setAttribute("message", message);
         
         page ="/error.jsp";
         
     }else{
         
         
         System.out.println("/////////////test the job1");
         // to update the movie 
         Moviedb movie = new Moviedb();
         //movie.setMovieid(jo.getInt("movieid"));
         movie.setTitle(jo.getString("title"));
         movie.setCoverurl(jo.getString("coverurl"));
         movie.setDescription(jo.getString("description"));
         movie.setDirector(jo.getString("director"));
         movie.setRating(jo.getDouble("rating"));
         movie.setType(jo.getString("type"));
         movie.setStarts(jo.getString("starts"));
       
         request.setAttribute("movie", movie);
       page = "/local_result.jsp";
         
     }
     //response to the client
     try
     {
      request.getRequestDispatcher(page).forward(request, response);
     } catch(ServletException e){
         System.out.println("_______exception");
         
     }catch(IOException e1){
     }
        
        
 
        
        
    }
public  JSONObject initJSON(String movieTitle) throws Exception {
    
    NewJerseyClient movieClient = new NewJerseyClient();
    //System.out.println("/////////////test the new client");
    JSONObject jo;
       jo = JSONObject.fromObject(movieClient.find(String.class, movieTitle));
     System.out.println("/////////////aftertest the new client   "+jo);
    return jo;
}
 



 
    @Override
    public String getServletInfo() {
        
        
        
        return "Short description";
    }// </editor-fold>

}
