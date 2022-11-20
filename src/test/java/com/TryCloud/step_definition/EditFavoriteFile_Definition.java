package com.TryCloud.step_definition;

import com.TryCloud.pages.EditFavoriteFilePage;
import com.TryCloud.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class EditFavoriteFile_Definition {
    EditFavoriteFilePage editFavoriteFilePage = new EditFavoriteFilePage();
    LoginPage loginPage = new LoginPage();

    WebElement storeRemoveFile;
    @Given("user on the dashboard page")
    public void user_on_the_dashboard_page() {
        loginPage.login("User6","Userpass123");
    }
    @When("the user clicks the Files module")
    public void the_user_clicks_the_module() {
        editFavoriteFilePage.clickFile.click();
    }
    @When("the users click action-icon from any file on the page to remove")
    public void the_users_click_action_icon_from_any_file_on_the_page_to_remove() throws InterruptedException {
        for (int i=0;i<=editFavoriteFilePage.actionModuleIcon.size();i++){
            if (editFavoriteFilePage.actionModuleIcon.get(4).isDisplayed()){
                editFavoriteFilePage.actionModuleIcon.get(4).click();
                for (int j =0;j<=editFavoriteFilePage.chooseFileModule.size();j++){
                    storeRemoveFile = editFavoriteFilePage.fileNameModule.get(4);
                    break;
                }break;

            }
        }
    }
    @When("user choose the Remove from favorites option")
    public void user_choose_the_option() {
        editFavoriteFilePage.removeFromFavorite.click();

    }
    @When("user click the Favorites sub-module on the left side")
    public void user_click_the_sub_module_on_the_left_side() {
        editFavoriteFilePage.clickOnFavorite.click();
    }
    @Then("Verify that the file is removed from the Favorites sub-module’s table")
    public void verify_that_the_file_is_removed_from_the_favorites_sub_module_s_table() {
        Assert.assertFalse(storeRemoveFile.isDisplayed());
    }
    @When("the user clicks the add icon on the top")
    public void theUserClicksTheAddIconOnTheTop() {
        editFavoriteFilePage.clickAddIcon.click();
    }
    @And("users uploads file with the “upload file” option")
    public void usersUploadsFileWithTheUploadFileOption() throws InterruptedException {
        Thread.sleep(3000);
        editFavoriteFilePage.inputFile.sendKeys
                ("C:/Users/techa/Downloads/some-file.txt");
    }
    @Then("verify the file is displayed on the page")
    public void verifyTheFileIsDisplayedOnThePage() {
        Assert.assertTrue(editFavoriteFilePage.someFileUploaded.isDisplayed());
        if (editFavoriteFilePage.someFileUploaded.isDisplayed()){
            System.out.println
                    (editFavoriteFilePage.someFileUploaded.getText()
                            +" is successfully uploaded");
        }
    }
}
