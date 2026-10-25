[← Back to Portfolio](README.md)

# Databases

## Artifact Overview

For my Databases enhancement, I selected my Animal Shelter Dashboard and MongoDB CRUD project from CS 340: Client/Server Development. The project was developed for an organization called Grazioso Salvare and was designed to help identify animals that could be candidates for different types of search and rescue training.

The original project uses Python, MongoDB, Pandas, and the Dash framework. It contains an AnimalShelterCRUD class for communicating with MongoDB and an interactive dashboard that displays animal shelter records in a table, chart, and geographical map.

Although the original project included MongoDB, the dashboard still loaded the animal shelter dataset directly from a CSV file into Pandas and performed most of its filtering on that local data. This meant the database and dashboard existed in the same project but were not fully integrated.

## Enhancement

For Enhancement Three, I redesigned the way data moves through the application so that MongoDB became the primary source for retrieving and filtering animal shelter records.

I added a database loading program that imports the animal shelter CSV data into MongoDB. The loader checks whether the database already contains records before performing the import so that running it again does not create duplicate records.

The dashboard was then changed so that user selections are converted into MongoDB query conditions and sent through the AnimalShelterCRUD class. Instead of loading the complete CSV file and applying the main search filters locally, the dashboard requests the matching records from MongoDB.

The original rescue categories were preserved:

- Water Rescue
- Mountain and Wilderness Rescue
- Disaster and Individual Rescue

I also added additional search options for:

- Animal Type
- Breed
- Sex
- Age Range

These filters can be combined so the user has more control over the records returned by the database.

The dashboard also provides summary information showing the number of matching animals and the most common breed in the current results. The table includes clearer column names, sorting, and filtering, including an Age in Weeks field that can be used for accurate numeric age sorting.

The Breed Distribution chart provides a visual summary of the current results, while the geographical map updates when the user selects an animal from the table.

Together, these changes make MongoDB an active part of the application instead of only an additional component connected in the background.

## Skills Demonstrated

This enhancement demonstrates skills in:

- MongoDB
- Python
- PyMongo
- CRUD operations
- Database integration
- Dynamic database queries
- Data processing
- Dash application development
- Data visualization
- Filtering and sorting
- Debugging and testing
- User interface improvements
- Connecting the database, application logic, and interface

The enhancement primarily supports Course Outcomes 3 and 4. I evaluated the way the original application handled its data and redesigned the flow so that the persistent database became the main source for searches. I also used database and application development tools together to create a more useful and complete software solution.

## Original and Enhanced Artifacts

### Original Artifact

The original artifact contains the CS 340 Animal Shelter Dashboard and CRUD code before the database enhancement. It demonstrates MongoDB connectivity and dashboard functionality, but the dashboard performs most of its data loading and filtering directly from the CSV dataset.

[Download the Original CS 340 Artifact](artifacts/databases/Original-CS340-Artifact.zip)

### Enhanced Artifact

The enhanced artifact contains the completed database driven version of the Animal Shelter Dashboard. It includes the MongoDB CRUD class, database loader, enhanced dashboard, animal shelter dataset, and package requirements.

[Download Enhancement Three](artifacts/databases/Enhancement-Three.zip)

## Enhancement Narrative

The artifact I selected for my database enhancement is the Animal Shelter Dashboard and MongoDB CRUD project that I originally created during CS 340: Client/Server Development. The project was developed for a fictional organization called Grazioso Salvare and was designed to help identify animals that could be good candidates for search and rescue training. The project uses Python, MongoDB, and the Dash framework. It includes a CRUD class that communicates with the MongoDB database and an interactive dashboard that allows users to view animal records, apply rescue filters, view a breed chart, and see the location of selected animals on a map. I selected this project for Enhancement Three because it already included both database operations and a user interface, which gave me a good opportunity to improve how those parts of the application work together.

I selected this artifact for my ePortfolio because it shows my ability to work with databases, application logic, and an interactive user interface in the same project. The original version already included a MongoDB CRUD class and a working dashboard, but the two parts were not fully connected. Even though the project had a database connection, the dashboard still loaded most of its data directly from a CSV file and used Pandas to perform the filtering. I saw this as a good opportunity to improve the project by making MongoDB the main source of data for the application. This made the artifact a stronger example of a database driven application and better demonstrated the skills I developed throughout the Computer Science program.

The enhancement improved the project by importing the animal shelter records into MongoDB and changing the dashboard so that user selections are converted into database queries. I kept the original rescue categories and added filters for animal type, breed, sex, and age range. The dashboard now sends these conditions through the CRUD class and retrieves only the matching records from MongoDB. I also added summary information that shows the number of matching animals and the most common breed. The table was improved with clearer column names and better organization, while the chart and map continue to update based on the current results. Through these changes, I demonstrated skills with Python, MongoDB, database queries, CRUD operations, data processing, debugging, and connecting different parts of an application together. The enhancement also made the dashboard easier to use and gave the user more control over the information being displayed.

One of the biggest things I learned from this enhancement was how important it is for different parts of an application to work together instead of existing as separate pieces. In the original project, the MongoDB database and CRUD class were present, but the dashboard still relied heavily on the CSV file and local Pandas filtering. Changing the program so that the dashboard builds MongoDB queries and retrieves records through the CRUD class helped me better understand how the database layer, application logic, and user interface connect to each other. I also became more comfortable working with MongoDB query conditions and combining several filters into one search.

There were several challenges while improving the artifact. I had to set up MongoDB locally, verify that the animal shelter data was imported correctly, and make sure the database was not loaded with duplicate records. I also had to adjust the dashboard so that the original rescue filters still worked while allowing the new animal type, breed, sex, and age filters to be used at the same time. During testing, I found smaller usability problems that I had not noticed at first. For example, negative age values appeared in the dataset, the age text column did not sort animals correctly, some table labels were difficult to read, and the breed chart title did not always match what was being displayed. I worked through these problems by testing each part of the dashboard and making small changes until the results were easier to understand and behaved as expected.

The feedback and testing process helped improve the artifact beyond my original plan. I changed the minimum age to zero, added a numeric Age in Weeks column for accurate sorting, placed the age columns beside each other, improved the table column names, and changed the chart title to Breed Distribution so that it made sense under different search conditions. I also added comments throughout the code and created a requirements file to make the project easier to understand and run. By the end of the enhancement, the project felt more complete because MongoDB became the main source of data instead of only being connected in the background. This process helped me see how testing and small design improvements can make a large difference in the quality and usability of a software application.

This enhancement most strongly supports Course Outcomes 3 and 4. Course Outcome 3 focuses on designing and evaluating computing solutions while using appropriate computer science practices and considering the tradeoffs involved in design decisions. I believe I met this outcome through the way I redesigned the flow of data in the application. Instead of continuing to rely on a locally loaded CSV file for the dashboard, I changed the project so that MongoDB became the main source used to retrieve and filter animal records. I also had to decide how the different filters would be combined, how the rescue categories would work with the new search options, and how the returned data would be passed to the table, chart, summary, and map. This required me to think about both how the solution worked and how easy it would be to maintain and understand.

The enhancement also supports Course Outcome 4, which focuses on using appropriate tools, techniques, and computing practices to create solutions that provide useful value. I demonstrated this outcome by using Python, MongoDB, PyMongo, Dash, Pandas, Plotly, and the CRUD pattern together in one working application. The finished dashboard gives users more ways to search the animal shelter data and presents the results through several different views. I also improved the usability of the project by adding clearer table headings, more accurate age sorting, summary information, and a cleaner chart. These changes made the application more useful while also showing that I can combine several technologies to solve a practical problem.

### Download Narrative

A Word document version of the narrative is also available below.

[Download the Enhancement Three Narrative](documents/Enhancement-Three-Narrative.docx)

---

[← Back to Portfolio](README.md)
