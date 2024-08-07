# Node.js example calling the RCS User Statuses API

This is a Node.js code sample showing how to call Google's RCS
User Statuses API.

More information can be found in [our documentation](https://developers.google.com/mobile-network-services/v2/list_user_statuses)

## Setup

1. Download the JSON key from the Service Account in the Google Cloud project
   you have asked Google to configure for Mobile Network Services API use.

2. Paste the JSON key into `service-account-credentials.json`.

3. Edit `src/config.js` and set values for your carrier and the account you want to 
   deativate.

4. Install dependencies:

    `npm install`

## Running the application
Run the following command:

   `node src/userStatuses.js`