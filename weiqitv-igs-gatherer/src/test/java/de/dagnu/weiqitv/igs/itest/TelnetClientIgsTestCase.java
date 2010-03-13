package de.dagnu.weiqitv.igs.itest;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import org.apache.commons.net.telnet.TelnetClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TelnetClientIgsTestCase {

	private static final int PORT = 7777;
	private static final String SERVER = "igs.joyjoy.net";

	private TelnetClient telnet;
	private InputStream in;
	private PrintStream out;

	@Before
	public void setUp() throws Exception {
		telnet = new TelnetClient();
		telnet.connect(SERVER, PORT);
		in = telnet.getInputStream();
		out = new PrintStream(telnet.getOutputStream());
	}

	@After
	public void tearDown() throws Exception {
		telnet.disconnect();
	}

	@Test
	public void loginAsGuest() throws Exception {
		readUntil("Login: ");
		write("guest");
		readUntil("#> ");
		write("exit");
	}

	private String readUntil(String pattern) throws IOException {
		char lastChar = pattern.charAt(pattern.length() - 1);
		StringBuffer sb = new StringBuffer();
		char ch = (char) in.read();
		while (true) {
			sb.append(ch);
			if (ch == lastChar) {
				if (sb.toString().endsWith(pattern)) {
					return sb.toString();
				}
			}
			ch = (char) in.read();
		}
	}

	private void write(String value) {
		out.println(value);
		out.flush();
	}

}
