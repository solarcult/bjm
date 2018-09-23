package org.shil.bjm.strategy8102.strategy;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matrixKey == null) ? 0 : matrixKey.hashCode());
		result = prime * result + ((playerAction == null) ? 0 : playerAction.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Result other = (Result) obj;
		if (matrixKey == null) {
			if (other.matrixKey != null)
				return false;
		} else if (!matrixKey.equals(other.matrixKey))
			return false;
		if (playerAction != other.playerAction)
			return false;
		return true;
	}
	
	
}
