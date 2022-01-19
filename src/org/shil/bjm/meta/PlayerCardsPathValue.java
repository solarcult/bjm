package org.shil.bjm.meta;

/**
 * 玩家的牌玩法
 * @author vanis
 *
 */
public class PlayerCardsPathValue extends CardsPathValue{

	private PlayerAction action;
	//投入金钱的倍数
	private double betMutiV ;
	//分牌的次数
	private int splitTimes;
	//double和split的次数
	private int dsTimes;

	//在牌局中的百分比,贯穿整个局的百分比
	private double percent;
	
	public PlayerCardsPathValue(Card ... _cards){
		super(_cards);
		if(_cards.length<2) throw new RuntimeException("PlayerCards Init should have 2 cards at least");
		action = PlayerAction.Init;
		betMutiV = 1;
		splitTimes = 0;
		dsTimes = 0;
		percent = 1;
	}
	
	public PlayerCardsPathValue(PlayerCardsPathValue playerCardsPathValue){
		super(playerCardsPathValue);
		action = playerCardsPathValue.getAction();
		betMutiV = playerCardsPathValue.getBetMutiV();
		splitTimes = playerCardsPathValue.getSplitTimes();
		this.dsTimes = playerCardsPathValue.getDsTimes();
		percent = playerCardsPathValue.getPercent();
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
		return this.getCards().get(0).getValue() == this.getCards().get(1).getValue();
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

	@Override
	public int getValue(){

		if(action==PlayerAction.Stand){
			return super.getValue();
		}

		//如果有A,加在一起已经达到了18点了，则不做任何操作。
		//否则返回<7的数字，就是说返回6以下的数字，还能博一下。
		if(getCards().contains(Card.One1)){
			int withoutAvalue = 0;
			int manyA = 0;
			for(Card o : getCards()){
				if(o!=Card.One1){
					withoutAvalue += o.getValue();
				}else{
					manyA++;
				}
			}

			int totalsoft = withoutAvalue + manyA;
			if(totalsoft > 11){
				return totalsoft;
			}

			if(totalsoft >= 8){
				return totalsoft + 10;
			}
			return totalsoft ;
		}

		return super.getValue();
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
					throw new RuntimeException("A split too many times should not happend "+this.toString());
				}
			}else{
				//other cards without A can only split 2 times
				if(this.splitTimes > 2 ){
					throw new RuntimeException("not A split too many times should not happend "+this.toString());
				}
			}
			//old code , i think not 严谨，为什么remove1而不是0，虽然这两个都是一样的牌 . this.getCards().remove(1);
			if(getCards().get(0).getValue() != getCards().get(1).getValue()) throw new RuntimeException("split cards should be equal");
			
			//only left the first card
			this.getCards().remove(0);
			
//			this.action = PlayerAction.Init; old way ,change by the new way 2022Jan17
			this.betMutiV = 2 * betMutiV;
			this.splitTimes++;
			this.setDsTimes(getDsTimes()+1);
		}else if(action == PlayerAction.Giveup){
			if(this.getDsTimes() > 1) {
				throw new RuntimeException("split or double can not surrender! "+this.toString());
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
	}
	
	@Override
	public String toString() {
		return "PlayerCardsPathValue [action=" + action + ", getStartValue()=" + getStartValue() + ", precent()=" + getPercent() + ", prob()=" + prob() + ", getValue()="
				+ getValue() + ", getCards()=" + getCards() + ", betMutiV=" + betMutiV + ", splitTimes=" + splitTimes
				+ ", isStartHand()=" + isStartHand() + ", isStartWithA()=" + isStartWithA() + ", isStartWithPairs()="
				+ isStartWithPairs() +  ", getDsTimes()="
				+ getDsTimes() + "]";
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

	public void reset(){
		//not good 分牌时会出现问题，忘了啥问题了，应该直接生成一个新对象，建议这个方法删掉。
		action = PlayerAction.Init;
		betMutiV = 1;
		splitTimes = 0;
		dsTimes = 0;
		percent = 1;
	}

	public double getPercent() {
		return percent;
	}

	public void setPercent(double percent) {
		this.percent = percent;
	}

	public static void main(String[] args){
		
		PlayerCardsPathValue cardsPathValue = new PlayerCardsPathValue(Card.Two2,Card.Four4,Card.One1);
		System.out.println(cardsPathValue.getValue());
		/*
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
		*/
	}
}
