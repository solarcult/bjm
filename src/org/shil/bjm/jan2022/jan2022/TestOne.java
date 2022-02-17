package org.shil.bjm.jan2022.jan2022;

import org.shil.bjm.HelloWorld;
import org.shil.bjm.anaylze.AnalyzeStatus;
import org.shil.bjm.anaylze.Jan172022AnalyzeUtil;
import org.shil.bjm.anaylze.PlayersVSDealersResultChanceProb;
import org.shil.bjm.core.DealerCards;
import org.shil.bjm.jan2022.Jan2022Strategy;
import org.shil.bjm.meta.Card;
import org.shil.bjm.meta.PlayerCardsPathValue;

import java.util.Collection;
import java.util.Map;

public class TestOne {

    public static void main(String[] args){
        PlayerCardsPathValue one = new PlayerCardsPathValue(Card.Nine9,Card.Nine9);
        Card dealerCard = Card.Seven7;

        Jan2022Strategy jan2022Strategy = new Jan2022Strategy(Jan16Test2022NM.SELF, Jan18PairCard2022Matrix.SELF,Jan17WithA2022Matrix.SELF);

        double[] total = new double[4];
        Collection<PlayerCardsPathValue> ones = jan2022Strategy.generate2End(one,dealerCard);
        HelloWorld.print(ones);
        Map<Integer, AnalyzeStatus> playerMap = Jan172022AnalyzeUtil.analyzePlayerCardsPathValuePercent(ones);
        HelloWorld.printMap(playerMap);
        double [] wdl = PlayersVSDealersResultChanceProb.calcPlayerVSDealerAnaylzeStatusPrecent(playerMap, DealerCards.analyzeDealerCardValuePrecent(dealerCard));
        total[0]+=wdl[0];
        total[1]+=wdl[1];
        total[2]+=wdl[2];
        HelloWorld.printDoubleWDL(wdl);

        double nowM = 0d;
        for(PlayerCardsPathValue pcpv : ones){
            PlayerCardsPathValue x = new PlayerCardsPathValue(pcpv);
            double t = Jan172022AnalyzeUtil.moneyCalcOneHandInReturnPureProb(x,dealerCard);
            nowM += t;
        }
        int totalMatch = ones.size() * DealerCards.fetchDealerCards(dealerCard).size();
        System.out.println();
        System.out.println(totalMatch +" : now Money: " + nowM);
        System.out.println();

    }
}
