# Brian Pitcher
# CS-499

# MongoClient allows the program to connect to MongoDB.
from pymongo import MongoClient


# Handles the database operations used by the animal shelter application.
class AnimalShelterCRUD:

    def __init__(self,
                 host="localhost",
                 port=27017,
                 database="AAC",
                 collection="animals"):

        """ Initialize MongoDB connection """

        # Connect to the local MongoDB server
        self.client = MongoClient(
            host,
            port
        )

        # Select the AAC database.
        self.database = self.client[
            database
        ]

        # Select the animals collection inside the database.
        self.collection = self.database[
            collection
        ]


    def create(self, data):
        """ Insert a document into MongoDB """

        try:

            # Insert one animal record into the collection.
            result = self.collection.insert_one(
                data
            )

            # Return True if MongoDB created an ID for the record.
            return True if result.inserted_id else False

        except Exception as e:

            # display the error and report that the insert failed.
            print(
                f"Error inserting document: {e}"
            )

            return False


    def create_many(self, data):
        """ Insert multiple documents into MongoDB """

        try:

            # Make sure there is data to insert
            if not data:

                return 0

            # Insert all records into the collection
            result = self.collection.insert_many(
                data
            )

            # Return the number of records that were added
            return len(
                result.inserted_ids
            )

        except Exception as e:

            # Display the error and report that no records were added
            print(
                f"Error inserting documents: {e}"
            )

            return 0


    def read(self, query):
        """ Query documents from MongoDB """

        try:

            # Search the collection using the supplied MongoDB query
            cursor = self.collection.find(
                query
            )

            # Convert the MongoDB cursor into a list of records
            return list(
                cursor
            )

        except Exception as e:

            # Display the error and return an empty list
            print(
                f"Error querying document: {e}"
            )

            return []


    def update(self, query, new_data):
        """ Update documents in MongoDB """

        try:

            # Find matching records and update the supplied fields.
            result = self.collection.update_many(
                query,
                {
                    '$set':
                        new_data
                }
            )

            # Return the number of records that were changed.
            return result.modified_count

        except Exception as e:

            # Display the error and report that nothing was updated.
            print(
                f"An error occurred: {e}"
            )

            return 0


    def delete(self, query):
        """ Delete documents from MongoDB """

        try:

            # Delete all records that match the supplied query.
            result = self.collection.delete_many(
                query
            )

            # Return the number of records that were deleted.
            return result.deleted_count

        except Exception as e:

            # Display the error and report that nothing was deleted.
            print(
                f"An error occurred: {e}"
            )

            return 0


    def count(self):
        """ Return the number of documents in the collection """

        try:

            #  Count every animal record currently stored.
            return self.collection.count_documents(
                {}
            )

        except Exception as e:

            # Display the error and return zero if counting fails.
            print(
                f"Error counting documents: {e}"
            )

            return 0

