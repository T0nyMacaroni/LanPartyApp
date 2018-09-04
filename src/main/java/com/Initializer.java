package com;

import com.io.Reader;
import com.io.Writer;

public class Initializer {

	public static void init() {
    	Writer.create_directory_if_doesnt_exist();
    	Reader.initData();
	}
	
}