[← Back to Portfolio](README.md)

# Databases

## Artifact Overview

For my Databases enhancement, I selected my Animal Shelter Dashboard and MongoDB CRUD project from CS 340: Client/Server Development. The project was developed for a fictional organization called Grazioso Salvare and was designed to help identify animals that could be candidates for different types of search and rescue training.

The original project uses Python, MongoDB, Pandas, and the Dash framework. It contains an `AnimalShelterCRUD` class for communicating with MongoDB and an interactive dashboard that displays animal shelter records in a table, chart, and geographical map.

Although the original project included MongoDB, the dashboard still loaded the animal shelter dataset directly from a CSV file into Pandas and performed most of its filtering on that local data. This meant the database and dashboard existed in the same project but were not fully integrated.

## Enhancement

For Enhancement Three, I redesigned the way data moves through the application so that MongoDB became the primary source for retrieving and filtering animal shelter records.

I added a database loading program that imports the animal shelter CSV data into MongoDB. The loader checks whether the database already contains records before performing the import so that running it again does not create duplicate records.

The dashboard was then changed so that user selections are converted into MongoDB query conditions and sent through the `AnimalShelterCRUD` class. Instead of loading the complete CSV file and applying the main search filters locally, the dashboard requests the matching records from MongoDB.

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

The Enhancement Three narrative explains why I selected this artifact, how MongoDB was integrated more completely into the dashboard, the challenges I encountered during development and testing, the skills demonstrated by the enhancement, and how the completed work aligns with the CS 499 course outcomes.

[Download the Enhancement Three Narrative](documents/Enhancement-Three-Narrative.docx)

---

[← Back to Portfolio](README.md)
