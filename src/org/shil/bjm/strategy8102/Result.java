package org.shil.bjm.strategy8102;

import org.shil.bjm.meta.PlayerAction;

public class Result implements Comparable<Result>{
	MatrixKey matrixKey;
	PlayerAction playerAction;
	
	public Result(MatrixKey matrixKey,PlayerAction playerAction) {
		this.matrixKey = matrixKey;
		this.playerAction = playerAction;
	}
	
	@Override
	public int compareTo(Result o) {
		return this.matrixKey.compareTo(o.matrixKey);
	}

	@Override
	public String toString() {
		return "Result [matrixKey=" + matrixKey + ", playerAction=" + playerAction + "]";
	}
}
