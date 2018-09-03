package org.shil.bjm.meta;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

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
	
	/**
	 * 起手牌是对的选择
	 * @return
	 * @ 
	 */
	public static PlayerAction randomStartWithPairAction() {
		SecureRandom sr = null;
		try {
			sr =SecureRandom.getInstanceStrong();
		}catch (Exception e) {
			e.printStackTrace();
		}
		int r = sr.nextInt(5);
		switch(r){
			case 0 : 
				return Hit;
			case 1 :
				return Stand;
			case 2:
				return Double;
			case 3:
				return Giveup;
			case 4:
				return Split;
			default:
				return null;
		}
	}
	
	/**
	 * 起手牌是对的选择,当遇到庄家是A的时候，不能投降
	 * @return
	 * @ 
	 */
	public static PlayerAction randomStartWithPairActionVSDealerA()   {
		SecureRandom sr = null;
		try {
			sr =SecureRandom.getInstanceStrong();
		}catch (Exception e) {
			e.printStackTrace();
		}
		int r = sr.nextInt(4);
		switch(r){
			case 0 : 
				return Hit;
			case 1 :
				return Stand;
			case 2:
				return Double;
			case 3:
				return Split;
			default:
				return null;
		}
	}
	
	/**
	 * 起手牌 不是对的情况 : Ax or other
	 * @return
	 * @ 
	 */
	public static PlayerAction randomStartWithoutPairAction()  {
		SecureRandom sr = null;
		try {
			sr =SecureRandom.getInstanceStrong();
		}catch (Exception e) {
			e.printStackTrace();
		}
		int r = sr.nextInt(4);
		switch(r){
			case 0 : 
				return Hit;
			case 1 :
				return Stand;
			case 2:
				return Double;
			case 3:
				return Giveup;
			default:
				return null;
		}
	}
	
	/**
	 * 起手牌 不是对的情况，当遇到庄家是A的时候，不能投降
	 * @return
	 * @ 
	 */
	public static PlayerAction randomStartWithoutPairActionVSDealerA()   {
		SecureRandom sr = null;
		try {
			sr =SecureRandom.getInstanceStrong();
		}catch (Exception e) {
			e.printStackTrace();
		}
		int r = sr.nextInt(3);
		switch(r){
			case 0 : 
				return Hit;
			case 1 :
				return Stand;
			case 2:
				return Double;
			default:
				return null;
		}
	}
	
	/**
	 * 分牌后又遇到对,这时还能分牌的情况
	 * @return
	 * @ 
	 */
	public static PlayerAction randomSplitedPairAndCanSplitAction()   {
		SecureRandom sr = null;
		try {
			sr =SecureRandom.getInstanceStrong();
		}catch (Exception e) {
			e.printStackTrace();
		}
		int r = sr.nextInt(4);
		switch(r){
			case 0 : 
				return Hit;
			case 1 :
				return Stand;
			case 2:
				return Double;
			case 3:
				return Split;
			default:
				return null;
		}
	}
	
	/**
	 * 分牌后又遇到对,这时不能分牌的情况 （AA分1次，其他分2次 最多）
	 * @return
	 * @ 
	 */
	public static PlayerAction randomSplitedPairAndCanNotSplittAction()   {
		SecureRandom sr = null;
		try {
			sr =SecureRandom.getInstanceStrong();
		}catch (Exception e) {
			e.printStackTrace();
		}
		int r = sr.nextInt(3);
		switch(r){
			case 0 : 
				return Hit;
			case 1 :
				return Stand;
			case 2:
				return Double;
			default:
				return null;
		}
	}
	
	public static PlayerAction randomThreeCardsAction()   {
		SecureRandom sr = null;
		try {
			sr =SecureRandom.getInstanceStrong();
		}catch (Exception e) {
			e.printStackTrace();
		}
		int r = sr.nextInt(2);
		switch(r){
			case 0 :
				return Hit;
			case 1 :
				return Stand;
			default:
				return null;
		}
	}
	
	public static void main(String[] args) {
		try {
			SecureRandom sr = SecureRandom.getInstanceStrong();
			for(int i=0;i<30;i++) {
				System.out.println(sr.nextInt(10));
			}
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}
