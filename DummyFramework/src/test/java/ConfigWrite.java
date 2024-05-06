import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigWrite {
	
	 public String StoreValueToConfig() throws IOException {
		   
		   Properties props=new Properties();
		   String Path="D:\\FrameWork_25\\FW\\src\\test\\java\\File.properties";
		   FileOutputStream outputstream=new FileOutputStream(Path);
//		   props.store(outputstream, "Automation tester");
		   props.setProperty("QuoteNo", "000011");
		   props.save(outputstream, "Generated Quote No");
		return Path;
		   
		
		   
		   
	   }
	
	

	public static void main(String[] args) throws IOException {
		ConfigWrite c = new ConfigWrite();
		c.StoreValueToConfig();
	}
}
