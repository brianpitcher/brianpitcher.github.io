# Brian Pitcher
# CS-499

# math is used to round the maximum animal age
import math

# Dash components are used to build the web dashboard
from dash import Dash
from dash import dcc
from dash import html
from dash import dash_table
from dash.dependencies import Input, Output

# dash_leaflet is used to display animal locations on a map
import dash_leaflet as dl

# pandas is used to organize MongoDB records for tables and charts
import pandas as pd

# plotly is used to create the breed pie chart
import plotly.express as px

# Import the CRUD class used to communicate with MongoDB
from aac_crud import AnimalShelterCRUD


###########################
# Data Manipulation / Model
###########################

# Connect to the local MongoDB database
db = AnimalShelterCRUD()


# Remove MongoDB's internal _id field before sending records to Dash
def clean_records(records):

    # Check each record returned from MongoDB
    for record in records:

        # Remove _id if it exists
        if "_id" in record:
            del record["_id"]

    # Return the cleaned records
    return records


# Find the most common breed in a list of animal records
def find_most_common_breed(records):

    # Store each breed and the number of times it appears
    breed_counts = {}

    # Count each breed
    for record in records:

        # Get the breed from the current animal record
        breed = record.get(
            "breed"
        )

        # Only count valid breed values
        if (
            isinstance(breed, str)
            and breed
        ):

            # Increase the count if the breed is already stored
            if breed in breed_counts:

                breed_counts[
                    breed
                ] += 1

            # add the breed if this is the first time it was found
            else:

                breed_counts[
                    breed
                ] = 1


    # Return None if no breeds were found
    if len(breed_counts) == 0:

        return "None", 0


    # Store the current most common breed and its count
    most_common_breed = "None"
    highest_count = 0


    # Find the breed with the highest count
    for breed in breed_counts:

        if breed_counts[breed] > highest_count:

            most_common_breed = breed

            highest_count = breed_counts[
                breed
            ]


    # Return the breed name and number of matching animals
    return most_common_breed, highest_count


# Retrieve all records so filter options can be created
all_records = db.read({})

# Remove MongoDB's internal IDs
all_records = clean_records(
    all_records
)

# Create a list of the animal types stored in MongoDB
animal_types = []

for record in all_records:

    # Get the animal type from the current record
    animal_type = record.get(
        "animal_type"
    )

    # Only add valid values that are not already in the list
    if (
        isinstance(animal_type, str)
        and animal_type
        and animal_type not in animal_types
    ):

        animal_types.append(
            animal_type
        )

# Put the animal types in alphabetical order
animal_types.sort()


# Create the options for the animal type dropdown
# All is added first so the user can search every animal type
animal_type_options = [

    {
        "label": "All",
        "value": "All"
    }
]

# Add each database animal type to the dropdown
for animal_type in animal_types:

    animal_type_options.append(

        {
            "label": animal_type,
            "value": animal_type
        }
    )


# Create a list of breeds stored in MongoDB
breeds = []

for record in all_records:

    # Get the breed from the current record
    breed = record.get(
        "breed"
    )

    # Only add valid breeds that are not already in the list
    if (
        isinstance(breed, str)
        and breed
        and breed not in breeds
    ):

        breeds.append(
            breed
        )


# Put the breeds in alphabetical order.
breeds.sort()


# Create the options for the breed dropdown.
breed_options = [

    {
        "label": "All",
        "value": "All"
    }
]

# Add each database breed to the dropdown.
for breed in breeds:

    breed_options.append(

        {
            "label": breed,
            "value": breed
        }
    )


# Create a list of sex values stored in MongoDB.
sex_values = []

for record in all_records:

    # Get the sex value from the current record.
    sex = record.get(
        "sex_upon_outcome"
    )

    # Only add valid values that are not already stored.
    if (
        isinstance(sex, str)
        and sex
        and sex not in sex_values
    ):

        sex_values.append(
            sex
        )


# Put the sex values in alphabetical order
sex_values.sort()


# Create the options for the sex dropdown.
sex_options = [

    {
        "label": "All",
        "value": "All"
    }
]

# add each database sex value to the dropdown.
for sex in sex_values:

    sex_options.append(

        {
            "label": sex,
            "value": sex
        }
    )


# Create a list of animal ages stored in MongoDB.
age_values = []

for record in all_records:

    # Get the animal's age in weeks.
    age = record.get(
        "age_upon_outcome_in_weeks"
    )

    # Only store valid numeric age values.
    if (
        isinstance(age, (int, float))
        and not pd.isna(age)
    ):

        age_values.append(
            age
        )

# Start the usable age range at zero weeks
# Negative ages in the original data are not displayed
minimum_age = 0

# Find the oldest animal in the database
# math.ceil rounds the value up to a whole number for the slider
maximum_age = math.ceil(
    max(age_values)
)

# Retrieve the starting dog records from MongoDB
# Negative ages are excluded from the starting results
records = db.read(
    {
        "animal_type": "Dog",

        "age_upon_outcome_in_weeks": {
            "$gte": minimum_age,
            "$lte": maximum_age
        }
    }
)

# Remove MongoDB's internal IDs
records = clean_records(
    records
)

# Find the most common breed in the starting records
starting_common_breed, starting_breed_count = \
    find_most_common_breed(
        records
    )

# Convert the MongoDB records into a DataFrame.
# The DataFrame is used to build the starting table.
df = pd.DataFrame(
    records
)

# Create easier to read names for the table columns
column_names = {

    "animal_id":
        "Animal ID",

    "animal_type":
        "Animal Type",

    "age_upon_outcome":
        "Age",

    "age_upon_outcome_in_weeks":
        "Age in Weeks",

    "breed":
        "Breed",

    "color":
        "Color",

    "date_of_birth":
        "Date of Birth",

    "datetime":
        "Date and Time",

    "monthyear":
        "Month and Year",

    "name":
        "Name",

    "outcome_subtype":
        "Outcome Subtype",

    "outcome_type":
        "Outcome Type",

    "sex_upon_outcome":
        "Sex",

    "location_lat":
        "Latitude",

    "location_long":
        "Longitude"
}


# Set the order that columns appear in the table.
# Age and Age in Weeks are placed beside each other.
table_columns = [

    "animal_id",
    "name",
    "animal_type",
    "age_upon_outcome",
    "age_upon_outcome_in_weeks",
    "breed",
    "color",
    "sex_upon_outcome",
    "date_of_birth",
    "datetime",
    "monthyear",
    "outcome_type",
    "outcome_subtype",
    "location_lat",
    "location_long"
]


# Add any extra database columns that were not listed above
# This prevents a field from being accidentally hidden
for column in df.columns:

    if column not in table_columns:

        table_columns.append(
            column
        )


# Only keep table columns that actually exist in the DataFrame
existing_table_columns = []

for column in table_columns:

    if column in df.columns:

        existing_table_columns.append(
            column
        )


# Display useful startup information in the console
print(
    "Records loaded from MongoDB:",
    len(df)
)

print(
    "Age range:",
    minimum_age,
    "to",
    maximum_age,
    "weeks"
)


#########################
# Dashboard Layout / View
#########################

# Create the Dash application
app = Dash(__name__)


# Build the visible dashboard layout
app.layout = html.Div([

    # Dashboard title
    html.Center(
        html.H1(
            "Grazioso Salvare Dashboard - CS499 - Brian Pitcher"
        )
    ),

    html.Hr(),

    # Rescue category filters
    html.Div([

        html.H3(
            "Rescue Category"
        ),

    # Radio buttons allow one rescue category to be selected
        dcc.RadioItems(

            id="filter-type",

            options=[

                {
                    "label": " Water Rescue ",
                    "value": "Water"
                },

                {
                    "label": " Mountain and Wilderness Rescue ",
                    "value": "Mountain"
                },

                {
                    "label": " Disaster and Individual Rescue ",
                    "value": "Disaster"
                },

                {
                    "label": " No Rescue Filter ",
                    "value": "Reset"
                }
            ],

            # Start without applying a rescue category
            value="Reset"
        )
    ]),

    html.Br(),


    # Animal type filter
    html.Div([

        html.H3(
            "Animal Type"
        ),

        # The choices were created from the MongoDB records
        dcc.Dropdown(

            id="animal-type",

            options=animal_type_options,

            # Start by showing dogs like the original dashboard
            value="Dog",

            clearable=False
        )
    ]),

    html.Br(),


     # Breed filter
    html.Div([

        html.H3(
            "Breed"
        ),

        dcc.Dropdown(

            id="breed",

            options=breed_options,

            # All means no individual breed restriction
            value="All",

            clearable=False
        )
    ]),

    html.Br(),


    # Sex filter
    html.Div([

        html.H3(
            "Sex"
        ),

        dcc.Dropdown(

            id="sex",

            options=sex_options,

            # All means no individual sex restriction
            value="All",

            clearable=False
        )
    ]),

    html.Br(),


    # Age range filter.
    html.Div([

        html.H3(
            "Age Range in Weeks"
        ),

        # RangeSlider allows a minimum and maximum age to be selected.
        dcc.RangeSlider(

            id="age-range",

            min=minimum_age,

            max=maximum_age,

            step=1,

           # Start with the entire usable age range selected.
            value=[
                minimum_age,
                maximum_age
            ],

            # Display the youngest and oldest values on the slider.
            marks={
                minimum_age:
                    str(minimum_age),

                maximum_age:
                    str(maximum_age)
            },

            # Show the selected value while moving the slider.
            tooltip={
                "placement": "bottom",
                "always_visible": False
            },

            # Prevent the minimum slider from crossing the maximum.
            allowCross=False
        )
    ]),

    html.Hr(),



    # Display a summary of the matching records.
    html.Div([

        html.H3(
            "Search Summary"
        ),

        # This area is updated whenever the database filters change
        html.Div(

            id="summary-id",

            children=[

                # Show how many animals currently match
                html.H4(
                    "Matching Animals: "
                    + str(len(df))
                ),

                # Show the most common breed in the results
                html.H4(
                    "Most Common Breed: "
                    + starting_common_breed
                    + " ("
                    + str(starting_breed_count)
                    + " animals)"
                )
            ]
        )
    ]),

    html.Hr(),


    # Display the animal records
    dash_table.DataTable(

        id="datatable-id",

        # Create table columns in the order listed above
        columns=[

            {
                # Use an easier to read name if one was created
                "name": column_names.get(
                    column,
                    column
                ),

                # Keep the original MongoDB field name as the ID
                "id": column,

                "deletable": False
            }

            for column in existing_table_columns
        ],

        # Display the starting animal records
        data=df.to_dict(
            "records"
        ),

        # Records are displayed but cannot be directly edited
        editable=False,

        # Allow the user to type filters into the table
        filter_action="native",

        # Allow the user to sort one column at a time
        sort_action="native",
        sort_mode="single",

        # Allow one animal to be selected for the map
        row_selectable="single",

        # Do not allow records to be deleted from the table
        row_deletable=False,

        # Select the first animal when the table first loads
        selected_rows=[0],

        # Display the data in pages instead of one very long table
        page_action="native",
        page_current=0,
        page_size=10
    ),

    html.Br(),
    html.Hr(),


    # Display the chart and map beside each other
    html.Div(

        className="row",

        # Flex places the graph and map beside each other
        style={
            "display": "flex"
        },

        children=[

            # The breed chart uses half of the available width
            html.Div(
                id="graph-id",

                style={
                    "width": "50%"
                }
            ),

            # The animal location map uses the other half
            html.Div(
                id="map-id",

                style={
                    "width": "50%"
                }
            )
        ]
    )
])




#############################################
# Interaction Between Components / Controller
#############################################

# Update the table and summary whenever a search filter changes
@app.callback(

    # Replace the records displayed in the table
    Output(
        "datatable-id",
        "data"
    ),

    # Replace the information displayed in the summary
    Output(
        "summary-id",
        "children"
    ),

     # Watch the rescue category
    Input(
        "filter-type",
        "value"
    ),

    # Watch the animal type
    Input(
        "animal-type",
        "value"
    ),

    # Watch the breed
    Input(
        "breed",
        "value"
    ),

    # Watch the sex
    Input(
        "sex",
        "value"
    ),

    # Watch the selected age range
    Input(
        "age-range",
        "value"
    )
)
def update_dashboard(
        filter_type,
        animal_type,
        breed,
        sex,
        age_range):

    # Store each MongoDB condition selected by the user
    query_conditions = []


    # Add the selected animal type to the query
    if animal_type != "All":

        query_conditions.append(

            {
                "animal_type":
                    animal_type
            }
        )


    # Add the selected breed to the query
    if breed != "All":

        query_conditions.append(

            {
                "breed":
                    breed
            }
        )


    # Add the selected sex to the query
    if sex != "All":

        query_conditions.append(

            {
                "sex_upon_outcome":
                    sex
            }
        )


    # Always apply the selected age range.
    # This also prevents negative ages from being displayed.
    query_conditions.append(

        {
            "age_upon_outcome_in_weeks": {

                # Age must be greater than or equal to the minimum.
                "$gte":
                    age_range[0],

                # Age must be less than or equal to the maximum.
                "$lte":
                    age_range[1]
            }
        }
    )

    # Add the original Water Rescue requirements.
    if filter_type == "Water":

        query_conditions.append(

            {
                "animal_type": "Dog",

                # Match one of the accepted water rescue breeds.
                "breed": {
                    "$regex":
                        "Labrador Retriever Mix|"
                        "Chesapeake|"
                        "Newfoundland",
                    "$options": "i"
                },

                # Water rescue requires an intact female.
                "sex_upon_outcome":
                    "Intact Female",

                # Water rescue requires the animal to be in this age range.
                "age_upon_outcome_in_weeks": {
                    "$gt": 26,
                    "$lt": 156
                }
            }
        )


    # Add the original Mountain and Wilderness Rescue requirements.
    elif filter_type == "Mountain":

        query_conditions.append(

            {
                "animal_type": "Dog",

                # Match one of the accepted mountain rescue breeds.
                "breed": {
                    "$regex":
                        "German Shepherd|"
                        "Alaskan Malamute|"
                        "Old English Sheepdog|"
                        "Siberian Husky|"
                        "Rottweiler",
                    "$options": "i"
                },

                # Mountain rescue requires an intact male.
                "sex_upon_outcome":
                    "Intact Male",

                # Mountain rescue requires the animal to be in this age range.
                "age_upon_outcome_in_weeks": {
                    "$gt": 26,
                    "$lt": 156
                }
            }
        )


    # Add the original Disaster and Individual Rescue requirements
    elif filter_type == "Disaster":

        query_conditions.append(

            {
                "animal_type": "Dog",

                # Match one of the accepted disaster rescue breeds
                "breed": {
                    "$regex":
                        "Doberman Pinscher|"
                        "German Shepherd|"
                        "Golden Retriever|"
                        "Bloodhound|"
                        "Rottweiler",
                    "$options": "i"
                },

                # Disaster rescue requires an intact male
                "sex_upon_outcome":
                    "Intact Male",

                # Disaster rescue requires the animal to be in this age range
                "age_upon_outcome_in_weeks": {
                    "$gt": 20,
                    "$lt": 300
                }
            }
        )


    # Create the completed MongoDB query
    if len(query_conditions) == 0:

        # An empty query would return every record
        query = {}

    elif len(query_conditions) == 1:

         # Use the condition directly if there is only one
        query = query_conditions[0]

    else:

        # '$and' requires every selected condition to be true
        query = {
            "$and":
                query_conditions
        }


    # Send the completed query through the CRUD class to MongoDB
    results = db.read(
        query
    )

    # Remove MongoDB's internal IDs before displaying the records
    results = clean_records(
        results
    )

    # Calculate the total number of matching records
    matching_count = len(
        results
    )

    # Find the most common breed in the matching records
    most_common_breed, breed_count = \
        find_most_common_breed(
            results
        )

    # Create the updated search summary
    summary = [

        html.H4(
            "Matching Animals: "
            + str(matching_count)
        ),

        html.H4(
            "Most Common Breed: "
            + most_common_breed
            + " ("
            + str(breed_count)
            + " animals)"
        )
    ]


    #  Display the current search information in the console
    print(
        "Filter:",
        filter_type,
        "Animal Type:",
        animal_type,
        "Breed:",
        breed,
        "Sex:",
        sex,
        "Age Range:",
        age_range,
        "Records found:",
        matching_count,
        "Most Common Breed:",
        most_common_breed
    )


    # Update both the table and the summary
    return results, summary


# Display the most common breeds in the current table data
@app.callback(

    # Update the graph area
    Output(
        "graph-id",
        "children"
    ),

    # Use the current table data after filtering and sorting
    Input(
        "datatable-id",
        "derived_virtual_data"
    )
)
def update_graphs(
        view_data):

    # Do not create a chart if there are no matching records
    if view_data is None or len(view_data) == 0:

        return html.P(
            "No data available for chart."
        )


    # Convert the current table records into a DataFrame
    graph_df = pd.DataFrame.from_records(
        view_data
    )

    # Count the number of animals for each breed
    breed_counts = graph_df[
        "breed"
    ].value_counts()


    # Get the 10 most common breeds
    top_breeds = breed_counts.head(
        10
    )


    # Count every breed outside of the top 10
    other_count = breed_counts.iloc[
        10:
    ].sum()


    # Create the data used by the pie chart
    chart_data = pd.DataFrame({

        "Breed":
            top_breeds.index,

        "Count":
            top_breeds.values
    })


    # Group all remaining breeds into one Other category
    if other_count > 0:

        other_data = pd.DataFrame({

            "Breed": [
                "Other"
            ],

            "Count": [
                other_count
            ]
        })


        # Add the Other category to the chart data
        chart_data = pd.concat(

            [
                chart_data,
                other_data
            ],

            ignore_index=True
        )


    # Display the breed information as a pie chart.
    return [

        dcc.Graph(

            figure=px.pie(

                chart_data,

                names="Breed",

                values="Count",

                title=
                    "Breed Distribution"
            )
        )
    ]


# Update the map using the animal selected in the table.
@app.callback(

     # Update the map area.
    Output(
        "map-id",
        "children"
    ),

    # Use the current visible table data.
    Input(
        "datatable-id",
        "derived_virtual_data"
    ),

    # Watch which table row is selected.
    Input(
        "datatable-id",
        "derived_virtual_selected_rows"
    )
)
def update_map(
        view_data,
        selected_rows):

    # Do not create a map if there are no matching records.
    if view_data is None or len(view_data) == 0:

        return html.P(
            "No location data available."
        )


    # Use the first row if the user has not selected an animal.
    if not selected_rows:

        row = 0

    else:

        # Use the row selected by the user.
        row = selected_rows[0]


    # Convert the current table records into a DataFrame.
    map_df = pd.DataFrame.from_dict(
        view_data
    )


    # Prevent an invalid selected row after filters change
    if row >= len(map_df):

        row = 0


    # Get the complete record for the selected animal
    selected_animal = map_df.iloc[
        row
    ]


    # Retrieve the animal's latitude
    latitude = selected_animal[
        "location_lat"
    ]


    # Retrieve the animal's longitude
    longitude = selected_animal[
        "location_long"
    ]


    # Do not create a marker if location information is missing
    if pd.isna(latitude) or pd.isna(longitude):

        return html.P(
            "Location data is not available for this animal."
        )


    # Display the selected animal on the map
    return [

        dl.Map(

            # Set the size of the map
            style={
                "width": "100%",
                "height": "500px"
            },

            # Center the map on the selected animal
            center=[
                latitude,
                longitude
            ],

            # Set the starting zoom level
            zoom=10,

            children=[

                # Display the map tiles
                dl.TileLayer(),

                # Place a marker at the animal's location
                dl.Marker(

                    position=[
                        latitude,
                        longitude
                    ],

                    children=[

                        # Show the breed when the marker is hovered over
                        dl.Tooltip(
                            str(
                                selected_animal[
                                    "breed"
                                ]
                            )
                        ),

                        # Show the animal's name when the marker is selected
                        dl.Popup([

                            html.H3(
                                "Animal Name"
                            ),

                            html.P(
                                str(
                                    selected_animal[
                                        "name"
                                    ]
                                )
                            )
                        ])
                    ]
                )
            ]
        )
    ]


# Start the dashboard only when this file is run directly.
if __name__ == "__main__":

    # Run the local Dash development server.
    app.run(
        debug=True
    )

