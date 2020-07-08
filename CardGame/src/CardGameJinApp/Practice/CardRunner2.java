package CardGameJinApp.Practice;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;



public class CardRunner2 {

	public static void main(String[] args) {
		boolean winner = false;
		Scanner input = new Scanner(System.in);

		Card h = new Card();
		Stack<Card> deck = h.createDeck();
		Stack<Card> trash = new Stack<>();
		boolean p1;
		boolean p2;
		//System.out.println(cards.toString());
		//System.out.println(cards);
		//Queue<Player> usedCards = new LinkedList<>();
//		
		List <Card> player1 = new ArrayList<Card>();
		List <Card> player2 = new ArrayList<Card>();

//		
//		// Shuffling my cards
		Collections.shuffle(deck);
		//PLAYER 1 CARDS
		for (int i = 0; i <=9; i++) {
			player1.add(deck.get(i));
			deck.remove(i);
			
		}
		//PLAYER 2 CARDS
		for (int i = 0; i <=9; i++) {
			player2.add(deck.get(i));
			deck.remove(i);
					
		}
		
		//System.out.println("This is the size of your new deck: " + deck.size());
				
		System.out.println("                                  JIN");
		Collections.sort(player1, new CardComparator()); 
		Collections.sort(player2, new CardComparator()); 
//		
		System.out.println();
		System.out.println("Player 1's Cards");
		System.out.println(player1.toString());
		
		System.out.println("This is the stream >>>>> ");
		player1.stream().forEach(card ->
			
			System.out.println(card.getFilename(card))
			);
		
	
		
		p1= true;
	
		Card first = deck.pop();
		System.out.println();
		System.out.println("This is the first card: " +  first.toString());
		System.out.println("Keep or Throw? (1 or 0)");
		int pick = input.nextInt();
		if(pick ==1) {
			System.out.println("Which card would you like to replace");
			int replace = input.nextInt()-1;
			Card garbage = player1.get(replace);
			trash.add(garbage);
			player1 = replace(player1,first,replace);
			Collections.sort(player1, new CardComparator()); 
			System.out.println(">>>> New Hand");
			System.out.println(player1.toString());
			
		}
		else {
	
			trash.add(first);
		}
		p1 = false;
		p2 = true;
		
		while(winner != true) {
			//System.out.println("This is the size of the deck >>>>> " + deck.size());
			if(p2) {
				System.out.println("                                  Player 2's Turn!");
				System.out.println("Your Cards: ");
				System.out.println(player2.toString());
				Card top = trash.pop();
				System.out.println("\nCard facing up >>> " +  top.toString());
				System.out.println();
				System.out.println("Keep or Draw? (1 or 0)");
				int choice = input.nextInt();
				if(choice ==1) {
					System.out.println("Which card would you like to replace");
					int replace = input.nextInt()-1;
					Card garbage = player2.get(replace);
					trash.add(garbage);
					player2 = replace(player2,top,replace);
					Collections.sort(player2, new CardComparator()); 
					System.out.println(">>>> New Hand");
					System.out.println(player2.toString());
					System.out.println("Did you win??? (1 for YES 0 for NO");
					int won = input.nextInt();
					if(won == 1) {
						System.out.println();
						System.out.println();
						System.out.println("PLAYER 2 WON!!!");
						System.out.println();
						System.out.println();
						break;
					}
		
				}
				else {
					Card draw2 = deck.pop();
					System.out.println("You drew:   " +  draw2.toString());
					System.out.println();
					System.out.println("Keep or throw? (1 or 0)");
					int choice2 = input.nextInt();
					if(choice2 ==1) {
						System.out.println("Which card would you like to replace");
						int replace2 = input.nextInt()-1;
						Card garbage2 = player2.get(replace2);
						trash.add(garbage2);
						player2 = replace(player2,draw2,replace2);
						Collections.sort(player2, new CardComparator()); 
						System.out.println(">>>> New Hand");
						System.out.println(player2.toString());
						System.out.println("Did you win??? (1 for YES 0 for NO");
						int won = input.nextInt();
						if(won == 1) {
							System.out.println();
							System.out.println();
							System.out.println("PLAYER 2 WON!!!");
							System.out.println();
							System.out.println();
							break;
						}
						
					}
					else {
						trash.add(draw2);
						
					}
					
				}
				p2 = false;
				p1 = true;
				
			}
			
			if(p1) {
				System.out.println("                                  Player 1's Turn!");
				System.out.println("Your Cards: ");
				System.out.println(player1.toString());
				Card top3 = trash.pop();
				System.out.println("\nCard facing up >>> " +  top3.toString());
				System.out.println();
				System.out.println("Keep or Draw? (1 or 0)");
				int choice3 = input.nextInt();
				if(choice3 ==1) {
					System.out.println("Which card would you like to replace");
					int replace3 = input.nextInt()-1;
					Card garbage3 = player1.get(replace3);
					trash.add(garbage3);
					player1 = replace(player1,top3,replace3);
					Collections.sort(player1, new CardComparator()); 
					System.out.println(">>>> New Hand");
					System.out.println(player1.toString());
					System.out.println("Did you win??? (1 for YES 0 for NO");
					int won = input.nextInt();
					if(won == 1) {
						System.out.println();
						System.out.println();
						System.out.println("PLAYER 1 WON!!!");
						System.out.println();
						System.out.println();
						winner = true;
						break;
					}
		
				}
				else {
					Card draw4 = deck.pop();
					System.out.println("You drew:   " +  draw4.toString());
					System.out.println();
					System.out.println("Keep or throw? (1 or 0)");
					System.out.println();
					int choice4 = input.nextInt();
					if(choice4 ==1) {
						System.out.println("Which card would you like to replace");
						int replace4 = input.nextInt()-1;
						Card garbage4 = player1.get(replace4);
						trash.add(garbage4);
						player1 = replace(player1,draw4,replace4);
						Collections.sort(player1, new CardComparator()); 
						System.out.println(">>>> New Hand");
						System.out.println(player1.toString());
						System.out.println("Did you win??? (1 for YES 0 for NO");
						int won = input.nextInt();
						if(won == 1) {
							System.out.println();
							System.out.println();
							System.out.println("PLAYER 1 WON!!!");
							System.out.println();
							System.out.println();
							winner = true;
						}
						
						
					}
					else {
						trash.add(draw4);
						
					}
					
				}
				p2 = true;
				p1 = false;
				
			}
			
			

			
		}
		
		input.close();
	}
	
	
	public static List<Card> replace(List<Card> list, Card h, int remove){
		list.add(h);
		list.remove(remove);
		return(list);
	}
//	

}
