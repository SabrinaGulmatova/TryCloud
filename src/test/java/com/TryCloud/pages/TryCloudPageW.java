package com.TryCloud.pages;

import com.TryCloud.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TryCloudPageW {
    public TryCloudPageW() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//input[@id='user']")
    public WebElement inputUsername;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement inputPassword;

    @FindBy(xpath = "//a[@aria-label='Files']")
    public WebElement fileModule;


    @FindBy(xpath = "//tr//td//span[@class='icon icon-more']")
    public List<WebElement> actionsList;



    @FindBy(xpath = "//a[@data-action='Delete']")
    public WebElement deleteButton;

    @FindBy(xpath = "//a[.='Deleted files']")
    public WebElement deletedFiles;

    @FindBy(xpath = "(//tr//td//span[@class='innernametext'])[12]")
    public List<WebElement> foldersNames;

    @FindBy(xpath = "(//tbody[@id='fileList'])[12]")
    public List <WebElement> newPage;

    //---------------------

    @FindBy(xpath = " //a[@aria-label='Talk']")
    public WebElement talk;


    @FindBy(xpath = "//input[@type='text']")
    public WebElement searchBox;


    @FindBy(xpath = "//span[@class='acli__content__line-one__title']")
    public List<WebElement> userChat;

    @FindBy(xpath = "//div[@placeholder='Write message, @ to mention someone …']")
    public WebElement messageBox;


    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitBttn;


    @FindBy(xpath = "//div[@class='rich-text--wrapper']")
    public List<WebElement> sentMsg;













    public void loginW() {
        inputUsername.sendKeys("user7");
        inputPassword.sendKeys("Userpass123" + Keys.ENTER);


    }


}

