package org.shil.bjm.strategy8102.strategy;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.shil.bjm.HelloWorld;
import org.shil.bjm.core.DealerCards;
import org.shil.bjm.core.PlayerCards;
import org.shil.bjm.meta.BlackJackInfo;
import org.shil.bjm.meta.Card;
import org.shil.bjm.meta.DealerCardsPathValue;
import org.shil.bjm.meta.PlayerAction;
import org.shil.bjm.meta.PlayerCardsPathValue;
import org.shil.bjm.meta.ProfitUtil;
import org.shil.bjm.meta.StartValue;
import org.shil.bjm.simulation.Casion6Deck;
import org.shil.bjm.strategy8102.EvolutionOneWayTest;
import org.shil.bjm.strategy8102.Strategy8012;

/**
 * 最基本的StrategyMatrix,提供默认的打牌方案，分两类：可变matrix和不可变matrix，以减少穷举的数量
 * @author vanis
 *
 */
public abstract class StrategyMatrix8012{
	
	/*
	 * 不可变Matrix，基本是真理的东西
	 */
	protected Map<MatrixKey,PlayerAction> notChangesMatrix;
	/*
	 * 还在研究的方案
	 */
	protected Map<MatrixKey,PlayerAction> changesMatrix;
	/*
	 * 将可变不可变合并在一起
	 */
	protected Map<MatrixKey,PlayerAction> one;
	
	/*
	 * 拿回来的钱，包含自己的本金
	 */
	protected Double probMoneyReturn;
	/*
	 * 总共花销
	 */
	protected Double probTotalSpead;
	
	/*
	 * 拿回来的钱，包含自己的本金
	 */
	protected Double timeMoneyReturn;
	/*
	 * 总共花销
	 */
	protected Double timeTotalSpead;
	
	/*
	 * 投资回报比
	 */
	protected Double probRoi;
	protected Double timeRoi;
	/*
	 * 根据现实中所有的穷举对战产生的胜平负比率
	 */
	protected Double[] timeRates;
	protected double totalTimes;
	/*
	 * 根据出牌概率算出来的胜平负比率，比RawRate要低，为什么？
	 */
	protected Double[] probRates;
	protected double totalProbs;
	
	protected StrategyMatrix8012() {
		notChangesMatrix = new HashMap<>();
		changesMatrix = new HashMap<>();
		
//		普通牌
		
		/*
		 * Situation.Start_Hand_WithoutA_WithoutPair [3~8] 
		 * VS
		 * DealerCard  (One ~ K)
		 */
		for(int start = 5; start <= 8 ; start++) {
			for(Card dealerCard : Card.values()) {
				if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				notChangesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Hit);
			}
		}
		
		/*
		 * Situation.Start_Hand_WithoutA_WithoutPair [9~16] 
		 * VS
		 * DealerCard  (One ~ K)
		 */
		for(int start = 9; start <= 16; start++) {
			for(Card dealerCard : Card.values()) {
				if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				changesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Hit);
			}
		}
		
		/*
		 * Situation.Start_Hand_WithoutA_WithoutPair [17~21] 
		 * VS
		 * DealerCard  (One ~ K)
		 */
		for(int start = 17; start <= 21 ; start++) {
			for(Card dealerCard : Card.values()) {
				if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
				MatrixKey start_Hand_WithoutA_WithoutPair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_Hand_WithoutA_WithoutPair);
				notChangesMatrix.put(start_Hand_WithoutA_WithoutPair, PlayerAction.Stand);
			}
		}
		
//		AX牌
		
		/*
		 * Situation.Start_With_A [2~7]
		 */
		for(int start = 2; start <= 7; start++) {
			for(Card dealerCard : Card.values()) {
				if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
				MatrixKey start_With_A = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_A);
				changesMatrix.put(start_With_A, PlayerAction.Hit);
				MatrixKey splited_With_A = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_With_A);
				changesMatrix.put(splited_With_A, PlayerAction.Hit);
				MatrixKey a_Three_More_Cards = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.A_Three_More_Cards);
				changesMatrix.put(a_Three_More_Cards, PlayerAction.Hit);
			}
		}
		
		for(Card dealerCard : Card.values()){
			if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
			//after test stand
			if(dealerCard.getValue() == 4 || dealerCard.getValue() == 5){
				MatrixKey start_With_A_Three_More = new MatrixKey(StartValue.getOne(7), dealerCard, Situation.A_Three_More_Cards);
				changesMatrix.put(start_With_A_Three_More, PlayerAction.Stand);
				MatrixKey splited_With_A = new MatrixKey(StartValue.getOne(7), dealerCard, Situation.Splited_With_A);
				changesMatrix.put(splited_With_A, PlayerAction.Stand);
			}else if(dealerCard.getValue() ==6){
				MatrixKey start_With_A_Three_More = new MatrixKey(StartValue.getOne(7), dealerCard, Situation.A_Three_More_Cards);
				changesMatrix.put(start_With_A_Three_More, PlayerAction.Stand);
				MatrixKey splited_With_A = new MatrixKey(StartValue.getOne(7), dealerCard, Situation.Splited_With_A);
				changesMatrix.put(splited_With_A, PlayerAction.Stand);
			}
			else if(dealerCard.getValue() >=9 && dealerCard.getValue() <=10){
				//after test hit
				MatrixKey start_With_A_Three_More = new MatrixKey(StartValue.getOne(7), dealerCard, Situation.A_Three_More_Cards);
				changesMatrix.put(start_With_A_Three_More, PlayerAction.Hit);
				MatrixKey splited_With_A = new MatrixKey(StartValue.getOne(7), dealerCard, Situation.Splited_With_A);
				changesMatrix.put(splited_With_A, PlayerAction.Hit);
			}else if(dealerCard == Card.One1){
				MatrixKey start_With_A_Three_More = new MatrixKey(StartValue.getOne(7), dealerCard, Situation.A_Three_More_Cards);
				changesMatrix.put(start_With_A_Three_More, PlayerAction.Hit);
				MatrixKey splited_With_A = new MatrixKey(StartValue.getOne(7), dealerCard, Situation.Splited_With_A);
				changesMatrix.put(splited_With_A, PlayerAction.Hit);
			}else {
				//2,7,8
				MatrixKey start_With_A_Three_More = new MatrixKey(StartValue.getOne(7), dealerCard, Situation.A_Three_More_Cards);
				changesMatrix.put(start_With_A_Three_More, PlayerAction.Stand);
				MatrixKey splited_With_A = new MatrixKey(StartValue.getOne(7), dealerCard, Situation.Splited_With_A);
				changesMatrix.put(splited_With_A, PlayerAction.Stand);
			}
		}
		
		/*
		 * Situation.Start_With_A [8,9,10]
		 * VS
		 * DealerCard (One ~ K)
		 */
		for(int start = 8; start <= 10; start++) {
			for(Card dealerCard : Card.values()) {
				if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
				MatrixKey start_With_A = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_A);
				notChangesMatrix.put(start_With_A, PlayerAction.Stand);
				MatrixKey splited_With_A = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_With_A);
				notChangesMatrix.put(splited_With_A, PlayerAction.Stand);
				//A8以后当作19处理,不用特意计算
//				MatrixKey a_Three_More_Cards = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.A_Three_More_Cards);
//				notChangesMatrix.put(a_Three_More_Cards, PlayerAction.Stand);
			}
		}
		
		//对牌
		
		/*
		 * Situation.Start_With_Pair [2~9]
		 * VS
		 * DealerCard (One ~ K)
		 */
		for(int start = 2; start <= 9; start++) {
			for(Card dealerCard : Card.values()) {
				if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
				MatrixKey start_With_Pair = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Start_With_Pair);
				changesMatrix.put(start_With_Pair, PlayerAction.Split);
			}
		}
		
		/*
		 * Situation.Start_With_Pair 10
		 * VS
		 * DealerCard (One ~ K)
		 */
		for(Card dealerCard : Card.values()) {
			if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
			MatrixKey start_With_Pair = new MatrixKey(StartValue.Ten, dealerCard, Situation.Start_With_Pair);
			changesMatrix.put(start_With_Pair, PlayerAction.Stand);
		}
		
		/*
		 * Situation.Start_With_Pair 11 or 1
		 * VS
		 * DealerCard (One ~ K)
		 */
		for(Card dealerCard : Card.values()) {
			if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
			MatrixKey start_With_A = new MatrixKey(StartValue.One, dealerCard, Situation.Start_With_Pair);
			changesMatrix.put(start_With_A, PlayerAction.Split);
		}
		
		
//		对牌一次
		
		/*
		 * Situation.Splited_Pair_And_Can_Split [2~9]
		 * VS
		 * DealerCard (One ~ K)
		 */
		for(int start = 2; start <= 9; start++) {
			for(Card dealerCard : Card.values()) {
				if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
				MatrixKey splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
				changesMatrix.put(splited_Pair_And_Can_Split, PlayerAction.Split);
			}
		}
		
		//10,10
		for(Card dealerCard : Card.values()) {
			if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
			MatrixKey splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(10), dealerCard, Situation.Splited_Pair_And_Can_Split);
			changesMatrix.put(splited_Pair_And_Can_Split, PlayerAction.Stand);
		}
		
		//对牌两次, 同时给了分牌后的普通牌场景
		
		/*
		 * Situation.Splited_Pair_And_Can_NOT_Split [4~8]
		 * VS
		 * DealerCard (One ~ K)
		 */
		for(int start = 4; start <= 8; start++) {
			for(Card dealerCard : Card.values()) {
				if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
				MatrixKey splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				notChangesMatrix.put(splited_Pair_And_Can_NOT_Split, PlayerAction.Hit);
			}
		}
		
		
		/*
		 * Situation.Splited_Pair_And_Can_NOT_Split [9~16] 
		 * VS
		 * DealerCard  (One ~ K)
		 */
		for(int start = 9; start <= 16; start++) {
			for(Card dealerCard : Card.values()) {
				if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
				MatrixKey splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				changesMatrix.put(splited_Pair_And_Can_NOT_Split, PlayerAction.Hit);
			}
		}
		
		/*
		 * Situation.Splited_Pair_And_Can_NOT_Split [17~21] 
		 * VS
		 * DealerCard  (One ~ K)
		 */
		for(int start = 17; start <= 21 ; start++) {
			for(Card dealerCard : Card.values()) {
				if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
				MatrixKey splited_Pair_And_Can_NOT_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_NOT_Split);
				notChangesMatrix.put(splited_Pair_And_Can_NOT_Split, PlayerAction.Stand);
			}
		}
		
		
//		两张牌以上不能投降时
		
		/*
		 * Situation.Three_More_Cards [6~11] 
		 * VS
		 * DealerCard  (One ~ K)
		 */
		for(int start = 6; start <= 11 ; start++) {
			for(Card dealerCard : Card.values()) {
				if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
				MatrixKey three_More_Cards = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Three_More_Cards);
				notChangesMatrix.put(three_More_Cards, PlayerAction.Hit);
			}
		}
		
		/*
		 * Situation.Three_More_Cards [12~16] 
		 * VS
		 * DealerCard  (One ~ K)
		 */
		for(int start = 12; start <= 16; start++) {
			for(Card dealerCard : Card.values()) {
				if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
				MatrixKey three_More_Cards = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Three_More_Cards);
				changesMatrix.put(three_More_Cards, PlayerAction.Hit);
			}
		}
		
		/*
		 * Situation.Three_More_Cards [17~21] 
		 * VS
		 * DealerCard  (One ~ K)
		 */
		for(int start = 17; start <= 21 ; start++) {
			for(Card dealerCard : Card.values()) {
				if(dealerCard == Card.JJJ || dealerCard == Card.QQQ || dealerCard == Card.KKK) continue;
				MatrixKey three_More_Cards = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Three_More_Cards);
				notChangesMatrix.put(three_More_Cards, PlayerAction.Stand);
			}
		}
		
		//should be hashmap , try to use treemap , the key is collision , then size is not right
		one = new HashMap<>();
		one.putAll(changesMatrix);
		one.putAll(notChangesMatrix);
		this.timeRates = null;
		this.probRates = null;
	}
	
	protected StrategyMatrix8012(Map<MatrixKey,PlayerAction> notChangesMatrix,Map<MatrixKey,PlayerAction> changesMatrix){
		this.notChangesMatrix = notChangesMatrix;
		this.changesMatrix = changesMatrix;
		this.one = new HashMap<>();
		one.putAll(changesMatrix);
		one.putAll(notChangesMatrix);
		this.timeRates = null;
		this.probRates = null;
	}

	public Map<MatrixKey, PlayerAction> getNotChangesMatrix() {
		return notChangesMatrix;
	}

	public Map<MatrixKey, PlayerAction> getChangesMatrix() {
		return changesMatrix;
	}

	public Map<MatrixKey, PlayerAction> getOne() {
		return one;
	}
	
	public PlayerAction fetchPlayAction(MatrixKey matrixKey, int count){
		return one.get(matrixKey);
	}
	
	public List<Result> getChangeMatrxByList(){
		List<Result> changeResults = new LinkedList<>();
		for(Entry<MatrixKey, PlayerAction> e : changesMatrix.entrySet()) {
			changeResults.add(new Result(e.getKey(), e.getValue()));
		}
		Collections.sort(changeResults);
		return changeResults;
	}
	
	public List<Result> getOneMatrxByList(){
		List<Result> changeResults = new LinkedList<>();
		for(Entry<MatrixKey, PlayerAction> e : one.entrySet()) {
			changeResults.add(new Result(e.getKey(), e.getValue()));
		}
		Collections.sort(changeResults);
		return changeResults;
	}
	
	public abstract StrategyMatrix8012 evolve();
	
	/**
	 * 在此方法中,一次计算所有你需要的数据,减少计算量,为计算帕累托最优前沿做坚实准备.LOL
	 * Start at 2019-Mar-22
	 */
	public void getEverythingInOneLoop() {
		if(EvolutionOneWayTest.debug) System.out.println("getEverythingInOneLoop() class : " + this.getClass().getName() );
		if(this.probRates != null && this.timeRates != null && this.probRoi != null&& this.timeRoi != null) {
//			System.out.println("This Matrix8012 has been calc DONE ! ");
			return;
		}
		long startTime = System.currentTimeMillis();
		
		//纯的胜平负计数
		double winTimes = 0;
		double drawTimes = 0;
		double loseTimes = 0;
		
		//根据概率的胜平负计数
		double winProbs = 0;
		double drawProbs = 0;
		double loseProbs = 0;
		
		//赢来的钱，包含自己本金
		double probReturnMoney = 0;
		//总共投入的钱
		double probTotalSpendMoney = 0;

		//赢来的钱，包含自己本金
		double timeReturnMoney = 0;
		//总共投入的钱
		double timeTotalSpendMoney = 0;
		
		int processed = 1;
		Collection<PlayerCardsPathValue> playerCards = PlayerCards.generateTwoStartCards();
		for(PlayerCardsPathValue pcpv : playerCards){
			if(EvolutionOneWayTest.debug) System.out.println(this.getClass().getSimpleName() + " process: " +pcpv.getCards() +" "+pcpv.getValue() + " \t : "+processed+" / "+playerCards.size());
			processed++;
			for(Card dealerCard : Card.values()){
				PlayerCardsPathValue oneCalc = new PlayerCardsPathValue(pcpv);
				//开局两张牌和dealer的一张牌根据Strategy生成了所有组合的玩家牌 oneSet
				Collection<PlayerCardsPathValue> oneSet = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(), this, oneCalc, dealerCard);
				//得到Dealer这张牌的所有组合庄家牌
				Collection<DealerCardsPathValue> dealerSet = DealerCards.fetchDealerCards(dealerCard);
				for(PlayerCardsPathValue playerCardsPathValue : oneSet) {
					for(DealerCardsPathValue dealerCardsPathValue : dealerSet) {
						//playtime的含义时分牌的次数
						double playtimes = Math.pow(2, playerCardsPathValue.getSplitTimes());
												
						double multiProb =  playerCardsPathValue.prob() * dealerCardsPathValue.prob();
						
						if(playerCardsPathValue.getAction() == PlayerAction.Giveup) {
							if(playerCardsPathValue.getValue()>BlackJackInfo.BlackJack) throw new RuntimeException("should not give up but value > 21.");
							if(playerCardsPathValue.getDsTimes() > 0) throw new RuntimeException("playerCardsPathValue.getDsTimes() > 0 can't give up should not happened");
							
							loseTimes += playtimes; //这里只跟玩牌的次数有关
							loseProbs += multiProb * playtimes; //这里只跟出现的概率有关，所以乘以玩的次数
							if(playerCardsPathValue.getBetMutiV()!=0.5) throw new RuntimeException("playerCardsPathValue.getBetMutiV()!=0.5 in give up ! ");

							probReturnMoney += multiProb * ProfitUtil.BaseMoney * playerCardsPathValue.getBetMutiV(); //这里的playerCardsPathValue.getBetMutiV()只能是0.5，如果不是0.5就说明代码有Bug。
							probTotalSpendMoney += multiProb * ProfitUtil.BaseMoney;
							timeReturnMoney += ProfitUtil.BaseMoney * playerCardsPathValue.getBetMutiV(); //这里的playerCardsPathValue.getBetMutiV()只能是0.5，如果不是0.5就说明代码有Bug。
							timeTotalSpendMoney += ProfitUtil.BaseMoney;
							continue;
						}else if(playerCardsPathValue.getAction() == PlayerAction.SplitAbandon){
							continue;
						}else if(playerCardsPathValue.getAction() == PlayerAction.Init 
								|| playerCardsPathValue.getAction() == PlayerAction.Hit 
								|| playerCardsPathValue.getAction() == PlayerAction.Double
								|| playerCardsPathValue.getAction() == PlayerAction.Split){
							throw new RuntimeException("what is wrong in here? status not done: " + playerCardsPathValue.getAction());
						}
						
						if(playerCardsPathValue.getValue() > BlackJackInfo.BlackJack){
							loseTimes += playtimes;
							loseProbs += multiProb * playtimes;
							
							probTotalSpendMoney += multiProb * ProfitUtil.BaseMoney * playerCardsPathValue.getBetMutiV();
							timeTotalSpendMoney += ProfitUtil.BaseMoney * playerCardsPathValue.getBetMutiV();
							continue;
						}
						if(dealerCardsPathValue.getValue() > BlackJackInfo.BlackJack) {
							winTimes += playtimes;
							winProbs += multiProb * playtimes;

							probReturnMoney += 2 * multiProb * ProfitUtil.BaseMoney * playerCardsPathValue.getBetMutiV(); 
							probTotalSpendMoney += multiProb * ProfitUtil.BaseMoney * playerCardsPathValue.getBetMutiV();
							timeReturnMoney += 2 * ProfitUtil.BaseMoney * playerCardsPathValue.getBetMutiV(); 
							timeTotalSpendMoney += ProfitUtil.BaseMoney * playerCardsPathValue.getBetMutiV();
							continue;
						}
						if(playerCardsPathValue.getValue() > dealerCardsPathValue.getValue()) {
							winTimes += playtimes;
							winProbs += multiProb * playtimes;
							
							probReturnMoney += 2 * multiProb * ProfitUtil.BaseMoney * playerCardsPathValue.getBetMutiV(); 
							probTotalSpendMoney += multiProb * ProfitUtil.BaseMoney * playerCardsPathValue.getBetMutiV();
							timeReturnMoney += 2 * ProfitUtil.BaseMoney * playerCardsPathValue.getBetMutiV(); 
							timeTotalSpendMoney += ProfitUtil.BaseMoney * playerCardsPathValue.getBetMutiV();
							continue;
						}
						if(playerCardsPathValue.getValue() == dealerCardsPathValue.getValue()) {
							drawTimes += playtimes;
							drawProbs += multiProb * playtimes;
							
							probReturnMoney += multiProb * ProfitUtil.BaseMoney * playerCardsPathValue.getBetMutiV(); 
							probTotalSpendMoney += multiProb * ProfitUtil.BaseMoney * playerCardsPathValue.getBetMutiV();
							timeReturnMoney += ProfitUtil.BaseMoney * playerCardsPathValue.getBetMutiV(); 
							timeTotalSpendMoney += ProfitUtil.BaseMoney * playerCardsPathValue.getBetMutiV();
							continue;
						}
						if(playerCardsPathValue.getValue() < dealerCardsPathValue.getValue()) {
							loseTimes += playtimes;
							loseProbs += multiProb * playtimes;
							
							probTotalSpendMoney += multiProb * ProfitUtil.BaseMoney * playerCardsPathValue.getBetMutiV();
							timeTotalSpendMoney += ProfitUtil.BaseMoney * playerCardsPathValue.getBetMutiV();							
							continue;
						}
					}
				}
			}
		}
		
		totalProbs = winProbs + drawProbs + loseProbs;
		probRates = new Double[] {winProbs/totalProbs,drawProbs/totalProbs,loseProbs/totalProbs};
		if(EvolutionOneWayTest.debug) System.out.println("totalProbs : " + totalProbs);
		
		totalTimes = winTimes + drawTimes + loseTimes;
		timeRates  = new Double[] {winTimes/totalTimes,drawTimes/totalTimes,loseTimes/totalTimes};
		if(EvolutionOneWayTest.debug) System.out.println("totalTimes : " + totalTimes);
		
		this.probMoneyReturn = probReturnMoney;
		this.probTotalSpead = probTotalSpendMoney;
		this.probRoi = probMoneyReturn/probTotalSpead;
		
		this.timeMoneyReturn = timeReturnMoney;
		this.timeTotalSpead = timeTotalSpendMoney;
		this.timeRoi = timeMoneyReturn/timeTotalSpead;
		
		if(EvolutionOneWayTest.debug) System.out.println("probRoi : " + this.probRoi);
		if(EvolutionOneWayTest.debug) System.out.println("timeRoi : " + this.timeRoi);
		
		if(EvolutionOneWayTest.debug) System.out.println(this.getClass().getSimpleName() + " total wasted time : " + (System.currentTimeMillis() - startTime));
	}
	
	
	
	public Double getProbMoneyReturn() {
		return probMoneyReturn;
	}

	public Double getProbTotalSpead() {
		return probTotalSpead;
	}

	public Double getTimeMoneyReturn() {
		return timeMoneyReturn;
	}

	public Double getTimeTotalSpead() {
		return timeTotalSpead;
	}

	public Double getProbRoi() {
		return probRoi;
	}

	public Double getTimeRoi() {
		return timeRoi;
	}

	public double getTotalTimes() {
		return totalTimes;
	}

	public double getTotalProbs() {
		return totalProbs;
	}

	public Double[] getTimeRates() {
		if(timeRates == null) getEverythingInOneLoop();
		return timeRates;
	}
	
	public Double[] getProbRates() {
		if(probRates == null) getEverythingInOneLoop();
		return probRates;
	}

	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();		
		sb.append(getCalcResult());
		sb.append("\nconstruct code = \n");
		sb.append("\n{\nsuper();");
		sb.append("\nMap<MatrixKey,PlayerAction> changesMatrix = new HashMap<>();");
		for(Result or: getOneMatrxByList()) {
			sb.append("\n{\n");
//			MatrixKey splited_Pair_And_Can_Split = new MatrixKey(StartValue.getOne(start), dealerCard, Situation.Splited_Pair_And_Can_Split);
			sb.append(" MatrixKey goodluck = new MatrixKey(");
			sb.append("StartValue.getOne(");
			sb.append(or.matrixKey.getStartValue().getValue());
			if(or.matrixKey.getDealerCard().getValue()==10) {
				sb.append("),Card.Ten,Situation.");
			}else {
				sb.append("),Card.getOne(");
				sb.append(or.matrixKey.getDealerCard().getValue());
				sb.append("),Situation.");
			}
			sb.append(or.matrixKey.getSituation().name());
			sb.append(");\n");
//			notChangesMatrix.put(start_With_A, PlayerAction.Hit);
			sb.append(" changesMatrix.put(goodluck,");
			sb.append("PlayerAction.");
			sb.append(or.playerAction.name());
			sb.append(");");
			sb.append("\n}");
		}
		sb.append("\nthis.changesMatrix = changesMatrix;");
		sb.append("\nthis.one = new HashMap<>();");
		sb.append("\none.putAll(changesMatrix);");
		sb.append("\none.putAll(notChangesMatrix);");
		sb.append("\n}\n");
		sb.append("\n\nchangeMatrix = ");
		for(Result r: getChangeMatrxByList()) {
			sb.append("\n");
			sb.append(r);
		}
		sb.append("\n");
		return sb.toString();
	}
	

	public String getSimpleDesc() {
		return getCalcResult();
	}
	
	public String getCalcResult() {
		StringBuffer sb = new StringBuffer();
		sb.append("StrategyMatrix8012 [ParetoFrontValue= ");
		sb.append(getParetoFrontValue());
		sb.append(" ,ParetotYPE= ");
		sb.append(StrategyMatrix8012.paretoFrontType);
		sb.append(",\t roiFactor()= ");
		sb.append(roiFactor());
		sb.append(",\t probRateFactor()= ");
		sb.append(probRateFactor());
		sb.append(",\t timeRateFactor()= ");
		sb.append(timeRateFactor());
		sb.append(",\t timeRoi= ");
		sb.append(getTimeRoi());
		sb.append(",\t probRoi= ");
		sb.append(getProbRoi());
		sb.append(",\t totalTimes: "+ this.totalTimes);
		sb.append(",\t getTimeRates= ");
		sb.append(HelloWorld.builderDoubleWDL(getTimeRates()));
		sb.append(",\t totalProbs: "+ this.totalProbs);
		sb.append(",\t getProbRate= ");
		sb.append(HelloWorld.builderDoubleWDL(getProbRates()));
		sb.append(",\t timeMoneyReturn= ");
		sb.append(getTimeMoneyReturn());
		sb.append(",\t timeTotalSpead= ");
		sb.append(getTimeTotalSpead());
		sb.append(",\t probMoneyReturn= ");
		sb.append(getProbMoneyReturn());
		sb.append(",\t probTotalSpead= ");
		sb.append(getProbTotalSpead());

		return sb.toString();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((one == null) ? 0 : one.hashCode());
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
		StrategyMatrix8012 other = (StrategyMatrix8012) obj;
		if (one == null) {
			if (other.one != null)
				return false;
		} else if (!one.equals(other.one))
			return false;
		return true;
	}

	
	public String diffWith(StrategyMatrix8012 other){
		List<Result> changeResults = new LinkedList<>();
		for(Entry<MatrixKey,PlayerAction> e: this.one.entrySet()) {
//			if(e.getValue()!= other.one.get(e.getKey())) {
			if(this.fetchPlayAction(e.getKey(), 0)!= other.fetchPlayAction(e.getKey(),0)) {
				changeResults.add(new Result(e.getKey(), e.getValue()));
			}
		}
		Collections.sort(changeResults);
		StringBuilder sb = new StringBuilder();
		for(Result result : changeResults) {
			sb.append(result.matrixKey);
			sb.append(" : ");
			sb.append(this.fetchPlayAction(result.matrixKey,0));
			sb.append(" -> ");
			sb.append(other.fetchPlayAction(result.matrixKey,0));
			sb.append("\n");
		}
		return sb.toString();
	}
	
	public static int paretoFrontType = 4;
	
	//0:Version Zero: 关于赢率,此时的数据roi影响应该不大,取值范围都在[0~1],prob和time的数据都在0.4~0.5之间,roi在0.7~0.9之间 
	//基于DStime的权重，鼓励分牌和Double
	public static double roi0 = 3;
	//基于playtime的权重，鼓励分牌,净概率,关注于赢
	public static double probRates0 = 2.8;
	//基于playtime的权重，鼓励分牌,净胜率,关注于赢
	public static double timeRates0 = 4.2;
	
	//1:Version One: 关于不输率,此时的数据roi影响应该不大,取值范围都在[0~1],prob和time的数据都在0.4~0.5之间,roi在0.7~0.9之间 
	//基于DStime的权重，鼓励分牌和Double
	public static double roi01 = 3.25;
	//基于playtime的权重，鼓励分牌,净概率,关注于不输
	public static double probRates01 = 2.75;
	//基于playtime的权重，鼓励分牌,净胜率,关注于不输
	public static double timeRates01 = 4;
	
	//2:Version Two: 关于于胜率比败率差多多少,用胜-负得到的值可能在[0.1 ~ -0.1]之前,这时roi在0.7~0.9之间的影响就变大了
	//算完的结果就是: getTimeRates= w:47.78862602578159 $d:3.8930589887208806 $l:48.31831498549754 ,造成平局比例大幅减少.没有什么意义.
	//基于DStime的权重，鼓励分牌和Double
	public static double roi02 = 0.07;
	//基于playtime的权重，鼓励分牌,净概率,关注于差值
	public static double probRates02 = 7;
	//基于playtime的权重，鼓励分牌,净胜率,关注于差值
	public static double timeRates02 = 1.22;
	
	//3:Version Three: 
	//基于DStime的权重，鼓励分牌和Double
	public static double roi03 = 0.108;
	//基于playtime的权重，鼓励分牌,净概率,关注于差值
	public static double probRates03 = 1.08;
	//基于playtime的权重，鼓励分牌,净胜率,关注于差值
	public static double timeRates03 = 1.36;
	
	//4:Version Four: 纯ROI,无它
	//基于DStime的权重，鼓励分牌和Double
	public static double roi04 = 1;
	//基于playtime的权重，鼓励分牌,净概率,关注于差值
	public static double probRates04 = 0;
	//基于playtime的权重，鼓励分牌,净胜率,关注于差值
	public static double timeRates04 = 0;
	
	//5:Version Five:纯 ProbRates
	//基于DStime的权重，鼓励分牌和Double
	public static double roi05 = 0;
	//基于playtime的权重，鼓励分牌,净概率,关注于差值
	public static double probRates05 = 1;
	//基于playtime的权重，鼓励分牌,净胜率,关注于差值
	public static double timeRates05 = 0;
	
	//6:Version Six:纯timeRates
	//基于DStime的权重，鼓励分牌和Double
	public static double roi06 = 0;
	//基于playtime的权重，鼓励分牌,净概率,关注于差值
	public static double probRates06 = 0;
	//基于playtime的权重，鼓励分牌,净胜率,关注于差值
	public static double timeRates06 = 1;
	
	public double getParetoFrontValue() {
		getEverythingInOneLoop();
		
		return this.roiFactor() + this.probRateFactor() + this.timeRateFactor();
	}
	
	public double roiFactor() {
		
		if(paretoFrontType ==0) {
			//Version Zero: 关于赢率,此时的数据roi影响应该不大,取值范围都在[0~1],prob和time的数据都在0.4~0.5之间,roi在0.7~0.9之间 
			//基于DStime的权重，鼓励分牌和Double
			return roi0 * this.getProbRoi();
		}
		if(paretoFrontType == 1){
			//Version One: 关于不输率,此时的数据roi影响应该不大,取值范围都在[0~1],prob和time的数据都在0.4~0.5之间,roi在0.7~0.9之间 
			//基于DStime的权重，鼓励分牌和Double
			return roi01 * this.getProbRoi();
		}
		if(paretoFrontType == 2) {
			//Version Two: 关于于胜率比败率差多多少,用胜-负得到的值可能在[0.1 ~ -0.1]之前,这时roi在0.7~0.9之间的影响就变大了
			//基于DStime的权重，鼓励分牌和Double
			return roi02 * this.getProbRoi();
		}
		if(paretoFrontType == 3) {
			//基于DStime的权重，鼓励分牌和Double
			return roi03 * this.getProbRoi();
		}
		if(paretoFrontType == 4) {
			//基于DStime的权重，鼓励分牌和Double
			return roi04 * this.getProbRoi();
		}
		if(paretoFrontType == 5) {
			//基于DStime的权重，鼓励分牌和Double
			return roi05 * this.getProbRoi();
		}
		if(paretoFrontType == 6) {
			//基于DStime的权重，鼓励分牌和Double
			return roi06 * this.getProbRoi();
		}
		
		throw new RuntimeException("roiFactor ParetoFrontValue is incorrect: " +paretoFrontType);
	
	}
	
	public double probRateFactor() {
		if(paretoFrontType ==0) {
			//Version Zero: 关于赢率,此时的数据roi影响应该不大,取值范围都在[0~1],prob和time的数据都在0.4~0.5之间,roi在0.7~0.9之间 
			return probRates0 * this.getProbRates()[0];
		}
		if(paretoFrontType == 1){
			//Version One: 关于不输率,此时的数据roi影响应该不大,取值范围都在[0~1],prob和time的数据都在0.4~0.5之间,roi在0.7~0.9之间 
			return probRates01 * (this.getProbRates()[0] + this.getProbRates()[1]);
		}
		if(paretoFrontType == 2) {
			//Version Two: 关于于胜率比败率差多多少,用胜-负得到的值可能在[0.1 ~ -0.1]之前,这时roi在0.7~0.9之间的影响就变大了
			return probRates02 * (this.getProbRates()[0] - this.getProbRates()[2]);
		}
		if(paretoFrontType == 3) {
			return probRates03 * (this.getProbRates()[0] + this.getProbRates()[1] - this.getProbRates()[2]);
		}
		if(paretoFrontType ==4) {
			return probRates04 * this.getProbRates()[0] + (probRates04 / 3) * this.getProbRates()[1];
		}
		if(paretoFrontType ==5) {
			return probRates05 * this.getProbRates()[0] + (probRates05 / 3) * this.getProbRates()[1];
		}
		if(paretoFrontType ==6) {
			return probRates06 * this.getProbRates()[0] + (probRates06 / 3) * this.getProbRates()[1];
		}
		
		throw new RuntimeException("probRateFactor ParetoFrontValue is incorrect: " +paretoFrontType);
	}
	
	public double timeRateFactor() {
		if(paretoFrontType ==0) {
			//Version Zero: 关于赢率,此时的数据roi影响应该不大,取值范围都在[0~1],prob和time的数据都在0.4~0.5之间,roi在0.7~0.9之间 
			return timeRates0 * this.getTimeRates()[0];
		}
		if(paretoFrontType == 1){
			//Version One: 关于不输率,此时的数据roi影响应该不大,取值范围都在[0~1],prob和time的数据都在0.4~0.5之间,roi在0.7~0.9之间 
			return timeRates01 * (this.getTimeRates()[0] + this.getTimeRates()[1]);
		}
		if(paretoFrontType == 2) {
			//Version Two: 关于于胜率比败率差多多少,用胜-负得到的值可能在[0.1 ~ -0.1]之前,这时roi在0.7~0.9之间的影响就变大了
			return timeRates02 * (this.getTimeRates()[0] - this.getTimeRates()[2]);
		}
		if(paretoFrontType == 3) {
			//Version Two: 关于于胜率比败率差多多少,用胜-负得到的值可能在[0.1 ~ -0.1]之前,这时roi在0.7~0.9之间的影响就变大了
			return timeRates03 * (this.getTimeRates()[0] + this.getTimeRates()[1] - this.getTimeRates()[2]);
		}
		if(paretoFrontType == 4) {
			return timeRates04 * this.getTimeRates()[0] + (timeRates04 / 3) * this.getTimeRates()[1];
		}
		if(paretoFrontType == 5) {
			return timeRates05 * this.getTimeRates()[0] + (timeRates05 / 3) * this.getTimeRates()[1];
		}
		if(paretoFrontType == 6) {
			return timeRates06 * this.getTimeRates()[0] + (timeRates06 / 3) * this.getTimeRates()[1];
		}
		
		throw new RuntimeException("timeRateFactor ParetoFrontValue is incorrect: " +paretoFrontType);
	}
	

	//计算完以后，不是100%，而是超过100%，还没想清楚为什么
	public void testPureProb() {
		double total = 0;
		Collection<PlayerCardsPathValue> playerCards = PlayerCards.generateTwoStartCards();
		int i =1;
		for(PlayerCardsPathValue pcpv : playerCards){
			System.out.println(i+"/"+playerCards.size());
			i++;
			for(Card dealerCard : Card.values()){
				PlayerCardsPathValue oneCalc = new PlayerCardsPathValue(pcpv);
				Collection<PlayerCardsPathValue> oneSet = Strategy8012.generatePlayerCardsPaths(Casion6Deck.buildCasion6Deck(), this, oneCalc, dealerCard);
				Collection<DealerCardsPathValue> dealerSet = DealerCards.fetchDealerCards(dealerCard);
				for(PlayerCardsPathValue playerCardsPathValue : oneSet) {
					for(DealerCardsPathValue dealerCardsPathValue : dealerSet) {
						total += playerCardsPathValue.prob() * dealerCardsPathValue.prob();
//						System.out.println(total);
					}
				}
			}
		}
		
		System.out.println(total);
	}
	
}
