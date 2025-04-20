# RMI
Java RMI Task Management System is a simple project built to demonstrate the concept of Remote Method Invocation (RMI) in Java.
The system consists of a server that stores tasks in a local text file and a client that can remotely add or view tasks.
A remote interface defines the methods that the client can call, such as addTask(String) and getTasks().
The server uses UnicastRemoteObject to expose these methods, and the client connects using Java RMI Registry.
Tasks are saved permanently in a file called tasks.txt, ensuring data persistence even after restarting the server.
The client provides a basic command-line menu for user interaction.
This project helps understand distributed computing principles using pure Java SE (no external libraries).

