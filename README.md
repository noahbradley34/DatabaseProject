# DatabaseProject

Hello, welcome to my Database Project for Oakland University's CSI 3450 database desgin and implementation course.

This project centers around NCAA Men's Basketball, and through the use of a UI and Database, a user can access statistics for the
2018 - 2019 season.

The UI was built in Netbeans IDE 8.2, while the database was built in mySQL Workbench 8.0 CE.

Attached as well is the several excel files used as a "middle man" approach to importing the data into mySQL. They are not
a download requirment.

System requirments:
  
  Netbeans IDE 8.2, 
  Javafx plugin, which can be installed within Netbeans,   
  mySQL Workbench 8.0 CE, 
  mySQL JBDC Driver, which can be installed within Netbeans

Back End Steps:

Download the nbproject folder, src folder, and the mySQLDump file. Using mySQL Workbench, do a data import on the mySQLDump file. Now open Netbeans and open and save the src and nbproject into a project folder. Once this is done, please download the two plugin's listed in the System requirments. Once everything is installed and downloaded, please turn on the database connection within mySQL, followed by conncecting to it within netbeans through the Services tab. The database and UI should now be connected.

User Manual:

After executing the application, you will arrive to the "Teams" page, where you will see a list of teams and their respective attributes. You can order the table by clicking on any attribute at the top of the table. If you would like to search for a specific school, type into the search bar and click "Search", if you want to see the teams that belong to a specific conference, type in the conference name and click "Conf Search". You can navigate through the application using the drop down menu in the upper left hand corner, with this you can select Coaches, Players, or a March Madness table. Within these tables, the same functions apply, in that you can order by attribute, or search by a name.

