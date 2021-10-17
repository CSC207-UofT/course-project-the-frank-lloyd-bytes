**Progress report**

**Specification Summary:**
This is a virtual TCard. A faculty member or a student can sign in to the app, and see their profile which contains their user information which differs if the user is a faculty member or a student. The program also presents them with the virtual TCard option, their app Wallet, the merchants and facilities they have access to. The virtual TCard can be used to access UofT facilities that the user has access to, or to make purchases with registered merchants in the app using their money in their virtual wallet. They have the option to load funds to the wallet if they’re low on money, see their account balance, and see their past transaction history. While making purchases, they might even get discounts based on what program the student is registered in (e.g. getting grocery discounts from Metro because they’re a UofT undergrad student). A user can see a list of merchants through the app and specifically what discounts are available through each merchant. A list of facilities that the user has access to will also be shown in the app.
The facilities and merchants users have access to will be registered by admins. They will login to the app with a special password from the main menu of the app, and can then create a new merchant in the app (by inputting merchant name, address, description, hours and discounts they offer). They can also create the facility profiles the users can use by inputting the facility name, address, description, hours, and the criteria to access to the facility.


**CRC Model Summary:**
Entity Classes: Merchant, Faculty, Database, Transaction, Discount, Student, User, Wallet, Facility
Use Case Classes: InputBoundary, Criteria, TCard
Controller: Controller, UserCommands
Basic Command Line Interface: Menu

Controller: Outputs login results and gets a profile if login succesfull
Criteria: adds and stores criterias (like being in Math program) and evaluates whether the user criteria matches the required merchant or facility criteria
Database: Adds merchants, facilities and users while storing their information
Discount: Stores discount amounts and criterias required for the specific discounts
Facility: Gives access to the facilities and stores facility information
Faculty: Holds faculty member information
InputBoundary: connects the UserCommands and Controller
Menu: let’s the user login
Merchant: stores in merchant information
Student: A subclass of the User class, stores student specific information such as program and the level the student is in.
TCard: Stores a user’s TCard, specifically the barcode and allows the card to be scanned as well as used to provide access to certain facilities and merchants by accessing the user’s information. Also allows the user to pay for items with their virtual wallet in the tcard.
Transaction: Stores a transaction between a user and a merchant, or a user with itself when it wants to deposit money. Includes the transaction amount, date, and type of transaction, whether it is a withdrawal or deposit.
User: Stores basic user information and is the superclass of student and faculty.
UserCommands: stores a list of commands that can be used by the user, such as log in.
Wallet: Stores the financial information of the TCard, that includes the balance, transaction history. Allows user to add funds, update transaction histories, and make payments.
TCardAppShell: Creates a command line interface that allows user to interact with. Also makes instances of needed classes when the app is run.

**Scenario-walkthrough Summary:**
Ming is a user that logs into the app with her own username and password. The app checks that her inputted information is correct and lets her see her own profile if the password inputted correctly matches her username in the database. If the login was successful, Ming’s user profile will be displayed in the app. This profile consists of Ming’s legal name, utorid, password, status (‘student’ for Ming, a prof would be ‘faculty’), id number, email, years in UofT, and which faculty she belongs to.


**Skeleton Program Summary:**
Only the part of the app that deals with login and profile display was finished for the skeleton program. In the tCardAppShell, instances that are needed to create the command line interface are made immediately when the app is run. Then, the menu class is run where it prompts the user to enter their username and corresponding to it, the password of their account. The Menu class saves what the user inputs and runs the runLogin method in the Controller class. runLogin calls LoginResult in the UserCommands class to check if the username and the corresponding password are correct and exist in the database. After, it goes back to runLogin to print the result for the user. If a match was found, the user will be logged in to the app. If either the password is wrong or the username does not exist, the program will print an error message for the user. After the user successfully logs in, the controller gets the profile which is displayed by the User class. The User Class gets the information for each user from the UserList Class.

**Open Questions:**
How would we make a transaction? How would the code know when to start the purchase process?
Would it be cleaner to get rid of the Admins and just register faculties and merchants by the code reading CSV forms they’ll fill in?
How does a barcode work?
How would it work when we add more merchants and facilities
Communication has been good, but still needs improvement. We double coded/designed a few things which 
a better workflow system could have prevented, so an open question is how do we do this?

**What Has Worked Well For Our Design:**
Successfully implemented the User class and it's subclasses. Constructed a basic program structrue that follows the Clean Architecture. The Use Case classes connect our controllers, so modifying the code in one controller won’t affect the other one.
The controllers display the information stored in the entity classes for the user.
Our communication and teamwork within the team

**What Each Group Member Has Been Working On (and future plans):**
So far…
Jonah: Wrote the Specifications and the CRC Model. Maintained project flow. 
Peter: Questioned the CRC Model and specifications for improvement. Wrote the skeleton code and first structure layers 
    implementation in clean code design. Moved project forward and helped organize group. 
    Created Kanban card system in git Project(didn't use this phase0).
Ming: Helped with writing the specifications and the CRC Model. Wrote the walkthrough and the report.
Yanbin: Helped with writing the specifications and the CRC Model. Wrote the skeleton code. Also corrected layer
    design issues. 
Kristal: Questioned the CRC Model and specifications for improvement. Wrote the walkthrough and the report.
Jesse: Wrote the test cases for the skeleton code. Took a leadership role in organizing group. 

**Future plans…**
Jonah: Do more coding in the next phases to gain experience and have a deeper understanding of design pattern.
Peter: With an eye towards expandability, keep the structure clean and agile. Look for structural inefficiency in code 
and workflow. Help coding classes and try to get our testing up to a Test Driven model with Jesse. Create a project 
task interface with clearer work assignments to prevent double coding issues. 
Ming: Write classes and interfaces for the code, understand more about what is good design and how to implement.
Yanbin: Try to learn more about GUI and android development. Have a clearer understanding of desgin patterns and desgin principle and apply these to our program. 
Kristal: Improve the design of the app by revising the specifications and better defining the relationship of the classes with each other (+ adding more user case classes). Help with the coding.
Jesse:



