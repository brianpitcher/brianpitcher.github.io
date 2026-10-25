[← Back to Portfolio](README.md)

# Software Design and Engineering

## Artifact Overview

For my Software Design and Engineering enhancement, I selected my CS 320 project. The original project contains separate services for managing contacts, tasks, and appointments. Each service stores and manages its own type of record and provides operations for adding, updating, deleting, and retrieving information.

The original project demonstrated object oriented programming, data validation, service classes, and automated testing. However, the three services operated mostly as separate parts of the project rather than as one complete application.

## Enhancement

For Enhancement One, I connected the Contact, Task, and Appointment services through a single menu driven application.

The enhanced application allows a user to choose which type of information they want to manage and then perform operations such as adding, viewing, updating, or deleting records. I kept the existing service and model classes while adding an application layer that coordinates the different parts of the project.

I also improved input and error handling so that invalid selections or missing records could be handled more consistently. Testing was used throughout the enhancement to confirm that the existing functionality continued to work after the services were integrated.

The goal of this enhancement was to turn the original collection of separate services into a more complete and usable application without replacing the structure that was already working.

## Skills Demonstrated

This enhancement demonstrates skills in:

- Object oriented programming
- Software organization and integration
- Input validation and error handling
- Application design
- Debugging and testing
- Maintaining existing functionality while expanding a project

The enhancement primarily supports Course Outcomes 3 and 4. It required me to evaluate the design of an existing program, decide how its components could work together more effectively, and use appropriate programming techniques to create a more useful application.

## Original and Enhanced Artifacts

### Original Artifact

The original artifact shows the CS 320 project before the capstone enhancements were completed.

[Download Original CS 320 Artifact](artifacts/software-design/Original-CS320-Artifact.zip)

### Enhanced Artifact

The enhanced artifact contains the completed Software Design and Engineering enhancement, including the integrated application used to manage contacts, tasks, and appointments.

[Download Enhancement One](artifacts/software-design/Enhancement-One.zip)

## Enhancement Narrative

The artifact I selected for my software design and engineering enhancement is a Java project that I originally created in CS 320 Software Testing, Automation, and Quality Assurance. The project was designed to manage contacts, tasks, and appointments through separate classes and services. Each section allowed information to be created, updated, deleted, and retrieved while also using validation rules to prevent invalid information from being stored. The original project was created during my CS 320 course and mainly focused on building and testing the individual services. For CS 499, I returned to this project and expanded it into a more complete application by connecting the separate parts together and improving how the program handles user input and errors.

I selected this artifact because it gave me a good opportunity to improve a project that already had a solid foundation while also showing how much I have learned since I first created it. The original project worked, but the contact, task, and appointment sections were mostly separate from each other. For the enhancement, I connected all three parts into one application with a main menu that allows the user to choose which type of information they want to manage. I also added separate menus for contacts, tasks, and appointments so the program is easier to use and the code stays organized. This improvement helped the project feel more like a complete application instead of several separate assignments placed together.

This artifact also demonstrates several skills I have developed in software development. I used object oriented programming to keep the different parts of the application separated by responsibility while still allowing them to work together through the main program. I improved input validation and error handling so the program responds better when a user enters invalid information or tries to access a record that does not exist. I also fixed inconsistencies in the appointment service and corrected the task tests so they use the task IDs that are actually created by the program. I continued using unit tests throughout the project and tested the full application after making the changes. These improvements made the program easier to use, easier to understand, and more reliable while still keeping the basic structure of the original project.

I believe I met the course outcomes that I originally planned to address with this enhancement. The first outcome I focused on was designing and evaluating a computing solution using appropriate computer science practices. I worked toward this outcome by reviewing the structure of the original project, identifying areas that could be improved, and making changes that made the program more complete and easier to use. Instead of replacing the existing structure, I kept the parts that already worked well and improved how the different sections connected to each other. This helped me think more carefully about how design choices affect the overall quality of a program.

I also made progress toward the outcome that focuses on using computing techniques, skills, and tools to create useful solutions. I demonstrated this by adding the main application, improving input handling, making the services more consistent, and correcting problems in the existing tests. I also used unit testing to confirm that the updated project continued to work correctly after the changes were made. At this point, I do not think I need to change my original outcome coverage plan for this enhancement. I still believe Outcomes 3 and 4 are the best match because the work focused mainly on improving the design, organization, usability, and reliability of the application.

The process of enhancing this artifact helped me see the difference between simply making a program work and improving the way the program is organized and used. One of the main things I learned was how important it is to look at an existing project as a whole instead of only focusing on individual classes. The original contact, task, and appointment services worked on their own, but connecting them together showed me how different parts of a program need to work with each other in a clear and consistent way. I also learned more about handling user input, checking for errors, and making the program respond in a way that makes sense when something goes wrong.

One of the biggest challenges was improving the project without changing too much of the original structure. I wanted to keep the parts that already worked while still making the application feel more complete. I also had to fix differences between the services, such as how missing records were handled and how appointment updates worked. Testing was important because every change had the possibility of causing a problem somewhere else in the program. Working through these challenges helped me become more comfortable reading older code, finding areas that could be improved, and making changes without starting the project over from the beginning. Overall, this enhancement helped me build more confidence in improving and organizing existing software.

### Download Narrative

A Word document version of the narrative is also available below.

[Download Enhancement One Narrative](documents/Enhancement-One-Narrative.docx)

---

[← Back to Portfolio](README.md)
