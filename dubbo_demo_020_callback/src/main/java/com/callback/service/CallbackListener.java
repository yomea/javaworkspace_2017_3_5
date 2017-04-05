package com.callback.service;

import java.io.Serializable;

public interface CallbackListener extends Serializable {
	
	void changed(String msg);
	
	void test();

}
