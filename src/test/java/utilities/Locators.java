package utilities;

import org.openqa.selenium.By;

public class Locators {

	public static By getId(String locatorvalue) {
		return By.id(locatorvalue);
	}
	public static By getName(String locatorvalue) {
		return By.name(locatorvalue);

	}
	public static By getXpath(String locatorvalue) {
		return By.xpath(locatorvalue);

	}
	public static By getLinkTest(String locatorvalue) {
		return By.linkText(locatorvalue);

	}
	public static By getCSSSelector(String locatorvalue) {
		return By.cssSelector(locatorvalue);

	}
	public static By getPartialLinkText(String locatorvalue) {
		return By.partialLinkText(locatorvalue);

	}

}
