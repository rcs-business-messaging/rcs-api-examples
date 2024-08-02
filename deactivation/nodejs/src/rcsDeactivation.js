// Copyright 2022 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the License);
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an AS IS BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

'use strict';

const {google} = require('googleapis');
const googleapis_common_1 = require('googleapis-common');

const serviceAccountJsonObject = require('../service-account-credentials.json');

const config = require('./config');


class RcsDeactivation {
	constructor(plmns) {
		this.plmns = plmns;
		this.context = {
			_options: {},
			google,
		};

		this.authClient = new google.auth.JWT(
			serviceAccountJsonObject.client_email,
			null,
			serviceAccountJsonObject.private_key,
			['https://www.googleapis.com/auth/mobilenetworkservices']
		);
	}

	deactivate(msisdn, imsi) {
		const serviceUrl = `https://mobilenetworkservices.googleapis.com/v2/plmns/${this.plmns}/serviceNotifications`;

		let body = {
			msisdn: msisdn,
			imsi: imsi,
			serviceName: 'RCS',
			accountStatus: 'TERMINATED',
			eligibilityStatus: 'DISABLED'
		};

		const parameters = {
			options: {
				url: serviceUrl,
				method: 'POST',
			},
			params: {
				auth: this.authClient,
				resource: body
			},
			requiredParams: [],
			pathParams: [],
			context: this.context,
		};
		
		googleapis_common_1.createAPIRequest(parameters);


	}
}


new RcsDeactivation(config.plmns).deactivate(config.msisdn, config.imsi);
