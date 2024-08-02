# Python example calling the RCS Deactivation API

This is a python code sample showing how to call Google's RCS
Deactivation API.

Further information can be found on our [online documentation](https://docs.jibemobile.com/).

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

   `python rcsDeactivation.py`