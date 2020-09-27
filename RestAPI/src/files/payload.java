package files;

public class payload {

	public static String CoursePrice()
	{
		return "{\r\n" + 
				"  \"dashboard\": \r\n" + 
				"{\r\n" + 
				"\"purchaseAmount\": 910,\r\n" + 
				"\"website\": \"rahulshettyacademy.com\"\r\n" + 
				"},\r\n" + 
				"\"courses\": \r\n" + 
				"[\r\n" + 
				"{\r\n" + 
				"\"title\": \"Selenium Python\",\r\n" + 
				"\"price\": 50,\r\n" + 
				"\"copies\": 6\r\n" + 
				"},\r\n" + 
				"\r\n" + 
				"{\r\n" + 
				"\"title\": \"Cypress\",\r\n" + 
				"\"price\": 40,\r\n" + 
				"\"copies\": 4\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"title\": \"RPA\",\r\n" + 
				"\"price\": 45,\r\n" + 
				"\"copies\": 10\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"}";
	}
	
	public static String Addbook()
	{
		String payload="{\r\n" + 
		"  \r\n" + 
		"  \"name\":\"Learn Appium Automation with Java\",\r\n" + 
		"  \"isbn\":\"abcd\",\r\n" + 
		"  \"aisle\":\"227\",\r\n" + 
		"  \"author\":\"Nishant\"\r\n" + 
		"}";
		
		
		return payload;
	}
}
