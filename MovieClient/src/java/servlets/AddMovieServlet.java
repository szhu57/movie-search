/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import client.NewJerseyClient;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;

/**
 *
 * @author hp
 */
public class AddMovieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        // request.setCharacterEncoding("utf-8");
        String title = request.getParameter("title");
        String type = request.getParameter("type");
        String director = request.getParameter("director");
        String description = request.getParameter("description");
        String url = request.getParameter("coverurl");
        String starts = request.getParameter("starts");
        String rating = request.getParameter("rating");
           // System.out.println(title+type+director+url+starts);

        JSONObject jo = new JSONObject();

        jo.put("coverurl", url);
        jo.put("title", title);
        jo.put("type", type);
        jo.put("director", director);
        jo.put("starts", starts);
        jo.put("description", description);
        jo.put("rating", rating);
        NewJerseyClient movieClient = new NewJerseyClient();
        movieClient.create_JSON(jo.toString());
       request.getRequestDispatcher("./index.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
