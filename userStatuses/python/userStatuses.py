# Copyright 2018 Google Inc. All rights reserved.

# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at

#     http://www.apache.org/licenses/LICENSE-2.0

# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

"""
A python example of calling the RCS deactivation API.
"""

from httplib2 import Http
from oauth2client.service_account import ServiceAccountCredentials

import config


def main():
    print('Looking up account ' + config.MSISDN)

    scopes = ['https://www.googleapis.com/auth/mobilenetworkservices']
    credentials = ServiceAccountCredentials.from_json_keyfile_name(
        'resources/service-account-credentials.json', scopes=scopes)
    http_auth = credentials.authorize(Http())

    serviceUrl = 'https://mobilenetworkservices.googleapis.com/v2/plmns/' + config.MCCMNC + '/userStatuses?serviceName=RCS&filter=msisdn=' + config.MSISDN

    print("User statuses URL: " + serviceUrl);

    http_auth = credentials.authorize(Http())

    resp, content = http_auth.request(serviceUrl, method='GET')

    print('Received response:');
    print(resp);
    print(content);

if __name__ == '__main__':
    main()
