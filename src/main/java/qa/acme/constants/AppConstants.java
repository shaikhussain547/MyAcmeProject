package qa.acme.constants;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class AppConstants {
	
//	private AppConstants() {}//cannot able to crate object for this AppConstants class.
	
	public static final int SHORT_DEFAUTT_WAIT = 5;
	public static final int MEDIUM_DEFAUTT_WAIT = 10;
	public static final int LONG_DEFAUTT_WAIT = 20;
	public static final int POLLING_DEFAUTT_WAIT = 2;
	
	public static final String CONFIG_FILE_PATH = "./src/test/resources/config/config.properties";
	public static final String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
	public static final String OUTPUT_FOLDER = "./TestReports/Latest/"+timeStamp+"/";
	
	public static final String LOGIN_PAGE_TITLE = "ACME System 1 - Log In";
	public static final String ACCOUNTS_PAGE_TITLE = "ACME System 1 - Dashboard";

	public static final String LOGIN_PAGE_FRACTION_URL = "test.uipath.com/login";
	public static final String ACC_PAGE_FRACTION_URL = "test.uipath.com";
	
	public static final List<String> ACC_PAGE_HEADERS_LIST = 
			Arrays.asList("My Account", "My Orders", "My Affiliate Account", "Newsletter");

	public static final String USER_REGISTER_SUCCESS_MESSG = "Your Account Has Been Created!";
	
	
	//*****************SHEET CONSTANTS************//
	public static final String REGISTER_SHEET_NAME = "register";
	public static final String PRODUCT_IMAGES_SHEET_NAME = "productimages";
	
	public static String urlInfo(String env) {
		String url = null;
		if(env.equals("TE1")) {
			url = "https://acme-test.uipath.com/login";
		}else if(env.equals("TE2")) {
			
		}else if(env.equals("Dev")) {
			
		}else if(env.equals("Prod")) {
			
		}
		return url;
	}
	

	

	

}

