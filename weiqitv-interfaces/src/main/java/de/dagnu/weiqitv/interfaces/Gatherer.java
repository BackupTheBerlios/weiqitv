package de.dagnu.weiqitv.interfaces;

public interface Gatherer {

	/**
	 * gather filtered games and save those in storage
	 * 
	 * @param criteria
	 */
	void gatherGames(Criteria criteria);

	boolean isConnected();

	boolean login(String user, String password);

	boolean loginAnonymous();

	void logout();

	void setGameStorage(Storage storage);
}
