package StepDef;


import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.openqa.selenium.*;
import io.cucumber.java.en.*;
import java.time.Duration;


public class FirstStepdefs {

    public static WebDriver driver = new ChromeDriver();
    String expected_title = "Latest online English world news photo video live bd";


    @Before
    public void startBrowser()
    {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }



// TC_Home_001 Verify the Prothom Alo Application Home Page Title
    @When("Open Prothom Alo Home Page in browser")
    public void OpenProthomAlo() throws InterruptedException {
        driver.get("https://en.prothomalo.com/");
        Thread.sleep(3000);
    }
    @Then("Verify the title")
    public void TitleVerify() throws InterruptedException {
         if (driver.getTitle().equalsIgnoreCase(expected_title))
            System.out.println("Prothom Alo Home Page title is correctly match");
        else
            System.out.println("Something Wrong in Prothom Alo Home Page title");
    Thread.sleep(1000);
    }



// TC_Home_002 Verify side navigation bar is showing and work properly
    @When("Click on ham burger icon")
    public void clickOnHamBurgerIcon() throws InterruptedException {
        WebElement ham = driver.findElement(By.xpath("//div[@class='hamburger Yan0a']"));
        ham.click();
        Thread.sleep(1000);
    }

    @Then("Click on home button on side navigation bar")
    public void clickOnHomeButtonOnSideNavigationBar() throws InterruptedException {
        WebElement homeBtn =driver.findElement(By.linkText("Home"));
        homeBtn.click();
        System.out.println("Side navigation bar is showing and work properly");
        Thread.sleep(1000);
    }

// TC_Home_003 Verify Search News Functionality
    @When("Click on search icon")
    public void clickOnSearchIcon() throws InterruptedException {
        WebElement SearchBtn = driver.findElement(By.xpath("//span[@class='search-icon-wrapper FaggC']"));
        SearchBtn.click();
        Thread.sleep(1000);
    }

    @Then("input search keyword")
    public void inputSearchKeyword() throws InterruptedException {
        WebElement SearchBar = driver.findElement(By.name("q"));
        SearchBar.sendKeys("News");
        WebElement SearchEnter = driver.findElement(By.xpath("//button[@type='submit']"));
        SearchEnter.click();
        Thread.sleep(3000);
    }

    @And("Select first result")
    public void selectFirstResult() throws InterruptedException {
        WebElement SearchCont = driver.findElement(By.xpath("//span[@class='tilte-no-link-parent']"));
        SearchCont.click();
        System.out.println("Search News is Working properly");
        Thread.sleep(2000);
    }



// TC_Login_1 Verify Functionality of login module
    @When("Click on Login Button")
    public void clickOnLoginButton() throws InterruptedException {
        WebElement LoginBtn = driver.findElement(By.xpath("//button[@class='desktop-btn btn _9DzOy']"));
        LoginBtn.click();
        Thread.sleep(2000);
    }

    @Then("Input Email And Password")
    public void inputEmailAndPassword() throws InterruptedException {
        WebElement Email = driver.findElement(By.name("email"));
        Email.sendKeys("saharahul353@gmail.com");
        WebElement Password = driver.findElement(By.xpath("//input[@class='password SqWiZ ']"));
        Password.sendKeys("asdfgh1234");
        Thread.sleep(1000);
    }

    @And("Click Login Button")
    public void clickLoginButton() throws InterruptedException {
        WebElement LoginBton = driver.findElement(By.xpath("//button[@class='button Tq1xe']"));
        LoginBton.click();
        System.out.println("login module is Working properly");
        Thread.sleep(3000);
    }

// TC_Login_002 Verify Login Profile
    @When("Open Login Profile")
    public void openLoginProfile() throws InterruptedException {
        WebElement probtn = driver.findElement(By.xpath("//div[@class='HSALi']"));
        probtn.click();
        Thread.sleep(3000);
    }
    @Then("Check profile Email")
    public void checkProfileEmail() throws InterruptedException {
        WebElement PName = driver.findElement(By.xpath("//span[@class='_646En']"));
        String name = PName.getText();
        String EName = "Rahul Saha";
        Assert.assertEquals(EName, name);
        System.out.println("My Profile Is Ok");
        Thread.sleep(1000);
    }


// TC_Login_003 Verify logout Functionality
    @When("Click Logout Button")
    public void clickLogoutButton() throws InterruptedException {
        WebElement logOut = driver.findElement(By.xpath("//button[@class='btn logout-btn _9DzOy']"));
        logOut.click();
        Thread.sleep(1000);
    }

    @Then("try to open profile")
    public void tryToOpenProfile() throws InterruptedException {
        driver.get("https://en.prothomalo.com/profile");
        WebElement login =driver.findElement(By.linkText("Click here to login"));
        login.click();
        System.out.println("Logout Functionality is ok");
        Thread.sleep(1000);
    }

// TC_Login_004 Verify User and Password Validation

    @When("Input Email And Wrong Password")
    public void inputEmailAndWrongPassword() throws InterruptedException {
        WebElement Email = driver.findElement(By.name("email"));
        Email.sendKeys("saharahul353@gmail.com");
        WebElement Password = driver.findElement(By.xpath("//input[@class='password SqWiZ ']"));
        Password.sendKeys("asdfgh");
        Thread.sleep(1000);
    }

    @Then("Click Login")
    public void clickLogin() throws InterruptedException {
        WebElement LoginBton = driver.findElement(By.xpath("//button[@class='button Tq1xe']"));
        LoginBton.click();
        Thread.sleep(1000);
    }

    @And("Check return error")
    public void checkReturnError() throws InterruptedException {
        String Eerror = "Your email address or password is incorrect. Please check and try again";
        WebElement error =  driver.findElement(By.xpath("//div[@class='error-wrapper QhDnj']"));
        String Error = error.getText();
        Assert.assertEquals(Eerror, Error);
        System.out.println("Password Validation is working properly");
        Thread.sleep(1000);
    }

//TC_Create_001 Verify the Email Validation Functionality
    @Given("Open Create Account Page")
    public void openCreateAccountPage() throws InterruptedException {
        WebElement CreateBtn = driver.findElement(By.linkText("Create an account"));
        CreateBtn.click();
        Thread.sleep(1000);

    }

    @When("Enter valid Full Name Email Password Confirm Password")
    public void enterValidFullNameEmailPasswordConfirmPassword() throws InterruptedException {
        driver.findElement(By.name("name")).sendKeys("Test Name");
        driver.findElement(By.name("email")).sendKeys("Email");
        driver.findElement(By.name("password")).sendKeys("Asdfg1234");
        driver.findElement(By.name("confirmPassword")).sendKeys("Asdfg1234");
        Thread.sleep(1000);

    }

    @Then("Click Register Button")
    public void clickRegisterButton() throws InterruptedException {
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']")));
        WebElement cap = driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-border']"));
        cap.click();
        Thread.sleep(9000);
        driver.switchTo().parentFrame();
        WebElement reg = driver.findElement(By.xpath("//button[@class='button Tq1xe']"));
        reg.click();
        Thread.sleep(1000);


    }

    @And("Check for name error")
    public void checkForError() throws InterruptedException {
        WebElement er = driver.findElement(By.className("_2UuOH"));
        String err = er.getText();
        if (err.contains("Please enter a valid email address"))
            System.out.println("Email Validation working Properly");
        else
            System.out.println("Something Wrong in Email Validation");
        Thread.sleep(1000);
    }
//TC_Create_002 Verify the Password Validation Functionality
    @When("Enter Name short Password")
    public void enterNameShortPassword() throws InterruptedException {
        WebElement nm = driver.findElement(By.name("name"));
        nm.clear();
        nm.sendKeys("Test Name");
        WebElement em =driver.findElement(By.name("email"));
        em.clear();
        em.sendKeys("email@email.com");
        WebElement pp =driver.findElement(By.name("password"));
        pp.clear();
        pp.sendKeys("1234");
        WebElement cp =driver.findElement(By.name("confirmPassword"));
        cp.clear();
        cp.sendKeys("1234");
        Thread.sleep(1000);
    }
    @Then("Click Register")
    public void clickRegister() throws InterruptedException {
        WebElement reg = driver.findElement(By.xpath("//button[@class='button Tq1xe']"));
        reg.click();
        Thread.sleep(1000);
    }
    @And("Check for password error")
    public void checkForPasswordError() throws InterruptedException {
        WebElement er = driver.findElement(By.xpath("(//span[@class='_7wW5k'])[1]"));
        String err = er.getText();
        if (err.contains("Password too short"))
            System.out.println("Password Validation working Properly");
        else
            System.out.println("Something Wrong in Password Validation");
        Thread.sleep(1000);

    }

//TC_Create_003 Verify the Confirm Password Validation Functionality
    @When("Enter Name Password")
    public void enterNamePassword() throws InterruptedException {
        WebElement nm = driver.findElement(By.name("name"));
        nm.clear();
        nm.sendKeys("Test Name");
        WebElement em =driver.findElement(By.name("email"));
        em.clear();
        em.sendKeys("email@email.com");
        WebElement pp =driver.findElement(By.name("password"));
        pp.clear();
        pp.sendKeys("asdf1234");
        WebElement cp =driver.findElement(By.name("confirmPassword"));
        cp.clear();
        cp.sendKeys("asdfg1234");
        Thread.sleep(1000);
    }

    @And("Check for password matching error")
    public void checkForPasswordMatchingError() throws InterruptedException {
        WebElement er = driver.findElement(By.xpath("//div[@class='error-wrapper QhDnj']"));
        String err = er.getText();
        if (err.contains("Password do not match"))
            System.out.println("Confirm Password Validation working Properly");
        else
            System.out.println("Something Wrong in Confirm Password Validation");
        Thread.sleep(3000);
        System.out.println("End Of Test Prothom Alo");

        driver.quit();

    }
}
