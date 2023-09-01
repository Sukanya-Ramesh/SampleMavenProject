package org.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	public static Actions a;
	public static Robot r;
	public static FileInputStream fi;
	public static Workbook book;
	
	
	 public static void launchChrome() {
		
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 
		 
	}
	 public static void getURL(String url) {
		
		 driver.get(url);

	}
	 
	 public static void quit() {
			
		 driver.quit();

	}
	 
	 public static void close() {
			
		 driver.close();

	}
	 
	 public static void wait(int time) {
			
		 driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);

	}

	 public static void sendValues(WebElement element, String value) {
			
		 element.sendKeys(value);

	}
	 
	 public static void click(WebElement element) {
			
		 element.click();

	}
	 
	 public static void screenShot(String name) {
			
		 TakesScreenshot t = (TakesScreenshot) driver;
		 File src = t.getScreenshotAs(OutputType.FILE);
		 String home = System.getProperty("user.dir");
		 File des = new File (home+"\\screenshot\\"+name+".png");
		 try {
			FileUtils.copyFile(src, des);
		} catch (IOException e) {
			
		}

	}
	 
	 public static void clickUsingActions(WebElement element) {
		 
		 a = new Actions(driver);
			
		 a.moveToElement(element).perform();

	}
	 
	 public static void doubleClick(WebElement element) {
		 
		 a = new Actions(driver);
		 
		 a.doubleClick(element).perform();

	}
	 
	 public static void contextClick(WebElement element) {
		 
		 a = new Actions(driver);
			
		 a.contextClick(element).perform();

	}
	 
	 public static void robotEnter() {
		 
		 try {
			r = new Robot();
		} catch (AWTException e) {
			
		}			
		 r.keyPress(KeyEvent.VK_ENTER);
		 r.keyRelease(KeyEvent.VK_ENTER);
		 
	}
	 
	 public static void robotTab() {
		 
		 try {
			r = new Robot();
		} catch (AWTException e) {
			
		}			
		 r.keyPress(KeyEvent.VK_TAB);
		 r.keyRelease(KeyEvent.VK_TAB);
		 
	}
	 
	 public static void dateTime() {
		 
		 Date d = new Date();
		 SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		 String da = s.format(d);
		 System.out.println(da);
	 }
	 
	 public static String readData(String name, int sheetNo, int rowNo, int cellNo) {
		
		 File f = new File ("C:\\Users\\User\\eclipse-workspace\\SampleMavenProject\\Sheet\\"+name+".xlsx");
		 
		 try {
			fi = new FileInputStream(f);
		} catch (FileNotFoundException e) {
			
		}
		 
		 try {
			book = new XSSFWorkbook(fi);
		} catch (IOException e) {
				}
		 Sheet sheet = book.getSheetAt(sheetNo);
		 Row row = sheet.getRow(rowNo);
		 Cell cell = row.getCell(cellNo);
		 int cellType = cell.getCellType();
		 
		 String value = null;
		 
		 if (cellType==1) {
			 
			 value = cell.getStringCellValue();
		 }
		 else if (DateUtil.isCellDateFormatted(cell)) {
			 Date d = cell.getDateCellValue();
			 SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy z");
			 value = sdf.format(d);
			 
			 
			
		} else {

			double numDoubleCell = cell.getNumericCellValue();
			
			long numLongCell = (long) numDoubleCell;
			value = String.valueOf(numLongCell);
		}
		return value;
		 
	 }


}
