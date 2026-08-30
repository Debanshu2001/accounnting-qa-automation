package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    // Locators - common for PHPMaker generated apps; adjust if needed after inspect
    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "btnsubmit")
    private WebElement loginButton;

    @FindBy(id = "btnreset")
    private WebElement resetButton;

    @FindBy(xpath = "//a[contains(text(),'Logout') or contains(text(),'Log Out') or contains(@href,'logout')]")
    private WebElement logoutLink;

    @FindBy(xpath = "//*[contains(@class,'alert') or contains(text(),'Incorrect') or contains(text(),'Invalid') or contains(text(),'error')]")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username) {
        usernameField.clear();
        if (username != null && !username.isEmpty()) {
            usernameField.sendKeys(username);
        }
    }

    public void enterPassword(String password) {
        passwordField.clear();
        if (password != null && !password.isEmpty()) {
            passwordField.sendKeys(password);
        }
    }

    public void clickLogin() {
        loginButton.click();
    }

    public void clickReset() {
        resetButton.click();
    }

    public boolean isLogoutVisible() {
        try {
            return logoutLink.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isErrorDisplayed() {
        try {
            return errorMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
