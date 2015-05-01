package net.batkin.service;

import org.hamcrest.core.Is;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MultiOperatorHandlerTest {

	@org.junit.Test
	public void testAnswerQuestion() throws Exception {
		String answer = new MultiOperatorHandler().answerQuestion("what is 5 multiplied by 3 plus 4");
		assertThat(answer, is("19"));
	}
}