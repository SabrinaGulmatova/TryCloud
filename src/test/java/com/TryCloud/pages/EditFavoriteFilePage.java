package com.TryCloud.pages;

import com.TryCloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class EditFavoriteFilePage {
    //First scenario start here
    public EditFavoriteFilePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@id='user']")//login username
    public WebElement username;
    @FindBy (xpath = "//input[@id='password']")//login password
    public WebElement password;
    @FindBy (xpath = "//input[@id='submit-form']")//login button
    public WebElement submitBtn;
    @FindBy (xpath = "//ul[@id='appmenu']//li[@data-id='files']")//user clicks the "Files" module
    public WebElement clickFile;
    @FindBy (xpath = "//span[@class='nametext']")
    public List<WebElement> chooseFileModule;
    @FindBy (xpath = "//a[@data-action='menu']")//users click action-icon from any file on the page to remove
    public List<WebElement> actionModuleIcon;
    @FindBy (xpath = "//span[.='Remove from favorites']")//user choose the "Remove from favorites" option
    public WebElement removeFromFavorite;
    @FindBy (xpath = "//a[@class='nav-icon-favorites svg']")//user click the "Favorites" sub-module on the left side
    public WebElement clickOnFavorite;
    @FindBy(xpath = "//span[@class='nametext']")
    public List<WebElement> fileNameModule;

    //Second Scenario start here
    @FindBy (xpath = "//a[@class='button new']")//    When the user clicks the add icon on the top

    public WebElement clickAddIcon;
    @FindBy (xpath = "//input[@type='file']")
    public WebElement inputFile;
    @FindBy (xpath = "//span[.='some-file']")
    public WebElement someFileUploaded;
}
