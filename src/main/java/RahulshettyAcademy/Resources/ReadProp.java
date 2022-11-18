package RahulshettyAcademy.Resources;

import java.io.FileInputStream;

import java.util.Properties;

public class ReadProp {

	
	public Properties readconfig() {
		
		Properties prop = null;
		try {
			String path=System.getProperty("user.dir")+"\\src\\main\\java\\RahulShettyAcademy\\Resources\\GlobalData.properties";
			FileInputStream fic=new FileInputStream(path);
			prop=new Properties();
			prop.load(fic);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} 
		
		return prop;
		
		
		
	}
	
}
