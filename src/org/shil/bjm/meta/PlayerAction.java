package org.shil.bjm.meta;

public enum PlayerAction {
	Init,Stand,Hit,Double,Giveup,DoubleDone,Split,SplitAbandon;
	
	/**
	 * no one use this method
	 * @param playerAction
	 * @return
	 * @deprecated
	 */
	public static boolean isStopAction(PlayerAction playerAction){
		if(playerAction == Stand || playerAction == Giveup || playerAction == DoubleDone){ //how about SplitAbandon
			return true;
		}
		return false;
	}
}
