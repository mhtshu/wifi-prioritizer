/*
 * Copyright (C) 2012 Michał Gryglicki
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.gryglicki.android.wifi;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Toast;

public class WiFiPrioritizerWelcomeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
		
		if (prefs.contains(WiFiPrioritizerPrefsActivity.HOME_WIFI_NETWORK_ID_KEY) && prefs.contains(WiFiPrioritizerPrefsActivity.HOME_WIFI_SSID_KEY)) {
			startActivity(new Intent(this, WiFiPrioritizerMainActivity.class));
		} else {
			startActivity(new Intent(this, WiFiPrioritizerPrefsActivity.class));
			Toast.makeText(this, getString(R.string.error_no_home_wifi), Toast.LENGTH_LONG).show();
		}
		finish();
	}
}
