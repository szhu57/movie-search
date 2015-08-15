/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import client.NewJerseyClient;
import entity.Moviedb;
import flickr.Flickr;
import google.Google;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
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
import youtube.YoutubeItem;
import youtube.YoutubeSearch;

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
            throws IOException, UnsupportedEncodingException, ServletException {
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
            } else if (method.equals("youtube")) {

                searchByYoutube(request, response);
            }

        }

    }

    public void searchByGoogle(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, ServletException, IOException {
        String k = request.getParameter("moviename");
        String page = "";
        if (k.isEmpty()) {
            page = "/index.jsp";
        } else {

            String keyword = URLEncoder.encode(k, "utf-8");
            String url = " https://www.googleapis.com/customsearch/v1?key=AIzaSyAXjKWG4Zj1oGWEZPdaygBR4OA424ZdRyw"
                    + "&cx=017273734144320215856:dknc-smozwk"
                    + "&q=" + keyword
                    + "&num=10";

            JSONObject jo = getHttpRequestResult(request, response, keyword, url);
            if (jo != null) {
                try {
                    JSONArray array = jo.getJSONArray("items");

                    System.out.println(array);
                    if (array != null && array.size() > 0) {
                        List<Google> googleList = new ArrayList<>();
                        for (int i = 0; i < array.size(); i++) {
                            JSONObject job = array.getJSONObject(i);

                            Google go = new Google();
                            go.setLink(job.getString("link"));
                            go.setSinppet(job.getString("snippet"));
                            go.setTitle(job.getString("title"));
                            googleList.add(go);

                        }
                        // System.out.println(tudou);
                        request.setAttribute("google", googleList);
                    } else {
                        request.setAttribute("message", "NOT FOUND");
                    }
                } catch (net.sf.json.JSONException e) {
                    request.setAttribute("message", "NOT FOUND");
                    request.getRequestDispatcher("/" + request.getParameter("method") + "_result.jsp").forward(request, response);

                }
                page = "/google_result.jsp";
            }
        }
        try {
            request.getRequestDispatcher(page).forward(request, response);
        } catch (ServletException e) {
            System.out.println("_______exception");

        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }

    public void searchByYoutube(HttpServletRequest request, HttpServletResponse response) {

        String movieTitle = request.getParameter("moviename".trim());
        String page = "";
        if (movieTitle.isEmpty()) {
            page = "/index.jsp";
        } else {

            YoutubeSearch instance = YoutubeSearch.getInstance();
            List<YoutubeItem> list = new ArrayList<>();

            list = instance.searchFromYoutube(movieTitle);
            System.out.println(list);
            if (list != null) {
                request.setAttribute("video", list);

            } else {
                request.setAttribute("message", "NOT FOUND");
            }
            page = "/youtube_result.jsp";
        }

        try {
            request.getRequestDispatcher(page).forward(request, response);
        } catch (ServletException e) {
            System.out.println("_______exception");

        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }

    public void searchByTudou(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        String k = request.getParameter("moviename");
        String page = "";
        if (k.isEmpty()) {
            page = "/index.jsp";
        } else {
            String keyword = URLEncoder.encode(k, "utf-8");
            String url = "http://api.tudou.com/v6/video/search?app_key=15eb0f0d933741c3"
                    + "&format=json"
                    + "&kw=" + keyword
                    + "&pageNo=1";
            JSONObject jo = getHttpRequestResult(request, response, keyword, url);
            System.out.println(jo);
            if (jo != null) {
                JSONArray array = jo.getJSONArray("results");
                System.out.println(array);
                if (array != null && array.size() > 0) {
                    List<Tudou> tudou = new ArrayList<>();
                    for (int i = 0; i < array.size(); i++) {
                        JSONObject job = array.getJSONObject(i);
                        System.out.println("---------------------------->" + job);
                        Tudou td = new Tudou();
                        td.setItemCode(job.getString("itemCode"));
                        td.setTitle(job.getString("title"));
                        td.setDescription(job.getString("description"));
                        td.setPlayUrl(job.getString("playUrl"));
                        td.setLocation(job.getString("location"));
                        td.setPicUrl(job.getString("picUrl"));
                        td.setOuterPlayerUrl(job.getString("outerPlayerUrl"));
                        tudou.add(td);

                    }
                    // System.out.println(tudou);
                    request.setAttribute("tudou", tudou);
                } else {
                    request.setAttribute("message", "NOT FOUND");
                }
                page = "/tudou_result.jsp";
            }
        }
        try {
            request.getRequestDispatcher(page).forward(request, response);
        } catch (ServletException e) {
            System.out.println("_______exception");

        } catch (IOException e1) {
        }

    }

    public void searchByNewFlickr(HttpServletRequest request, HttpServletResponse response) {

        String page = "";
        String movieTitle = request.getParameter("moviename");
        if (movieTitle.isEmpty()) {
            page = "/index.jsp";
        } else {
            List<FlickrItem> img = new ArrayList<>();
            List<String> list = new ArrayList<>();
            img = new_flickr.Flickr.getInstance().search(movieTitle, "25");
            if (img != null) {
                for (FlickrItem flickr : img) {
                    list.add(flickr.getURL());
                }
                request.setAttribute("imgurl", list);
            } else {
                request.setAttribute("error", "sorry not found");
            }
            page = "/flickr_result.jsp";
        }
        try {
            request.getRequestDispatcher(page).forward(request, response);
        } catch (ServletException e) {
            System.out.println("_______exception");

        } catch (IOException e1) {
        }
    }

    public void searchByFlickr(HttpServletRequest request, HttpServletResponse response) {

        String page = "";
        // List<String> list = new ArrayList<>();
        String movieTitle = request.getParameter("moviename");
        if (movieTitle.isEmpty()) {
            page = "/index.jsp";
        } else {

            List<String> img = new ArrayList<>();
            img = Flickr.getInstance().search(movieTitle);
            if (img != null) {
                request.setAttribute("imgurl", img);
            } else {
                request.setAttribute("error", "sorry not found");
            }
            page = "/flickr_result.jsp";
        }
        try {
            request.getRequestDispatcher(page).forward(request, response);
        } catch (ServletException e) {
            System.out.println("_______exception");

        } catch (IOException e1) {
        }

    }

    public void searchByLocal(HttpServletRequest request, HttpServletResponse response) throws JSONException {

        String movieTitle = request.getParameter("moviename");
        String page = "";
        System.out.println(movieTitle);
        // if the user input nothing but submmit then to jump the home page
        if (movieTitle.isEmpty()) {
            page = "/index.jsp";
        } else {

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
                Double score = tweetSentiment(request, response, movieTitle);
                request.setAttribute("score", score);
                System.out.println("----------------------->"+score);
                page = "/local_result.jsp";

            }
        }
        //response to the client
        try {
            request.getRequestDispatcher(page).forward(request, response);
        } catch (ServletException e) {
            System.out.println("_______exception");

        } catch (IOException e1) {
        }

    }

    public double tweetSentiment(HttpServletRequest request, HttpServletResponse response, String keyword) {
        String url = "https://www.tweetsentimentapi.com/api/?key=3991721a853590bcb4b0508c627a2652b76e3920&text=" + keyword;

        // to sovle the javax.net.ssl.SSLHandshakeException
        TrustManager[] trustAllCerts = new TrustManager[]{
            new X509TrustManager() {

                @Override
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                @Override
                public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {
                    //No need to implement.
                }

                @Override
                public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {
                    //No need to implement.
                }
            }
        };

        // Install the all-trusting trust manager
        try {
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (Exception e) {
            System.out.println(e);
        }
        JSONObject jo = getHttpRequestResult(request, response, keyword, url);
        Double score = jo.getDouble("score");
       // String attitude = jo.getString("sentiment");
        //  System.out.println("------------------------------------------tweetSentiment" + score + attitude);
        return (score+1)/2;
    }

    public JSONObject initJSON(String movieTitle) throws Exception {

        NewJerseyClient movieClient = new NewJerseyClient();
        //System.out.println("/////////////test the new client");
        JSONObject jo;
        jo = JSONObject.fromObject(movieClient.find(String.class, movieTitle));
        return jo;
    }

    public JSONObject getHttpRequestResult(HttpServletRequest request, HttpServletResponse response, String keyword, String url) {

        HttpURLConnection httpConnection = null;
        try {
            URL restServiceURL;
            restServiceURL = new URL(url);

            httpConnection = (HttpURLConnection) restServiceURL.openConnection();
            httpConnection.setRequestMethod("GET");
            httpConnection.setRequestProperty("Accept", "application/json");
            if (httpConnection.getResponseCode() != 200) {
                request.setAttribute("message", "NOT FOUND");
                request.getRequestDispatcher("/" + request.getParameter("method") + "_result.jsp").forward(request, response);

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

            return jo;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            httpConnection.disconnect();
        }
        return null;
    }

    @Override
    public String getServletInfo() {

        return "Short description";
    }// </editor-fold>

}
