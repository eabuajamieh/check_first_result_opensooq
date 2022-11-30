import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Audi {

	SoftAssert softassertProcess = new SoftAssert();

	@BeforeTest()

	public void this_is_before_test() {

		WebDriverManager.chromedriver().setup();
		PassParameters.driver = new ChromeDriver();
		PassParameters.driver.get("https://jo.opensooq.com/en/cars/cars-for-sale/audi");
		PassParameters.driver.manage().window().maximize();
	}

	@Test()

	public void check_if_all_results_contains_the_word_audi() {
		PassParameters.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		List<WebElement> myResults = PassParameters.driver.findElements(By.className("noEmojiText"));

		for (int i = 0; i < myResults.size(); i++) {
			String[] first_result_array = myResults.get(0).getText().split(" ");
			PassParameters.first_result = first_result_array[0] + " " + first_result_array[1];
		}

		// put the car name in the search field and enter
		PassParameters.driver.findElement(By.name("term")).sendKeys(PassParameters.first_result + Keys.ENTER);

		PassParameters.driver.findElement(By.xpath("//*[@id=\"landingPostDynamicField\"]/div/button")).click();

		softassertProcess.assertEquals(PassParameters.check_result_exist(), true);

		softassertProcess.assertAll();

	}

}
