package com.capgemini.interview.hotelbooking;



import org.openqa.selenium.By;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.TestCase;



public class HotelBookingStepDefs {
	
	private HomePage homePageForm;
	private String hotelName;
	private String dHotelName;
	
	
	
	
	@Given("^when I login to the hotel management system using \"([^\"]*)\" and \"([^\"]*)\"$")
	public void when_I_login_to_the_hotel_management_system_using_and(String userName, String passwd) throws Throwable {
	    homePageForm = new HomePage();
	    homePageForm.login(userName,passwd);
	}

	@When("^enter HotelName as \"([^\"]*)\"$")
	public void enter_HotelName_as(String uName) throws Throwable {
	    hotelName = uName;
		homePageForm.enterUserName(uName);
}

	@When("^I enter Address as \"([^\"]*)\"$")
	public void i_enter_Address_as(String addr) throws Throwable {
	    homePageForm.enterAddress(addr);
	}

	@When("^I enter Owner as \"([^\"]*)\"$")
	public void i_enter_Owner_as(String owner) throws Throwable {
	    homePageForm.enterOwner(owner);
	}

	@When("^I enter phone number as \"([^\"]*)\"$")
	public void i_enter_phone_number_as(String ph) throws Throwable {
	    homePageForm.enterPhoneNumber(ph);
	}

	@When("^I enter email address as \"([^\"]*)\"$")
	public void i_enter_email_address_as(String email) throws Throwable {
	    homePageForm.enterEmail(email);
	}

	@When("^I click on Button \"([^\"]*)\"$")
	public void i_click_on_Button(String arg1) throws Throwable {
		System.out.println("***********************************");
		System.out.println("HOTEL TO BE ADDED:"+hotelName);
		System.out.println("***********************************");
	    homePageForm.clickCreate();
	}

	@Then("^Then entry should be added on to the page$")
	public void then_entry_should_be_added_on_to_the_page() throws Throwable {
		System.out.println("---------HOTEL ADDTION ASSERTION-----------");
	    boolean success = false;
		for(int i=2; HomePage.client.driver.findElements(By.xpath("/html/body/div[1]/div["+i+"]/div[1]/div[1]/p")).size() !=0; i++) {
			int j=i;
	    	Utilities.wait(By.xpath("/html/body/div[1]/div["+i+"]/div[1]/div[1]/p"), HomePage.client);
			String cHotel = HomePage.client.driver.findElement(By.xpath("/html/body/div[1]/div["+i+"]/div[1]/div[1]/p")).getText();
	    	String nClass = HomePage.client.driver.findElement(By.xpath("/html/body/div[1]/div["+ ++j +"]")).getAttribute("class");
	    	//System.out.println("HOTELNAME FROM ADD = "+hotelName);
	    	System.out.println("HOTEL["+(i-1)+"]"+cHotel);
	    	//System.out.println("className["+i+"]="+nClass);
	    	//Thread.sleep(1000);
	    	if(hotelName.equals(cHotel) && nClass.equals("row")) {
	    		System.out.println("-----------------------------------");
	    		System.out.println("HOTEL "+hotelName+" ADDED TO LAST ROW");
	    		System.out.println("-----------------------------------");
	    		success = true;
	    		break;
	    	}
	    }
		if(!success) {
			TestCase.fail();
		}
		
	}

	@When("^I click the X mark next to the hotel entry row with username \"([^\"]*)\"$")
	public void i_click_the_X_mark_next_to_the_hotel_entry_row_with_username(String deleteUser) throws Throwable {
	   dHotelName = deleteUser;
	   homePageForm.deleteHotel(deleteUser);
	}

	@Then("^The corresponding entry should be deleted$")
	public void the_corresponding_entry_should_be_deleted() throws Throwable {
		if(homePageForm.deleted) {
		boolean success = false;
		System.out.println("\n\n---------HOTEL DELETION ASSERTION-----------");
		for(int i=2; HomePage.client.driver.findElements(By.xpath("/html/body/div[1]/div["+i+"]/div[1]/div[1]/p")).size() !=0; i++) {
	    	int j=i;
			String cHotel = HomePage.client.driver.findElement(By.xpath("/html/body/div[1]/div["+i+"]/div[1]/div[1]/p")).getText();
	    	String nClass = HomePage.client.driver.findElement(By.xpath("/html/body/div[1]/div["+ ++j +"]")).getAttribute("class");
	    	//System.out.println("HOTELNAME FROM DELETE = "+dHotelName);
	    	System.out.println("HOTEL["+(i-1)+"]"+cHotel);
	    	//System.out.println("className["+i+"]="+nClass);
	    	if(dHotelName.equals(cHotel))
	    		break;
	    	//Thread.sleep(1000);
	    	if(!dHotelName.equals(cHotel) && nClass.equals("row")) {
	    		System.out.println("\n\n---------------------------------------");
	    		System.out.println("All HOTELS NAMED:"+dHotelName+" DELETED");
	    		System.out.println("---------------------------------------");
	    		success = true;
	    		break;
	    	}
	    }
		
		
		if(!success)
			TestCase.fail();
	}
		else {
			System.out.println("-------------------------------------------------");
			System.out.println("NOTHING TO ASSERT. DELETE OPERATION NOT PERFORMED");
			System.out.println("-------------------------------------------------");
		}
	}

	

}
