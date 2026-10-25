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

The Enhancement Two narrative explains why I selected this artifact for the Algorithms and Data Structures category, how I expanded the existing collections, the challenges I encountered, what I learned during development, and how the enhancement aligns with the CS 499 course outcomes.

[Download Enhancement Two Narrative](documents/Enhancement-Two-Narrative.docx)

---

[← Back to Portfolio](README.md)
