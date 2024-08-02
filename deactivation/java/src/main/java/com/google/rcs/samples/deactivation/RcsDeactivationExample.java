/*
Copyright 2024 Google Inc. All rights reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package com.google.rcs.samples.deactivation;

import com.google.api.client.http.*;

import com.google.api.client.http.javanet.*;
import com.google.auth.http.HttpCredentialsAdapter;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequest;
import com.google.auth.oauth2.GoogleCredentials;

import java.io.File;
import java.io.FileInputStream;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;


public class RcsDeactivationExample {
    private static final Logger logger = Logger.getLogger(RcsDeactivationExample.class.getName());
    private static final String serviceUrl = "https://mobilenetworkservices.googleapis.com/v2/plmns/%s/serviceNotifications";

    protected GoogleCredentials credentials;
    protected String plmns;


    public RcsDeactivationExample(String plmns) {
        this.plmns = plmns;

        try {
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource("service-account-credentials.json").getFile());

            logger.info("Creating authentication credentials from service account key.");
            credentials = 
                GoogleCredentials.fromStream(new FileInputStream(file))
                    .createScoped(
                        Collections.singleton("https://www.googleapis.com/auth/mobilenetworkservices"));
            
            // Set credentials to refresh if they expire
            credentials.refreshIfExpired();
        }
        catch (Exception e) {
            logger.severe("Exception thrown when creating credentials: " + e);
        }
    }


    public void deactivate(String msisdn, String imsi) {
        try {
            logger.info("Deleting account " + msisdn + " (" + imsi + ")");

            String requestBody = "{'msisdn': '" + msisdn + "','imsi': '" + imsi
                + "','serviceName': 'RCS','accountStatus': 'TERMINATED','eligibilityStatus': 'DISABLED'}";

            GenericUrl url = new GenericUrl(String.format(serviceUrl, plmns));
            HttpTransport transport = new NetHttpTransport();
            HttpRequestFactory requestFactory = transport.createRequestFactory(new HttpCredentialsAdapter(credentials));
            HttpRequest request = requestFactory.buildPostRequest(url, ByteArrayContent.fromString("application/json", requestBody));

            request.getHeaders().setContentType("application/json");

            logger.info("Deactivation URL: " + url);
            logger.info("Deactivation payload: " + requestBody);

            HttpResponse response = request.execute();

            logger.info(response.parseAsString());
        }
        catch (Exception e) {
            logger.severe("Exception thrown when deactivating: " + e);
        }

        
    }


    public static void main(String[] args) {
        RcsDeactivationExample sample = new RcsDeactivationExample(Config.PLMNS);

        sample.deactivate(Config.MSISDN, Config.IMSI);
    }
}


// 