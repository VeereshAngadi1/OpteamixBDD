package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private Properties prop;

	public Properties inti_prop() throws IOException {

		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources1/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return prop;
	}
}