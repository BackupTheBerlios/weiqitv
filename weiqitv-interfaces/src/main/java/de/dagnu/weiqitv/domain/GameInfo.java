package de.dagnu.weiqitv.domain;

import java.util.Date;
import java.util.List;

public class GameInfo {

	private Player white;

	private Player black;

	private int size;

	private List<Move> handicap;

	private float komi;

	private Date timestamp;

	private String result;

	public Player getWhite() {
		return white;
	}

	public void setWhite(Player white) {
		this.white = white;
	}

	public Player getBlack() {
		return black;
	}

	public void setBlack(Player black) {
		this.black = black;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public List<Move> getHandicap() {
		return handicap;
	}

	public void setHandicap(List<Move> handicap) {
		this.handicap = handicap;
	}

	public float getKomi() {
		return komi;
	}

	public void setKomi(float komi) {
		this.komi = komi;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
