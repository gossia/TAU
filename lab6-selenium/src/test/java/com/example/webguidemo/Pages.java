package com.example.webguidemo;

import org.jbehave.web.selenium.WebDriverProvider;

import com.example.webguidemo.pages.Registration;
import com.example.webguidemo.pages.Home;
import com.example.webguidemo.pages.TenMinuteMail;

public class Pages {

	private WebDriverProvider driverProvider;
	
	//Pages
	private Home home;
	private Registration registration;
	private TenMinuteMail tenMinuteMail;
	// ...

	public Pages(WebDriverProvider driverProvider) {
		super();
		this.driverProvider = driverProvider;
	}

	public Home home() {
		if (home == null) {
			home = new Home(driverProvider);
		}
		return home;
	}
	
	public Registration registration(){
		if (registration == null) {
			registration = new Registration(driverProvider);
		}
		return registration;
	}
	
	public TenMinuteMail tenMinuteMail(){
		if (tenMinuteMail == null) {
			tenMinuteMail = new TenMinuteMail(driverProvider);
		}
		return tenMinuteMail;
	}
}
