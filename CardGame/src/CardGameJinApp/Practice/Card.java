package CardGameJinApp.Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Card {
	public int suite;
	public int num;
	List <String> player1 = new ArrayList<String>();
	
	List<String> listNums = Arrays.asList("", "A","2", "3", "4", "5", "6", "7",
				"8", "9", "10", "J", "Q", "K");
	List<String> listSuites = Arrays.asList("", "Spades", "Clovers", "Hearts", "Diamonds");

	
	public Card() {
		
	}
	
	public Card (int n,int s){
		this.num = n;
		this.suite = s;
		
	}
	
	public Stack<Card> createDeck(){
		Stack<Card> cards = new Stack<>();
		
		for(int cardNum = 1; cardNum <=13; cardNum++) {
			for(int suiteNum = 1; suiteNum <=4; suiteNum++) {
				Card newCard = new Card(cardNum,suiteNum);
				cards.add(newCard);
			}
		}
		return cards;
	}

	public Integer getSuite() {
		return suite;
	}

	public Integer getNum() {
		return num;
	}
	
	public String getFilename(Card c) {
		int first = c.getNum();
		int second = c.getSuite();
		String filename = "img/" + first + "-" + second + ".png";
		
		return(filename);
	}
	
	@Override
	public String toString() {
		
		String print = "Num >> " + num  + " Suite >>>" + suite;
		return print;
	}
	
	public static List<Card> replace(List<Card> list, Card h, Card remove){
		list.add(h);
		list.remove(remove);
		return(list);
	}
	
	public static List<Card> replace(List<Card> list, Card h, int remove){
		list.add(h);
		list.remove(remove);
		return(list);
	}
	
	
//	@Override
//	public String toString() {
//		
//		String print = "\n" + listNums.get(num) + " " + listSuites.get(suite);
//		return print;
//	}
//	
	
	
}
