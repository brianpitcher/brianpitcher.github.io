# Brian Pitcher
# CS-340

from pymongo import MongoClient

class AnimalShelterCRUD:
    def __init__(self, username, password, host, port, database, collection):
      """ Initialize MongoDB connection """
      USER = username
      PASS = password
      HOST = host
      PORT = port
      DB = database
      COL = collection
      self.client = MongoClient('mongodb://%s:%s@%s:%d' % (USER,PASS,HOST,PORT))
      self.database = self.client['%s' % (DB)]
      self.collection = self.database['%s' % (COL)]
        
    def create(self, data):
        """ Insert a document into MongoDB """
        try:
            result = self.collection.insert_one(data)
            return True if result.inserted_id else False
        except Exception as e:
            print(f"Error inserting document: {e}")
            return False
        
    def read(self, query):
        """ Query documents from MongoDB """
        try:
            cursor = self.collection.find(query)
            return list(cursor)  # Convert cursor to list of documents
        except Exception as e:
            print(f"Error querying document: {e}")
            return []
          
    def update(self, query, new_data):
        """ Update document in MongoDB """
        try:
          result = self.collection.update_many(query, {'$set': new_data})
          return result.modified_count
        except Exception as e:
          print(f"An error occured: {e}")
          return 0
        
    def delete(self, query):
      try:
        result = self.collection.delete_many(query)
        return result.deleted_count
      except Exception as e:
        print(f"An error occured: {e}")
        return 0
