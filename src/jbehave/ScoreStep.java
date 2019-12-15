package jbehave;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;

import game.Score;
import org.junit.Assert;

public class ScoreStep extends Steps {

    private Score score;

    @Given("score")
    public void setScore() {
        score = new Score();
    }
    
    @When("Obliczam wynik $difficulty $mode $usedHints $time")
    public void calculateResult(String difficulty, String mode, int usedHints, long time){
        score.calculateResult(difficulty, mode, usedHints, time);
        System.out.println("Obliczam wynik dla: poziom trudnoœci: "+difficulty+" tryb: "+mode+" wykorzystane podpowiedzi: "+usedHints+" czas: "+time);
    }
    
    @Then("Wynik $result")
    public void testResult(int output){
        Assert.assertEquals(output, score.getResult() );
        System.out.println(score.getResult());
    }
}
