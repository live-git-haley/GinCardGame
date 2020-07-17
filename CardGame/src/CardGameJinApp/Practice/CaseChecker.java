package CardGameJinApp.Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CaseChecker {
	
	public CaseChecker()
	{
		
	}
	
	public static boolean checkWinner(List<Card> cards){
		boolean fourSuite1 = false;
		boolean fourSuite2 = false;
		boolean fourSuite3 = false;

		boolean fourNum1 = false;
		boolean fourNum2 = false;
		boolean fourNum3 = false;
		
		boolean fourBig1 = false;
		boolean fourBig2 = false;
		boolean fourBig3 = false;

		
		boolean fourCons1 = false;
		boolean fourCons2 = false;
		boolean fourCons3 = false;

		boolean threeA = false;
		boolean threeB = false;
		boolean threeC = false;
		boolean threeD = false;
		boolean win1 = false;
		boolean win2 = false;
		boolean win3 = false;
		boolean win4 = false;
		boolean win5 = false;
		boolean win6 = false;
		


	    List<Integer> listA = Arrays.asList(0,1,2);
	    List<Integer> listB = Arrays.asList(3,4,5);
	    List<Integer> listC = Arrays.asList(4,5,6);
	    List<Integer> listD = Arrays.asList(7,8,9);
	    
	    List<Integer> one = Arrays.asList(0,1,2,3);
	    List<Integer> two = Arrays.asList(3,4,5,6);
	    List<Integer> three = Arrays.asList(6,7,8,9);
	    



		fourSuite1 = (((cards.get(one.get(0)).getSuite()) == (cards.get(one.get(1)).getSuite()))
				&& ((cards.get(one.get(0)).getSuite()) == (cards.get(one.get(2)).getSuite())))
				&& (((cards.get(one.get(0)).getSuite()) == (cards.get(one.get(3)).getSuite())));

		fourSuite3 = (((cards.get(three.get(0)).getSuite()) == (cards.get(three.get(1)).getSuite()))
				&& ((cards.get(three.get(0)).getSuite()) == (cards.get(three.get(2)).getSuite())))
				&& (((cards.get(three.get(0)).getSuite()) == (cards.get(three.get(3)).getSuite())));

		fourSuite2 = (((cards.get(two.get(0)).getSuite()) == (cards.get(two.get(1)).getSuite()))
				&& ((cards.get(two.get(0)).getSuite()) == (cards.get(two.get(2)).getSuite())))
				&& (((cards.get(two.get(0)).getSuite()) == (cards.get(two.get(3)).getSuite())));

		threeA = ((cards.get(listA.get(0)).getNum() == cards.get(listA.get(1)).getNum()) && (cards.get(listA.get(0)).getNum() == cards.get(listA.get(2)).getNum()));
		threeB = ((cards.get(listB.get(0)).getNum() == cards.get(listB.get(1)).getNum()) && (cards.get(listB.get(0)).getNum() == cards.get(listB.get(2)).getNum()));
		threeC = ((cards.get(listC.get(0)).getNum() == cards.get(listC.get(1)).getNum()) && (cards.get(listC.get(0)).getNum() == cards.get(listC.get(2)).getNum()));
		threeD = ((cards.get(listD.get(0)).getNum() == cards.get(listD.get(1)).getNum()) && (cards.get(listD.get(0)).getNum() == cards.get(listD.get(2)).getNum()));

		
		fourCons1 = ((((cards.get(one.get(1)).getNum() == cards.get(one.get(0)).getNum() + 1)
				&& (cards.get(one.get(2)).getNum() == cards.get(one.get(1)).getNum() + 1)) &&
				((cards.get(one.get(3)).getNum() == cards.get(one.get(2)).getNum() + 1))));
				
		
		fourCons3 = ((((cards.get(three.get(1)).getNum() == cards.get(three.get(0)).getNum() + 1)
				&& (cards.get(three.get(2)).getNum() == cards.get(three.get(1)).getNum() + 1)) &&
				((cards.get(three.get(3)).getNum() == cards.get(three.get(2)).getNum() + 1))));
		
		fourCons2 = ((((cards.get(two.get(1)).getNum() == cards.get(two.get(0)).getNum() + 1)
				&& (cards.get(two.get(2)).getNum() == cards.get(two.get(1)).getNum() + 1)) &&
				((cards.get(two.get(3)).getNum() == cards.get(two.get(2)).getNum() + 1))));
		
		
		fourNum1 = ((((cards.get(one.get(0)).getNum() == cards.get(one.get(1)).getNum())
				&& (cards.get(one.get(0)).getNum() == cards.get(one.get(2)).getNum())) &&
				((cards.get(one.get(0)).getNum() == cards.get(one.get(3)).getNum()))));
		
		fourNum2 = ((((cards.get(two.get(0)).getNum() == cards.get(two.get(1)).getNum())
				&& (cards.get(two.get(0)).getNum() == cards.get(two.get(2)).getNum())) &&
				((cards.get(two.get(0)).getNum() == cards.get(two.get(3)).getNum()))));
		
		fourNum3 = ((((cards.get(three.get(0)).getNum() == cards.get(three.get(1)).getNum())
				&& (cards.get(three.get(0)).getNum() == cards.get(three.get(2)).getNum())) &&
				((cards.get(three.get(0)).getNum() == cards.get(three.get(3)).getNum()))));
		
		
		fourBig1 = fourSuite1 && fourCons1;
		fourBig2 = fourSuite2 && fourCons2;
		fourBig3 = fourSuite3 && fourCons3;
		

		win1 = ((fourNum1 && threeC) && threeD);
		win2 = ((fourBig1 && threeC) && threeD);
		
		win3 = ((fourNum2 && threeA) && threeD);
		win4 = ((fourBig2 && threeA) && threeD);
		
		win5 = ((fourNum3 && threeA) && threeB);
		win6 = ((fourBig3 && threeA) && threeB);
		
		if(win1 | win2 | win3 | win4 | win5 | win6) {
			return true;
		}
		return(false);
		
	}
	public static void main(String[] args) {
		System.out.println("Main");

		List<Card> case1 = new ArrayList<>();
		Card c1 = new Card(1, 1);
		Card c2 = new Card(2, 1);
		Card c3 = new Card(3, 1);
		Card c4 = new Card(4, 1);
		Card c5 = new Card(8, 4);
		Card c6 = new Card(8, 2);
		Card c7 = new Card(8, 1);
		Card c8 = new Card(9, 3);
		Card c9 = new Card(9, 2);
		Card c10 = new Card(9, 1);

		case1.add(c1);
		case1.add(c2);
		case1.add(c3);
		case1.add(c4);
		case1.add(c5);
		case1.add(c6);
		case1.add(c7);
		case1.add(c8);
		case1.add(c9);
		case1.add(c10);

		System.out.println(checkWinner(case1));

	}

}
