cns2450-teamname
==============

Members
-----------

Name: Brian Rodham
Email: rodhambrian@yahoo.com
Phone: 801-669-2078

Name: Austin Williams
Email: austinwilliams@gmail.com
Phone: 801-471-8028

Name: Frank Hadrian
Email: vivoon29@gmail.com
Phone: 801-755-5012

Name: Shariann Stagg
Email: thezerothcat@hotmail.com
Phone: 801-885-4480

Name: James Jacobson
Email: shames@intogeek.com
Phone: 435-709-1095

Name: Wyatt Penrod
Email: wyattpenrod@softekeng.com
Phone: 801-615-1957

GPS Tracker Requirements
----------------

GPS Tracker is a new product that gives Android users the ability to track the distances they travel from their mobile devices and then view them from a web browser. The product is logically divided into two sides, the Android side and the Server Side.
* (FR) are functional requirements that must be included in the roadmap.
* (NF) are non-functional requirements, like supported platform and browser versions.

### Android Side
The Android side of this project consists of three components: the GPS Tracker Application (referred to as “application”), the GPS Tracker Service (referred to as “service”), and the GPS Tracker Database (referred to as “database” and which is used to locally store the location data gathered by the service).

1. (FR) GPS Tracker Application - The Android application that the user runs to create a new tracking session, starting and stopping the service, and sending the gathered session data to the server.
    1. (NF) Will run on Android 2.3.3 (Honeycomb)
    2. (FR) When the application is launched, the user is presented with a text field with the prompt “Enter GPS Tracking Session Name” and a button “Create Session”
    3. (FR) When a name has been provided in the text field and the user clicks “Create Session”, the user is brought to a new activity screen:
        1. (FR) When the service is not running, a “Start” button appears and, when pressed, starts the service.
        2. (FR) When the service is running, a “Stop” button appears and, when pressed, stops the service.
        3. (FR) The “End Session” button appears below the Start or Stop button. Pressing this button will:
            1. (FR) End the current session. If pressed when the service is running, it will also terminate the service and end the session.
            2. (FR) Gather location data from service’s local database and calculates mileage traversed for the ended session using android’s API’s to google maps.
            3. (FR) Send session data to the server’s database.
            4. (FR) Delete session data from local database. 
2. (FR) GPS Tracker Service - The service that actually polls the LocationManager API for GPS location and writes it to a local database
    1. (NF) Will run on the android device “behind the scenes”
    2. (NF) Is started by the GPS Tracker Application
    3. (NF) Is terminated by the GPS Tracker Application
    4. (FR) Gathers GPS location from LocationManager API whenever location has changed by more than 20 feet and 10 seconds.
    5. (FR) Writes new location data into local database (SQLite)
3. GPS Tracker Local Database - Stores location and timestamp and other identifiers for the duration of the session.
    1. (NF) Implemented using SQLite
    2. (FR) Schema: SessionID (index starting with 0), PhoneID, SessionName, GPSCoordinates, Timestamps

### Server Side
The server side of this project consists of two components: User Interface (involving user authentication and the display of tracked GPS sessions) and Data Storage (containing user account information and tracked GPS sessions).

1. (FR) User Interface - User Authentication - The login access page
    1. (FR) User Authentication
        1. (FR) When the home page is loaded, the user is presented with Username and Password fields and a Login button. A button to “Create User” is also provided.
    2. (FR) Registering new users
        1. (FR) When clicking the Create User button, the user is provided four text fields and a button: Username, PhoneID, two password fields (for verification) and a Register button.
        2. (FR) When Register is clicked, the username and phoneid are checked for uniqueness in the GPSUser table of the database and passwords are checked to match. If they all pass, then a new row is inserted into the GPSUser table and the user is automatically logged in.
2. (FR) User Interface - After login has successfully occurred:
        1. (FR) Automatically display the most recent GPS Tracker session’s data in table format.
        2. (FR) Provide a way to select and view previous sessions.
3. Data Storage - The database that listens for and stores the data sent from the android application.
    1. (FR) Data storage will exist in a MySQL database on the server and will consist of two tables: GPS-Users and GPS-Sessions.
    2. (FR) GPS-Users table schema: Username, PhoneID, Password
    3. (FR) GPS-Sessions table schema: SessionID, PhoneID, SessionName, GPSCoordinates, Timestamps

Roadmap
-------------------

Feature numbers are referenced hierarchically and are prepended with AS or SS to indicate Android Side or Server Side.

### September
* Deliverable 1 - SS-3 and all subrequirements - Implement server side database
* Deliverable 2 - AS-3 and all subrequirements - Implement GPS tracker local database on android

### October
* Deliverable 3 - SS-1 and all subrequirements - User Interface/User Authentication
* Deliverable 4 - AS-2 and all subrequirements - GPS Tracker Service

### November
* Deliverable 5 - GPS Tracker Application features:
    * AS-1.2 - UI and functionality for creating new tracking session
    * AS-1.3.1 - Start button that starts service
    * AS-1.3.2 - Stop button that stops service
* Deliverable 6 - AS-1.3.3 and all subrequirements - session control and mileage calculations

### December
* Deliverable 7 - SS-2 and all subrequirements - Display of mileage on website
 
Task Assignments
------------------

* Deliverable 1 - ___ & ___
* Deliverable 2 - ___ & ___
* Deliverable 3 - ___ & ___
* Deliverable 4 - ___ & ___
* Deliverable 5 - ___ & ___
* Deliverable 6 - ___ & ___
* Deliverable 7 - ___ & ___