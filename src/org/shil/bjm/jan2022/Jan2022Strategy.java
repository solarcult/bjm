package org.shil.bjm.jan2022;

import org.shil.bjm.HelloWorld;
import org.shil.bjm.anaylze.AnalyzeStatus;
import org.shil.bjm.anaylze.Jan172022AnalyzeUtil;
import org.shil.bjm.anaylze.PlayersVSDealersResultChanceProb;
import org.shil.bjm.core.DealerCards;
import org.shil.bjm.core.PlayerCards;
import org.shil.bjm.jan2022.jan2022.BeforeJan16Test2022NM;
import org.shil.bjm.jan2022.jan2022.Jan17WithA2022Matrix;
import org.shil.bjm.jan2022.jan2022.Jan18PairCard2022Matrix;
import org.shil.bjm.meta.*;
import org.shil.bjm.strategy.PlayerStrategy;
import org.shil.bjm.strategy.PlayerStrategyMatrix;
import org.shil.bjm.strategy.one.OneStrategy;
import org.shil.bjm.strategy.one.OneWithAMatrix;
import org.shil.bjm.jan2022.jan2022.Jan16Test2022NM;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/**
 * 之前的策略是一把生成所有可能的牌，但在计算胜负平的概率时发现，更好的行为造成的结果不对，
 * 比如说，在某个牌组合产生的概率是20%，在这个组合下再产生其他组合的总概率相加应该最多不会超过20%，但是如果按之前的方法，会和所有的dealer牌相乘，造成概率超过20%
 * 现在要每一步算出来，计算出概率，然后再次按策略产生牌，在之前的概率下进行计算。
 * let try it
 * @since 2022-Jan-17
 */
public class Jan2022Strategy {
    /**
     * normal 一般的组合的牌，没有对，没有A的策略
     */
    private PlayerStrategyMatrix nmSM;
    /**
     * 带对的组合牌
     */
    private PlayerStrategyMatrix pairSM;
    /**
     * 带A的组合牌
     */
    private PlayerStrategyMatrix waSM;

    public Jan2022Strategy(PlayerStrategyMatrix nmSM, PlayerStrategyMatrix scSM, PlayerStrategyMatrix waSM){
        this.nmSM = nmSM;
        this.pairSM = scSM;
        this.waSM = waSM;
    }

    public Collection<PlayerCardsPathValue> generate2End(PlayerCardsPathValue playerCardsPathValue, Card dealerCard){
        Collection<PlayerCardsPathValue> atTheEnds = new ArrayList<>();
        Collection<PlayerCardsPathValue> oneStepSet = genOneStepCards(playerCardsPathValue,dealerCard);
        for(PlayerCardsPathValue pcpv : oneStepSet){
            PlayerAction playerAction = pcpv.getAction();
            if(playerAction == PlayerAction.Hit || playerAction == PlayerAction.Init){
                 atTheEnds.addAll(generate2End(pcpv,dealerCard));
            }else{
                atTheEnds.add(pcpv);
            }
        }

        return atTheEnds;
    }

    public Collection<PlayerCardsPathValue> genOneStepCards(PlayerCardsPathValue playerCardsPathValue, Card dealerCard){

        //找到策略配置的动作
        PlayerAction playerAction = findPlayerAction(playerCardsPathValue,dealerCard);
//        System.out.println(playerAction);
        playerCardsPathValue.setAction(playerAction);

        //进行行动
        Collection<PlayerCardsPathValue> playerCardsPathValues = handlePlayerAction(playerCardsPathValue);

        //刷新所占比的概率,将本层的概率分解到各个下层
        Jan172022AnalyzeUtil.refreshPlayerCardsPercent(playerCardsPathValues);
//        HelloWorld.print(playerCardsPathValues);

        return playerCardsPathValues;
    }

    public PlayerAction findPlayerAction(PlayerCardsPathValue playerCardsPathValue, Card dealerCard){
        //the first time reset action
        PlayerAction playerAction = null;

        if(playerCardsPathValue.getAction() == PlayerAction.Init){
            if(playerCardsPathValue.getCards().size()>=2){

                if(playerCardsPathValue.getSplitTimes()>=1 && playerCardsPathValue.getCards().get(0) == Card.One1){
                    return PlayerAction.Stand;
                }

                //detect player cards type
                if(playerCardsPathValue.isStartWithPairs()){
                    if(playerCardsPathValue.getCards().get(0) == Card.One1){
                        //TODO AA 是否一定要分牌,待验证!!!
                        //AA only can split 1 time
                        if(playerCardsPathValue.getSplitTimes()>=1){
                            playerAction = PlayerAction.Stand;
                        }else{
                            playerAction = pairSM.getPlayerAction(StartValue.getOne(playerCardsPathValue.getCards().get(0).getValue()),dealerCard).getStartAction();
                        }
                    }else{
                        if(playerCardsPathValue.getSplitTimes() >= 2){
                            //only can split 2 times
                            PlayerStrategy playerStrategy = nmSM.getPlayerAction(StartValue.getOne(playerCardsPathValue.getValue()),dealerCard);
                            playerAction = playerStrategy.getStartAction();
                            //split can not surrender
                            if(playerAction == PlayerAction.Giveup) playerAction = playerStrategy.getThreeCardAction();
                        }else{
                            //pairs
                            PlayerStrategy pairStrategy = pairSM.getPlayerAction(StartValue.getOne(playerCardsPathValue.getCards().get(0).getValue()),dealerCard);
                            if(pairStrategy == null){
                                PlayerStrategy playerStrategy = nmSM.getPlayerAction(StartValue.getOne(playerCardsPathValue.getValue()),dealerCard);
                                if(playerCardsPathValue.getSplitTimes()>0 && playerStrategy.getStartAction() == PlayerAction.Giveup){
                                    //split cards can not surrender
                                    playerAction = playerStrategy.getThreeCardAction();
                                }else{
                                    playerAction = playerStrategy.getStartAction();
                                }
                            }else{
                                playerAction = pairStrategy.getStartAction();
                            }
                        }
                    }

                }else if(playerCardsPathValue.isStartWithA()){
                    //with A
                    Card withoutAcard = OneWithAMatrix.findFirstTwoCardsWithOutA(playerCardsPathValue);
                    if(withoutAcard!=null){
                        PlayerStrategy playerStrategy = waSM.getPlayerAction(StartValue.getOne(withoutAcard.getValue()),dealerCard);
                        playerAction = playerStrategy.getStartAction();
                    }
                }else{
                    PlayerStrategy playerStrategy = nmSM.getPlayerAction(playerCardsPathValue.getStartValue(),dealerCard);
                    //normal cards
                    playerAction = playerStrategy.getStartAction();

                    if(playerCardsPathValue.getSplitTimes()>0 || playerCardsPathValue.getBetMutiV()>1){
                        if(playerAction == PlayerAction.Giveup){
                            playerAction = playerStrategy.getThreeCardAction();
                        }
                    }
                }
            }

            //此处不能用else{,因为如果是Pair被split以后，要在下面的这段代码再发一张牌，继续旅程
            //only handle split cards here
            if(playerCardsPathValue.getCards().size()<2) {
                playerAction = PlayerAction.Split;
                //如果是A只能分1次
                if(playerCardsPathValue.getCards().get(0) == Card.One1) {
                    playerAction = PlayerAction.Stand;
                }
            }
        }else if(playerCardsPathValue.getAction() == PlayerAction.Hit){
            //HIT in normal
            if(playerCardsPathValue.getValue() <= BlackJackInfo.BlackJack) {
                playerAction = nmSM.getPlayerAction(StartValue.getOne(playerCardsPathValue.getValue()), dealerCard).getThreeCardAction();
            }else {
                return PlayerAction.Stand;
            }
        }

        if(playerAction == null){
            throw new RuntimeException("playaction is null, should not happend " + playerCardsPathValue + dealerCard);
        }

        return playerAction;
    }

    public Collection<PlayerCardsPathValue> handlePlayerAction(PlayerCardsPathValue playerCardsPathValue){

        Collection<PlayerCardsPathValue> playerCardsPathValues = new ArrayList<>();

        if(playerCardsPathValue.getValue() > BlackJackInfo.BlackJack){
            //burst, bye~
            playerCardsPathValue.setAction(PlayerAction.Stand);
            playerCardsPathValues.add(playerCardsPathValue);
        }else if(playerCardsPathValue.getAction() == PlayerAction.Giveup) {
            // we finish and pray
            playerCardsPathValues.add(playerCardsPathValue);
        }else if(playerCardsPathValue.getAction() == PlayerAction.Stand){
            // we finish and pray
            playerCardsPathValues.add(playerCardsPathValue);
        }else if(playerCardsPathValue.getAction() == PlayerAction.DoubleDone){
            // good luck
            playerCardsPathValues.add(playerCardsPathValue);
        }else if(playerCardsPathValue.getAction() == PlayerAction.Double){
            //let double me up
            for (Card card : Card.values()) {
                PlayerCardsPathValue aNewPath = new PlayerCardsPathValue(playerCardsPathValue);
                aNewPath.addCard(card);
                aNewPath.setAction(PlayerAction.DoubleDone);
                playerCardsPathValues.add(aNewPath);
            }
        }else if(playerCardsPathValue.getAction() == PlayerAction.Hit){
//			System.out.println(playerCardsPathValue);
            // hit me hardly
            for (Card card : Card.values()) {
                PlayerCardsPathValue aNewPath = new PlayerCardsPathValue(playerCardsPathValue);
                aNewPath.addCard(card);
                playerCardsPathValues.add(aNewPath);
            }
        }else if(playerCardsPathValue.getAction() == PlayerAction.Split){
//			System.out.println(playerCardsPathValue);
            // hit me hardly
            for (Card card : Card.values()) {
                PlayerCardsPathValue aNewPath = new PlayerCardsPathValue(playerCardsPathValue);
                aNewPath.addCard(card);
                aNewPath.setAction(PlayerAction.Init);
                aNewPath.setPercent(1);
                playerCardsPathValues.add(aNewPath);
            }
        }else if(playerCardsPathValue.getAction() == PlayerAction.SplitAbandon){
            //after split the origin pairs one left card playerCardsPathValue will abandon here and be ignored
        }else{
            throw new RuntimeException("wtf of this action, should not happend " + playerCardsPathValue);
        }

        return playerCardsPathValues;
    }

    public static void main(String[] args){


        Jan2022Strategy jan2022Strategy = new Jan2022Strategy(Jan16Test2022NM.SELF, Jan18PairCard2022Matrix.SELF, Jan17WithA2022Matrix.SELF);

        Collection<PlayerCardsPathValue> startCards =  PlayerCards.generateTwoStartCards();
        double[] wdlr = new double[4];

        for(PlayerCardsPathValue pcpv : startCards){
            for(Card dealerCard : Card.values()){

                System.out.println("\n           --- " + pcpv.getCards().get(0)+" "+ pcpv.getCards().get(1) +" vs "+ dealerCard + " ---");

                double[] r = testOne(pcpv,dealerCard,jan2022Strategy);
                wdlr[0]+=r[0];
                wdlr[1]+=r[1];
                wdlr[2]+=r[2];
                wdlr[3]+=r[3];
            }
        }

        System.out.println("Finally: ");
        HelloWorld.printDoubleWDLR(wdlr);
//        w:94611.58022974315(43%)  $d:19209.615019891815(8.8%)  $l:105878.80475036505(48%)      money return : 74586.12487142246


//        testOne(new PlayerCardsPathValue(Card.One1,Card.One1),Card.Six6,jan2022Strategy);
//        testGenerateSame();

    }

    public static double[] testOne(PlayerCardsPathValue opcpv , Card dealerCard, Jan2022Strategy jan2022Strategy){
        PlayerCardsPathValue playerCardsPathValue = new PlayerCardsPathValue(opcpv);

        Collection<PlayerCardsPathValue> all = jan2022Strategy.generate2End(playerCardsPathValue,dealerCard);
//        HelloWorld.print(all);

        Map<Integer, AnalyzeStatus> playerMap = Jan172022AnalyzeUtil.analyzePlayerCardsPathValuePercent(all);
//        HelloWorld.printMap(playerMap);

        double [] wdl = PlayersVSDealersResultChanceProb.calcPlayerVSDealerAnaylzeStatusPrecent(playerMap, DealerCards.analyzeDealerCardValuePrecent(dealerCard));
//        HelloWorld.printDoubleWDL(wdl);

        double nowM = 0d;
        for(PlayerCardsPathValue pcpv : all){
            PlayerCardsPathValue one = new PlayerCardsPathValue(pcpv);
            double t = Jan172022AnalyzeUtil.moneyCalcOneHandInReturnPureProb(one,dealerCard);
            nowM += t;
        }
//        int totalMatch = all.size() * DealerCards.fetchDealerCards(dealerCard).size();
//        System.out.println(totalMatch +" : now Money: " + nowM);
//        System.out.println();
        double[] allr = new double[4];
        allr[0]=wdl[0];
        allr[1]=wdl[1];
        allr[2]=wdl[2];
        allr[3]=nowM;

        HelloWorld.printDoubleWDLR(allr);

        return allr;
    }

    public static void testGenerateSame(){
        OneStrategy oldStrategy = new OneStrategy(BeforeJan16Test2022NM.SELF,null,null);
        Jan2022Strategy oneStepStrategy = new Jan2022Strategy(BeforeJan16Test2022NM.SELF,null,null);

        Collection<PlayerCardsPathValue> playerCardsPathValues = PlayerCards.generateTwoStartCardsWithoutPairWithoutA();
        int i = 0;
        for(PlayerCardsPathValue pcpv : playerCardsPathValues){
            System.out.println(" testing  "+ ++i + "   " + pcpv.getCards().get(0)+" "+ pcpv.getCards().get(1));
            for(Card dealer : Card.values()){
                PlayerCardsPathValue old = new PlayerCardsPathValue(pcpv);
                PlayerCardsPathValue now = new PlayerCardsPathValue(pcpv);
                if(oldStrategy.generatePlayerCardsPaths(old,dealer).size() != oneStepStrategy.generate2End(now,dealer).size()){
                    System.out.println("            " + pcpv.getValue() + " vs " + dealer);
                    System.out.println("NOoooooooooooo");
                }else{
//                    System.out.println("yep");
                }

            }
        }
    }

}
