package de.dagnu.weiqitv.interfaces;

import java.util.Map;


public interface Criteria extends Map<String, Criterion> {

	void add(Criterion criterion);

	void add(String name, String value);

	Criterion get(String name);
}
