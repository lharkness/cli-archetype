package ${package};

import java.util.concurrent.Callable;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Command(name = "helloworld", mixinStandardHelpOptions = true, version = "helloworld 1.0",
         description = "Prints Hello World and optional text to STDOUT.")
class App implements Callable<Integer> {

    @Parameters(index = "0", arity="0..1", description = "Optional text to display.", defaultValue="")
    private String text;

    @Override
    public Integer call() throws Exception { // your business logic goes here...
    	log.info("Starting application with text: '{}'", text);
    	log.debug("This is a debug message that will go to the log file only");
    	log.warn("This is a warning message");
    	
    	System.out.println("Hello " + text);
    	
    	log.info("Application completed successfully");
    	return 0;
    }

    // this example implements Callable, so parsing, error handling and handling user
    // requests for usage help or version help can be done with one line of code.
    public static void main(String... args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
