		package tests;
		
		import java.util.Random;
		
		import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.WebElement;
		import org.openqa.selenium.chrome.ChromeDriver;
		import org.openqa.selenium.edge.EdgeDriver;
		import org.testng.Assert;
		import org.testng.annotations.BeforeTest;
		import org.testng.annotations.Test;
		
		public class Tests {
			
		
			WebDriver driver = new EdgeDriver();
			String webSite = "https://magento.softwaretestingboard.com/";
			Random random = new Random();
			String[] firstName = { "yazan", "mohammad", "mahmoud", "kalel", "ahmad", "abed" };
			String fname = firstName[random.nextInt(firstName.length)];
			String[] lastName = { "yanal", "kasem", "naeem", "ibraheem", "jakop" };
			String lname = firstName[random.nextInt(lastName.length)];
			String password = "sdM.12se";
			int num=random.nextInt(84262);
			String email=fname+lname+num+"@gmail.com";
			
		
			@BeforeTest
			public void setup() {
				driver.get(webSite);
				driver.manage().window().maximize();
		
			}
		    //1
			@Test(priority=1,enabled = true)
			public void signUp() throws InterruptedException {
				//driver.findElement(By.cssSelector("header[class='page-header'] li:nth-child(3) a:nth-child(1)")).click();
				driver.navigate().to("https://magento.softwaretestingboard.com/customer/account/create/");
				driver.findElement(By.id("firstname")).sendKeys(fname);
				driver.findElement(By.id("lastname")).sendKeys(lname);
				driver.findElement(By.id("email_address")).sendKeys(email);
				driver.findElement(By.id("password")).sendKeys(password);
				driver.findElement(By.id("password-confirmation")).sendKeys(password);
				driver.findElement(By.cssSelector("button[title='Create an Account'] span")).click();
				Boolean ActualResult=driver.getPageSource().contains("welcome");
				Assert.assertEquals(true, ActualResult);
				
			}
			//11
			@Test (priority=3,enabled=true)
					public void PrivacyandPolicy() throws InterruptedException {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollTo(0,1900)");
				
				String conf1 ="Privacy Policy";
				String conf2 ="Luma Security";
				String conf3 ="The Information We Collect";
				driver.findElement(By.xpath("//a[normalize-space()='Privacy and Cookie Policy']")).click();
				Boolean ActualResult=driver.getPageSource().contains(conf1);
				Boolean ActualRe=driver.getPageSource().contains(conf2);
				Boolean ActualR=driver.getPageSource().contains(conf3);
				Assert.assertEquals(true, ActualResult&&ActualRe&&ActualR);
		
			}
			//13
			@Test(priority=4,enabled=true)
			public void InvalidInputsRegister() throws InterruptedException {
				String conferm="Please enter a valid email address";
				//driver.findElement(By.cssSelector("header[class='page-header'] li:nth-child(3) a:nth-child(1)")).click();
				driver.navigate().to("https://magento.softwaretestingboard.com/customer/account/create/");
                driver.findElement(By.id("firstname")).sendKeys(fname);
				driver.findElement(By.id("lastname")).sendKeys(lname);
				driver.findElement(By.id("email_address")).sendKeys("ernlkwsfk25");
				driver.findElement(By.id("password")).sendKeys(password);
				driver.findElement(By.id("password-confirmation")).sendKeys(password);
				driver.findElement(By.cssSelector("button[title='Create an Account'] span")).click();
			    Boolean ActualResult=driver.getPageSource().contains(conferm);
			    Assert.assertEquals(true, ActualResult);
			}
			
			//14
			@Test(priority=2,enabled=true)
			public void logOut() {
				String conf="You are signed out";
				driver.findElement(By.cssSelector("div[class='panel header'] button[type='button']")).click();
				driver.findElement(By.cssSelector("div[aria-hidden='false'] li[data-label='or'] a")).click();
				Boolean ActualResult=driver.getPageSource().contains(conf);
				Assert.assertEquals(true, ActualResult);
				
			}
		
		}
		
		
		
		
		
		
		
		
		
		
		/*
		 1. Homepage Accessibility
Test Case ID: TC_MSTB_001
Objective: Verify that the homepage loads successfully without errors.
Test Steps:
Navigate to https://magento.softwaretestingboard.com/.
Expected Result: The homepage loads completely, displaying featured products and navigation menus.
2. User Registration Process
Test Case ID: TC_MSTB_002
Objective: Ensure that new users can register an account.
Test Steps:
Click on the "Create an Account" link.
Fill in the required registration details.
Submit the registration form.
Expected Result: A new user account is created, and a confirmation message is displayed.
3. User Login Functionality
Test Case ID: TC_MSTB_003
Objective: Verify that registered users can log in successfully.
Test Steps:
Click on the "Sign In" link.
Enter valid credentials.
Submit the login form.
Expected Result: The user is logged in and redirected to their account dashboard.
4. Product Search Functionality
Test Case ID: TC_MSTB_004
Objective: Ensure that users can search for products using keywords.
Test Steps:
Enter a product name (e.g., "Radiant Tee") into the search bar.
Press Enter or click the search icon.
Expected Result: A list of relevant products matching the search term is displayed.magento.softwaretestingboard.com
5. Filtering Search Results
Test Case ID: TC_MSTB_005
Objective: Verify that users can filter search results based on categories (e.g., price, color).
Test Steps:
Perform a product search.
Apply various filters to the search results.
Expected Result: Search results update to reflect the applied filters.
6. Viewing Product Details
Test Case ID: TC_MSTB_006
Objective: Ensure that users can view detailed information about a product.
Test Steps:
Click on a product from the listings.
Expected Result: The product detail page displays images, specifications, price, and availability.
7. Adding Products to Cart
Test Case ID: TC_MSTB_007
Objective: Verify that users can add products to the shopping cart.
Test Steps:
Navigate to a product detail page.
Select size and color if applicable.
Click the "Add to Cart" button.
Expected Result: The product is added to the cart, and a confirmation message is displayed.
8. Viewing and Modifying the Shopping Cart
Test Case ID: TC_MSTB_008
Objective: Ensure that users can view and modify their shopping cart.
Test Steps:
Click on the "Cart" icon.
Review the listed products.
Adjust quantities or remove items.
Expected Result: The cart updates accordingly, reflecting changes in quantity and total price.
9. Proceeding to Checkout
Test Case ID: TC_MSTB_009
Objective: Verify that users can proceed to the checkout process.
Test Steps:
Click on the "Cart" icon.
Click the "Proceed to Checkout" button.
Expected Result: The checkout page is displayed, showing address details and order summary.
x10. Contact Form Submission
Test Case ID: TC_MSTB_010
Objective: Ensure that users can submit inquiries through the contact form.
Test Steps:
Navigate to the "Contact Us" page.
Fill in the required fields.
Submit the form.
Expected Result: A confirmation message is displayed, indicating successful submission.
11. Privacy Policy Accessibility
Test Case ID: TC_MSTB_011
Objective: Verify that users can access and view the privacy policy.
Test Steps:
Click on the "Privacy and Cookie Policy" link in the footer.
Expected Result: The privacy policy page loads, displaying relevant information.
x12. Session Timeout Handling
Test Case ID: TC_MSTB_012
Objective: Verify that the application handles session timeouts appropriately.
Test Steps:
Log in with valid credentials.
Remain inactive for a period exceeding the session timeout threshold.
Attempt to navigate to a protected page.
Expected Result: The user is redirected to the login page, indicating that the session has expired.
13. Error Handling on Invalid Inputs
Test Case ID: TC_MSTB_013
Objective: Verify that the application handles invalid inputs gracefully.
Test Steps:
Attempt to register with invalid data (e.g., missing required fields).
Submit the form.
Expected Result: Appropriate error messages are displayed, guiding the user to correct the inputs.
14. Logging Out of the Account
Test Case ID: TC_MSTB_014
Objective: Verify that users can log out of their accounts successfully.
Test Steps:
Click on the "Sign Out" link.
Expected Result: The user is logged out and redirected to the homepage or login page.
x15. Product Comparison Feature
Test Case ID: TC_MSTB_015
Objective: Ensure that users can compare multiple products.
Test Steps:
Add multiple products to the comparison list.
Click on the "Compare Products" link.
Expected Result: A comparison page displays the selected products side by side, highlighting differences.

		 * */
