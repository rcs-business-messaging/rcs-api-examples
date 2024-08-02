# Node.js example calling the RCS Deactivation API

This is a node.js code sample showing how to call Google's RCS
Deactivation API.

Further information can be found on our [online documentation](https://docs.jibemobile.com/).

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

   `node src/rcsDeactivation.js`