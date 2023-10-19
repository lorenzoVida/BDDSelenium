package stepDefinition;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.loginPage;
import java.util.List;

public class loginStep {

    private static loginPage logeo;
    String app ="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    WebDriver driver;
    @Given("enter the login form")
    public void enterTheLoginForm() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver();
        driver.get(app);
    }


    @When("^type user and password$")
    public void typeUserAndPassword(DataTable table) throws InterruptedException {

        List<List<String>> rows = table.asLists(String.class);
        for (List<String> columns : rows) {
            Thread.sleep(2000);
            driver.findElement(By.cssSelector("input[placeholder='Username")).sendKeys(columns.get(0));
            driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys(columns.get(0));
            driver.findElement(By.cssSelector("button[type='submit']")).click();
            System.out.println(columns);
        }
    }

    @Then("show message user or password wrong")
    public void mostrarDashboard() {
        System.out.println("hola");
    }

}