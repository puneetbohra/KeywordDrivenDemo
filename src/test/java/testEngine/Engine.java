package testEngine;


import org.openqa.selenium.By;

import utilities.ExcelRead;
import utilities.Locators;

public class Engine {
	
	public static By Locator;

	public static void main(String[] args) throws Exception {
		System.out.println("THE START");
		ExcelRead e=new ExcelRead();
		ExcelRead.ReadExcel("D:\\KeywordDrivenFramework\\src\\test\\resources\\Keyword.xlsx");
		for (int i = 1; i <= ExcelRead.lastrow ; i++) {
			ExcelRead.Action(i, ExcelRead.locatorcell,ExcelRead.Actioncell,ExcelRead.datacell);
			Engine.getWebElement();
			e.executeKeywords();
		}
		System.out.println("END");
	}
	public static void getWebElement() {
		switch (ExcelRead.locatorid) {
		case "id":
			Locator=Locators.getId(ExcelRead.locatorvalue);
			break;
		case "name":
			Locator=Locators.getName(ExcelRead.locatorvalue);
			break;
		case "xpath":
			Locator=Locators.getXpath(ExcelRead.locatorvalue);
			break;
		case "CSSSelector":
			Locator=Locators.getCSSSelector(ExcelRead.locatorvalue);
			break;

		default:
			break;
		}

	}
}
