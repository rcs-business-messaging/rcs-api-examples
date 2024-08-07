# Python example calling the RCS User Statuses API
This is a Node.js code sample showing how to call Google's RCS
User Statuses API.

More information can be found in [our documentation](https://developers.google.com/mobile-network-services/v2/list_user_statuses)

## Setup

1. Download the JSON key from the Service Account in the Google Cloud project
   you have asked Google to configure for Mobile Network Services API use.

2. Paste the JSON key into `resources/service-account-credentials.json`.

3. Edit `config.py` and set values for your carrier and the account you want to 
   deativate.

4. In a terminal, navigate to this sample's root directory.

5. Run the following commands to set up your python environment:

```
   python3 -m venv env
   source env/bin/activate
   python -m pip install -r requirements.txt
```

## Running the application
Run the following command:

   `python userStatuses.py`