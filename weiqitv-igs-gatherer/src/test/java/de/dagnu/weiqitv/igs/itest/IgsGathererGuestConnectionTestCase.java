package de.dagnu.weiqitv.igs.itest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import de.dagnu.weiqitv.igs.IgsGatherer;

public class IgsGathererGuestConnectionTestCase {

	private IgsGatherer cut;

	@Before
	public void setUp() {
		cut = new IgsGatherer(IgsTestConstants.SERVER, IgsTestConstants.PORT);
	}

	@Test
	public void connectAsGuestAndLogout() {
		assertTrue(cut.loginAnonymous());
		assertTrue(cut.isConnected());
		cut.logout();
		assertFalse(cut.isConnected());
	}
}
