package org.shil.bjm.strategy8102;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

import org.shil.bjm.core.PlayerCards;
import org.shil.bjm.meta.Card;
import org.shil.bjm.meta.PlayerCardsPathValue;
import org.shil.bjm.meta.ProfitUtil;

public class TestA {
	private static boolean useMorePercificRate = false;
	
	public static void main(String[] args) {
		testROI();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss");
		String fileName=sdf.format(Calendar.getInstance().getTime())+"_blackjack.txt";
		System.out.println(sdf.format(Calendar.getInstance().getTime()));
		
		List<StrategyMatrix8012> a = new ArrayList<>();
		a.add(new Standard2017());
//		EvolutionTest.writeToDisk(a);
		
		for(int i=0;i<5000;i++) {
			if((i + 1) % 888 == 0) {
				System.out.println(i);
			}
		}
	}
	
	public static void testROI(){}
}
