package de.dagnu.weiqitv.igs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.log4j.Logger;

/**
 * synchronous write and read for initial commands like login
 * 
 * @author danny
 */
public class TelnetUtil {

	private static final Logger log = Logger.getLogger(TelnetUtil.class);

	private BufferedReader in;
	private PrintWriter out;

	public TelnetUtil(BufferedReader in, PrintWriter out) {
		this.in = in;
		this.out = out;
	}

	public String readUntil(String pattern) {
		log.debug("read until: " + pattern);
		StringBuffer sb = new StringBuffer();
		char lastChar = pattern.charAt(pattern.length() - 1);
		char ch = readChar();
		while (true) {
			sb.append(ch);
			if (ch == lastChar && sb.toString().endsWith(pattern)) {
				log.debug("readed: " + sb);
				return sb.toString();
			}
			ch = readChar();
		}
	}

	private char readChar() {
		try {
			return (char) in.read();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void send(String value) {
		log.debug("write: " + value);
		out.println(value);
		out.flush();
	}

}
