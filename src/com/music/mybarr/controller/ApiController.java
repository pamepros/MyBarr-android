package com.music.mybarr.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import android.content.Context;
import android.util.Log;

import com.music.mybarr.callbacks.UserCallback;
import com.urucas.services.JSONRequestTask;
import com.urucas.services.JSONRequestTaskHandler;
import com.urucas.services.RequestTask;
import com.urucas.services.RequestTaskHandler;
import com.urucas.utils.Utils;

public class ApiController {

	private static String BASE_URL = "http://checkboxx.us/";
	
	public void getBeatsUser(final UserCallback callback) {
	
		if(!isConnected()) {
			//Utils.Toast(BaseApplication.getInstance(), R.string.no_connection);
			return;
		}
		
		String url = "https://partner.api.beatsmusic.com/v1/oauth2/authorize";
		try {
			new JSONRequestTask(new JSONRequestTaskHandler() {

				@Override
				public void onSuccess(JSONObject result) {
				}

				@Override
				public void onError(String message) {
					callback.onError(message);
				}

				@Override
				public void onSuccess(JSONArray result) {
					Log.i("response array",result.toString());
					try {
						// parse json from trip
						Log.i("response array",result.toString());
						//Trip event = TripParser.parse(result);
						//callback.onSuccess();
						
					} catch (Exception e) {
						e.printStackTrace();
						callback.onError("error parsing");
					}
				}

			}).addParam("response", "token").addParam("redirect_uri", "").addParam("client_id", "1450482").execute(url);
			
		} catch (Exception e) {
			callback.onError("error calling api");
		}
	}
	
	public void sendMyData(String username, String lastSong, final UserCallback callback) {
		
		Log.i("username",username);
		Log.i("lastSong",lastSong);
		
		try {
			String url = BASE_URL+"mainEndPoint.php";
			new JSONRequestTask(new JSONRequestTaskHandler() {

				@Override
				public void onSuccess(JSONObject result) {
					Log.i("response object",result.toString());
					try {
						// parse json from trip
						Log.i("response array",result.toString());
						callback.onSuccess(result);
						
					} catch (Exception e) {
						e.printStackTrace();
						callback.onError("error parsing");
					}
				}

				@Override
				public void onError(String message) {
					callback.onError(message);
				}

				@Override
				public void onSuccess(JSONArray result) {
					Log.i("response array",result.toString());
				}

			}).addParam("username", username).addParam("artistId", lastSong).execute(url);
			
		} catch (Exception e) {
			callback.onError("error calling api");
		}
	}
	
	public void sendMyDataNoMore(final UserCallback callback) {
		
		if(!isConnected()) {
			//Utils.Toast(BaseApplication.getInstance(), R.string.no_connection);
			return;
		}
		
		String url = "post.php";
		try {
			new JSONRequestTask(new JSONRequestTaskHandler() {

				@Override
				public void onSuccess(JSONObject result) {
				}

				@Override
				public void onError(String message) {
					callback.onError(message);
				}

				@Override
				public void onSuccess(JSONArray result) {
					Log.i("response array",result.toString());
					try {
						// parse json from trip
						Log.i("response array",result.toString());
						//callback.onSuccess();
						
					} catch (Exception e) {
						e.printStackTrace();
						callback.onError("error parsing");
					}
				}

			}).addParam("response", "token").addParam("redirect_uri", "").addParam("client_id", "1450482").execute(url);
			
		} catch (Exception e) {
			callback.onError("error calling api");
		}
	}
	
	private boolean isConnected() {
		//return Utils.isConnected();
		return true;
	}

	

}
