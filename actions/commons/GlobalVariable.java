package commons;

import java.io.File;

public class GlobalVariable {
	public static final String PORTAL_DEV_URL = "https: //demo.nopcommerce.com/"; 
	public static final String ADMIN_DEV_URL = "https: / /admin-demo.nopcommerce.com";
	public static final String PORTAL_TESTING_URL = "https: //demo.nopcommerce.com/";
	public static final String ADMIN_TESTING_URL = "https: //admin-demo.nopcommerce.com";
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String UPLOAD_FILE_FOLDER = PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
	public static final String DOWNLOAD_FILE_FOLDER = PROJECT_PATH + File.separator + "downloadFiles";
	public static final String BROWSER_LOG_FOLDER = PROJECT_PATH + File. separator + "browserLogs";
	public static final String DRAP_DROP_HTML5 = PROJECT_PATH + File. separator + "dragDropHTML5";
	public static final String AUTO_IT_SCRIPT = PROJECT_PATH + File. separator + "autoIT";
	public static final String DB_DEV_URL = "192.168.1.15:9860";
	public static final String DB_DEV_USER = "auto";
	public static final String DB_DEV_PASS = "auto@ws123";
	public static final long SHORT_TIMEOUT = 5;
	public static final long LONG_TIMEOUT = 30;
	public static final long RETRY_TEST_FAIL = 3;
	
	

}
