package web.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RoutingServletTest {
	private WebDriver driver;
	private WebDriverWait wait;
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	private void sleep(long sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"D:/Deakin/Uni/2024 Tri 1/SIT707 - Software Quality And Testing/chromedriver-win64/"
						+ "chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 10);
		System.out.println("Driver info: " + driver);

		driver.navigate().to("http://localhost:8080/login");
		// sleep(5);
	} 

	@After
	public void close() {
		sleep(2);
		driver.quit();
	}

	public void loginFunction(String username, String password, String dob) {

		WebElement ele = driver.findElement(By.id("username"));
		ele.clear();
		ele.sendKeys(username);

		ele = driver.findElement(By.id("passwd"));
		ele.clear();
		ele.sendKeys(password);

		ele = driver.findElement(By.id("dob"));
		ele.clear();
		ele.sendKeys(dob);
		sleep(2);
		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.submit();
	}

	private void doingMathsQuestions(String number1, String number2, String result) {
		WebElement ele = driver.findElement(By.id("number1"));
		ele.clear();
		ele.sendKeys(number1);

		ele = driver.findElement(By.id("number2"));
		ele.clear();
		ele.sendKeys(number2);

		ele = driver.findElement(By.id("result"));
		ele.clear();
		ele.sendKeys(result);

		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.submit();
	}

	@Test
	public void testAllInvalidCredentials() {
		loginFunction("vishuddha", "wrong_pass", "05/22/1999");
		String message = driver.findElement(By.tagName("div")).getText();
		Assert.assertEquals("Incorrect credentials.", message);
	}

	@Test
	public void testWrongUsernameCorrectPasswdCorrectDob() {
		loginFunction("vishuddha", "ahsan_pass", "05/22/1993");
		String message = driver.findElement(By.tagName("div")).getText();
		Assert.assertEquals("Incorrect credentials.", message);
	}

	@Test
	public void testCorrectUsernameWrongPasswdCorrectDob() {
		loginFunction("ahsan", "Vish_pass", "05/22/1993");
		String message = driver.findElement(By.tagName("div")).getText();
		Assert.assertEquals("Incorrect credentials.", message);
	}

	@Test
	public void testCorrectUsernameCorrectPasswdWrongDob() {
		loginFunction("ahsan", "ahsan_pass", "05/22/1999");
		String message = driver.findElement(By.tagName("div")).getText();
		Assert.assertEquals("Incorrect credentials.", message);
	}

	@Test
	public void testEmptyUsernameEmptyPasswdEmptyDob() {
		loginFunction("", "", "");
		String message = driver.findElement(By.tagName("div")).getText();
		Assert.assertEquals("Incorrect credentials.", message);
	}

	@Test
	public void testLoginWithAllQuestions() {
		loginFunction("ahsan", "ahsan_pass", "05/22/1993");
		wait.until(ExpectedConditions.urlContains("/q1"));

		doingMathsQuestions("2", "2", "4");
		wait.until(ExpectedConditions.urlContains("/q2"));

		doingMathsQuestions("4", "2", "2");
		wait.until(ExpectedConditions.urlContains("/q3"));

		doingMathsQuestions("3", "2", "6");
		wait.until(ExpectedConditions.urlToBe("http://localhost:8080/"));
	}
	// Test Cases for Q1
	@Test
	public void testQuestion1WithEmptyValues() {
		loginFunction("ahsan", "ahsan_pass", "05/22/1993");
		wait.until(ExpectedConditions.urlContains("/q1"));

		doingMathsQuestions("", "", "");
		wait.until(ExpectedConditions.urlContains("/q1"));
		String message = driver.findElement(By.tagName("div")).getText();
        Assert.assertEquals("First number is not valid.", message);
}
	@Test
	public void testQuestion1With2ndNumberEmpty() {
		loginFunction("ahsan", "ahsan_pass", "05/22/1993");
		wait.until(ExpectedConditions.urlContains("/q1"));

		doingMathsQuestions("2", "", "");
		wait.until(ExpectedConditions.urlContains("/q1"));
		String message = driver.findElement(By.tagName("div")).getText();
        Assert.assertEquals("Second number is not valid.", message);
}
	@Test
	public void testQuestion1With1ndNumberInvalid() {
		loginFunction("ahsan", "ahsan_pass", "05/22/1993");
		wait.until(ExpectedConditions.urlContains("/q1"));

		doingMathsQuestions("w", "2", "");
		wait.until(ExpectedConditions.urlContains("/q1"));
		String message = driver.findElement(By.tagName("div")).getText();
        Assert.assertEquals("First number is not valid.", message);
}
	@Test
	public void testQuestion1With2ndNumberInvalid() {
		loginFunction("ahsan", "ahsan_pass", "05/22/1993");
		wait.until(ExpectedConditions.urlContains("/q1"));

		doingMathsQuestions("2", "a", "");
		wait.until(ExpectedConditions.urlContains("/q1"));
		String message = driver.findElement(By.tagName("div")).getText();
        Assert.assertEquals("Second number is not valid.", message);
}
	@Test
	public void testQuestion1WithWrongAnswer() {
		loginFunction("ahsan", "ahsan_pass", "05/22/1993");
		wait.until(ExpectedConditions.urlContains("/q1"));

		doingMathsQuestions("2", "2", "5");
		wait.until(ExpectedConditions.urlContains("/q1"));
		String message = driver.findElement(By.tagName("div")).getText();
        Assert.assertEquals("Wrong answer, try again.", message);
}
	// Test Cases for Q2
	@Test
	public void testQuestion2WithEmptyValues() {
		loginFunction("ahsan", "ahsan_pass", "05/22/1993");
		wait.until(ExpectedConditions.urlContains("/q1"));

		doingMathsQuestions("2", "2", "4");
        wait.until(ExpectedConditions.urlContains("/q2"));

        doingMathsQuestions("", "", "");
        wait.until(ExpectedConditions.urlContains("/q2"));
        String message = driver.findElement(By.tagName("div")).getText();
        Assert.assertEquals("First number is not valid.", message);
}
	@Test
	public void testQuestion2With2ndNumberEmpty() {
		loginFunction("ahsan", "ahsan_pass", "05/22/1993");
		wait.until(ExpectedConditions.urlContains("/q1"));

		doingMathsQuestions("2", "2", "4");
        wait.until(ExpectedConditions.urlContains("/q2"));

        doingMathsQuestions("6", "", "1");
        wait.until(ExpectedConditions.urlContains("/q2"));
        String message = driver.findElement(By.tagName("div")).getText();
        Assert.assertEquals("Second number is not valid.", message);
}
	@Test
	public void testQuestion2With1stNumberInvalid() {
		loginFunction("ahsan", "ahsan_pass", "05/22/1993");
		wait.until(ExpectedConditions.urlContains("/q1"));

		doingMathsQuestions("2", "2", "4");
        wait.until(ExpectedConditions.urlContains("/q2"));

        doingMathsQuestions("s", "3", "1");
        wait.until(ExpectedConditions.urlContains("/q2"));
        String message = driver.findElement(By.tagName("div")).getText();
        Assert.assertEquals("First number is not valid.", message);
}
	@Test
	public void testQuestion2With2ndNumberInvalid() {
		loginFunction("ahsan", "ahsan_pass", "05/22/1993");
		wait.until(ExpectedConditions.urlContains("/q1"));

		doingMathsQuestions("2", "2", "4");
        wait.until(ExpectedConditions.urlContains("/q2"));

        doingMathsQuestions("6", "r", "1");
        wait.until(ExpectedConditions.urlContains("/q2"));
        String message = driver.findElement(By.tagName("div")).getText();
        Assert.assertEquals("Second number is not valid.", message);
}
	@Test
	public void testQuestion2WithWrongAnswer() {
		loginFunction("ahsan", "ahsan_pass", "05/22/1993");
		wait.until(ExpectedConditions.urlContains("/q1"));

		doingMathsQuestions("2", "2", "4");
        wait.until(ExpectedConditions.urlContains("/q2"));

        doingMathsQuestions("6", "3", "1");
        wait.until(ExpectedConditions.urlContains("/q2"));
        String message = driver.findElement(By.tagName("div")).getText();
        Assert.assertEquals("Wrong answer, try again.", message);
}
	//Test Cases for Q3
	@Test
	public void testQuestion3WithEmptyValues() {
		loginFunction("ahsan", "ahsan_pass", "05/22/1993");
		wait.until(ExpectedConditions.urlContains("/q1"));

		doingMathsQuestions("2", "2", "4");
        wait.until(ExpectedConditions.urlContains("/q2"));

        doingMathsQuestions("6", "2", "4");
        wait.until(ExpectedConditions.urlContains("/q3"));
        
        doingMathsQuestions("", "", "");
        wait.until(ExpectedConditions.urlContains("/q3"));
        String message = driver.findElement(By.tagName("div")).getText();
        Assert.assertEquals("First number is not valid.", message);
}
	@Test
	public void testQuestion3With2ndNumberEmpty() {
		loginFunction("ahsan", "ahsan_pass", "05/22/1993");
		wait.until(ExpectedConditions.urlContains("/q1"));

		doingMathsQuestions("2", "2", "4");
        wait.until(ExpectedConditions.urlContains("/q2"));

        doingMathsQuestions("6", "2", "4");
        wait.until(ExpectedConditions.urlContains("/q3"));
        
        doingMathsQuestions("6", "", "1");
        wait.until(ExpectedConditions.urlContains("/q3"));
        String message = driver.findElement(By.tagName("div")).getText();
        Assert.assertEquals("Second number is not valid.", message);
}
	@Test
	public void testQuestion3With1stNumberInvalid() {
		loginFunction("ahsan", "ahsan_pass", "05/22/1993");
		wait.until(ExpectedConditions.urlContains("/q1"));

		doingMathsQuestions("2", "2", "4");
        wait.until(ExpectedConditions.urlContains("/q2"));

        doingMathsQuestions("6", "2", "4");
        wait.until(ExpectedConditions.urlContains("/q3"));
        
        doingMathsQuestions("s", "3", "1");
        wait.until(ExpectedConditions.urlContains("/q3"));
        String message = driver.findElement(By.tagName("div")).getText();
        Assert.assertEquals("First number is not valid.", message);
}
	@Test
	public void testQuestion3With2ndNumberInvalid() {
		loginFunction("ahsan", "ahsan_pass", "05/22/1993");
		wait.until(ExpectedConditions.urlContains("/q1"));

		doingMathsQuestions("2", "2", "4");
        wait.until(ExpectedConditions.urlContains("/q2"));

        doingMathsQuestions("6", "2", "4");
        wait.until(ExpectedConditions.urlContains("/q3"));
        
        doingMathsQuestions("6", "e", "1");
        wait.until(ExpectedConditions.urlContains("/q3"));
        String message = driver.findElement(By.tagName("div")).getText();
        Assert.assertEquals("Second number is not valid.", message);
}
	@Test
	public void testQuestion3WithWrongAnswer() {
		loginFunction("ahsan", "ahsan_pass", "05/22/1993");
		wait.until(ExpectedConditions.urlContains("/q1"));

		doingMathsQuestions("2", "2", "4");
        wait.until(ExpectedConditions.urlContains("/q2"));

        doingMathsQuestions("6", "2", "4");
        wait.until(ExpectedConditions.urlContains("/q3"));
        
        doingMathsQuestions("6", "3", "1");
        wait.until(ExpectedConditions.urlContains("/q3"));
        String message = driver.findElement(By.tagName("div")).getText();
        Assert.assertEquals("Wrong answer, try again.", message);
}
	}

