#!/bin/sh

# Deactivate an RCS account.
# See https://docs.jibemobile.com/cloud/how-cloud-works/api-integration#account_deactivation

# Edit these for your environment
MCCMNC=EDIT HERE
MSISDN=EDIT HERE

curl -v "https://mobilenetworkservices.googleapis.com/v2/plmns/$MCCMNC/userStatuses?serviceName=RCS&filter=msisdn=$MSISDN" \
-H "`oauth2l header --json service-account-credentials.json https://www.googleapis.com/auth/mobilenetworkservices`" 

