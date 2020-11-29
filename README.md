# Library System 1.0.0 (GRASP)
  
## Table of content  
* [Structure of the project](#Structure-of-the-project)
* [Usage](#Usage)
* [Proposed updates](#Proposed-updates)
  
## Structure of the project
Library System offers easy-to-use solution for adding, tracking, and managing readers and books in libraries.   
  
Source code of the library system project consists of the following classes:   
- main.java (Main class for running the library system),  
- Book.java (Class for book object),  
- Reader.java (Class for reader object),  
- Date.java (Class for date object, extends java.util.Calendar),  
- Library.java (Class for library object),  
- ISBN_Generator.java (Class for issuing unique ISBN numbers),  
- ID_Generator.java (Class for issuing unique IDs).  
  
## Usage  
Library System can do following actions: Creating new library, adding new reader, adding new book, borrowing a book, returning a book, searching for a book, and checking fines.  
  
After the starting the system, it will offer you to enter name of your library, which will be created in the system imidiatelly after. Following the creation of the library, the system will ask you to choose your further actions.  
  
You can choose one of the action as stated below:  
1 - Add new reader,  
2 - Add new book,  
3 - Borrow a book,  
4 - Return a book,  
5 - Check fines,  
6 - Search a book,  
0 - Exit the library system.  
  
## Proposed updates  
- [ ] GUI.
- [ ] Support of multiple libraries.
- [ ] Adding author to book class.
- [ ] Saving the system's data to the local database.
- [ ] Adding option for printing information about the chosen library.
