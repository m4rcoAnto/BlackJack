package LogicBehind;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class TestBlackJack {
    public static void main(String[] args){
        Deck deck1 = new Deck();
        Dealer dealer = new Dealer();
        Scanner scanner = new Scanner(System.in);
        deck1.initializeDeck();

        do {
            System.out.println("Hi and welcome , care to play ? Y / N");
            String word = scanner.next();
            while(word.equals("Y")){
                System.out.println("Here are the cards that are being dealt : ");
                System.out.println("------------------------------------------------------");
                dealer.assegnation(deck1);
                int myScore = dealer.calculatePoints();
                int dealerScore = dealer.calculateHisPoints(); /*
                try { // I also have to consider the idea of the Ace and the other cards which values are 10
                    while(myScore < 21){ // Here's another problem : Checking which type of cards my hand actually contains.
                        System.out.println("What's your move? Hit or Stand");
                        if(scanner.next().equalsIgnoreCase("Hit")){
                            dealer.Hit();
                            myScore = dealer.calculatePoints();
                            if(myScore == 21){

                            }
                        } else {
                            break;
                        }
                    }
                    while(dealerScore < 17){

                    }
                    */
            }
        } while();
    }
}

// so now I have to think a way of actually playing
// Either I decide to implement functions inside my main ( it should be my player , so me ) or another class
// to do that I wanted to create an introduction and then I have two options based on the cards on the table: hit or stand
//


// ok , so I actually can see the cards being dealt with a little latency so it does feel more
// Now I have to fix the dealing cards , because the hand only exists if I'm playing that hand
// Before doing that i have to create function -> Hit , beacause it is used both by me and the dealer.
// It is important because it is the only way to actually give a meaning to the game
// I'm also curious if I can add the card directly onto the line in the terminal that i want to put in

// if(!(dealer.myHand.contains(Card(11, "", )) && dealer.myHand.contains(Card(10, "", )))
// This type of check is actually very hard , and creates problems with contains because it uses equals , but it only confronts the indices of the Cards , not the argument
// And not only that but it would make my code a lot harder :
// The real question that I want to answer is : is my hand equal or inferior to 21 points ?

// So I inserted a lot of function which i will add in the Dealer menu. But the thing is that i have to consider first a check
// Whenever myhand is composed of an Ace and card that has 10 as a value, then it means that my Phase has to stop
/*
try { // I also have to consider the idea of the Ace and the other cards which values are 10
                    while(myScore < 21){ // Here's another problem : Checking which type of cards my hand actually contains.
                        System.out.println("What's your move? Hit or Stand");
                        if(scanner.next().equalsIgnoreCase("Hit")){
                            dealer.Hit();
                            myScore = dealer.calculatePoints();
                            if(myScore == 21){

                            }
                        } else {
                            break;
                        }
                    }
 */

// so this could be a potential loop for my hand , i have to consider the delaer hand now
// but before doing that i have to find a way to say that i've done blackjack and how to use the ace if it is not a blackjack.

// Let's analyze it.

