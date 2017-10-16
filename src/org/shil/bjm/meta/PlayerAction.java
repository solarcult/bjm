package org.shil.bjm.meta;

public enum PlayerAction {
	Init,Stand,Hit,Double,Giveup,DoubleDone,Split,SplitAbandon;
	
	public static boolean isStopAction(PlayerAction playerAction){
		if(playerAction == Stand || playerAction == Giveup || playerAction == DoubleDone){
			return true;
		}
		return false;
	}
}
