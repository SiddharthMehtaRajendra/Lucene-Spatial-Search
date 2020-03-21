# Lucene-Spatial-Search

Lucene and MySQL Spatial Search

Code Structure:

This is regarding the Service Search project.

I have divided the code into separate packages, each with a specific role to play in the application. This has allowed the application to be modular and extensible for future modifications.

The Backend contains the Java Files which act as the controller and middleware between the REST API Consumer and Lucene Search with Database Querying.

The Publication Search File in the Controllers package will expose the Basic Search and Spatial Search APIs to the outside world. For the sake of performance, I have lazily loaded the APIs required to run Lucene Search with the indexes added on Application Startup for performance increment while application is online.

For Lucene Search, I added indexes on Title and Authors as attributes for better querying of relevant titles.

I had to make some changes to map author names to publication titles for Lucene indexing which happens on App Startup and is loaded into the RAM Directory which could be volatile but easier to debug and implement. I plan to store indexes as persisted data in the future if time permits.

The db package in the backend contains the files responsible for direct communication with the database. This offloads the controller from dealing with low level DB logic and focus on core business logic. The DBQueryInterface Java file is the DAO Class responsible for retrieving the mapped publications and performing the spatial search query.

The Model package contains the new Search Region entity to process user start and end year specifications in the REST API Call. In this assignment as well, I have used a singleton JDBC Connector object API for performance and modularity.

The resources package contains the XML file for reference purposes. I added Lucene JARS as a part of build.sbt for seamless integration of modules in the application.

REST API Calls:

I have documented the REST API calls for easy understanding and for users to invoke the application functionality.

To invoke the search functionality, run the backend application and invoke the following:

•	Basic Search - localhost:9000/basicSearch
Parameters: Query String, Number of Results to Skip, Number of Results to Return


•	Spatial Search - localhost:9000/spatialSearch
Parameters: Query String, Year From, Year To, Number of Results to Skip, Number of Results to Return

I have documented and published the REST API both with along with this zip file and on the following URL:

•	https://documenter.getpostman.com/view/9486447/SzKZsG6k?version=latest

Code Documentation:

I have documented the code to allow greater ease of understanding the various sections of code including methods, classes and some variables.

I have added comments where I felt it would be beneficial to provide a description of that module of code to the reviewer.

I have added copyright comments so that the author of the file may be identified.

Design Considerations:

The code is structured for reusability and variable names are kept meaningful. This allows for a more readable and understandable code, which increases maintainability and extensibility.

I have also optimized the code at multiple places for increased performance and computational efficiency..







