package com.levelup.myfunds.Allocation;

public class UserScore {
	private double maxSavingScore;
	
	public UserScore() {
		this.maxSavingScore= 0;
	}

	public double getUserScore() {
		return maxSavingScore;
	}
	
	public void updateMaxScore(double amt) {
		maxSavingScore = Math.max(maxSavingScore, amt);
	}
}
