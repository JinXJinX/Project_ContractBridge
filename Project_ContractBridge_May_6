import java.util.ArrayList;
import java.util.Scanner;

public class Project_ContractBridge extends Project_ContractBridge_GamingPane {
	private static int suit,rank,team1Score=0,team2Score=0,round=1;
	private static String suitType,rankType;
	private static String banker="P1";
	//4 arrays for 4 players
	static ArrayList<Integer> player1=new ArrayList<>();
	private static ArrayList<Integer> player2=new ArrayList<>();
	private static ArrayList<Integer> player3=new ArrayList<>();
	private static ArrayList<Integer> player4=new ArrayList<>();

	private static int[][] cards= new int[4][13];
	
	private static int P1Card,P2Card,P3Card,P4Card;
	
	//actions
	public static int bankerChoise,the2ndChoise,the3rdChoise,the4thChoise;

	public static void main(String[] args) {
		//set the value into cards[][]
		
		//Licensing. randomly give 13 cards to every player
		Licensing();
		
		while(player1.size()>0){
			showCurentCards();
			round();
		}
		System.out.println("-----Game End-----");
		System.out.print("The winner is "+theWinner());
	}
	
	static //Licensing. randomly give 13 cards to every player
	//I have no idea how to make this short
	void Licensing(){
		for(suit=0; suit<4;suit++){
			for(rank=0; rank<13;rank++){
				cards[suit][rank]=rank+1;
			}
		}
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
	
	//get card from int to String
	static String getCard(int num){
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

		String theCard="_"+suitType+"_"+rankType;
		return theCard;
	}
	
	static int getSuit(int num){
		return suit=num/100;	
	}
	
	public static int getRank(int num){
		rank=num%100;
		return rank;
	}
	//-------------------------------------------------------------
	//playing method of this Contract Bridge Game
	public static void round(){		
		int p2,p3,p4;
		//showCurentCards();
		System.out.println("Round :" +round);
		//Player 1 is banker, p1 play first. then p2 p3 p4
		if(banker=="P1"){
			//setP1Action();
			
			p2=AIchoise(player2,P1Card);setP2Card(p2);
			p3=AIchoise(player3,P1Card);setP3Card(p3);
			p4=AIchoise(player4,P1Card);setP4Card(p4);
			
			P2Card=player2.get(p2);
			P3Card=player3.get(p3);
			P4Card=player4.get(p4);
			
			System.out.println("Player 1 Card: "+getCard(P1Card));
			System.out.println("Player 2 Card: "+getCard(P2Card));
			System.out.println("Player 3 Card: "+getCard(P3Card));
			System.out.println("Player 4 Card: "+getCard(P4Card));
			
			scoring(P1Card,P2Card,P3Card,P4Card);
			removeCards(P1Card,P2Card,P3Card,P4Card);
			
		}else if(banker=="P2"){
			//Player 2 is banker, p2 play first. then p3 p4 p1
			/*p2=0;
			p3=AIchoise(player3,P2Card);
			p4=AIchoise(player4,P2Card);
			P2Card=player2.get(p2);
			P3Card=player3.get(p3);
			P4Card=player4.get(p4);
			System.out.println("Player 2 Card: "+getCard(P2Card));
			System.out.println("Player 3 Card: "+getCard(P3Card));
			System.out.println("Player 4 Card: "+getCard(P4Card));
			*/
			//setP1Action();
			
			System.out.println("Player 1 Card: "+getCard(P1Card));
			
			scoring(P1Card,P2Card,P3Card,P4Card);
			removeCards(P1Card,-1,-1,-1);
			
		}else if(banker=="P3"){
			//Player 3 is banker, p3 play first. then p4 p1 p2
			/*p3=0;
			p4=AIchoise(player4,P3Card);
			P3Card=player3.get(p3);
			P4Card=player4.get(p4);
			System.out.println("Player 3 Card: "+getCard(P3Card));
			System.out.println("Player 4 Card: "+getCard(P4Card));
			*/
			//setP1Action();
			
			System.out.println("Player 1 Card: "+getCard(P1Card));
			
			p2=AIchoise(player2,P3Card);
			P2Card=player2.get(p2);
			System.out.println("Player 2 Card: "+getCard(P2Card));
			
			scoring(P1Card,P2Card,P3Card,P4Card);
			removeCards(P1Card,P2Card,-1,-1);
			
		}else if(banker=="P4"){
			//Player 4 is banker, p4 play first. then p1 p2 p3
			/*p4=0;setP4Card(p4);
			P4Card=player4.get(p4);
			System.out.println("Player 4 Card: "+getCard(P4Card));
			*/
			
			p2=AIchoise(player2,P4Card);setP2Card(p2);
			p3=AIchoise(player3,P4Card);setP3Card(p3);
			
			
			P2Card=player2.get(p2);
			P3Card=player3.get(p3);
			
			//setP1Action();
			
			System.out.println("Player 1 Card: "+getCard(P1Card));
			System.out.println("Player 2 Card: "+getCard(P2Card));
			System.out.println("Player 3 Card: "+getCard(P3Card));
			
			scoring(P1Card,P2Card,P3Card,P4Card);
			removeCards(P1Card,P2Card,P3Card,-1);
			
		}
		
		System.out.println(player1);
		System.out.println(player2);
		System.out.println(player3);
		System.out.println(player4);
		//removeCards(P1Card,P2Card,P3Card,P4Card);
		round++;
		}
	
	//remove used cards
	public static void removeCards(int p1Card,int p2Card,int p3Card,int p4Card){
		if(p1Card!=-1){player1.remove(player1.indexOf(p1Card));}
		if(p2Card!=-1){player2.remove(player2.indexOf(p2Card));}
		if(p3Card!=-1){player3.remove(player3.indexOf(p3Card));}
		if(p4Card!=-1){player4.remove(player4.indexOf(p4Card));}
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
	public static void scoring(int p1,int p2,int p3,int p4){
		int bankerSuit = 0,highestTeam1Rank=0,highestTeam2Rank=0,p1Rank,p2Rank,p3Rank,p4Rank;
		
		if(getRank(p1)==1){p1Rank=14;}else{p1Rank=getRank(p1);}
		if(getRank(p2)==1){p2Rank=14;}else{p2Rank=getRank(p2);}
		if(getRank(p3)==1){p3Rank=14;}else{p3Rank=getRank(p3);}
		if(getRank(p4)==1){p4Rank=14;}else{p4Rank=getRank(p4);}
	
		//player 1 as banker
		if(banker=="P1"){
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
			
		}else if(banker=="P2"){  //player 2 as banker
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
		}else if(banker=="P3"){  //player 3 as banker
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
			
		}else if(banker=="P4"){  ////player 4 as banker
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
		System.out.print("the highest card for this round is: ");
		int theHighestCard=Math.max(highestTeam1Rank,highestTeam2Rank);
		
		//set the banker for next round
		if(theHighestCard==p1Rank){theHighestCard=p1;banker="P1";
		}else if(theHighestCard==p2Rank){theHighestCard=p2;banker="P2";
		}else if(theHighestCard==p3Rank){theHighestCard=p3;banker="P3";
		}else if(theHighestCard==p4Rank){theHighestCard=p4;banker="P4";}
		
		System.out.println(getCard(theHighestCard));
		System.out.println();
		System.out.println("Team 1  Player 1 and Player 3 Points: "+ team1Score);
		System.out.println();
		System.out.println("Team 2  Player 2 and Player 4 Points: "+ team2Score);
	}
	
	public static void afterOneRound(){
		int p2,p3,p4;
		// just try...this way
		if(player1.size()>1||player2.size()>1||player3.size()>1||player4.size()>1){if(banker=="P2"){
			p2=0;
			p3=AIchoise(player3,P2Card);
			p4=AIchoise(player4,P2Card);
		
			P2Card=player2.get(p2);
			P3Card=player3.get(p3);
			P4Card=player4.get(p4);
		
			System.out.println("Player 2 Card: "+getCard(P2Card));
			System.out.println("Player 3 Card: "+getCard(P3Card));
			System.out.println("Player 4 Card: "+getCard(P4Card));
			removeCards(-1,P2Card,P3Card,P4Card);
		}else if(banker=="P3"){
			//Player 3 is banker, p3 play first. then p4 p1 p2
			p3=0;
			p4=AIchoise(player4,P3Card);
			
			P3Card=player3.get(p3);
			P4Card=player4.get(p4);
			
			System.out.println("Player 3 Card: "+getCard(P3Card));
			System.out.println("Player 4 Card: "+getCard(P4Card));
			removeCards(-1,-1,P3Card,P4Card);
		}else if(banker=="P4"){
			//Player 4 is banker, p4 play first. then p1 p2 p3
			p4=0;setP4Card(p4);		
			P4Card=player4.get(p4);
			System.out.println("Player 4 Card: "+getCard(P4Card));
			removeCards(-1,-1,-1,P4Card);
		}
		}
	}
	
	//return the winner team
	public static String theWinner(){
		if(team1Score>team2Score)
			return "YOU WIN!";
		else
			return "YOU LOSE! LOL";
	}
	
	ArrayList<Integer> getUserCardsOnHand(){
		return player1;
	}
	
	//-----------------------------------------------------------
	//get & set actions
	
	public static void setP1Action(int num){
		//Scanner input = new Scanner(System.in);
		//System.out.println("------------ Which card would you like to play?");
		int p1InputCard=num;
		P1Card=p1InputCard;
	}
	
	//setup AI's action as second-hand
	public static int AIchoise(ArrayList<Integer> AIcardsInHand,int bankerCard){
			int choise=-1,num=0;
			int bankerSuit=getSuit(bankerCard);
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
			//if don't have same-suit card, selete first card in hand
			if(choise==-1)
				return 0;
			else
				return choise;
		}
	
	String getBanker(){return banker;}
	
	//get the card for this round
	
	public static void setP2Card(int num){P2Card=num;}
	public static void setP3Card(int num){P3Card=num;}
	public static void setP4Card(int num){P4Card=num;}
	
	public String getP1Card(){return getCard(P1Card);}
	public String getP2Card(){return getCard(P2Card);}
	public String getP3Card(){return getCard(P3Card);}
	public String getP4Card(){return getCard(P4Card);}
	public int getTeam1Score(){return team1Score;}
	public int getTeam2Score(){return team2Score;}
	
	int getRound(){return round;}
}
