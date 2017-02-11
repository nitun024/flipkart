package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FKProperties {

	public static String getValue(String ask) throws IOException {

		File file = new File("flipkart.properties");
		FileInputStream fis = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fis);
		
		return prop.getProperty(ask);

	}

}
