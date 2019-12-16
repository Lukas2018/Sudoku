package jbehave;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;

import game.Field;
import org.junit.Assert;

public class FieldStep extends Steps {

    private Field field;

    @Given("field")
    public void setScore() {
        field = new Field();
    }
    
    @When("Ustawiam wartosc na $value")
    public void calculateResult(int value){
        field.setValueOfField(value);
    }
    
    @Then("Wartosc field wynosi $result")
    public void testResult(int output){
        Assert.assertEquals(output, field.getValueOfField() );
    }
}