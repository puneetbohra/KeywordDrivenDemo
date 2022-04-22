package utilities;

import java.io.FileInputStream;
import java.lang.reflect.Method;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import testclass.TestCase1;


public class ExcelRead {
	FileInputStream file;
	static XSSFWorkbook b;
	static XSSFSheet sheet;
	Method[] methods;
	//String name;
	TestCase1 tc;
	public static int lastrow;
	public static String locator;
	public static String locatorid;
	public static String locatorvalue;
	public static String ActionKeyword;
	public static String TestData;

	public static int locatorcell=3;
	public static int Actioncell=locatorcell+1;
	public static int datacell=locatorcell+2;


	public static void Action(int row,int locatorcell,int Actioncell,int datacell) {
		locator=sheet.getRow(row).getCell(locatorcell).toString().trim();
		if(!locator.contains("NA")){
			locatorid=locator.split("=")[0].toString();
			locatorvalue=locator.split("=")[1].toString();
		}else {
			locatorid="NA";
			locatorvalue="NA";
		}
		ActionKeyword=sheet.getRow(row).getCell(Actioncell).toString().trim();
		TestData=sheet.getRow(row).getCell(datacell).toString().trim();
		//System.out.println(locatorid +" "+ locatorvalue +" "+ ActionKeyword +" "+TestData);
		/* name= sheet.getRow(row).getCell(column).getStringCellValue();
		return name;*/		
	}

	public static void ReadExcel(String path) throws Exception {
		FileInputStream file=new FileInputStream(path);
		b=new XSSFWorkbook(file);
		sheet = b.getSheet("Sheet1");
		lastrow=sheet.getLastRowNum();
	}
	public ExcelRead() {
		tc=new TestCase1();
		methods = tc.getClass().getMethods();
	}

	public void executeKeywords() throws Exception {
		for (int i = 0; i < methods.length; i++) {
			if(methods[i].getName().equalsIgnoreCase(ActionKeyword)){
				methods[i].invoke(tc);
				break;
			};
		}
	}

}
