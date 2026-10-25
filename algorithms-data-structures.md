[← Back to Portfolio](README.md)

# Algorithms and Data Structures

## Artifact Overview

For my Algorithms and Data Structures enhancement, I used the same CS 320 project that I enhanced for Software Design and Engineering. This time, I focused on how the application stores, searches, and organizes contacts, tasks, and appointments.

The project uses `HashMap` collections to store each type of record. Each record has a unique ID that is used as the key, allowing the application to quickly retrieve a specific contact, task, or appointment when the ID is known.

Although this worked well for direct ID based access, the original application provided limited ways to find or organize records when the user did not already know the ID.

## Enhancement

For Enhancement Two, I expanded the application by adding search and sorting functionality.

The existing `HashMap` collections were kept because they already worked well for retrieving records by their unique IDs. Instead of replacing the existing data structure, I added new algorithms that work with the records stored inside it.

Search operations examine the stored records and return a list of matches based on information entered by the user. This gives the user additional ways to find information without requiring the exact record ID.

I also added sorting operations that convert the values stored in the `HashMap` into a `List` that can be ordered using Java collection tools.

The completed enhancement allows:

- Contacts to be sorted by last name and then first name
- Tasks to be sorted by task name
- Appointments to be sorted by appointment date
- Records to be searched using useful information in addition to their IDs

These changes expanded the usefulness of the existing data structures while keeping the implementation understandable and appropriate for the size of the application.

## Skills Demonstrated

This enhancement demonstrates skills in:

- Java collections
- `HashMap` and `List` data structures
- Searching through collections
- Sorting records
- Comparing and organizing data
- Algorithm design
- Testing and debugging
- Evaluating tradeoffs in an existing solution

The enhancement primarily supports Course Outcomes 3 and 4. I evaluated the existing data structure and decided that replacing the `HashMap` was unnecessary because it already worked well for direct ID access. Instead, I expanded the application by adding algorithms that provide additional ways to search and organize the stored information.

## Original and Enhanced Artifacts

### Original Artifact

The original artifact shows the CS 320 project before the capstone enhancements were completed.

[Download Original CS 320 Artifact](artifacts/algorithms-data-structures/Original-CS320-Artifact.zip)

### Enhanced Artifact

This artifact contains the completed Algorithms and Data Structures enhancement with the added search and sorting functionality.

[Download Enhancement Two](artifacts/algorithms-data-structures/Enhancement-Two.zip)

## Enhancement Narrative

The artifact I selected for my algorithms and data structure enhancement is the same Java project that I originally created in CS 320 Software Testing, Automation, and Quality Assurance. The project manages contacts, tasks, and appointments through separate classes and services. I first created the project during my CS 320 course, and I later improved it during the first enhancement in CS 499 by connecting the different services into one complete application. For the second enhancement, I continued building on that same project by improving how the program searches, organizes, and displays the information stored in the application.

I selected this artifact because it already used data structures in a way that gave me a good starting point for making the program more useful. The original services stored contacts, tasks, and appointments in HashMaps, which worked well when the program needed to find a specific record by its ID. However, the program did not give the user many options for finding or organizing information if the ID was not already known. This made the project a good choice for showing how I could build on an existing structure instead of replacing it completely.

For this enhancement, I added search and sorting features for all three types of records. Contacts can be searched by name and sorted by last name and then first name. Tasks can be searched and sorted by task name, while appointments can be searched by description and sorted by date. The program keeps the HashMaps for storing the records, but it also creates lists when records need to be searched through or placed into a specific order. This helped me demonstrate that different data structures can be useful for different purposes within the same program. The enhancement improved the application by giving the user more ways to find and organize information, while still keeping the functionality that was added during the first enhancement.

I believe I met the course outcomes that I originally planned to address with this enhancement. The main outcome I focused on was designing and evaluating computing solutions using algorithms and data structures. I worked toward this outcome by keeping the existing HashMaps for storing records by ID and adding lists for searching and sorting information. This gave me a better understanding of how different data structures can be used for different purposes. I also added search methods that check stored records for matches and sorting methods that organize contacts, tasks, and appointments in useful ways.

I also made progress toward the outcome that focuses on using computing techniques, skills, and tools to create useful solutions. The new search and sorting features made the application easier to use because the user is no longer limited to finding records only by their ID. I was able to add this functionality without removing the features from the first enhancement, which helped the project continue to grow as one complete application. At this point, I do not think I need to change my original outcome coverage plan. Outcome 3 is still the strongest match for this enhancement, while Outcome 4 is also supported by the way I used Java collections, testing, and programming techniques to improve the usefulness of the application.

The process of enhancing this artifact helped me better understand how algorithms and data structures affect the way a program handles information. One of the main things I learned was that a data structure that works well for one purpose may not be the best choice for every task. The HashMaps were still useful for storing records and finding them by ID, but lists worked better when I needed to search through several records or sort them into a specific order. Seeing both of these structures work together in the same application helped make the purpose of each one easier for me to understand.

One of the biggest challenges was adding the new search and sorting features without changing or breaking the functionality from the first enhancement. I wanted the existing contact, task, and appointment menus to continue working the same way while adding new ways for the user to find and organize records. I also had to think about how each type of record should be searched and sorted so the results would be useful. Testing each service separately and then testing the full application helped me find problems early and made it easier to confirm that the new features worked correctly. Overall, this enhancement helped me become more comfortable working with collections, searching through data, sorting information, and building new features on top of an existing project.

### Download Narrative

A Word document version of the narrative is also available below.

[Download Enhancement Two Narrative](documents/Enhancement-Two-Narrative.docx)

---

[← Back to Portfolio](README.md)
