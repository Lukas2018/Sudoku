package jbehave;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;

import game.Game;
import org.junit.Assert;

public class DifficultyStep extends Steps {

    private Game game;

    @Given("game")
    public void setScore() {
        game = Game.getGameInstance();
    }
    
    @When("Ustawiam difficulty na $dif")
    public void calculateResult(String dif){
        game.setDifficulty(dif);
    }
    
    @Then("Game pokazuje ze difficulty wynosi $result")
    public void testResult(String output){
        Assert.assertEquals(output, game.getDifficulty() );
    }
}