# Brian Pitcher
# CS-499

# os is used to build the path to the CSV file.
import os

# pandas is used to read and convert the CSV data
import pandas as pd

# Import the CRUD class used to communicate with MongoDB
from aac_crud import AnimalShelterCRUD


# Connect to the local MongoDB database.
db = AnimalShelterCRUD()


# Check how many animal records are already stored.
record_count = db.count()


# Only load the CSV if the database is currently empty.
if record_count == 0:

    print(
        "Database is empty."
    )

    print(
        "Loading animal shelter data..."
    )

    # Build the path to the CSV file in this project.
    file_path = os.path.join(
        os.path.dirname(__file__),
        "aac_shelter_outcomes.csv"
    )

    # Load the CSV file into a Pandas DataFrame.
    df = pd.read_csv(
        file_path
    )

    # Remove the extra CSV index column if it exists.
    if "Unnamed: 0" in df.columns:

        df.drop(
            columns=[
                "Unnamed: 0"
            ],
            inplace=True
        )

    # Convert each row of the DataFrame into a dictionary
    # that can be inserted into MongoDB.
    records = df.to_dict(
        orient="records"
    )

     # Insert all animal records into MongoDB.
    inserted_count = db.create_many(
        records
    )

    # Display how many records were added.
    print(
        "Records added:",
        inserted_count
    )

else:

    # Skip the import if records are already stored.
    # This prevents duplicate animal records.
    print(
        "Database already contains",
        record_count,
        "records."
    )

# Display the final number of records in MongoDB.
print(
    "Total records in database:",
    db.count()
)

