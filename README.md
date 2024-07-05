Task overview:

Please prepare a Spring Boot maven project that for the following object (object defined in pseudo-code) will:


Expose an API to return posts with the top ten highest view counts per postCategory
Expose an API to search posts by author

The solution should be as most production ready as possible so should contain all the features that would be considered essential for that.
The application should integrate with a database (you can use H2 integrated in-memory database) to facilitate operations exposed using the API
Please provide the test coverage and all other project facilities that are important in your opinion
When designing the API please consider scalability and performance aspects. Please note that the number of posts can be significant (like 10^9)
The following script can be used as a starting point to feed the database:

INSERT INTO SocialNetwork (ID,AUTHOR, CONTENT, POST_CATEGORY, POST_DATE, VIEW_COUNT) VALUES

(1,'Alice', 'Check out my new song!','Music', '2024-01-15',1570),

(2,'Bob', 'Just finished an epic gaming session!','Gaming','2024-02-22' 2215),

(3,'Charlie', 'Breaking news: Major event happening now!','News','2024-03-10',3050),

(4,'Diana', 'Top 10 movies to watch this summer.','Entertainment','2024-04-18,1725),

(5,'Eve', 'My concert was amazing last night!','Music','2024-05-05', 2850),

(6,'Frank', 'Tips and tricks for the latest game.','Gaming','2024-06-23',2380),

(7,'Grace', 'Election results are in.','News','2024-07-01', 3190),

(8,'Heidi', 'Best TV shows to binge-watch.','Entertainment', '2024-08-14',1920),

(9,'Ivan', 'Album release date announced!', 'Music','2024-09-09',2125),

(10,'Judy', 'Game review: The best and the worst.','Gaming','2024-10-25',2480),

(11,'Karl', 'Weather update: Severe storm approaching.','News','2024-11-11,2730),

(12,'Laura', 'Celebrity gossip: Who wore it best?','Entertainment', '2024-12-05',1650);



