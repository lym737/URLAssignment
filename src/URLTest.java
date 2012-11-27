import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;


public class URLTest {
	private String urlString = "http://en.wikipedia.org/wiki/Unit_testing#Unit_testing_limitations";
	private String urlString2 = "http://en.wikipedia.org/wiki/Unit_testing#Language-level_unit_testing_support";
	private String invalid = "/main.html";
	
	@Test
	public void testValidator() {
		URLModel url = new URLModel(urlString);
		assertTrue(url.isValid());
	}
	
	@Test
	public void testInvalidURL() {
		URLModel url = new URLModel(invalid);
		assertFalse(url.isValid());
	}
	
	@Test
	public void testCanonlizatioin() throws MalformedURLException {
		URLModel url = new URLModel(urlString);
		assertTrue(url.getCanonicalized().toString().equals("http://en.wikipedia.org/wiki/Unit_testing"));
	}
	
	@Test
	public void testComparator() {
		URLModel url = new URLModel(urlString);		
		URLModel url2 = new URLModel(urlString2);
		assertTrue(url.getURL().equals(url.getURL()));
		assertFalse(url.getURL().equals(url2.getURL()));
	}

}
