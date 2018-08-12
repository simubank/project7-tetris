development stack:
Frontend: Angular + HTML
web service: Jersey
hosting servlet container(local only): Apache Tomcat
processing logic: Java
dependency: maven
storage: in-memory

To run frontend:
open a cmd terminal, cd into the angular UI directory
$ npm install #update latest packages
$ ng serve 
load up a browser, type in the url specify in the terminal

To run backend:
ensure tomcat is already installed and running in the background
load up EclipseEE project file
click run select the tomcat instance