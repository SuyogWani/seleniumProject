package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Utility {
	private Properties props;
	private InputStream fs;
	
	public Utility(String file) {
		props = new Properties();
		try {
			fs = new FileInputStream(file);
			try {
				props.load(fs);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public String getProp(String propName) {
		return props.getProperty(propName);
	}
}
