package org.shil.bjm.strategy8102.strategy.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.shil.bjm.meta.Card;
import org.shil.bjm.meta.PlayerAction;
import org.shil.bjm.meta.StartValue;
import org.shil.bjm.strategy8102.strategy.MatrixKey;
import org.shil.bjm.strategy8102.strategy.Seven8012;
import org.shil.bjm.strategy8102.strategy.Situation;

public class Pareto2Mar26 extends Seven8012{

	public Pareto2Mar26()
	{
		super();
		Map<MatrixKey,PlayerAction> changesMatrix = new HashMap<>();
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(1),Card.getOne(1),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(1),Card.getOne(2),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Split);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(1),Card.getOne(3),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Split);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(1),Card.getOne(4),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Split);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(1),Card.getOne(5),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Split);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(1),Card.getOne(6),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Split);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(1),Card.getOne(7),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Split);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(1),Card.getOne(8),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Split);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(1),Card.getOne(9),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Split);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(1),Card.Ten,Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Split);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(2),Card.getOne(1),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(2),Card.getOne(1),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(2),Card.getOne(1),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(2),Card.getOne(2),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(2),Card.getOne(2),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(2),Card.getOne(2),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(2),Card.getOne(3),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(2),Card.getOne(3),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(2),Card.getOne(3),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(2),Card.getOne(4),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Split);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(2),Card.getOne(4),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(2),Card.getOne(4),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(2),Card.getOne(5),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Split);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(2),Card.getOne(5),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Double);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(2),Card.getOne(5),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Split);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(2),Card.getOne(6),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Split);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(2),Card.getOne(6),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Split);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(2),Card.getOne(6),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Double);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(2),Card.getOne(7),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(2),Card.getOne(7),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(2),Card.getOne(7),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(2),Card.getOne(8),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(2),Card.getOne(8),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(2),Card.getOne(8),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(2),Card.getOne(9),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(2),Card.getOne(9),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(2),Card.getOne(9),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(2),Card.Ten,Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(2),Card.Ten,Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(2),Card.Ten,Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(3),Card.getOne(1),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(3),Card.getOne(1),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(3),Card.getOne(1),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(3),Card.getOne(2),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Giveup);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(3),Card.getOne(2),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(3),Card.getOne(2),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(3),Card.getOne(3),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(3),Card.getOne(3),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(3),Card.getOne(3),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Split);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(3),Card.getOne(4),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(3),Card.getOne(4),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(3),Card.getOne(4),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(3),Card.getOne(5),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Double);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(3),Card.getOne(5),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Split);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(3),Card.getOne(5),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Split);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(3),Card.getOne(6),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Split);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(3),Card.getOne(6),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Split);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(3),Card.getOne(6),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Double);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(3),Card.getOne(7),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(3),Card.getOne(7),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(3),Card.getOne(7),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(3),Card.getOne(8),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(3),Card.getOne(8),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(3),Card.getOne(8),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(3),Card.getOne(9),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(3),Card.getOne(9),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(3),Card.getOne(9),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(3),Card.Ten,Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(3),Card.Ten,Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(3),Card.Ten,Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(4),Card.getOne(1),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(4),Card.getOne(1),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(4),Card.getOne(1),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(4),Card.getOne(1),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(4),Card.getOne(2),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(4),Card.getOne(2),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(4),Card.getOne(2),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(4),Card.getOne(2),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(4),Card.getOne(3),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Double);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(4),Card.getOne(3),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(4),Card.getOne(3),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(4),Card.getOne(3),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Double);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(4),Card.getOne(4),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Double);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(4),Card.getOne(4),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(4),Card.getOne(4),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(4),Card.getOne(4),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(4),Card.getOne(5),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(4),Card.getOne(5),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Split);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(4),Card.getOne(5),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Split);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(4),Card.getOne(5),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Double);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(4),Card.getOne(6),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Double);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(4),Card.getOne(6),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Split);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(4),Card.getOne(6),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(4),Card.getOne(6),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Split);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(4),Card.getOne(7),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(4),Card.getOne(7),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(4),Card.getOne(7),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(4),Card.getOne(7),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Double);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(4),Card.getOne(8),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(4),Card.getOne(8),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(4),Card.getOne(8),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(4),Card.getOne(8),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(4),Card.getOne(9),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Double);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(4),Card.getOne(9),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(4),Card.getOne(9),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(4),Card.getOne(9),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(4),Card.Ten,Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(4),Card.Ten,Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(4),Card.Ten,Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(4),Card.Ten,Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(5),Card.getOne(1),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(5),Card.getOne(1),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(5),Card.getOne(1),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(5),Card.getOne(1),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(5),Card.getOne(1),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(5),Card.getOne(2),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Double);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(5),Card.getOne(2),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(5),Card.getOne(2),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(5),Card.getOne(2),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(5),Card.getOne(2),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Double);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(5),Card.getOne(3),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Split);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(5),Card.getOne(3),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Double);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(5),Card.getOne(3),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(5),Card.getOne(3),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Double);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(5),Card.getOne(3),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(5),Card.getOne(4),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Double);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(5),Card.getOne(4),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Double);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(5),Card.getOne(4),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(5),Card.getOne(4),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(5),Card.getOne(4),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(5),Card.getOne(5),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(5),Card.getOne(5),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Double);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(5),Card.getOne(5),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Double);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(5),Card.getOne(5),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Double);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(5),Card.getOne(5),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(5),Card.getOne(6),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(5),Card.getOne(6),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Double);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(5),Card.getOne(6),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(5),Card.getOne(6),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(5),Card.getOne(6),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Split);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(5),Card.getOne(7),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(5),Card.getOne(7),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(5),Card.getOne(7),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(5),Card.getOne(7),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(5),Card.getOne(7),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Double);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(5),Card.getOne(8),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(5),Card.getOne(8),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(5),Card.getOne(8),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(5),Card.getOne(8),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Double);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(5),Card.getOne(8),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Double);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(5),Card.getOne(9),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(5),Card.getOne(9),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(5),Card.getOne(9),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Double);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(5),Card.getOne(9),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(5),Card.getOne(9),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Double);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(5),Card.Ten,Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(5),Card.Ten,Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(5),Card.Ten,Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(5),Card.Ten,Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(5),Card.Ten,Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(6),Card.getOne(1),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(6),Card.getOne(1),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(6),Card.getOne(1),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(6),Card.getOne(1),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(6),Card.getOne(1),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(6),Card.getOne(1),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(6),Card.getOne(2),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(6),Card.getOne(2),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(6),Card.getOne(2),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(6),Card.getOne(2),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Double);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(6),Card.getOne(2),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(6),Card.getOne(2),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(6),Card.getOne(3),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(6),Card.getOne(3),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(6),Card.getOne(3),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(6),Card.getOne(3),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(6),Card.getOne(3),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(6),Card.getOne(3),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(6),Card.getOne(4),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(6),Card.getOne(4),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(6),Card.getOne(4),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(6),Card.getOne(4),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(6),Card.getOne(4),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(6),Card.getOne(4),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(6),Card.getOne(5),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(6),Card.getOne(5),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Double);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(6),Card.getOne(5),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Split);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(6),Card.getOne(5),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Split);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(6),Card.getOne(5),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(6),Card.getOne(5),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(6),Card.getOne(6),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(6),Card.getOne(6),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Split);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(6),Card.getOne(6),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Double);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(6),Card.getOne(6),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(6),Card.getOne(6),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Split);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(6),Card.getOne(6),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(6),Card.getOne(7),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(6),Card.getOne(7),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(6),Card.getOne(7),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(6),Card.getOne(7),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(6),Card.getOne(7),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(6),Card.getOne(7),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(6),Card.getOne(8),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(6),Card.getOne(8),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(6),Card.getOne(8),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(6),Card.getOne(8),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(6),Card.getOne(8),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(6),Card.getOne(8),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(6),Card.getOne(9),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(6),Card.getOne(9),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Double);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(6),Card.getOne(9),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(6),Card.getOne(9),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(6),Card.getOne(9),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(6),Card.getOne(9),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(6),Card.Ten,Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(6),Card.Ten,Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(6),Card.Ten,Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(6),Card.Ten,Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(6),Card.Ten,Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(6),Card.Ten,Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(7),Card.getOne(1),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(7),Card.getOne(1),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(7),Card.getOne(1),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(7),Card.getOne(1),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(7),Card.getOne(1),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(7),Card.getOne(1),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(7),Card.getOne(2),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(7),Card.getOne(2),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(7),Card.getOne(2),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(7),Card.getOne(2),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(7),Card.getOne(2),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(7),Card.getOne(2),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(7),Card.getOne(3),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(7),Card.getOne(3),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(7),Card.getOne(3),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(7),Card.getOne(3),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(7),Card.getOne(3),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(7),Card.getOne(3),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(7),Card.getOne(4),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(7),Card.getOne(4),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(7),Card.getOne(4),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(7),Card.getOne(4),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Split);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(7),Card.getOne(4),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Split);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(7),Card.getOne(4),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(7),Card.getOne(5),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(7),Card.getOne(5),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(7),Card.getOne(5),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Split);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(7),Card.getOne(5),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(7),Card.getOne(5),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Split);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(7),Card.getOne(5),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(7),Card.getOne(6),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(7),Card.getOne(6),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Split);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(7),Card.getOne(6),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(7),Card.getOne(6),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(7),Card.getOne(6),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Split);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(7),Card.getOne(6),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(7),Card.getOne(7),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(7),Card.getOne(7),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(7),Card.getOne(7),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(7),Card.getOne(7),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(7),Card.getOne(7),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(7),Card.getOne(7),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(7),Card.getOne(8),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(7),Card.getOne(8),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(7),Card.getOne(8),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(7),Card.getOne(8),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(7),Card.getOne(8),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(7),Card.getOne(8),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(7),Card.getOne(9),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(7),Card.getOne(9),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(7),Card.getOne(9),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(7),Card.getOne(9),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(7),Card.getOne(9),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(7),Card.getOne(9),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(7),Card.Ten,Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(7),Card.Ten,Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(7),Card.Ten,Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(7),Card.Ten,Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Giveup);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(7),Card.Ten,Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(7),Card.Ten,Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(8),Card.getOne(1),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(8),Card.getOne(1),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(8),Card.getOne(1),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(8),Card.getOne(1),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(8),Card.getOne(1),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(8),Card.getOne(1),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(8),Card.getOne(2),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(8),Card.getOne(2),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(8),Card.getOne(2),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Split);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(8),Card.getOne(2),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Split);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(8),Card.getOne(2),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(8),Card.getOne(2),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(8),Card.getOne(3),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(8),Card.getOne(3),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Split);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(8),Card.getOne(3),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Split);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(8),Card.getOne(3),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(8),Card.getOne(3),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(8),Card.getOne(3),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(8),Card.getOne(4),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(8),Card.getOne(4),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(8),Card.getOne(4),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Split);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(8),Card.getOne(4),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Split);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(8),Card.getOne(4),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(8),Card.getOne(4),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(8),Card.getOne(5),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Split);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(8),Card.getOne(5),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(8),Card.getOne(5),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Split);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(8),Card.getOne(5),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(8),Card.getOne(5),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(8),Card.getOne(5),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(8),Card.getOne(6),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(8),Card.getOne(6),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(8),Card.getOne(6),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Split);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(8),Card.getOne(6),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(8),Card.getOne(6),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Split);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(8),Card.getOne(6),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(8),Card.getOne(7),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(8),Card.getOne(7),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(8),Card.getOne(7),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(8),Card.getOne(7),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Split);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(8),Card.getOne(7),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Split);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(8),Card.getOne(7),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(8),Card.getOne(8),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(8),Card.getOne(8),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(8),Card.getOne(8),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Giveup);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(8),Card.getOne(8),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(8),Card.getOne(8),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(8),Card.getOne(8),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(8),Card.getOne(9),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(8),Card.getOne(9),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Giveup);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(8),Card.getOne(9),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(8),Card.getOne(9),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(8),Card.getOne(9),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(8),Card.getOne(9),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(8),Card.Ten,Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(8),Card.Ten,Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(8),Card.Ten,Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(8),Card.Ten,Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(8),Card.Ten,Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Giveup);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(8),Card.Ten,Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(9),Card.getOne(1),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(9),Card.getOne(1),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(9),Card.getOne(1),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(9),Card.getOne(1),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(9),Card.getOne(1),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(9),Card.getOne(1),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(9),Card.getOne(2),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(9),Card.getOne(2),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(9),Card.getOne(2),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(9),Card.getOne(2),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(9),Card.getOne(2),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(9),Card.getOne(2),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(9),Card.getOne(3),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(9),Card.getOne(3),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Split);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(9),Card.getOne(3),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(9),Card.getOne(3),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Split);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(9),Card.getOne(3),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(9),Card.getOne(3),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(9),Card.getOne(4),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Double);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(9),Card.getOne(4),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Double);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(9),Card.getOne(4),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(9),Card.getOne(4),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Split);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(9),Card.getOne(4),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(9),Card.getOne(4),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Split);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(9),Card.getOne(5),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(9),Card.getOne(5),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Double);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(9),Card.getOne(5),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Split);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(9),Card.getOne(5),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(9),Card.getOne(5),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Double);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(9),Card.getOne(5),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Split);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(9),Card.getOne(6),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(9),Card.getOne(6),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Double);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(9),Card.getOne(6),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(9),Card.getOne(6),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Split);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(9),Card.getOne(6),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Split);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(9),Card.getOne(6),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Double);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(9),Card.getOne(7),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(9),Card.getOne(7),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(9),Card.getOne(7),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(9),Card.getOne(7),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(9),Card.getOne(7),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(9),Card.getOne(7),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(9),Card.getOne(8),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Split);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(9),Card.getOne(8),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Split);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(9),Card.getOne(8),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(9),Card.getOne(8),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(9),Card.getOne(8),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(9),Card.getOne(8),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Giveup);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(9),Card.getOne(9),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Double);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(9),Card.getOne(9),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(9),Card.getOne(9),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(9),Card.getOne(9),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(9),Card.getOne(9),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(9),Card.getOne(9),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(9),Card.Ten,Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(9),Card.Ten,Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Giveup);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(9),Card.Ten,Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(9),Card.Ten,Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(9),Card.Ten,Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(9),Card.Ten,Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(10),Card.getOne(1),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(10),Card.getOne(1),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Double);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(10),Card.getOne(1),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(10),Card.getOne(1),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(10),Card.getOne(1),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(10),Card.getOne(1),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(10),Card.getOne(2),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Double);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(10),Card.getOne(2),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(10),Card.getOne(2),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(10),Card.getOne(2),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Double);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(10),Card.getOne(2),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(10),Card.getOne(2),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(10),Card.getOne(3),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(10),Card.getOne(3),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(10),Card.getOne(3),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Double);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(10),Card.getOne(3),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(10),Card.getOne(3),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(10),Card.getOne(3),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Double);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(10),Card.getOne(4),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(10),Card.getOne(4),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(10),Card.getOne(4),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Double);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(10),Card.getOne(4),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(10),Card.getOne(4),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(10),Card.getOne(4),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Double);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(10),Card.getOne(5),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Double);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(10),Card.getOne(5),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(10),Card.getOne(5),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(10),Card.getOne(5),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Split);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(10),Card.getOne(5),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(10),Card.getOne(5),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Double);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(10),Card.getOne(6),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(10),Card.getOne(6),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Double);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(10),Card.getOne(6),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(10),Card.getOne(6),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Double);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(10),Card.getOne(6),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(10),Card.getOne(6),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(10),Card.getOne(7),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(10),Card.getOne(7),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(10),Card.getOne(7),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(10),Card.getOne(7),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Double);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(10),Card.getOne(7),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(10),Card.getOne(7),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Double);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(10),Card.getOne(8),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(10),Card.getOne(8),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(10),Card.getOne(8),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(10),Card.getOne(8),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Double);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(10),Card.getOne(8),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(10),Card.getOne(8),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Double);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(10),Card.getOne(9),Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(10),Card.getOne(9),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Double);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(10),Card.getOne(9),Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(10),Card.getOne(9),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Double);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(10),Card.getOne(9),Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(10),Card.getOne(9),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(10),Card.Ten,Situation.Start_With_Pair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(10),Card.Ten,Situation.Splited_Pair_And_Can_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(10),Card.Ten,Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(10),Card.Ten,Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(10),Card.Ten,Situation.Start_With_A);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(10),Card.Ten,Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(11),Card.getOne(1),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(11),Card.getOne(1),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(11),Card.getOne(1),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(11),Card.getOne(2),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Double);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(11),Card.getOne(2),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(11),Card.getOne(2),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Double);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(11),Card.getOne(3),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(11),Card.getOne(3),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Double);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(11),Card.getOne(3),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Double);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(11),Card.getOne(4),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(11),Card.getOne(4),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Double);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(11),Card.getOne(4),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Double);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(11),Card.getOne(5),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Double);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(11),Card.getOne(5),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(11),Card.getOne(5),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Double);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(11),Card.getOne(6),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(11),Card.getOne(6),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Double);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(11),Card.getOne(6),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Double);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(11),Card.getOne(7),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Double);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(11),Card.getOne(7),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Double);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(11),Card.getOne(7),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(11),Card.getOne(8),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(11),Card.getOne(8),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Double);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(11),Card.getOne(8),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Double);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(11),Card.getOne(9),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Double);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(11),Card.getOne(9),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(11),Card.getOne(9),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Double);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(11),Card.Ten,Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(11),Card.Ten,Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Double);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(11),Card.Ten,Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Double);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(12),Card.getOne(1),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(12),Card.getOne(1),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(12),Card.getOne(1),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(12),Card.getOne(2),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(12),Card.getOne(2),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(12),Card.getOne(2),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(12),Card.getOne(3),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(12),Card.getOne(3),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(12),Card.getOne(3),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(12),Card.getOne(4),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(12),Card.getOne(4),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(12),Card.getOne(4),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(12),Card.getOne(5),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(12),Card.getOne(5),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(12),Card.getOne(5),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(12),Card.getOne(6),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(12),Card.getOne(6),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(12),Card.getOne(6),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(12),Card.getOne(7),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(12),Card.getOne(7),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(12),Card.getOne(7),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(12),Card.getOne(8),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(12),Card.getOne(8),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(12),Card.getOne(8),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(12),Card.getOne(9),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(12),Card.getOne(9),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(12),Card.getOne(9),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(12),Card.Ten,Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(12),Card.Ten,Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(12),Card.Ten,Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(13),Card.getOne(1),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(13),Card.getOne(1),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(13),Card.getOne(1),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(13),Card.getOne(2),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(13),Card.getOne(2),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(13),Card.getOne(2),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(13),Card.getOne(3),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(13),Card.getOne(3),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(13),Card.getOne(3),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(13),Card.getOne(4),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(13),Card.getOne(4),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(13),Card.getOne(4),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(13),Card.getOne(5),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(13),Card.getOne(5),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(13),Card.getOne(5),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(13),Card.getOne(6),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(13),Card.getOne(6),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(13),Card.getOne(6),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(13),Card.getOne(7),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(13),Card.getOne(7),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(13),Card.getOne(7),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(13),Card.getOne(8),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(13),Card.getOne(8),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(13),Card.getOne(8),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(13),Card.getOne(9),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(13),Card.getOne(9),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(13),Card.getOne(9),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(13),Card.Ten,Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(13),Card.Ten,Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(13),Card.Ten,Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(14),Card.getOne(1),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(14),Card.getOne(1),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(14),Card.getOne(1),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(14),Card.getOne(2),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(14),Card.getOne(2),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(14),Card.getOne(2),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(14),Card.getOne(3),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(14),Card.getOne(3),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(14),Card.getOne(3),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(14),Card.getOne(4),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(14),Card.getOne(4),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(14),Card.getOne(4),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(14),Card.getOne(5),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(14),Card.getOne(5),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(14),Card.getOne(5),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(14),Card.getOne(6),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(14),Card.getOne(6),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(14),Card.getOne(6),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(14),Card.getOne(7),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(14),Card.getOne(7),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(14),Card.getOne(7),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(14),Card.getOne(8),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(14),Card.getOne(8),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(14),Card.getOne(8),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Double);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(14),Card.getOne(9),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(14),Card.getOne(9),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(14),Card.getOne(9),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(14),Card.Ten,Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(14),Card.Ten,Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(14),Card.Ten,Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(15),Card.getOne(1),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(15),Card.getOne(1),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(15),Card.getOne(1),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(15),Card.getOne(2),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(15),Card.getOne(2),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(15),Card.getOne(2),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(15),Card.getOne(3),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(15),Card.getOne(3),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(15),Card.getOne(3),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(15),Card.getOne(4),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(15),Card.getOne(4),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(15),Card.getOne(4),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(15),Card.getOne(5),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(15),Card.getOne(5),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(15),Card.getOne(5),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(15),Card.getOne(6),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(15),Card.getOne(6),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(15),Card.getOne(6),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(15),Card.getOne(7),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(15),Card.getOne(7),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(15),Card.getOne(7),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(15),Card.getOne(8),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(15),Card.getOne(8),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(15),Card.getOne(8),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(15),Card.getOne(9),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(15),Card.getOne(9),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(15),Card.getOne(9),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(15),Card.Ten,Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(15),Card.Ten,Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(15),Card.Ten,Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Giveup);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(16),Card.getOne(1),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(16),Card.getOne(1),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(16),Card.getOne(1),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(16),Card.getOne(2),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(16),Card.getOne(2),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(16),Card.getOne(2),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(16),Card.getOne(3),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(16),Card.getOne(3),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(16),Card.getOne(3),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(16),Card.getOne(4),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(16),Card.getOne(4),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(16),Card.getOne(4),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(16),Card.getOne(5),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(16),Card.getOne(5),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(16),Card.getOne(5),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(16),Card.getOne(6),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(16),Card.getOne(6),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(16),Card.getOne(6),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(16),Card.getOne(7),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(16),Card.getOne(7),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(16),Card.getOne(7),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(16),Card.getOne(8),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(16),Card.getOne(8),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(16),Card.getOne(8),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(16),Card.getOne(9),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(16),Card.getOne(9),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(16),Card.getOne(9),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Giveup);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(16),Card.Ten,Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(16),Card.Ten,Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Giveup);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(16),Card.Ten,Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Hit);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(17),Card.getOne(1),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(17),Card.getOne(1),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(17),Card.getOne(1),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(17),Card.getOne(2),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(17),Card.getOne(2),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(17),Card.getOne(2),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(17),Card.getOne(3),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(17),Card.getOne(3),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(17),Card.getOne(3),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(17),Card.getOne(4),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(17),Card.getOne(4),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(17),Card.getOne(4),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(17),Card.getOne(5),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(17),Card.getOne(5),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(17),Card.getOne(5),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(17),Card.getOne(6),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(17),Card.getOne(6),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(17),Card.getOne(6),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(17),Card.getOne(7),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(17),Card.getOne(7),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(17),Card.getOne(7),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(17),Card.getOne(8),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(17),Card.getOne(8),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(17),Card.getOne(8),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(17),Card.getOne(9),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(17),Card.getOne(9),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(17),Card.getOne(9),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(17),Card.Ten,Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(17),Card.Ten,Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(17),Card.Ten,Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(18),Card.getOne(1),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(18),Card.getOne(1),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(18),Card.getOne(1),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(18),Card.getOne(2),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(18),Card.getOne(2),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(18),Card.getOne(2),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(18),Card.getOne(3),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(18),Card.getOne(3),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(18),Card.getOne(3),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(18),Card.getOne(4),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(18),Card.getOne(4),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(18),Card.getOne(4),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(18),Card.getOne(5),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(18),Card.getOne(5),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(18),Card.getOne(5),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(18),Card.getOne(6),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(18),Card.getOne(6),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(18),Card.getOne(6),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(18),Card.getOne(7),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(18),Card.getOne(7),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(18),Card.getOne(7),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(18),Card.getOne(8),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(18),Card.getOne(8),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(18),Card.getOne(8),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(18),Card.getOne(9),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(18),Card.getOne(9),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(18),Card.getOne(9),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(18),Card.Ten,Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(18),Card.Ten,Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(18),Card.Ten,Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(19),Card.getOne(1),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(19),Card.getOne(1),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(19),Card.getOne(1),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(19),Card.getOne(2),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(19),Card.getOne(2),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(19),Card.getOne(2),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(19),Card.getOne(3),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(19),Card.getOne(3),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(19),Card.getOne(3),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(19),Card.getOne(4),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(19),Card.getOne(4),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(19),Card.getOne(4),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(19),Card.getOne(5),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(19),Card.getOne(5),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(19),Card.getOne(5),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(19),Card.getOne(6),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(19),Card.getOne(6),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(19),Card.getOne(6),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(19),Card.getOne(7),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(19),Card.getOne(7),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(19),Card.getOne(7),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(19),Card.getOne(8),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(19),Card.getOne(8),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(19),Card.getOne(8),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(19),Card.getOne(9),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(19),Card.getOne(9),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(19),Card.getOne(9),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(19),Card.Ten,Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(19),Card.Ten,Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(19),Card.Ten,Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(20),Card.getOne(1),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(20),Card.getOne(1),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(20),Card.getOne(1),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(20),Card.getOne(2),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(20),Card.getOne(2),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(20),Card.getOne(2),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(20),Card.getOne(3),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(20),Card.getOne(3),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(20),Card.getOne(3),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(20),Card.getOne(4),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(20),Card.getOne(4),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(20),Card.getOne(4),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(20),Card.getOne(5),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(20),Card.getOne(5),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(20),Card.getOne(5),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(20),Card.getOne(6),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(20),Card.getOne(6),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(20),Card.getOne(6),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(20),Card.getOne(7),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(20),Card.getOne(7),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(20),Card.getOne(7),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(20),Card.getOne(8),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(20),Card.getOne(8),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(20),Card.getOne(8),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(20),Card.getOne(9),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(20),Card.getOne(9),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(20),Card.getOne(9),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(20),Card.Ten,Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(20),Card.Ten,Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(20),Card.Ten,Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(21),Card.getOne(1),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(21),Card.getOne(1),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(21),Card.getOne(1),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(21),Card.getOne(2),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(21),Card.getOne(2),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(21),Card.getOne(2),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(21),Card.getOne(3),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(21),Card.getOne(3),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(21),Card.getOne(3),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(21),Card.getOne(4),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(21),Card.getOne(4),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(21),Card.getOne(4),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(21),Card.getOne(5),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(21),Card.getOne(5),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(21),Card.getOne(5),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(21),Card.getOne(6),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(21),Card.getOne(6),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(21),Card.getOne(6),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(21),Card.getOne(7),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(21),Card.getOne(7),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(21),Card.getOne(7),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(21),Card.getOne(8),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(21),Card.getOne(8),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(21),Card.getOne(8),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(21),Card.getOne(9),Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(21),Card.getOne(9),Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(21),Card.getOne(9),Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(21),Card.Ten,Situation.Start_Hand_WithoutA_WithoutPair);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(21),Card.Ten,Situation.Three_More_Cards);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		{
		 MatrixKey goodluck = new MatrixKey(StartValue.getOne(21),Card.Ten,Situation.Splited_Pair_And_Can_NOT_Split);
		 changesMatrix.put(goodluck,PlayerAction.Stand);
		}
		this.changesMatrix = changesMatrix;
		this.one = new HashMap<>();
		one.putAll(changesMatrix);
		one.putAll(notChangesMatrix);
		}
	
	public static void main(String[] args) {
		List l = new ArrayList(50);
		System.out.println(l.size());
//		System.out.println(new Pareto2Mar26().getSimpleDesc());
//		StrategyMatrix8012 [ParetoFrontValue= 6.379910550289516 ,ParetotYPE= 0,	 roiFactor()= 3.055512167675187,	 probRateFactor()= 1.3172760895315017,	 timeRateFactor()= 2.0071222930828267,	 roi= 1.0185040558917289,	 totalTimes: 7.91914561E8,	 getTimeRates= w:47.78862602578159 $d:3.8930589887208806 $l:48.31831498549754,	 totalProbs: 1.9969179507025978,	 getProbRate= w:47.04557462612506 $d:7.669053049587108 $l:45.285372324287835,	 moneyReturn= 2.4489227745E11,	 totalSpead= 2.404431048E11

	}
}
