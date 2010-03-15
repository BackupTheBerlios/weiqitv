package de.dagnu.weiqitv.igs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import org.apache.commons.net.telnet.TelnetClient;
import org.apache.log4j.Logger;

import de.dagnu.weiqitv.interfaces.Criteria;
import de.dagnu.weiqitv.interfaces.Gatherer;
import de.dagnu.weiqitv.interfaces.Storage;

public class IgsGatherer implements Gatherer {

	private static final Logger log = Logger.getLogger(IgsGatherer.class);

	private TelnetClient telnet;

	private final String server;

	private final int port;

	private BufferedReader in;

	private PrintWriter out;

	private TelnetUtil telnetUtil;

	public IgsGatherer(String server, int port) {
		telnet = new TelnetClient();
		this.server = server;
		this.port = port;
		log.debug("IGS gatherer created for " + this);
	}

	@Override
	public void gatherGames(Criteria criteria) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isConnected() {
		return telnet.isConnected();
	}

	@Override
	public boolean login(String user, String password) {
		throw new UnsupportedOperationException();
	}

	/**
	 * login to IGS as guest
	 */
	@Override
	public boolean loginAnonymous() {
		log.info("login as anonymous to server " + this);
		connect();
		telnetUtil.readUntil("Login: ");
		telnetUtil.send("guest");
		telnetUtil.readUntil("#> ");
		log.info("logged in as anonymous to server " + this);
		return true;
	}

	/**
	 * open telnet connection and assign streams
	 */
	private void connect() {
		log.debug("check whether already connected to " + this);
		if (telnet.isConnected()) {
			throw new IllegalStateException("already connected");
		}

		try {
			log.debug("try telnet connect to " + this);
			telnet.connect(server, port);
			log.debug("telnet connection established to " + this);
		} catch (Exception e) {
			throw new RuntimeException("telnet connection failed to " + this, e);
		}

		in = new BufferedReader(new InputStreamReader(telnet.getInputStream()));
		out = new PrintWriter(telnet.getOutputStream());
		telnetUtil = new TelnetUtil(in, out);
	}

	@Override
	public void logout() {
		log.info("log out from " + this);
		telnetUtil.send("exit");
		try {
			log.debug("try telnet disconnect from " + this);
			telnet.disconnect();
			log.debug("telnet disconnected from " + this);
		} catch (IOException e) {
			throw new RuntimeException("disconnect telnet failed", e);
		}
		log.info("logged out from " + this);
	}

	@Override
	public void setGameStorage(Storage storage) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String toString() {
		return server + ":" + port;
	}
}
