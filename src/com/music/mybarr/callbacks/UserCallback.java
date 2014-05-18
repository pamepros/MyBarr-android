package com.music.mybarr.callbacks;

import org.json.JSONObject;


/**
* @copyright Urucas
* @license   Copyright (C) 2013. All rights reserved
* @version   Release: 1.0.0
* @link       http://urucas.com
* @developers Bruno Alassia, Pamela Prosperi
*/

public interface UserCallback {
	public void onSuccess(JSONObject user);
	public void onError(String message);
}
