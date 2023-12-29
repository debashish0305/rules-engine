import pandas as pd
import json

def flatten_json(json_data):
    # Load JSON data
    data = json.loads(json_data)

    # Flatten JSON using pandas json_normalize
    flat_data = pd.json_normalize(data)

    return flat_data

def main():
    # Specify the paths for input and output files
    input_json_path = 'path/to/input.json'
    output_csv_path = 'path/to/output.csv'

    # Read the JSON file
    with open(input_json_path, 'r') as json_file:
        json_data = json_file.read()

    # Flatten the JSON
    flat_data = flatten_json(json_data)

    # Save the flattened data to a CSV file
    flat_data.to_csv(output_csv_path, index=False)

if __name__ == "__main__":
    main()
