package de.dagnu.weiqitv.beans.criterion.test;

import net.sf.twip.TwiP;
import net.sf.twip.Values;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.dagnu.weiqitv.beans.criterion.RankCriterion;

@RunWith(TwiP.class)
public class RankCriterionTestCase {

	public static final String[] RANKS_VALID = //
	{ "30k", "1k", "1d", "9d", "1p", "9p" };

	public static final String[] RANKS_INVALID = //
	{ null, "31k", "0k", "0d", "10d", "0p", "10p" };

	private RankCriterion cut;

	@Before
	public void setup() {
		cut = new RankCriterion() {
			@Override
			public String getName() {
				return "rankCriterion";
			}
		};
	}

	@Test
	public void validRank(@Values("RANKS_VALID") String rank) {
		cut.setValue(rank);
	}

	@Test(expected = IllegalArgumentException.class)
	public void invalidRank(@Values("RANKS_INVALID") String rank)
			throws Exception {
		cut.setValue(rank);
	}

	@Test(expected = IllegalArgumentException.class)
	public void noRank(String rank) throws Exception {
		cut.setValue(rank);
	}
}
