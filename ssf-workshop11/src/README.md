# ssf-workshop11


SSF - Day 11 Workshop&nbsp;

setup:<br>
    1. Generate a SpringBoot application with Spring Initializr with the following dependencies:<br>
       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; - Spring Boot DevTools<br>
       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; - Spring Web<br>
       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; - Thymeleaf<br>
       <br>
tasks:<br>
    1.Create a directory for your static HTML documents and resources. You can create 1 or 2 HTML document. Make sure that there is a HTML file called index.html; this is your ‘landing page’. ✓ <br>
    <br>
    2.Add an error page error.html ✓ <br>
    <br>
    3.Make the port that the application listens on configuration. The port should be configurable via the command line option as well as environment variable. When the application starts, it should check for the port in the following order of preference<br>
           &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i. Check if the option --port <port number> is set, if it is set, use the provided port number ✓<br>
           &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ii. Check if the environment variable PORT (case sensitive) is set, if it is set use the provided port number<br>
           &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;iii. If none of the above are set, default to port 3000<br>
    <br>
    4.Login to Heroku with heroku command line and deploy the application. ✓<br>
