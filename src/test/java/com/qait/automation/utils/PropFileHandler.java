package com.qait.automation.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.Set;

/**
 * 
 * @author QA InfoTech
 * This class defines the methods required to perform IO tasks on the "filename.properties" file.
 * filename.properties is the default file which stores data which either is required by the
 * application or is generated by the application at the runtime.
 * 
 */
public class PropFileHandler {
	static Properties properties = new Properties();

	/**
	 * This method is used to read the value of the given property from the properties file.
	 * 
	 * @param property : the property whose value is to be fetched.
	 * @return the value of the given property.
	 */
	

	public static String readProperty(String property, String filePath) 
	{
		InputStream inPropFile = null;
		try {
			inPropFile = new FileInputStream(filePath);
			properties.load(inPropFile);
		} catch (IOException e) {
		}
		String value=properties.getProperty(property);	
		
		
		return value;
	}

	public static Set<String> getPropertyNames(String filePath){
		InputStream inPropFile = null;
		try {
			inPropFile = new FileInputStream(filePath);
			properties.load(inPropFile);
		} catch (IOException e) {
		}
		return properties.stringPropertyNames();
		
	}
	
/**
 * This method is used to write the value of the property in property file.
 * @param property
 * @param value
 * @throws IOException
 */
	public static void writeToFile(String property, String value, String filePath) throws IOException {
		try {
			System.out.println("File path in Write Method" + "  " + filePath);
			InputStream inPropFile = new FileInputStream(filePath);
			properties.load(inPropFile);
			inPropFile.close();
			OutputStream outPropFile = new FileOutputStream(filePath);
			properties.setProperty(property, value);
			properties.store(outPropFile, null);
			outPropFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void cleanFile(String filePath) {
		String content = "";
		try{
			File file = new File(filePath);
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteFile(String filePath) {
		File file = new File(filePath);
		file.delete();
	}
	
}
