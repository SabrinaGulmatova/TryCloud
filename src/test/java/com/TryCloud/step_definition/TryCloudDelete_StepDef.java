package com.TryCloud.step_definition;

import com.TryCloud.pages.TryCloudPageW;
import com.TryCloud.utilities.ConfigurationReader;
import com.TryCloud.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TryCloudDelete_StepDef {
    TryCloudPageW tryCloudPageW = new TryCloudPageW();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
  public WebElement deletedFolder;

    @Given("user on the dashboard page")
    public void user_on_the_dashboard_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        tryCloudPageW.login();
    }
    @When("the user clicks the Files module")
    public void the_user_clicks_the_files_module() {
        wait.until(ExpectedConditions.visibilityOf(tryCloudPageW.fileModule));
        tryCloudPageW.fileModule.click();
    }

    @When("user click action-icon  from any file on the page")
    public void user_click_action_icon_from_any_file_on_the_page() {
        Faker faker= new Faker();
        deletedFolder = tryCloudPageW.actionsList.get(faker.number().numberBetween(0,tryCloudPageW.actionsList.size()-1));

        deletedFolder.click();
    }

    @When("user choose the Delete f option")
    public void user_choose_the_delete_f_option() {
        tryCloudPageW.deleteButton.click();
    }
    @When("the user clicks the Deleted files sub-module on the left side")
    public void the_user_clicks_the_deleted_files_sub_module_on_the_left_side() throws InterruptedException {

        tryCloudPageW.deletedFiles.click();
        Thread.sleep(3000);
    }

    @Then("Verify the deleted file is displayed on the page.")
    public void verify_the_deleted_file_is_displayed_on_the_page() {
        for (WebElement each : tryCloudPageW.foldersNames)
            for (WebElement each1 : tryCloudPageW.newPage) {

                if (each.getText() == each1.getText()) {
                    break;
                }
     Assert.assertTrue(" Yay Passed! ",each.isDisplayed() );

            }
    }}

