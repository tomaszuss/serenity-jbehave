package smoketests.stepdefinitions;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class UsingStepLibrariesStepDefinitions {


    public static class SomeStepLibrary {

        public int stepRunCount = 0;

        @Step
        public void doSomething() {
            stepRunCount++;
        }

        @Step
        public void doSomethingElse() {
            stepRunCount++;
        }

        @Step
        public void doSomeOtherThing() {
            stepRunCount++;
        }
    }

    @Steps
    private SomeStepLibrary someStepLibrary;

    @Given("I want to use a step library")
    public void givenIWantToUseAStepLibrary() {
    }

    @When("I use a step library field annotated with @Steps")
    public void whenIAddAStepLibraryFieldAnnotatedWithSteps() {
    }

    @Then("Serenity should instantiate the field")
    public void thenSerenityShouldInstantiateTheField() {
        assertThat(someStepLibrary, notNullValue());
    }

    //////

    @Steps
    private SomeStepLibrary someOtherStepLibrary;

    @Given("I want to use several step library fields of the same type")
    public void givenIWantToUseSeveralStepLibraryFieldsOfTheSameType() {
    }

    @When("I use a step library fields to each of them")
    public void whenIAddAStepLibraryFieldsToEachOfThem() {
    }

    @Then("Serenity should instantiate a different library for each field")
    public void thenSerenityShouldInstantiateADifferentLibraryForEachField() {
        assertThat(someOtherStepLibrary, is(not(sameInstance(someStepLibrary))));
    }

    /////
    @Steps
    private SomeStepLibrary myStepLibrary;

    @Given("I have a Serenity step library")
    public void givenIHaveASerenityStepLibrary() {
    }

    @When("I do something with the library")
    public void whenIDoSomethingWithTheLibrary() {
        myStepLibrary.doSomething();
    }

    @Then("the state of the library should be updated")
    public void thenTheStateOfTheLibraryShouldBeUpdated() {
        assertThat(myStepLibrary.stepRunCount, is(1));
    }

    ////


    @When("I start a new scenario")
    public void whenIStartANewScenario() {
    }

    @Then("the step library should be reinitialised")
    public void thenTheStepLibraryShouldBeReinitialised() {
        assertThat(myStepLibrary.stepRunCount, is(0));
    }

    @Steps(shared = true)
    private SomeStepLibrary aSharedStepLibrary;

    @Steps(shared = true)
    private SomeStepLibrary anotherSharedStepLibrary;

    @Given("I have two Serenity step libraries")
    public void givenIHaveTwoSerenityStepLibraries() {
    }

    @When("they are annotated with @Steps(shared=true)")
    public void whenTheyAreAnnotatedWithStepssharedtrue() {
    }

    @Then("both should refer to the same instance")
    public void thenBothShouldReferToTheSameInstance() {
        assertThat(aSharedStepLibrary, is(sameInstance(anotherSharedStepLibrary)));
    }
}
