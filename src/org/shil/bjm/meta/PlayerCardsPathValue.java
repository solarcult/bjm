package org.shil.bjm.meta;

import java.util.Collection;
import java.util.HashSet;

/**
 * 玩家的牌玩法
 * @author vanis
 *
 */
public class PlayerCardsPathValue extends CardsPathValue{

	private PlayerAction action;
	private double betMutiV ;
	private int splitTimes;
	
	//double和split的次数
	private int dsTimes;
	
	public PlayerCardsPathValue(Card ... _cards){
		super(_cards);
		if(_cards.length<2) throw new RuntimeException("PlayerCards Init should have 2 cards at least");
		action = PlayerAction.Init;
		betMutiV = 1;
		splitTimes = 0;
		dsTimes = 0;
	}
	
	public PlayerCardsPathValue(PlayerCardsPathValue playerCardsPathValue){
		super(playerCardsPathValue);
		action = playerCardsPathValue.getAction();
		betMutiV = playerCardsPathValue.getBetMutiV();
		splitTimes = playerCardsPathValue.getSplitTimes();
		this.dsTimes = playerCardsPathValue.getDsTimes();

	}
	
	public boolean isStartHand() {
		if(this.getCards().size()<2) throw new RuntimeException("Start hand should start form 2 cards!");
		return this.getCards().size() == 2;
	}

	public boolean isStartWithA(){
		if(this.getCards().get(0) == Card.One1){
			return true;
		}
		if(this.getCards().get(1) == Card.One1){
			return true;
		}
		
		return false;
	}
	
	public boolean isStartWithPairs(){
		return this.getCards().get(0) == this.getCards().get(1);
	}
	
	public Card findFirstTwoCardsWithOutA(){
		
		if(!isStartWithA()) {
			throw new RuntimeException("this could not happend with A , no A in first two cards");
		}
		
		Card withoutA = null;
		if(getCards().get(0).equals(Card.One1)){
			withoutA = getCards().get(1);
		}else if(getCards().get(1).equals(Card.One1)){
			withoutA = getCards().get(0);
		}
		return withoutA;
	}
	
	public Card findPairCardFromFirstTwoCards() {
		if(!isStartWithPairs()) {
			throw new RuntimeException("this could not happend with Pair , no Pair in first two cards");
		}
		return this.getCards().get(0);
	}


	public StartValue getStartValue(){
		int startvalue = this.getCards().get(0).getValue();
		if(this.getCards().size() >= 2){
			startvalue += this.getCards().get(1).getValue();
		}
		return StartValue.getOne(startvalue);
	}
	
	/*
	public StartValue getAnaylzeValue() {
		if(isStartHand()) {
			if(isStartWithPairs()) {
				return StartValue.getOne(findPairCardFromFirstTwoCards().getValue());
			}
			if(isStartWithA()) {
				return StartValue.getOne(findFirstTwoCardsWithOutA().getValue());
			}

		}
		
		return StartValue.getOne(getValue());
	}
	*/
	
	public PlayerAction getAction() {
		return action;
	}
	
	public int getSplitTimes() {
		return splitTimes;
	}

	public void setAction(PlayerAction action) {
		this.action = action;
		if(action == PlayerAction.Double){
			this.betMutiV = 2 * betMutiV;
			this.setDsTimes(getDsTimes()+1);
		}else if(action == PlayerAction.Split){
			if(this.getCards().get(0) == Card.One1){
				//AA only can split 1 time
				if(this.splitTimes > 1){
					// 12 is stand
					throw new RuntimeException("A split too many times should not happend ");
				}
			}else{
				//other cards without A can only split 2 times
				if(this.splitTimes > 2 ){
					throw new RuntimeException("not A split too many times should not happend ");
				}
			}
			//old code , i think not 严谨，为什么remove1而不是0，虽然这两个都是一样的牌 . this.getCards().remove(1);
			if(!getCards().get(0).equals(getCards().get(1))) throw new RuntimeException("split cards should be equal");
			
			//only left the first card
			this.getCards().remove(0);
			
			this.action = PlayerAction.Init;
			this.betMutiV = 2 * betMutiV;
			this.splitTimes++;
			this.setDsTimes(getDsTimes()+1);
		}else if(action == PlayerAction.Giveup){
			if(this.getDsTimes() > 1) {
				throw new RuntimeException("split or double can not surrender!");
			}
			this.betMutiV = 0.5;
		}
	}

	public double getBetMutiV() {
		return betMutiV;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((action == null) ? 0 : action.hashCode());
		long temp;
		temp = Double.doubleToLongBits(betMutiV);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((getCards() == null) ? 0 : getCards().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlayerCardsPathValue other = (PlayerCardsPathValue) obj;
		if (action != other.action)
			return false;
		if (Double.doubleToLongBits(betMutiV) != Double.doubleToLongBits(other.betMutiV))
			return false;
		if (getCards() == null) {
			if (other.getCards() != null)
				return false;
		} else if (!getCards().equals(other.getCards()))
			return false;
		return true;
	}
	
	@Override
	public void addCard(Card card){
		super.addCard(card);
		if(this.getCards().size()<=2 && this.getAction() == PlayerAction.Split){
			this.action = PlayerAction.Init;
		}
	}
	
	@Override
	public String toString() {
		return "PlayerCardsPathValue [action=" + action + ", betMutiV=" + betMutiV + ", splitTimes=" + splitTimes
				+ ", isStartHand()=" + isStartHand() + ", isStartWithA()=" + isStartWithA() + ", isStartWithPairs()="
				+ isStartWithPairs() + ", getStartValue()=" + getStartValue() + ", prob()=" + prob() + ", getValue()="
				+ getValue() + ", getCards()=" + getCards() + ", getDsTimes()="
				+ getDsTimes() + "]";
	}

	public static void main(String[] args){
		PlayerCardsPathValue cardsPathValue = new PlayerCardsPathValue(Card.One1,Card.One1);
		cardsPathValue.addCard(Card.Eight8);
//		cardsPathValue.setAction(PlayerAction.Double);
//		cardsPathValue.setBetMutiV(2);
		
		PlayerCardsPathValue cardsPathValue2 = new PlayerCardsPathValue(Card.One1,Card.One1);
		cardsPathValue2.addCard(Card.Eight8);
		
		PlayerCardsPathValue cardsPathValue3 = new PlayerCardsPathValue(Card.One1,Card.Eight8);
		cardsPathValue3.addCard(Card.One1);
		
		Collection<PlayerCardsPathValue> a = new HashSet<PlayerCardsPathValue>();
		a.add(cardsPathValue);
		a.add(cardsPathValue2);
		a.add(cardsPathValue3);
		System.out.println(a.size());
		System.out.println(cardsPathValue.equals(cardsPathValue2));
		System.out.println(cardsPathValue.hashCode());
		System.out.println(cardsPathValue2.hashCode());
		System.out.println(cardsPathValue3.hashCode());
		
		System.out.println(cardsPathValue);
		System.out.println(cardsPathValue3);
	}

	@Override
	public double prob() {
		return ProbUtil.calcProb(getCards(), splitTimes);
	}

	@Override
	public double prob(DeckSet deckset) {
		return ProbUtil.calcProb(getCards(), splitTimes,deckset);
	}
	
	public int getDsTimes() {
		return dsTimes;
	}

	public void setDsTimes(int dsTimes) {
		this.dsTimes = dsTimes;
	}
}
