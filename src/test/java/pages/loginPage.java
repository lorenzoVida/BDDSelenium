package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage extends basePage {
    WebDriver driver;

    By usuario = By.cssSelector("input[placeholder='Username']");
    String browser ="chrome";
    String app ="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";


    public loginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input[placeholder='Username']")
    WebElement txtUsuario;
    //WebElement user = driver.findElement(By.cssSelector("input[placeholder='Username']"));

    @FindBy(css = "input[placeholder='Password']")
    WebElement txtPassword;

    @FindBy(css = "button[type='submit']")
    WebElement btnIngresar;

    public void setUp() {
        ChromeOptions options = new ChromeOptions();
         driver = new ChromeDriver();
        visit(app);
    }
    public void ingresarUsuarioYPassword(String user, String pass) {
        waitForElementToAppear(usuario);
       // if(txtUsuario.isDisplayed()) {
            txtUsuario.sendKeys(user);
            txtPassword.sendKeys(pass);
            btnIngresar.click();
        //}
    }
}
