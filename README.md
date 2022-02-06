# evaguru-project

In the project folder there is the project that I built. 

First of all I used Java with Spring boot. 

After that before all of the operations you should run docker-compose.yml and you should go to localhost:8080 and create databe with the same name in the application.yml file. 

When you finish creating and setting this parameters. You could run the project. The aplication will be run on localhost:8081. 

I used Postgresql. There are 3 entities; Portfolio, Share and User. You should create User and Share datas with api. After that you can sell and buy portfolio. I will share Postman Collection in this folder with "postman-collection" name. 


Base Url = http://localhost:8081

 + /user  -> you can make your user implementations. 

 + /share  -> you can do operations with shares. 
 
 + /trade/buy -> you can buy portfolio 
 
 + /trade/sell -> you can sell portfolio 

  
Every user have portfolio. User table and Portfolio table relation is one to many. Portfolio join share with share_portfolio_id.  