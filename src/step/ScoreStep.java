package step;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import game.Score;
import org.junit.Assert;

public class ScoreStep {

    private Score score;

    @Given("score")
    public void setScore() {
        score = new Score();
    }
    
    @When("Obliczam wynik $difficulty $mode $usedHints $time")
    public void calculateResult(String difficulty, String mode, int usedHints, long time){
        score.calculateResult(difficulty, mode, usedHints, time);
    }
    
    @Then("Wynik $result")
    public void testResult(int output){
        Assert.assertEquals(output, score.getResult() );
    }
}
