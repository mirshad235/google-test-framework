package com.mirshad.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Config {
	
private static Properties prop;

public static String getConfig(String key){
	
	try {
		if(null == prop) {
			loadProperties();
		}
		return prop.getProperty(key);
	} catch (Exception e) {
		e.printStackTrace();
		return "N/A";
		
	}
}

private static void loadProperties() throws FileNotFoundException, IOException {
	prop = new Properties();
	prop.load(new FileInputStream(new File("src/main/resources/Config.properties")));
}


}
