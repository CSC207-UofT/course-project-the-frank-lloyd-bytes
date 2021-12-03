# CS207 - Design Document:
## Specification:
See the specification in the repository.

## Major Design Decisions:
- We decided to express the criteria for entry of a facility as a string. For example, suppose we have a facility whose criteria is "program=(CS/MAT),year=(1/2):department=(PHY),year=(any)”. The left side of the “:” is student criteria, the right side is faculty criteria. The “,” represent “and” and the “/” represent “or”. So, in words, this facility allows TCard access to: first and second year students in either the mathematics OR computer science program, and faculty members in the physics department with ANY number of years at U of T. We decided to do the criteria like this because we wanted a compact way to store it in the database. 
- Creating a “check access” option in the facilities menu of the app (unfortunately, we weren't able to finish implementing this). Selecting this option for a given facility will display a message indicating if you have TCard access to the facility or not. This is determined by checking if your user information satisfies the criteria for access listed by the facility. We did this because we wanted a reasonable way for users of the app to interact with facilities virtually.
- We decided to not include U of T merchants and the wallet feature of the app. This was partly a suggestion from one of the professors. We felt it was a bit over ambitious to also try to implement a sort of payment system, and it distracted from the main idea of the app. As well, adding merchants to the app in phase 2 would be a good way to extend the app.
- We decided to add the UCheck feature to the app (unfortunately, we weren't able to finish implementing this). This was also a suggestion from the professor. Users of the app can fill out their daily UCheck within the app and upload their vaccination receipts. This also allows users to have quick and easy access to UCheck stuff. We decided to add this because we thought it was a smart and attainable idea that is very fitting of our current situation at U of T. 


## Code Style and Documentation
- There are some design warnings that pop up when the code is opened in IntelliJ based on our choice of code grammar. However, these do not affect the app running. We will continue fixing these problems and warnings in the future. 
- Documentation is not written for all sections such as attributes and XML files. They are also written by different people depending on who wrote what parts of the app. Thus, language could be significantly different throughout the document. However, each method is documented including any return variables, parameters, and what the method does. Since we were quite short on time, they may not be very specific and are usually one line long. They do capture the essence of each block of code. We will do a better job and improve what we currently have for phase two. 


## Testing
- We tested entity classes, and use case classes. For activity classes, we did not feel the need to test activities since we can check everything by running the app and debugging the code as the app runs. And it would be difficult to test. Also we could see how the user database was filled in when the app ran. We were unable to test the controllers because we ran out of time. 

## Refactoring
- We built on each other’s codes by pulling on their branches and corrected them by using refactoring. Sometimes, we name variables and methods differently, and refactoring greatly helped with putting two sets of codes together. 
- Redundant code and long methods were also a big problem when we worked on the same parts of the code together. Thus, when combining, we simply refactored by deleting any code that did not contribute to the overall code. 
- Most of the obvious code smells have been eliminated as we see them, however, there are many more that we have definitely missed. Due to the lack of time, we couldn't find a way to reduce the long number of parameters for our user classes. 

## Code Organization
- We believe that our code is organized very meaningfully and clearly. To follow clean architecture, we created entities, use-cases, controllers, and UI packages in our code. This way, we always know when we can directly call from another class and if it violates clean architecture. 
- It is very easy to find things in this package structure. Similar classes and interfaces this way are packaged together and they are named intuitively enough to know which package they belong to. 

## Clean Architecture
- Please see our UML diagram tcard.png in the phase1_documentation folder.
- We believe that we followed clean architecture very well. To follow the order of the layers, when we had to call something from the entities, for example from the controllers, we had to pass them through the use-cases to follow the right order. When we get the information from the database for the facility, we start with the FacilityManager. It is a controller and it calls the FacilityMap class in the use cases, which then calls the Facility entity class to create the Facility object that can be put into the map. It is then passed back to FacilityManager, and then back to the GUI for the facility’s page to display. Because of this, the dependency rule is mostly consistently followed, as much as we could, when the GUI is being interacted with, and when the entities are being called and changed. 
- There is one part in our facilities activities where we directly call a method in the facility class. Since we are still debugging this page, we did not change it yet to comply with clean architecture. We will change this for the future by putting in the method we’re calling into a use case and then  a controller class to call it from the user interface.

## SOLID
- The user class adheres to the single responsibility principle well. User class and its subclasses: Student and Faculty are only responsible for storing and displaying the information of the user. 
- We only have one use case class for User, which takes all responsibilities like changing password, showing profiles and creating user objects. And this problem exists in our other higher layers classes too. This is because we don’t follow the dependency inversion principle. We designed the low level classes first and therefore all our higher level classes had to depend on the low level class. It was not hurting much since the program isn’t big. But we will try to solve this in the future.
- The design is extendable. For example, You can add more user types as you want: merchant, staff or guest. And they can implement their own behaviour as we are using the template design pattern in the project.

## Design Patterns
- We tried to implement the template design pattern for User, Student and Faculty but it didn’t seem useful. We used this pattern because we thought there would be a big difference between the behaviors of Student and Faculty. But for the part we implemented, there is no huge difference. But because it didn’t hurt our current design and for the future extension of User, this design pattern may be helpful , we are keeping it. 
- We also tried to use the adapter design pattern for the facility and it’s GUI regarding the recycler view and the viewpager2 for fragments. We used FragmentAdapter to connect fragments to viewpager, and to resize the cards (facility cards) to fit into the recyclerview.  However (for recycler view adaptor), we did not have time to finish debugging the facility part of the app and thus it still crashes when we run the app. We will resolve any errors starting phase 2 and hopefully correctly implement this design pattern. 


## Use of GitHub Features
- We definitely used pull requests, merges, and the token cards from Github to get each other’s codes and be organized. In order to see what each member did before it is merged to the main, everyone can open a pull request for other members to check over. If there are no problems, it can be merged to the main so that everyone can get the newest version of the code. We also used branches alot since some people were working together on the same functions which would make it easier for them to only pull each other’s changes.
- We used token cards to choose tasks and tell each other if we finished them. However, it was a little confusing with the member who added the card and who is actually doing it. We will definitely be more organized in the future. 

## Functionality
We did achieve a large part of our specs: Register, Login, Change password. We added a QR Code display for possible future uses (of the actual physical facilities having scanners to check if the student/faculty can enter the building). And we were able to connect to a database and load and store data into the database. But due to a number of reasons which I will list below, we were not able to complete our specs perfectly in phase 1. We will definitely start on phase 2 earlier next time and seek help as early as we can.
- IntelliJ and Github problems: More than half of the time that we have worked on this class, we have been debugging any problems with git and IntelliJ. Some members expressed that there was very minimal help offered throughout the reading week. This is definitely our fault though for starting a few weeks before the due date. (ask Jeffery how many times we called him for help :)) We met up multiple times throughout the week to code together, but most of the time was still spent on solving administrative problems.
- Miscommunication and lack of planning: Due to some miscommunication, some members were confused about which parts to work on. Despite having token cards on Github, we were a bit confused with who added what and who is actually working on what.

We are not trying to make any excuses for our ending UCheckResult, we will use this as a learning experience and hopefully improve greatly for the next phase.


## Open Questions and What has worked well with our design:
- Why does the emulator very rarely work and only work for some people
- Would it be too easy to have UCheck as an activity quiz, as fragments connecting to each other
- Should we use adapter for facilities
- How to store images in the database as a txt file

## What each member has been doing and plans to work on next:
- Yanbin: Helped everyone with administrative problems. Helped with android download and set up. Made the User database as well as a file reader for CSV files. Made user manager and user commands for the user GUI. helped with all GUI activities. In the future, I will help more with the facility databases, and do UCheck implementation. 
- Kristal: Designed and implemented the user interface, wrote documentation (helped ming for the facility section, helped Jesse for the update password activity, and almost did all the rest). Note: Yanbin helped a lot for fixing the bugs. Gonna fix the facility user interface in the future. Also going to add a dark mode view, upload profile pictures… (basically more user interface). AND have a better understanding of the controllers and use-cases.
- Jonah: Implemented criteria related classes and methods (Check criteria interface, evaluate method in Facility). Helped implement and refactor Facility, User, Student, Faculty, UserCommands classes. Implemented tests for all the entity and use case classes. Updated specification. I am planning to help finish the work we weren't able to complete in phase 1, then start to implement merchants and Ucheck into the app within the next week or so. 
- Jesse: I started off with working with Wallet but scrapped it since it was overly complicated, I then started to change my password in Database and GUI activity. I ended up having Yanbin help with Database and the correct design patterns to allow it to function properly and Kristal with XML design finished uniformly. For the future, I had a lot of issues with my IDE and emulator. I am going to focus on resolving it this week and help on future tasks, such as XML predesign with Ucheck just so it has functionality with our app. 
- Pete:
- Ming: Fixed up the facility class and created the facility database. Tried to create the XML for the facility page, as well as the adapter and activity that goes along with it. We don't think that we should use the adapter for the facility so we will change that for phase 2. I will continue to fix up the facility in the future. 
