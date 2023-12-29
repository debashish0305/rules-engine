#!/usr/bin/env python3

import json
import pandas as pd
from pandas import json_normalize

# Input JSON file
json_file = '/path/to/your/input.json'

# Output flat file (CSV-like)
flat_file = '/path/to/your/output_flat.csv'

# Read JSON data
with open(json_file, 'r') as file:
    data = json.load(file)

# Flatten JSON using pandas json_normalize
flat_data = json_normalize(data)

# Write to CSV file
flat_data.to_csv(flat_file, index=False)

print(f"Flat file conversion complete. Output saved to {flat_file}")
