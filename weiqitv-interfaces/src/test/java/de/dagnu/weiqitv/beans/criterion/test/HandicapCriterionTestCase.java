package de.dagnu.weiqitv.beans.criterion.test;

import net.sf.twip.TwiP;
import net.sf.twip.Values;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.dagnu.weiqitv.beans.criterion.HandicapCriterion;

@RunWith(TwiP.class)
public class HandicapCriterionTestCase {

	public static final String[] HANDICAPS_VALID = { "0", "9" };

	public static final String[] HANDICAPS_INVALID = { null, "-1", "10" };

	private HandicapCriterion cut;

	@Before
	public void setup() {
		cut = new HandicapCriterion() {
			@Override
			public String getName() {
				return "handicapCriterion";
			}
		};
	}

	@Test
	public void validHandicap(@Values("HANDICAPS_VALID") String rank) {
		cut.setValue(rank);
	}

	@Test(expected = IllegalArgumentException.class)
	public void invalidHandicap(@Values("HANDICAPS_INVALID") String rank)
			throws Exception {
		cut.setValue(rank);
	}

	@Test(expected = IllegalArgumentException.class)
	public void noHandicap(String rank) throws Exception {
		cut.setValue(rank);
	}
}
