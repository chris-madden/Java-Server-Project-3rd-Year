Java Server Project

Contents
========

There are 2 folders, Client and Server.
Each folder has 3 java files and the Server folder also has a txt file with the users and passwords

Run the code
============

The server java files and the txt file must be on the server and must all be in the same directory E.G all on the desktop
The ServerRunner has the main method for starting the server up
Start the server up first

The client java files can be run from any computer E.G using eclipse on a laptop
The ClientRunner has the main method for conenecting to the server

How the code works
==================

When you run the client code you'll be asked for an ip address, put in the ip address of the server you're connecting to
You will get a message saying if you've connected
Then you will be asked for your login details E.G your username and password
The client will then send the details over to the server to authenticate them

When the server first runs it reads in the usernames and passwords from the users.txt file
These details are stored in a hashmap, username is the key and password is the value
The server checks that the username is contained in the hashmap and then checks that the password entered correctly matches the value stored with the key
If either username or password is incorrect the user is informed and can try enter their details again
If the username and password is correct the server sends the result to the client which tells the user they were successful