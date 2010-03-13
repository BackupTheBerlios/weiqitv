package de.dagnu.weiqitv.interfaces;

import de.dagnu.weiqitv.domain.GameInfo;
import de.dagnu.weiqitv.domain.Move;

public interface Storage {

	/**
	 * adds a new game
	 * 
	 * @param info
	 * @return gameId
	 */
	String addGame(GameInfo info);

	void addMove(String gameId, Move move);
}
