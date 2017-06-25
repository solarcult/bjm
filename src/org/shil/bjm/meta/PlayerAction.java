package org.shil.bjm.meta;

public enum PlayerAction {
	//TODO Split还没有写入代码
	Init,Stand,Hit,Double,Giveup,DoubleDone,Split,SplitAbandon;
	
	public static boolean isStopAction(PlayerAction playerAction){
		if(playerAction == Stand || playerAction == Giveup || playerAction == DoubleDone){
			return true;
		}
		return false;
	}
}
