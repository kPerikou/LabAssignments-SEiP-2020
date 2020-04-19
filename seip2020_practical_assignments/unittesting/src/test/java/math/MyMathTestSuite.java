package math;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * MyMathTestSuite class is used as a holder of the @RunWith and @Suite
 * annotations. It groups the MyMathTest and the Parameterized test classes.
 * 
 * @author Aikaterini Perikou
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ MyMathTest.class, MyMathFactorialParameterizedTest.class })
public class MyMathTestSuite {
	/*
	 * This class remains empty. Is used only as a holder of the above annotations.
	 */
}
