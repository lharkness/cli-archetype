package ${package};

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyTests {

	@Test
	void testSomething() throws Exception {
		log.info("Started tests.");
		assertTrue(false);
	}
}
