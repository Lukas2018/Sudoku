package jbehave;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;

import game.Game;
import game.Board;
import org.junit.Assert;

public class RomanStep extends Steps {

    private Game game;

    @Given("Roman mode")
    public void setScore() {
        game = Game.getGameInstance();
    }
    
    @When("ustaw mode na $mode")
    public void calculateResult(String mode){
    	System.out.println("Ustawiam tryb: "+mode);
    	game.setMode(mode);
 
    }
    
    @Then("mode as $mode")
    public void testResult(String mode){
        Assert.assertEquals(mode, game.getMode() );
        System.out.println("poprawnie zmieniono tryb");
    }
}