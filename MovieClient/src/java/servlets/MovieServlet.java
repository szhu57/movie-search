/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import client.NewJerseyClient;
import entity.Moviedb;
import flickr.Flickr;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import new_flickr.FlickrItem;
import tudou.Tudou;

//import net.sf.json.JSONObject;
/**
 *
 * @author hp\
 *
 *
 *
 * this is movie servlet its function is controller
 *
 * for one thing it receive request form the broser, for another invoke the
 * JesrseyClient to response the request.
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
            throws IOException {
        // fix the Chinese charactor
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        String method = request.getParameter("method");

        System.out.print("Servlet -------->" + method);

        if (method != null) {

            if (method.equals("local")) {

                searchByLocal(request, response);

            } else if (method.equals("flickr")) {

                // searchByFlickr(request,response);
                searchByNewFlickr(request, response);
            } else if (method.equals("google")) {

                searchByGoogle(request, response);
            } else if (method.equals("tudou")) {
                searchByTudou(request, response);
            }

        }

    }

    public void searchByTudou(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        String k = request.getParameter("moviename");
        String keyword = URLEncoder.encode(k, "utf-8");
        HttpURLConnection httpConnection = null;
        try {
            URL restServiceURL;
            restServiceURL = new URL("http://api.tudou.com/v6/video/search?app_key=15eb0f0d933741c3"
                    + "&format=json"
                    + "&kw=" + keyword
                    + "&pageNo=1"
            );
            httpConnection = (HttpURLConnection) restServiceURL.openConnection();
            httpConnection.setRequestMethod("GET");
            httpConnection.setRequestProperty("Accept", "application/json");
            if (httpConnection.getResponseCode() != 200) {
                request.setAttribute("message", "NOT FOUND");
                 request.getRequestDispatcher("/tudou_result.jsp").forward(request, response);
                
                throw new RuntimeException("HTTP GET Request Failed with Error code : "
                        + httpConnection.getResponseCode());
            }
            BufferedReader responseBuffer = new BufferedReader(new InputStreamReader(
                    (httpConnection.getInputStream()), "utf-8"));
            String result = "", output;
            while ((output = responseBuffer.readLine()) != null) {
                result += output;
            }
           // System.out.println(result);
            JSONObject jo = JSONObject.fromObject(result);
            System.out.println(jo);
            if (jo != null) {
                JSONArray array = jo.getJSONArray("results");
                System.out.println(array);
                if (array != null && array.size() > 0) {
                    List<Tudou> tudou = new ArrayList<>();
                    for (int i = 0; i < array.size(); i++) {
                        JSONObject job = array.getJSONObject(i);
                        System.out.println("---------------------------->"+job);
                        Tudou td = new Tudou();
                       td.setItemCode(job.getString("itemCode"));
                        td.setTitle(job.getString("title"));
                    td.setDescription(job.getString("description"));
//                        td.setDescription(job.getString("playUrl"));
//                        td.setDescription(job.getString("location"));
//                        td.setDescription(job.getString("picUrl"));
                 td.setOuterPlayerUrl(job.getString("outerPlayerUrl"));
                        tudou.add(td);

                    }
                    // System.out.println(tudou);
                    request.setAttribute("tudou", tudou);
                }else request.setAttribute("message", "NOT FOUND");
                
            }

           
            request.getRequestDispatcher("/tudou_result.jsp").forward(request, response);

            //System.out.print(result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            httpConnection.disconnect();
        }

    }

    public void searchByGoogle(HttpServletRequest request, HttpServletResponse response) {

    }

    public void searchByNewFlickr(HttpServletRequest request, HttpServletResponse response) {

        List<FlickrItem> img = new ArrayList<>();
        List<String> list = new ArrayList<>();
        String movieTitle = request.getParameter("moviename");
        img = new_flickr.Flickr.getInstance().search(movieTitle, "25");
        if (img != null) {
            for (FlickrItem flickr : img) {
                list.add(flickr.getURL());
            }
            request.setAttribute("imgurl", list);
        } else {
            request.setAttribute("error", "sorry not found");
        }
        String page = "/flickr_result.jsp";
        try {
            request.getRequestDispatcher(page).forward(request, response);
        } catch (ServletException e) {
            System.out.println("_______exception");

        } catch (IOException e1) {
        }
    }

    public void searchByFlickr(HttpServletRequest request, HttpServletResponse response) {

        List<String> img = new ArrayList<>();
        // List<String> list = new ArrayList<>();
        String movieTitle = request.getParameter("moviename");
        img = Flickr.getInstance().search(movieTitle);
        if (img != null) {
            request.setAttribute("imgurl", img);
        } else {
            request.setAttribute("error", "sorry not found");
        }
        String page = "/flickr_result.jsp";
        try {
            request.getRequestDispatcher(page).forward(request, response);
        } catch (ServletException e) {
            System.out.println("_______exception");

        } catch (IOException e1) {
        }

    }

    public void searchByLocal(HttpServletRequest request, HttpServletResponse response) throws JSONException {

        String movieTitle = request.getParameter("moviename");

        System.out.println("input info----------------------->" + movieTitle);
        String page = "";
        JSONObject jo = null;

        try {
            jo = initJSON(movieTitle); // to get the movie object using the initial method;

            System.out.println("job is exception---- job --------------test");
        } catch (Exception e) {
            System.out.println("Movie is not found");
        }

        if (jo == null) {
            String message = "Not found";
            request.setAttribute("moviename", movieTitle);
            request.setAttribute("message", message);

            page = "/error.jsp";

        } else {

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
        try {
            request.getRequestDispatcher(page).forward(request, response);
        } catch (ServletException e) {
            System.out.println("_______exception");

        } catch (IOException e1) {
        }

    }

    public JSONObject initJSON(String movieTitle) throws Exception {

        NewJerseyClient movieClient = new NewJerseyClient();
        //System.out.println("/////////////test the new client");
        JSONObject jo;
        jo = JSONObject.fromObject(movieClient.find(String.class, movieTitle));
        return jo;
    }

    @Override
    public String getServletInfo() {

        return "Short description";
    }// </editor-fold>

}
