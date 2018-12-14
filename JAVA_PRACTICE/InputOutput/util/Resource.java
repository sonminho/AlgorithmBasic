package util;

import java.io.FileReader;
import java.net.URLDecoder;
import java.util.Properties;

public class Resource {
	public static Properties getProperties(String cpath) throws Exception {
		Properties properties = new Properties();
		String path = Resource.class.getResource(cpath).getPath();
		
		path = URLDecoder.decode(path, "utf-8");
		properties.load(new FileReader(path));
		
		return properties;
	}
}
