package jbehave;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;

import game.Timer;
import org.junit.Assert;

public class TimerStep extends Steps {

    private Timer timer;

    @Given("timer")
    public void setScore() {
        timer = new Timer();
    }
    
    @When("Ustawiam timer na $time")
    public void calculateResult(long time){
        timer.setTimer(time);
    }
    
    @Then("Timer wskazuje $result")
    public void testResult(int output){
        Assert.assertEquals(output, timer.getTime() );
    }
}