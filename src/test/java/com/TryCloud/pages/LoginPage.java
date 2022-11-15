package com.TryCloud.pages;

import com.TryCloud.utilities.ConfigurationReader;
import com.TryCloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.getDriverPool(),this);
    }

    @FindBy(xpath = "//input[@id='user']")
    public WebElement username;

    @FindBy (xpath = "//input[@id='password']")
    public WebElement password;

    @FindBy (xpath = "//input[@id='submit-form']")
    public WebElement submitBtn;

    public void login(String user,String pass){
        Driver.getDriverPool().get(ConfigurationReader.getProperty("env"));
        username.sendKeys(user);
        password.sendKeys(pass);
        submitBtn.click();
        // Driver.getDriverPool().manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
    }
}
