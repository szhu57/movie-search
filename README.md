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

## System Architecture

![architecture](/img/architecture.png)

This movie search engine totally complies with the typically MVC framework.
Browser as the View which implemented by JSP sends request to the Movie Search
Server. The Movie Search Server as the Controller implemented by Servlet can
handle the request from the Brower and response to the client. The Movie server
receive the request from the client and invoke the web service through Restful API
like Google, Flickr, twitter, and etc..



Five child modules are comprised of the movie search engine, including Local
movie search, Video search, Sentiment analysis, Image search, and General search. In
the Local movie search the web service can accept the request and retrieves the movie
details which store in my own database, including movie title, director, rating and so
on. In the Video search integrated with the Tudou API and Youtube API. In the Image
search and General search they are integrated with the Flickr API and Google API.
And also Sentiment analysis integrated with the Twitter Sentiment.

![homepage](/img/home.png)