# Java example calling the RCS Deactivation API

This is a Java code sample showing how to call Google's RCS
Deactivation API.

Further information can be found on our [online documentation](https://docs.jibemobile.com/).

## Setup

1.  Download the JSON key from the Service Account in the Google Cloud project
    you have asked Google to configure for Mobile Network Services API use.

2.  Paste the JSON key into `service-account-credentials.json`.

3.  Edit `src/main/java/com/google/rcs/samples/deactivation/Config.java` and set values for
    your carrier and the account you want to deativate.

4. Compile the code with:

    `mvn compile`

## Running the application
Run the following command:

   `mvn exec:java`