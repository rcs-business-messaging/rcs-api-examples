# Java example calling the RCS User Statuses API

This is a Java code sample showing how to call Google's RCS
User Statuses API.

More information can be found in [our documentation](https://developers.google.com/mobile-network-services/v2/list_user_statuses)

## Setup

1.  Download the JSON key from the Service Account in the Google Cloud project
    you have asked Google to configure for Mobile Network Services API use.

2.  Paste the JSON key into `src/main/resources/service-account-credentials.json`.

3.  Edit `src/main/java/com/google/rcs/samples/userstatuses/Config.java` and set values for
    your carrier and the account you want to look up.

4. Compile the code with:

    `mvn compile`

## Running the application
Run the following command:

   `mvn exec:java`