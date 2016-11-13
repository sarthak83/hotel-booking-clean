package com.capgemini.interview.hotelbooking;



public class Config {
	
	public static class Url {
		public static final String baseUrl = "http://localhost:3003";
	}
	
	public static class Ui {
		
		public enum BrowserType
        {
			Firefox,
            Safari,
            Chrome
        }
		
		
		public static BrowserType browser = BrowserType.Chrome;
		public static String url = Config.Url.baseUrl;
		
	}

}
