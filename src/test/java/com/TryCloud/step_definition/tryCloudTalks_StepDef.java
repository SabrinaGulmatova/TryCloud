package com.TryCloud.step_definition;

import com.TryCloud.pages.TryCloudPageW;
import com.TryCloud.utilities.BrowserUtils;
import com.TryCloud.utilities.ConfigurationReader;
import com.TryCloud.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class tryCloudTalks_StepDef {

    TryCloudPageW tryCloudPageW= new TryCloudPageW();
    String message = "Hello World";

    @Given("user on the dashboard  page")
    public void user_on_the_dashboard_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        tryCloudPageW.login();



    }
    @When("the user clicks the Talk  module")
    public void the_user_clicks_the_talk_module() {
        tryCloudPageW.talk.click();

    }
    @Then("verify the page title is {string}")
    public void verify_the_page_title_is(String string) {

        BrowserUtils.verifyTitle(Driver.getDriver(),string);


    }


    @When("user search user from the search box")
    public void user_search_user_from_the_search_box() {
        tryCloudPageW.searchBox.sendKeys("User");


    }
    @When("user write a message")
    public void user_write_a_message() {
        Faker faker= new Faker();
    tryCloudPageW.userChat.get(faker.number().numberBetween(0,tryCloudPageW.userChat.size()-1)).click();
    tryCloudPageW.messageBox.sendKeys(message);

    }
    @When("user clicks to submit button")
    public void user_clicks_to_submit_button() {
    tryCloudPageW.submitBttn.click();



    }
    @Then("the user should be able to see the message is displayed on the conversation log")
    public void the_user_should_be_able_to_see_the_message_is_displayed_on_the_conversation_log() throws InterruptedException {
        Assert.assertEquals(message ,tryCloudPageW.sentMsg.get(tryCloudPageW.sentMsg.size()-1).getText());
        Thread.sleep(3000);


    }

}
