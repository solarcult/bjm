package org.shil.bjm.anaylze;

import org.shil.bjm.core.DealerCards;
import org.shil.bjm.meta.Card;
import org.shil.bjm.meta.PlayerAction;
import org.shil.bjm.meta.PlayerCardsPathValue;
import org.shil.bjm.meta.WinDrawLose;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;

public class Jan172022AnalyzeUtil {

    /**
     * 将传进来的组合百分比平均分配到下面分散的分支中去
     * 原百分比在percent里面
     * 根据概率平分
     * @param playerCardsPathValues
     * @return
     */
    public static Collection<PlayerCardsPathValue> refreshPlayerCardsPercent(Collection<PlayerCardsPathValue> playerCardsPathValues){

        double totalProb = 0;
        for(PlayerCardsPathValue cpv : playerCardsPathValues){
            if(cpv.getAction()==PlayerAction.Init) continue; //分牌产生的,按照全新的组合
            totalProb += cpv.prob();
        }

        for(PlayerCardsPathValue cpv : playerCardsPathValues){
            if(cpv.getAction()==PlayerAction.Init) continue; //分牌产生的,按照全新的组合
            double thisTurnPercent = cpv.prob() / totalProb;
            cpv.setPercent(thisTurnPercent * cpv.getPercent());
        }

        return playerCardsPathValues;
    }

    /**
     * 根据百分比算
     * @param cardsPathValues
     * @return
     */
    public static Map<Integer,AnalyzeStatus> analyzePlayerCardsPathValuePercent(Collection<PlayerCardsPathValue> cardsPathValues){
        double totalPercent = 0;
        Map<Integer,AnalyzeStatus> valueMap = new TreeMap<>();
        for(PlayerCardsPathValue cpv : cardsPathValues){
            totalPercent += cpv.getPercent();
            AnalyzeStatus as = valueMap.getOrDefault(cpv.getValue(), new AnalyzeStatus(cpv.getValue(),0d,0d,0d,0d,0d));
            //as.getProb()只是用这个名字,实际记录的是百分比
            as.setProb(as.getProb()+cpv.getPercent());
            valueMap.put(cpv.getValue(), as);
        }

        double totalPct = 0d;
        double tillProb = 0d;
        for(Map.Entry<Integer, AnalyzeStatus> e : valueMap.entrySet()){
            AnalyzeStatus as = e.getValue();
            tillProb += as.getProb();
            as.setTillProb(tillProb);
            as.setPrecent(as.getProb()/totalPercent);
            totalPct+=as.getPrecent();
            as.setTillPct(totalPct);
            as.setTotalProb(totalPercent);
        }

        return valueMap;
    }

    public static double moneyCalcOneHandInReturnPureProb(PlayerCardsPathValue playerCardsPathValue, Card dealerCard){
        double basicBet = 1000;
        double allReturnIncludeBet = 0d;
        double onePot = basicBet * playerCardsPathValue.getBetMutiV() * playerCardsPathValue.getPercent();

        if(playerCardsPathValue.getAction() == PlayerAction.Giveup){
            if(playerCardsPathValue.getBetMutiV()>1 || playerCardsPathValue.getSplitTimes()>0 || playerCardsPathValue.getDsTimes()>0){
                throw new RuntimeException("should not here if split or double :" + playerCardsPathValue);
            }
            allReturnIncludeBet -= onePot;
            return allReturnIncludeBet;
        }else if(playerCardsPathValue.getAction() == PlayerAction.SplitAbandon){
            return allReturnIncludeBet;
        }else if(playerCardsPathValue.getAction() == PlayerAction.Init
				|| playerCardsPathValue.getAction() == PlayerAction.Hit
                || playerCardsPathValue.getAction() == PlayerAction.Double
                || playerCardsPathValue.getAction() == PlayerAction.Split){
            throw new RuntimeException("what is wrong in here? status not done: " + playerCardsPathValue.getAction());
        }

        //最终计算投资收益率
        Collection<PlayerCardsPathValue> players = new HashSet<PlayerCardsPathValue>();
        players.add(playerCardsPathValue);
        Map<Integer, AnalyzeStatus> playerMap = Jan172022AnalyzeUtil.analyzePlayerCardsPathValuePercent(players);
        double [] wdl = PlayersVSDealersResultChanceProb.calcPlayerVSDealerAnaylzeStatusPrecent(playerMap, DealerCards.analyzeDealerCardValuePrecent(dealerCard));
        //从桌上拿回来的钱
        allReturnIncludeBet += wdl[WinDrawLose.win] * 2 * onePot;
        allReturnIncludeBet += wdl[WinDrawLose.draw] * onePot;
        //不要处理输掉的钱,因为没有从桌上拿回钱,成本在下一行减去,终于算对了,开心
//        allReturnIncludeBet -= wdl[WinDrawLose.lose] * onePot;
        //减去成本
        allReturnIncludeBet = allReturnIncludeBet - onePot;

        return allReturnIncludeBet;
    }
}
