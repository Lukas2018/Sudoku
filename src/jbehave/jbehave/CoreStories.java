package jbehave;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.jbehave.core.Embeddable;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.i18n.LocalizedKeywords;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.model.ExamplesTableFactory;
import org.jbehave.core.reporters.CrossReference;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.reporters.SurefireReporter;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.ParameterConverters;


 
public class CoreStories extends JUnitStories {
	 
    @Override 
    public Configuration configuration() { 
        return new MostUsefulConfiguration()            
                .useStoryLoader(
                        new LoadFromClasspath(this.getClass().getClassLoader()))
                .useStoryReporterBuilder(
                        new StoryReporterBuilder()
                            .withDefaultFormats()
                            .withFormats(Format.HTML)
                            .withRelativeDirectory("jbehave-report")
                );
    }

 
    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), new ScoreStep(),new TimerStep(),new HintStep(),new ModeStep(),new DifficultyStep(),new FieldStep());
    }
    
    @Override
    protected List<String> storyPaths() {
        return Arrays.asList("jbehave/field_story.story","jbehave/score_story.story","jbehave/timer_story.story","jbehave/hint_story.story","jbehave/mode_story.story","jbehave/difficulty_story.story");
    }
}