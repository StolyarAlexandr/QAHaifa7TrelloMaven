package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageHelper extends PageBase{
    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "login")
    WebElement loginButton;

    @FindBy(id = "user")
    WebElement loginField;

    @FindBy(id = "error")
    WebElement errorMessage;

    @FindBy(id = "login-error")
    WebElement errorMessageAttl;

    @FindBy(xpath = "//input[@value='Log in with Atlassian']")
    WebElement loginButtonAttl;

    @FindBy(id = "login-submit")
    WebElement loginSubmitButton;

    public LoginPageHelper(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public LoginPageHelper loginAsAttlassian(String login, String password) {
        enterLoginAsAttlassian(login);
        submitAsAttlassian();
        enterPasswordAsAttlassian(password);
        return this;
    }

    public LoginPageHelper waitUntilPageIsLoaded() {
        waitUntilElementIsClickable(passwordField,15);
        waitUntilElementIsClickable(loginButton,10);
        waitUntilElementIsClickable(loginField,15);
        return this;
    }

    public String getErrorMessage()  {

        waitUntilElementIsVisible(errorMessage, 15);
        return errorMessage.getText();
    }

    public String getAttlassianErrorMessage(){
        waitUntilElementIsVisible(errorMessageAttl, 15);
        return errorMessageAttl.getText();
    }

    public LoginPageHelper pressLoginButton() {
        //waitUntilElementIsClickable(loginButton,10);
        log4j.info("LoginPageHelper: pressLoginButton()");
        log4j.info("----Wait 5 sec---");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log4j.info("Click on the login button");
        loginButton.click();
        return this;
    }

    public LoginPageHelper enterNotAttlassianPassword(String password) {
        log4j.info("LoginPageHelper: enterNotAttlassianPassword(password="+password+")");
        log4j.info("---Enter password value to the password field----");
        editField(passwordField,password);
        return this;
    }


    public LoginPageHelper enterNotAttlassianLogin(String login) {
        log4j.info("LoginPageHelper: enterNotAttlassianLogin(login="+login+")");
        log4j.info("---Enter login value to the login field");
        editField(loginField,login);
        return this;
    }

    public LoginPageHelper enterLoginAsAttlassian(String login) {
        editField(loginField,login);
        return this;
    }
    public LoginPageHelper submitAsAttlassian() {
        waitUntilElementIsClickable(loginButtonAttl,10);
        loginButtonAttl.click();
        waitUntilElementIsClickable(passwordField,20);
        return this;
    }
    public LoginPageHelper enterPasswordAsAttlassian(String password) {
        editField(passwordField,password);
        loginSubmitButton.click();
        return this;
    }
    public LoginPageHelper loginNotAttlassian(String login, String password) {
        log4j.info("LoginPageHelper: loginNotAttlassian(login="+login+", password="+password+")");
        enterNotAttlassianLogin(login);
        enterNotAttlassianPassword(password);
        pressLoginButton();

        return this;
    }




}
