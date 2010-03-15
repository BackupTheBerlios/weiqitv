package de.dagnu.weiqitv.beans.criterion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import de.dagnu.weiqitv.interfaces.Criterion;

public abstract class RankCriterion implements Criterion {

	public static final Pattern RANK_PATTERN = Pattern
			.compile("([0-9]{1,2})([dkp])");

	private static final Logger log = Logger.getLogger(RankCriterion.class);

	private String rank;

	public RankCriterion() {
		super();
	}

	@Override
	public String getValue() {
		return rank;
	}

	/**
	 * hint: online weiqi ranking includes 8d and 9d
	 * 
	 * @link http://en.wikipedia.org/wiki/Go_ranks_and_ratings
	 */
	@Override
	public void setValue(String value) {
		Matcher matcher;
		try {
			matcher = RANK_PATTERN.matcher(value);
		} catch (NullPointerException e) {
			throw new IllegalArgumentException(e);
		}

		if (matcher.matches() == false) {
			throw new IllegalArgumentException( //
					value + " doesn't match regex: " + RANK_PATTERN.toString());
		} else {
			int nr = Integer.parseInt(matcher.group(1));
			String type = matcher.group(2);
			if (nr > 0 && ((type.equals("k") && nr < 31) || nr < 10)) {
				log.debug("set rank " + value);
				rank = value;
			} else {
				throw new IllegalArgumentException( //
						value + " is an invalid rank");
			}
		}
	}
}