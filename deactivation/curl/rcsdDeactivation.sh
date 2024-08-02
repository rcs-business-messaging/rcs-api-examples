#!/bin/sh

# Deactivate an RCS account.
# See https://docs.jibemobile.com/cloud/how-cloud-works/api-integration#account_deactivation

# Edit these for your environment
PLMNS=EDIT HERE
IMSI=EDIT HERE
MSISDN=EDIT HERE

curl -v -X POST "https://mobilenetworkservices.googleapis.com/v2/plmns/$PLMNS/serviceNotifications?serviceNotificationId=serviceNotificationId1&requestId=requestId1" \
-H "Content-Type: application/json" \
-H "`oauth2l header --json service-account-credentials.json https://www.googleapis.com/auth/mobilenetworkservices`" \
-d "{
  'imsi': '$IMSI', 
  'msisdn': '$MSISDN', 
  'serviceName': 'RCS',
  'accountStatus': 'TERMINATED', 
  'eligibilityStatus': 'DISABLED'
  }" 
