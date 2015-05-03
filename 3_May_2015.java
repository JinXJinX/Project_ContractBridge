import java.util.ArrayList;
import java.util.Scanner;

public class Project_ContractBridge {
	
	private static int suit,rank,team1Score=0,team2Score=0,round=1;
	private static String suitType,rankType;
	//4 arrays for 4 players
	private static ArrayList<Integer> player1=new ArrayList<>();
	private static ArrayList<Integer> player2=new ArrayList<>();
	private static ArrayList<Integer> player3=new ArrayList<>();
	private static ArrayList<Integer> player4=new ArrayList<>();

	private static int[][] cards= new int[4][13];
	
	//actions
	public static int bankerChoise,the2ndChoise,the3rdChoise,the4thChoise;

	public static void main(String[] args) {
		//set the value into cards[][]
		for(suit=0; suit<4;suit++){
			for(rank=0; rank<13;rank++){
				cards[suit][rank]=rank+1;
			}
		}
		//Licensing. randomly give 13 cards to every player
		Licensing();
		
		while(player1.size()>0){
			showCurentCards();
			round();
			round++;
		}
		System.out.println("-----Game End-----");
		System.out.print("The winner is "+theWinner());
	}
	
	//Licensing. randomly give 13 cards to every player
	//I have no idea how to make this short
	public static void Licensing(){
		for(suit=0;suit<4;suit++){
			for(rank=0;rank<13;rank++){
				double random = Math.random();
				if(random<=0.25){
					if(player1.size()<13){
						player1.add(cards[suit][rank]+(suit+1)*100);
					}else if(player2.size()<13){// put the card to a non-full player
						player2.add(cards[suit][rank]+(suit+1)*100);
					}else if(player3.size()<13){
						player3.add(cards[suit][rank]+(suit+1)*100);
					}else if(player4.size()<13){
						player4.add(cards[suit][rank]+(suit+1)*100);
					}
				}else if(random<=0.5){
					if(player2.size()<13){
						player2.add(cards[suit][rank]+(suit+1)*100);
					}else if(player3.size()<13){// put the card to a non-full player
						player3.add(cards[suit][rank]+(suit+1)*100);
					}else if(player4.size()<13){
						player4.add(cards[suit][rank]+(suit+1)*100);
					}else{
						player1.add(cards[suit][rank]+(suit+1)*100);
					}
				}else if(random<=0.75){
					if(player3.size()<13){
						player3.add(cards[suit][rank]+(suit+1)*100);
					}else if(player4.size()<13){// put the card to a non-full player
						player4.add(cards[suit][rank]+(suit+1)*100);
					}else if(player1.size()<13){
						player1.add(cards[suit][rank]+(suit+1)*100);
					}else{
						player2.add(cards[suit][rank]+(suit+1)*100);
					}
				}else{
					if(player4.size()<13){
						player4.add(cards[suit][rank]+(suit+1)*100);
					}else if(player1.size()<13){// put the card to a non-full player
						player1.add(cards[suit][rank]+(suit+1)*100);
					}else if(player2.size()<13){
						player2.add(cards[suit][rank]+(suit+1)*100);
					}else{
						player3.add(cards[suit][rank]+(suit+1)*100);
					}
				}		
			}
		}
	}
	
	//show cards in hand
	public static String showCards(ArrayList<Integer> a){
		String playersCard="";
		for(int x=0;x<player1.size();x++){
			playersCard = playersCard+getCard(a.get(x))+" ";
		}
		return playersCard;
	}
	
	public static String getCard(int num){
		suit=getSuit(num);
		// give the suitType a String value
		//1 is club;  2 is diamond; 3 is heart; 4 is spade
		if(suit==1){suitType="club";
		}else if(suit==2){suitType="diamond";
		}else if(suit==3){suitType="heart";
		}else{suitType="spade";}
		
		rank=getRank(num);
		// give the rankType a String value
		// 1 is Ace, 11 is J, 12 is Q, 13 is K
		if(rank==1){rankType="A";
		}else if(rank==11){rankType="J";
		}else if(rank==12){rankType="Q";
		}else if(rank==13){rankType="K";
		}else{rankType=rank+"";}

		String theCard=suitType+"_"+rankType;
		return theCard;
	}
	
	public static int getSuit(int num){
		return suit=num/100;	
	}
	
	public static int getRank(int num){
		rank=num%100;
		return rank;
	}
	
	//playing method of this Contract Bridge Game
	public static void round(){
		Scanner input=new Scanner(System.in);
		
		//each round change the banker
		if(round%4==1){
			System.out.println("------------ Which card would you like to play?");
			bankerChoise=input.nextInt()-1;
			the2ndChoise=AIchoise(player2,bankerChoise,round);
			the3rdChoise=AIchoise(player3,bankerChoise,round);
			the4thChoise=AIchoise(player4,bankerChoise,round);
			System.out.println("Player 1 Card: "+getCard(player1.get(bankerChoise)));
			System.out.println("Player 2 Card: "+getCard(player2.get(the2ndChoise)));
			System.out.println("Player 3 Card: "+getCard(player3.get(the3rdChoise)));
			System.out.println("Player 4 Card: "+getCard(player4.get(the4thChoise)));
			scoring(player1.get(bankerChoise),player2.get(the2ndChoise),
					player3.get(the3rdChoise),player4.get(the4thChoise),round);
			removeCards(bankerChoise,the2ndChoise,the3rdChoise,the4thChoise);
		}else if(round%4==2){
			bankerChoise=AIchoise();
			the2ndChoise=AIchoise(player3,bankerChoise,round);
			the3rdChoise=AIchoise(player4,bankerChoise,round);
			System.out.println("Player 2 Card: "+getCard(player2.get(bankerChoise)));
			System.out.println("Player 3 Card: "+getCard(player3.get(the2ndChoise)));
			System.out.println("Player 4 Card: "+getCard(player4.get(the3rdChoise)));
			System.out.println("------------ Which card would you like to play?");
			the4thChoise=input.nextInt()-1;
			System.out.println("Player 1 Card: "+getCard(player1.get(the4thChoise)));
			scoring(player1.get(the4thChoise),player2.get(bankerChoise),
					player3.get(the2ndChoise),player4.get(the3rdChoise),round);
			removeCards(the4thChoise,bankerChoise,the2ndChoise,the3rdChoise);
		}else if(round%4==3){
			bankerChoise=AIchoise();
			the2ndChoise=AIchoise(player4,bankerChoise,round);
			System.out.println("Player 3 Card: "+getCard(player3.get(bankerChoise)));
			System.out.println("Player 4 Card: "+getCard(player4.get(the2ndChoise)));
			System.out.println("------------ Which card would you like to play?");
			the3rdChoise=input.nextInt()-1;
			System.out.println("Player 1 Card: "+getCard(player1.get(the3rdChoise)));
			the4thChoise=AIchoise(player2,bankerChoise,round);
			System.out.println("Player 2 Card: "+getCard(player2.get(the4thChoise)));
			scoring(player1.get(the3rdChoise),player2.get(the4thChoise),
					player3.get(bankerChoise),player4.get(the2ndChoise),round);
			removeCards(the3rdChoise,the4thChoise,bankerChoise,the2ndChoise);
		}else if(round%4==0){
			bankerChoise=AIchoise();
			System.out.println("Player 4 Card: "+getCard(player4.get(bankerChoise)));
			System.out.println("------------ Which card would you like to play?");
			the2ndChoise=input.nextInt()-1;
			System.out.println("Player 1 Card: "+getCard(player1.get(the2ndChoise)));
			the3rdChoise=AIchoise(player2,bankerChoise,round);
			System.out.println("Player 2 Card: "+getCard(player2.get(the3rdChoise)));
			the4thChoise=AIchoise(player4,bankerChoise,round);
			System.out.println("Player 3 Card: "+getCard(player3.get(the4thChoise)));
			scoring(player1.get(the2ndChoise),player2.get(the3rdChoise),
					player3.get(the4thChoise),player4.get(bankerChoise),round);
			removeCards(the2ndChoise,the3rdChoise,the4thChoise,bankerChoise);
		}
	}
	
	//setup AI's action as sencond-hand
	public static int AIchoise(ArrayList<Integer> AIcardsInHand,int bankerAction,int round){
		int choise=-1,num=0;
		int bankerSuit;
		if(round%4==1){
			bankerSuit=getSuit(player1.get(bankerAction));
		}else if(round%4==2){
			bankerSuit=getSuit(player2.get(bankerAction));
		}else if(round%4==3){
			bankerSuit=getSuit(player3.get(bankerAction));
		}else{
			bankerSuit=getSuit(player4.get(bankerAction));
		}
		for(int card:AIcardsInHand){
			if(getSuit(card)==bankerSuit){
				if(choise==-1){
					choise=num;
				}else{
					if(getRank(card)>getRank(AIcardsInHand.get(choise))){
						choise=num;
					}
				}
			}
			num++;
		}
		if(choise==-1)
			return 0;
		else
			return choise;
	}
	
	//AI action as first hand
	public static int AIchoise(){
		return 0;
	}
	
	//remove used cards
	public static void removeCards(int p1Card,int p2Card,int p3Card,int p4Card){
		player1.remove(p1Card);
		player2.remove(p2Card);
		player3.remove(p3Card);
		player4.remove(p4Card);
	}
	
	//display current cards every player has.
	public static void showCurentCards(){
		System.out.println("                               CONTRACT BRIDGE"
				+"       Round: " + round);
		for(int x=1;x<=player1.size();x++){
			System.out.print(x+" ");}
		System.out.println();
		System.out.println("PLAYER 1 Hand");System.out.println();
		
		//show player1's card in hand
		System.out.println(showCards(player1));
		System.out.println();
		//show player2's card in hand
		System.out.println("PLAYER 2 Hand");System.out.println();
		System.out.println(showCards(player2));
		System.out.println();
		//show player3's card in hand
		System.out.println("PLAYER 3 Hand");System.out.println();
		System.out.println(showCards(player3));
		System.out.println();
		//show player4's card in hand
		System.out.println("PLAYER 4 Hand");System.out.println();
		System.out.println(showCards(player4));
		System.out.println();
	}
	
	//computing points
	public static void scoring(int p1,int p2,int p3,int p4,int round){
		int bankerSuit = 0,highestTeam1Rank=0,highestTeam2Rank=0,p1Rank,p2Rank,p3Rank,p4Rank;
		
		if(getRank(p1)==1){p1Rank=14;}else{p1Rank=getRank(p1);}
		if(getRank(p2)==1){p2Rank=14;}else{p2Rank=getRank(p2);}
		if(getRank(p3)==1){p3Rank=14;}else{p3Rank=getRank(p3);}
		if(getRank(p4)==1){p4Rank=14;}else{p4Rank=getRank(p4);}
		
		//player 1 as banker
		if(round%4==1){
			bankerSuit=getSuit(p1);
			//find the highest rank in Team 1
			if(bankerSuit==getSuit(p3)){
				highestTeam1Rank=Math.max(p1Rank,p3Rank);
			}else{
				highestTeam1Rank=getRank(p1);
			}
			//find the highest rank in Team 2
			if(bankerSuit==getSuit(p2)&&bankerSuit==getSuit(p4)){
				highestTeam2Rank=Math.max(p2Rank,p4Rank);
			}else if(bankerSuit==getSuit(p2)){
				highestTeam2Rank=getRank(p2);
			}else if(bankerSuit==getSuit(p4)){
				highestTeam2Rank=getRank(p4);
			}
			//compare the rank and adding point to winer team
			if(highestTeam1Rank>highestTeam2Rank){
				team1Score++;
			}else{team2Score++;}
			
		}else if(round%4==2){  //player 2 as banker
			bankerSuit=getSuit(p2);
			//find the highest rank in Team 2
			if(bankerSuit==getSuit(p4)){
				highestTeam2Rank=Math.max(p2Rank,p4Rank);
			}else{
				highestTeam2Rank=p4Rank;
			}
			//find the highest rank in Team 1
			if(bankerSuit==getSuit(p1)&&bankerSuit==getSuit(p3)){
				highestTeam1Rank=Math.max(p1Rank,p3Rank);
			}else if(bankerSuit==getSuit(p1)){
				highestTeam1Rank=p1Rank;
			}else if(bankerSuit==getSuit(p3)){
				highestTeam1Rank=p3Rank;
			}
			//compare the rank and adding point to winer team
			if(highestTeam1Rank>highestTeam2Rank){
				team1Score++;
			}else{team2Score++;}
		}else if(round%4==3){  //player 3 as banker
			bankerSuit=getSuit(p3);
			//find the highest rank in Team 1
			if(bankerSuit==getSuit(p1)){
				highestTeam1Rank=Math.max(p1Rank,p3Rank);
			}else{
				highestTeam1Rank=p3Rank;
			}
			//find the highest rank in Team 2
			if(bankerSuit==getSuit(p2)&&bankerSuit==getSuit(p4)){
				highestTeam2Rank=Math.max(p2Rank,p4Rank);
			}else if(bankerSuit==getSuit(p2)){
				highestTeam2Rank=p2Rank;
			}else if(bankerSuit==getSuit(p4)){
				highestTeam2Rank=p4Rank;
			}
			//compare the rank and adding point to winer team
			if(highestTeam1Rank>highestTeam2Rank){
				team1Score++;
			}else{team2Score++;}
			
		}else if(round%4==0){  ////player 4 as banker
			bankerSuit=getSuit(p4);
			//find the highest rank in Team 2
			if(bankerSuit==getSuit(p2)){
				highestTeam2Rank=Math.max(p2Rank,p4Rank);
			}else{
				highestTeam2Rank=p4Rank;
			}
			//find the highest rank in Team 1
			if(bankerSuit==getSuit(p1)&&bankerSuit==getSuit(p3)){
				highestTeam1Rank=Math.max(p1Rank,p3Rank);
			}else if(bankerSuit==getSuit(p1)){
				highestTeam1Rank=getRank(p1);
			}else if(bankerSuit==getSuit(p3)){
				highestTeam1Rank=getRank(p3);
			}
			//compare the rank and adding point to winer team
			if(highestTeam1Rank>highestTeam2Rank){
				team1Score++;
			}else{team2Score++;}
		}
		System.out.print("This is the highest card on the table: ");
		int theHighestCard=Math.max(highestTeam1Rank,highestTeam2Rank);
		if(theHighestCard==p1Rank){theHighestCard=p1;
		}else if(theHighestCard==p2Rank){theHighestCard=p2;
		}else if(theHighestCard==p3Rank){theHighestCard=p3;
		}else if(theHighestCard==p4Rank){theHighestCard=p4;}
		
		System.out.println(getCard(theHighestCard));
		System.out.println();
		System.out.println("Team 1  Player 1 and Player 3 Points: "+ team1Score);
		System.out.println();
		System.out.println("Team 2  Player 2 and Player 4 Points: "+ team2Score);
	}
	
	public static String theWinner(){
		if(team1Score>team2Score)
			return "Team 1!\nCongratulations!\nPlayer 1, Player 3";
		else
			return "Team 2!\nCongratulations!\nPlayer 2, Player 4";
	}
}
