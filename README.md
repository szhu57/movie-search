#A Personalized Movie Search Engine Application


## Project Introduction 

This Application implement a personalised search application for movie on DVD which will invoke and interact with several real-world web services and search engine.

The user can search for a particular movie by entering the title. The application is required to retrieve information from:

* My own personal database that stores all the DVDs that I have
* Google search engine;
* Some relevant video from Tudou and Youtube
* Any relevant images from Flickr
* Add movies into my own database
* use twitter sentiment analysis the movie

The application is implemented in Netbeans IDE, and should has well-organised layout and friendly GUI.

## How to run this application  on the PC
* environment  OS: window ,mac  Server:Glassfish

* Glassfish config:you need to find the **config.xml** file, which located in the **dist** file. Add the content in this file into the **domain.xml** which is located in the installing path of glassfish(glassshfih/domains/domain1/config/domain.xml).

* import the database id26346915.sql which is also located in the dist file.

* copy the two **.war** package(one in the MoiveClient package,the other is in the MovieSearch package) into the **autodeploy** path which is located int the installing path of glassfish(glassfish/domains/domain1/autodeploy)

* start you glassfish server

* type this address <http://localhost:8080/MovieClient> in your browser.
	

## System Architecture

![architecture](/img/architecture.png)

This movie search engine totally complies with the typically **MVC** framework.
Browser as the View which implemented by **JSP** sends request to the Movie Search
Server. The Movie Search Server as the Controller implemented by **Servlet** can
handle the request from the Browser and response to the client. The Movie server
receive the request from the client and invoke the web service through **Restful API**
like Google, Flickr, twitter, and etc..



Five child modules are comprised of the movie search engine, including Local
movie search, Video search, Sentiment analysis, Image search, and General search. In
the Local movie search the web service can accept the request and retrieves the movie
details which store in my own database, including movie title, director, rating and so
on. In the Video search integrated with the **Tudou API** and **Youtube API**. In the Image
search and General search they are integrated with the** Flickr API** and **Google API**.
And also Sentiment analysis integrated with the **Twitter Sentiment**.


## Function demonstrate
### home page
![homepage](/img/home.png)

### Local Search
![local](/img/local.png)

### Image Search
![flickr](/img/flickr.png)

### Viedo Search
![youtube](/img/youtube.png)


### Google Search
![google](/img/google.png)

##About athor

 * Name: Shuai ZHU

 * Mail: szhu57@outlook.com

 * Weibo:http://weibo.com/2613558687/profile
 
 * University: Southeast University & Monash University (Australia)


## How to get

operation example:$ git clone http://github.com/szhu57/monash-hotelbooking
