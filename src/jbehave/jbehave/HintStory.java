package jbehave;

import java.util.Arrays;
import java.util.List;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.CandidateSteps;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;

public class HintStory extends JUnitStory {

	  @Override 
	  public Configuration configuration() {
	    return new MostUsefulConfiguration();
	  }

	  @Override 
	  public InjectableStepsFactory stepsFactory() {
	    return new InstanceStepsFactory(configuration(),
	                                    new HintStep());
	  }
	}