package de.dagnu.weiqitv.domain;

public class Move {

	private BlackOrWhite player;

	private String coordinate;

	public void setPlayer(BlackOrWhite player) {
		this.player = player;
	}

	public BlackOrWhite getPlayer() {
		return player;
	}

	public void setCoordinate(String coordinate) {
		this.coordinate = coordinate;
	}

	public String getCoordinate() {
		return coordinate;
	}

}
