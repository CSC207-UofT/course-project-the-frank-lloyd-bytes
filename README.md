# TCard App Specification

Consider the following description of a software system that facilitates a virtual TCard to be used by students and
faculty at the University of Toronto.

### First menu:
When you open the app, you are given the option "LOGIN" as a user after inputting information to the fields "User Name" 
and "Password". There is also an option "New user? Register" where you can register an account in the app.

###Log in:
You can select the “LOGIN” option after entering information to the fields "User Name" and "Password". If the UTORid and 
password the user enters is not registered (i.e. is not in the user database), an error message comes up saying 
“incorrect UTORid and/or password” and they cannot access the app. If the UTORid and password the user enters is 
registered, they are navigated to the main menu of the app.

### Register User
Selecting "New user? Register" navigates to a menu with the following fields that users can enter information into:
- User Name
- Password
- Legal Names: first name, last name
- Status: Faculty or Student
- email
- TCard #
- Department
- Year

###GUI:
The main menu GUI displays TCard information of the user in the centre of the screen:
- UTORid
- Legal name
- ID number
- Status: student, faculty

At the bottom of the screen, there is a bar displaying the following menu options:
- Account
- Facilities

###GUI - Account menu:
Selecting the “Account” option navigates to a menu that displays the user's information. If the user's status is student,
the information that is displayed is:
- First name
- Last name
- UTORid
- Status: student
- Student number
- U of T email
- Program of study
- Level (undergraduate or graduate)
- Year of study

If the user's status is faculty, the information that is displayed is:
- First name
- Last name
- UTORid
- Status: faculty
- Personell number
- U of T email
- Department
- Position (professor, assistant professor, etc)

Within the account menu, there is a "change password option". Selecting this option allows users to change their 
password. Users are first prompted to enter their current password, then they are navigated to a screen with two fields:
"new password" and "confirm new password". Typing in your desired new password in both of these fields changes the users
password.

###TCard:
Every user is associated with a unique TCard, which holds a unique bar code and ID number for the user.
Users can also use their TCard to gain access to certain U of T facilities by scanning the barcode on their TCard.
All facilities have a list of criteria that determine which users may be granted access after scanning their TCard.

###GUI - Facilities menu:
Selecting the “Facilities” option navigates to a menu that displays a list of all the major U of T facilities (e.g.
major U of T buildings). For each facility, the following information is displayed:
- Name
- Address
- Description
- Hours

For each facility, there is a "check access" option. Selecting this option checks to see if you have TCard
access to this facility, based on the criteria for entry that the facility has listed. If you satisfy the facilities 
criteria, a message will be displayed saying "You have TCard access to <facility name>!". Otherwise, a message is 
displayed saying "You do not have TCard access to <facility name>."

###UCheck
We need to be able to identify whether a user has done Ucheck (or fully vaccinated or has an exemption) or not. If the 
user is fully vaccinated and has done their Ucheck, the background color of the main menu GUI should be green, and red 
otherwise.

Users should be able to upload their vaccination receipt or other documents to their profile.

Users should be able to complete Uchek through the app every day.

The Ucheck status of the user renews every day(or every 24 hours). Once the Ucheck expires, the app will notify the user to renew their Ucheck status.

On the main menu GUI, users can swipe left or right to change to different GUIs to show their Ucheck result or vaccination receipt.(There will be two GUIs, one for Ucheck and one for the vaccine. And any modification of the Ucheck or vaccine can be done through their GUIs).


