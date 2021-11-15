# TCard App Specification

Consider the following description of a software system that facilitates a virtual TCard to be used by students and
faculty at the University of Toronto.

### First menu:
When you open the app, you are given the option "login" where you can login as a user after inputting information to the
fields "Username" and "Password". A user can anyone at U of T who uses a TCard, i.e., students and faculty. There is 
also an option "New user? Register" where you can create and register a new account in the app.

###TCard:
Every user is associated with a unique TCard, which holds a unique barcode and ID number for the user.
Users can also use their TCard to gain access to certain U of T facilities by scanning the barcode on their TCard.
All facilities have a list of criteria that determine which users may be granted access after scanning their TCard.

### Log in:
In the first menu, you can select the “login” option after entering information to the fields "Username" and "Password". If the UTORid and
password the user enters is not registered (i.e. is not in the user database), an error message comes up saying
“incorrect UTORid and/or password” and they cannot access the app. If the UTORid and password the user enters is
registered, they are navigated to the main menu of the app.

### Register User
Selecting "New user? Register" navigates to a menu with the following fields that users can enter information into:
- Username
- Password
- Legal Names: first name, last name
- Status: faculty or student
- email
- ID number
- Department/program
- Year

Once this information is entered, the user can now login and use the app with the user information they just registered.

### GUI:
The main menu GUI displays TCard information and QR Code of the user in the centre of the screen:
TCARD:
- UTORid
- Legal name
- ID number
- Photo ID (if one has been provided)
QR CODE:
- Status
- Year
- Department

At the bottom of the screen, there is a bar displaying the following options:
- Account Menu
- Facilities Menu
- Log out

At the top of the screen, there is a bar displaying a “UCheck” option.

### GUI - Account menu:
Selecting the “Account” option navigates to a menu that displays the user's information. If the user's status is student,
the information that is displayed is:
- Legal name
- UTORid
- Status
- Student number
- Email
- Program of study
- Year of study

If the user's status is faculty, the information that is displayed is:
- Legal name
- UTORid
- Status
- Personnel number
- Email
- Department
- Years at U of T

Within the account menu, there are options:
- "change password"

Selecting the “change password” option allows users to change their password. Users are first prompted to enter their 
current password, then they are navigated to a screen with two fields (if the password they entered is correct):
"new password" and "confirm new password". Typing in your desired new password in both of these fields changes the user's
password.


### GUI - Facilities menu:
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

### GUI - UCHECK menu
We need to be able to identify whether a user has done Ucheck (or fully vaccinated or has an exemption) or not. If the
user is fully vaccinated and has done their Ucheck, the background color of the main menu GUI should be green, and red
otherwise.

Users should be able to upload their vaccination receipt or other documents to their profile.

Users should be able to complete Uchek through the app every day.

The Ucheck status of the user renews every day(or every 24 hours). Once the Ucheck expires, the app will notify the user to renew their Ucheck status.

On the main menu GUI, users can swipe left or right to change to different GUIs to show their Ucheck result or 
vaccination receipt. (There will be two GUIs, one for Ucheck and one for the vaccine. And any modification of the 
Ucheck or vaccine can be done through their GUIs).

