package CardGameJinApp.Practice;

import java.util.Comparator;

public class CardComparator implements Comparator<Card> {
	public CardComparator(){
		
	}

	@Override
	public int compare(Card o1, Card o2) {
		int numCompare = o1.getNum().compareTo(o2.getNum());
		int suiteCompare = o1.getSuite().compareTo(o2.getSuite());
		if(numCompare == 0) {
			return ((suiteCompare == 0) ? numCompare : suiteCompare);
		} else {
			return numCompare;
		}
		
	}

}
