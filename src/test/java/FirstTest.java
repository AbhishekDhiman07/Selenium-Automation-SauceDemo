import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class FirstTest {

    @Test
    public void myFirstAutomationTest() {
        // 1. Setup
        WebDriver driver = new ChromeDriver();
        
        // This makes the window big so you can see everything clearly
        driver.manage().window().maximize(); 
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try {
            // 2. Open the practice site
            driver.get("https://www.saucedemo.com/");

            // 3. Login
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();

            // 4. Add the 'Backpack' to the cart
            driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

            // 5. Verify the Cart shows '1' item
            String cartCount = driver.findElement(By.className("shopping_cart_badge")).getText();
            
            if (cartCount.equals("1")) {
                System.out.println("✅ SUCCESS: Cart count is: " + cartCount);
            } else {
                System.out.println("❌ FAILURE: Cart count is: " + cartCount);
            }

            // --- THE LONG PAUSE ---
            System.out.println("Waiting for 70 seconds before closing...");
            Thread.sleep(70000); 

        } catch (Exception e) {
            System.out.println("⚠️ ERROR: " + e.getMessage());
        } finally {
            // 6. Cleanup
            driver.quit();
        }
    }
}