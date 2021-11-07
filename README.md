# TCard App Specification

Consider the following description of a software system that facilitates a virtual TCard to be used by students and
faculty at the University of Toronto.

### First menu
When you open the app, you are given three options to choose from in the first menu:
- Sign-in
- Register business
- Register facility

Users (i.e. people who use a TCard) access the app by selecting “sign-in”.

###Sign-in:
Selecting the “sign-in” option prompts the user to enter a UTORid and password. If the UTORid and password the user
enters is not registered (i.e. is not in the user database), an error message comes up saying “incorrect UTORid and/or
password” and they cannot access the app. If the UTORid and password the user enters is registered, they are navigated
to the main menu of the app.

###GUI:
The main menu is a GUI that displays the following TCard information of the user in the centre of the screen:
- UTORid
- Legal name
- ID number
- Status: student, faculty

At the bottom of the screen, there is a bar displaying the following menu options:
- Account
- Wallet
- Merchants
- Facilities

###GUI - Account menu:
Selecting the “Account” option navigates to a menu that displays the user's information. If the user's status is student,
the information that is displayed is:
- Legal name
- U of T email
- Program
- Level: undergraduate, graduate

If the user's status is faculty, the information that is displayed is:
- Legal name
- U of T email
- Department
- Position

###GUI - Wallet menu
Selecting the “Wallet” option navigates to a menu that displays three options:
- View account balance
- View transaction history
- Load funds

Selecting the “View account balance” option displays the amount of funds currently on the account to the user.
Selecting the “View transaction history” option diplays the users TCard transaction history, i.e., the type of payment
(deposit, withdrawal), the date the transaction was made, the amount of money. Selecting the “load funds” option prompts
the user to enter an amount of money, which is added to the user's account balance after confirming.

###GUI - Merchants menu:
Selecting the “Merchants” option navigates to a menu that displays a list of all TCard-compatible merchants
at U of T. For each merchant, the following information is displayed:
- Name
- Address
- Description
- Hours
- Discounts that they offer

###GUI - Facilities menu:
Selecting the “Facilities” option navigates to a menu that displays a list of all the major U of T facilities (e.g.
major U of T buildings, but not rooms within the buildings). For each facility, the following information is displayed:
- Name
- Address
- Description
- Hours

###TCard:
Every user is associated with a unique TCard, which holds a unique bar code and ID number for the user. Every TCard has
a wallet, which deals with all the financial information and transactions of the user's TCard (as described above in
the “GUI - Wallet Menu” section).

Users can use their TCard to make purchases at TCard-compatible merchants by scanning the barcode on their TCard. All
merchants have a list of discounts offered by their business. Each discount has a list of criteria that decide who the
discount applies to. If a user is making a purchase at a merchant, any applicable discounts will automatically be
applied.

Users can also use their TCard to gain access to certain U of T facilities by scanning the barcode on their TCard.
All facilities have a list of criteria that determine which users may be granted access after scanning their TCard.
If a user scans their card and satisfies the facilities criteria, they will be granted access and the entrance will
open. If the user does not satisfy the criteria, the entrance will remain locked.

###Register Merchant
Administrators can register U of T merchants on the app (so that the business and its information will be visible to
users of the app) by selecting the “Register merchant” option in first menu of the app. Selecting this prompts the
administrator to enter an administrator username and password. If the username or password they entered is invalid, an
error message is displayed saying "incorrect username and/or password". If the username and password they entered is
valid, they prompted to input the following information on the merchant:
- Name
- Address
- Description
- Hours
- Discounts that are offered by the business

After this information is entered, the merchant will be visible to users in the “Merchants” menu of the app.

###Register facility
Administrators can register U of T facilities on the app (so that the business and its information will be visible to
users of the app) by selecting the “Register facility” option in first menu of the app. Selecting this prompts the
administrator to enter an administrator username and password. If the username or password they entered is invalid, an
error message is displayed saying "incorrect username and/or password". If the username and password they entered is
valid, they prompted to input the following information on the merchant:
- Name
- Address
- Description
- Hours
- Criteria for access to the facility

After this information is entered, the facility will be visible to users in the “Facility” menu of the app.
