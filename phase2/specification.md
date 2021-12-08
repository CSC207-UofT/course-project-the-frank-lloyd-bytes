# TCard App Specification

Consider the following description of a software system that facilitates a virtual TCard to be used by students and
faculty members at the University of Toronto.

### Login and register:
There are two types of users of this app: students and faculty members. You can log in to the app using a registered
UTORid and password. If you are not yet registered, you may register a new account for yourself. To register, you are
required to provide the following information:
- UTORid (your username)
- Password
- Legal name
- Status: student or faculty
- U of T email
- TCard number
- Associated department
- Number of years at U of T

After logging in, you are taken to the main menu of the app.

### Main menu:
In the centre of the screen, your tcard information (UTORid, legal name, TCard number, photo ID) as well as a unique
QR code. Scanning this QR code will tell you the status, year, and department of the user associated with it. Within
the main menu, you also see options that you may select to navigate to different menus:
- Profile
- Facilities
- Merchants
- Log out
- Complete UCheck

### Profile menu:
The profile menu displays all of your user specific information:
- Legal name
- UTORid
- TCard number
- Status
- Department
- Year

You are given an option to change your password and upload/change your profile picture with a picture from your phone
gallery.

### Facilities menu:
The facilities menu displays a list of the major facilities at the University of Toronto, such as Robarts library or
the Bahen centre. Each list item displays the following information for a facility:
- Name
- Address
- Hours

Each list item also displays a button “Check facility access”. Each facility has their own list of criteria that
describes which students and faculty members at U of T are granted TCard access. Selecting the “Check facility access”
button for a given facility runs a check to see if you satisfy their criteria, then displays a message describing the
result.

### Merchants menu:
The merchants menu displays a list of campus stores and food outlets that are TCard compatible. For example, the U of T
bookstore or Cafe Reznikoff. Each list item displays the following information for a merchant:
- Name
- Address
- Hours

Each list item also displays a button “See your discounts”. Each merchant has a list of discounts that they offer. Each
discount has its own list of criteria that describes which students and faculty members at U of T the discount applies
to. Selecting the “Check facility access” button for a given facility runs a check to see which discounts offered by
the merchant are applicable to you, then displays a message describing the result.

### UCheck:
The UCheck menu allows quick and easy access for users to complete the UCheck quiz as well as show their UCheck results.
Students and faculty at U of T are required to complete this quiz frequently and have a green UCheck result before
coming to campus. If you have not completed your quiz, you can complete it in this menu. After you complete the quiz,
your UCheck result will be displayed on the screen in this menu for the next 24hrs. Once this 24hrs is up, your UCheck
result is no longer valid, and you are required to complete the quiz again to get a result.

