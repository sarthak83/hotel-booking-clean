package com.capgemini.interview.hotelbooking;

import org.openqa.selenium.By;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class HomePage {
	
	static DriverClient client;
	boolean deleted = false;
	
	@Before
	public void setUp() {
		client = new DriverClient();
		client.driver.get(Config.Url.baseUrl);
		//client.driver.manage().window().maximize();
		}
	
	@After
	public void tearDown() throws Exception{
		//Thread.sleep(1000);
		client.clientTearDown(client.driver);
	}
	
	
	public void login(String uname, String pwd) throws Exception{
		Utilities.wait(By.linkText("Login"), client);
		client.driver.findElement(By.linkText("Login")).click();
		Utilities.wait(By.id("username"), client);
		client.driver.findElement(By.id("username")).sendKeys(uname);
		Utilities.wait(By.id("password"), client);
		client.driver.findElement(By.id("password")).sendKeys(pwd);
		Utilities.wait(By.id("doLogin"), client);
		client.driver.findElement(By.id("doLogin")).click();
		//Thread.sleep(5000);
	}
	
	
	public void enterUserName(String name) {
		client.driver.findElement(By.id("hotelName")).sendKeys(name);
	}
	
	public void enterAddress(String addr) {
		client.driver.findElement(By.id("address")).sendKeys(addr);
	}
	
	public void enterOwner(String owner) {
		client.driver.findElement(By.id("owner")).sendKeys(owner);
	}
	
	public void enterPhoneNumber(String phone) {
		client.driver.findElement(By.id("phone")).sendKeys(phone);
	}
	
	public void enterEmail(String email) {
		client.driver.findElement(By.id("email")).sendKeys(email);
	}
	
	public void clickCreate() {
		client.driver.findElement(By.id("createHotel")).click();
	}
	
	public void deleteHotel(String hotelToDelete) throws Exception {
		Utilities.wait(By.xpath("/html/body/div[1]/div[2]/div[1]/div[1]/p"), client);
		System.out.println("***********************************");
		System.out.println("HOTEL TO BE DELETED:"+hotelToDelete);
		System.out.println("***********************************");
		
		int i = 2;
		
		while(client.driver.findElements(By.xpath("/html/body/div[1]/div["+i+"]/div[1]/div[1]/p")).size() !=0) {
			//below doesnot work all the time. Sleep is only option
			//Update 1: It works if we move the wait to line 78. StaleElementReferenceException is no longer thrown. Wait till element is destroyed and recreated. 
			//Utilities.wait(By.xpath("/html/body/div[1]/div["+i+"]/div[1]/div[1]/p"), client);	 
			System.out.println("HOTEL["+(i-1)+"]=" +client.driver.findElement(By.xpath("/html/body/div[1]/div["+i+"]/div[1]/div[1]/p")).getText());
			String hotelName = client.driver.findElement(By.xpath("/html/body/div[1]/div["+i+"]/div[1]/div[1]/p")).getText();
			if(hotelName.equalsIgnoreCase(hotelToDelete)) {
				System.out.println("\nHOTEL "+client.driver.findElement(By.xpath("/html/body/div[1]/div["+i+"]/div[1]/div[1]/p")).getText()+" DELETED\n");
				client.driver.findElement(By.xpath("/html/body/div[1]/div["+i+"]/div[2]/span")).click();
				deleted = true;
				//Update 2: After udpate 1, if last hotel was deleted, StaleElementException on line 85. So had to wait only if NOT last element. 
				//Update 3: Line 83 needed for row element to be recreated. If not last row then wait till hotel element is recreated. FOOL PROOF! 
				Utilities.wait(By.xpath("/html/body/div[1]/div["+(i)+"]"), client);
				if(!client.driver.findElement(By.xpath("/html/body/div[1]/div["+(i)+"]")).getAttribute("class").equalsIgnoreCase("row")) 
					Utilities.wait(By.xpath("/html/body/div[1]/div["+i+"]/div[1]/div[1]/p"), client);
				
			}
			else 
				i++;
		}
		if(!deleted) 
			System.out.println("\nHOTEL NAME:"+hotelToDelete+" NOT FOUND!\n");
	}
	
	
	
	
	
	

}
