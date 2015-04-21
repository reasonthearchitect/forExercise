package com.teksystems.story

import org.jbehave.core.configuration.Configuration
import org.jbehave.core.configuration.MostUsefulConfiguration
import org.jbehave.core.configuration.groovy.GroovyResourceFinder
import org.jbehave.core.io.CodeLocations
import org.jbehave.core.io.LoadFromClasspath
import org.jbehave.core.io.StoryFinder
import org.jbehave.core.junit.JUnitStories
import org.jbehave.core.reporters.Format
import org.jbehave.core.reporters.StoryReporterBuilder
import org.jbehave.core.steps.InjectableStepsFactory
import org.jbehave.core.steps.InstanceStepsFactory

import com.teksystems.story.steps.SalesTaxSteps

class TaxStoryRunner extends JUnitStories {

	@Override
    public Configuration configuration() {
        return new MostUsefulConfiguration()
            .useStoryLoader(new LoadFromClasspath(this.getClass()))  
            .useStoryReporterBuilder(new StoryReporterBuilder().withDefaultFormats().withFormats(Format.CONSOLE, Format.TXT));
    }
 
    @Override
    protected List<String> storyPaths() {
        return new StoryFinder()
                .findPaths(CodeLocations.codeLocationFromClass(this.getClass()).getFile(), "**/*.story", null);
    }
 
    @Override
    public InjectableStepsFactory stepsFactory() {
        GroovyResourceFinder resourceFinder = new GroovyResourceFinder(CodeLocations.codeLocationFromPath("src/integration/groovy"), "com/tek/kata/bdd/ba/it/balance/**/*.groovy", "");
		return new InstanceStepsFactory(configuration(), new SalesTaxSteps());    
	}
}