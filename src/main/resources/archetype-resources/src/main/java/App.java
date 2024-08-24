package ${package};

import java.util.concurrent.Callable;

import picocli.CommandLine.Command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;

@Command(name = "helloworld", mixinStandardHelpOptions = true, version = "helloworld 1.0",
         description = "Prints Hello World and optional text to STDOUT.")
class App implements Callable<Integer> {

    @Parameters(index = "0", arity="0..1", description = "Optional text to display.", defaultValue="")
    private String text;

    @Override
    public Integer call() throws Exception { // your business logic goes here...
    	System.out.println("Hello " + text);
    	return 0;
    }

    // this example implements Callable, so parsing, error handling and handling user
    // requests for usage help or version help can be done with one line of code.
    public static void main(String... args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
