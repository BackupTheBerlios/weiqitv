package de.dagnu.weiqitv.igs.itest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import org.apache.commons.net.telnet.TelnetClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.dagnu.weiqitv.igs.TelnetUtil;

public class TelnetUtilIgsTestCase {

	private TelnetUtil cut;
	private TelnetClient telnet;

	private BufferedReader in;
	private PrintWriter out;

	@Before
	public void setUp() throws Exception {
		telnet = new TelnetClient();
		telnet.connect(IgsTestConstants.SERVER, IgsTestConstants.PORT);
		in = new BufferedReader(new InputStreamReader(telnet.getInputStream()));
		out = new PrintWriter(telnet.getOutputStream());
		cut = new TelnetUtil(in, out);
	}

	@After
	public void tearDown() throws Exception {
		in.close();
		out.close();
		telnet.disconnect();
	}

	@Test
	public void loginAsGuest() {
		cut.readUntil("Login: ");
		cut.send("guest");
		cut.readUntil("#> ");
		cut.send("exit");
	}

}
