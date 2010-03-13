package de.dagnu.weiqitv.beans.criterion;

import org.apache.log4j.Logger;

import de.dagnu.weiqitv.interfaces.Criterion;

public abstract class HandicapCriterion implements Criterion {

	private static final Logger log = Logger.getLogger(HandicapCriterion.class);

	private String handicap;

	public HandicapCriterion() {
		super();
	}

	@Override
	public String getValue() {
		return handicap;
	}

	@Override
	public void setValue(String value) {
		try {
			int h = Integer.parseInt(value);
			if (h >= 0 && h < 10) {
				log.debug("set handicap " + value);
				handicap = value;
			} else {
				String message = value + " is an invalid handicap";
				log.error(message);
				throw new IllegalArgumentException(message);
			}
		} catch (NumberFormatException e) {
			String message = "unsupported handicap value: " + value;
			log.error(message);
			throw new IllegalArgumentException(message, e);
		}
	}
}