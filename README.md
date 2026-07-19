# url shortner

The goal of this project is to get better in system design.So the main focus will be on my choices in the design and the explanation behind these choices.The code will be minimal to just get things working


# First we define the main features :
- We are designing a url shortner that allows users creating short urls from long one,store these urls and keeps a mapping between the short url and the long corresponding one. 
- Users that wants to use the shortning service must have an account to keep track of its links 
-Every short link have expiration date 
- The url shortner redirect users that click on the short links to the original ones(long urls) 

# Non functional requirements

- Low latency (fast redirects) 
- scalabilty (in case of increasing number of reads and writes): \
url creations: 1160write/sec
url retrievals: 11600read/sec
=> ~ 10000 QPS
- high availability 

# Apis

in this section we will mention the most important end-points for our url shortner, the expected input and output for these end-points 

  |end-point    | inputs | output |
  | ------------| ------   | ------ |
  |POST /new-url|- long url <br>- auth token     |successful message    |
  |GET /id       | -user id     | { <br> "long link":  "short link" <br>} |
  |POST /redirect| -short link | {<br> "message":301 <br>}


  # Design

- The url shortner is a heavy-read app therefore we have to optimize our read operations by adding a caching layer
- In order to handle the increasing load we need to multiple backend servers with a load balancer 


<img src="./Untitled Diagram.drawio(1).png">
