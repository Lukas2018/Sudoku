package jbehave;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;

import game.Hint;
import org.junit.Assert;

public class HintStep extends Steps {

    private Hint hint;

    @Given("hint")
    public void setScore() {
        hint = new Hint();
    }
    
    @When("Uzywam podpowiedzi $ilosc")
    public void calculateResult(int ilosc){
    	System.out.println("ilosc podpowiedzi: "+ilosc);
    	for(int i=0;i<ilosc;i++) {
    		hint.getHint();
    		System.out.println("Podpowiedz zosta³a zu¿yta");
    	}
    }
    
    @Then("ilosc podpowiedzi $result")
    public void testResult(int output){
        Assert.assertEquals(output, hint.getAmountOfHints() );
        System.out.println(hint.getAmountOfHints());
    }
}