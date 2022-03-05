package org.shil.bjm.jan2022.jan2022;

import org.shil.bjm.HelloWorld;
import org.shil.bjm.anaylze.AnalyzeStatus;
import org.shil.bjm.anaylze.Jan172022AnalyzeUtil;
import org.shil.bjm.anaylze.PlayersVSDealersResultChanceProb;
import org.shil.bjm.core.DealerCards;
import org.shil.bjm.core.PlayerCards;
import org.shil.bjm.jan2022.Jan2022Strategy;
import org.shil.bjm.meta.Card;
import org.shil.bjm.meta.PlayerCardsPathValue;

import java.util.Collection;
import java.util.Map;

public class TestOne {

    public static boolean DETAIL = false;

    public static void main(String[] args){

        testOne();

//        testWithoutPairWithoutA();

    }

    public static void testOne(){
        PlayerCardsPathValue one = new PlayerCardsPathValue(Card.Nine9,Card.Nine9);
        Card dealerCard = Card.Six6;
        test(one,dealerCard);

//        PlayerCardsPathValue two = new PlayerCardsPathValue(Card.Nine9,Card.Nine9);
//        Card dealerCard2 = Card.Eight8;
//        test(two,dealerCard2);
    }

    public static double[] testWithoutPairWithoutA(){

        Collection<PlayerCardsPathValue> wawps = PlayerCards.sortedOneValueStartCardsWithoutA();
//        Collection<PlayerCardsPathValue> wawps = PlayerCards.generatePairs();
//        Collection<PlayerCardsPathValue> wawps = PlayerCards.generateTwoStartCards();
        double total[] = new double[5];
        for(PlayerCardsPathValue pcpv : wawps){
            double[] ps = new double[5];
            for(Card dealerCard : Card.values()){
                System.out.println(pcpv.getValue() + " vs "+dealerCard.getValue());
                PlayerCardsPathValue p = new PlayerCardsPathValue(pcpv);
                double[] rs = test(p,dealerCard);
                ps[0]+=rs[0];
                ps[1]+=rs[1];
                ps[2]+=rs[2];
                ps[3]+=rs[3];
                ps[4]+=rs[4];
            }
            System.out.println("-- total -- \n number: " + pcpv.getValue() + " ,times : " +ps[4]+ "  ,money : " + ps[3] + " ,effect: " +ps[3]/ps[4]);
            HelloWorld.printDoubleWDL( convertHundredPercent(ps));
            System.out.println();

            total[0]+=ps[0];
            total[1]+=ps[1];
            total[2]+=ps[2];
            total[3]+=ps[3];
            total[4]+=ps[4];
        }
        System.out.println("           Finally:           ");
        HelloWorld.printDoubleWDL(convertHundredPercent(total));
        System.out.println(total[3]+ " ,effect : " + total[3]/total[4]);
        System.out.println();

        return total;
    }


    public static double[] test(PlayerCardsPathValue one , Card dealerCard){

        Jan2022Strategy jan2022Strategy = new Jan2022Strategy(Jan16Test2022NM.SELF, Jan18PairCard2022Matrix.SELF,Jan17WithA2022Matrix.SELF);

        double[] total = new double[5];
        Collection<PlayerCardsPathValue> ones = jan2022Strategy.generate2End(one,dealerCard);
        Map<Integer, AnalyzeStatus> playerMap = Jan172022AnalyzeUtil.analyzePlayerCardsPathValuePercent(ones);
        if(DETAIL){
            HelloWorld.print(ones);
            HelloWorld.printMap(playerMap);
        }
        double [] wdl = PlayersVSDealersResultChanceProb.calcPlayerVSDealerAnaylzeStatusPrecent(playerMap, DealerCards.analyzeDealerCardValuePrecent(dealerCard));
        total[0]+=wdl[0];
        total[1]+=wdl[1];
        total[2]+=wdl[2];
        HelloWorld.printDoubleWDL(wdl);

        double nowM = 0d;
        double playtimes = 0;
        for(PlayerCardsPathValue pcpv : ones){
            playtimes += pcpv.getBetMutiV();
            if(pcpv.getBetMutiV()>1){
                System.out.println("here > 1 : "+pcpv.getBetMutiV());
            }
            PlayerCardsPathValue x = new PlayerCardsPathValue(pcpv);
            double t = Jan172022AnalyzeUtil.moneyCalcOneHandInReturnPureProb(x,dealerCard);
            nowM += t;
        }
        total[3] += nowM;
        total[4] += playtimes;

        int totalMatch = ones.size() * DealerCards.fetchDealerCards(dealerCard).size();
        System.out.println(totalMatch +" : earn Money: " + nowM + " ,playtimes "+playtimes +" ,effect: "+ nowM/playtimes);
        System.out.println();
        return total;
    }

    public static double[] convertHundredPercent(double[] wdl){
        double total = wdl[0]+wdl[1]+wdl[2];
        wdl[0] = wdl[0]/total;
        wdl[1] = wdl[1]/total;
        wdl[2] = wdl[2]/total;
        return wdl;
    }
}
