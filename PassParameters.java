import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PassParameters {

	static String first_result = "";
	static public WebDriver driver;
	static String newResult_String = "";

	public static Boolean check_result_exist() {
		List<WebElement> myNewResults = driver.findElements(By.className("noEmojiText"));

		for (int k = 0; k < myNewResults.size(); k++) {

			newResult_String = myNewResults.get(k).getText();
		}
		return newResult_String.contains(first_result);

	}

}
