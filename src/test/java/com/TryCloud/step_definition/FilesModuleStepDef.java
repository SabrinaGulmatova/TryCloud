package com.TryCloud.step_definition;

import com.TryCloud.pages.FilesModulePage;
import com.TryCloud.utilities.ConfigurationReader;
import com.TryCloud.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class FilesModuleStepDef {

    FilesModulePage filesModulePage = new FilesModulePage();

    @Given("user on the dashboard page")
    public void user_on_the_dashboard_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        filesModulePage.login(ConfigurationReader.getProperty("username1"),ConfigurationReader.getProperty("password"));
    }
    @When("the user clicks the Files module")
    public void the_user_clicks_the_files_module() {
        filesModulePage.filesButton.click();
    }
    @Then("verify the page title is Files - Trycloud QA")
    public void verify_the_page_title_is_files_trycloud_qa() {
        String expectedTitle = "Files - Trycloud QA";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @When("user click the top-left checkbox of the table")
    public void user_click_the_top_left_checkbox_of_the_table() {
        filesModulePage.selectAllCheckBox.click();
    }
    @Then("verify all the files are selected")
    public void verify_all_the_files_are_selected() {
        filesModulePage.selectAllCheckBox.isSelected();
    }

}
