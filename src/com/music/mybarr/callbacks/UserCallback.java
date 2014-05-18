package com.music.mybarr.callbacks;

import com.music.mybarr.model.BeatUser;


/**
* @copyright Urucas
* @license   Copyright (C) 2013. All rights reserved
* @version   Release: 1.0.0
* @link       http://urucas.com
* @developers Bruno Alassia, Pamela Prosperi
*/

public interface UserCallback {
	public void onSuccess(BeatUser user);
	public void onError(String message);
}
