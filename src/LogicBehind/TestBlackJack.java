package LogicBehind;

import java.util.Scanner;


public class TestBlackJack {
    public static void main(String[] args){
        Deck deck1 = new Deck();
        deck1.initializeDeck();
        Dealer dealer = new Dealer();
        Scanner scanner = new Scanner(System.in);
        String word = "";
        int games = 0;
        int wins = 0;
        int losses = 0;

        do {
            System.out.println("Hi and welcome , care to play ? Y / N");
            word = scanner.next();
            while(word.equalsIgnoreCase("y")){
                if(deck1.shuffle()){
                    System.out.println("The deck has to be shuffled first : ");
                    System.out.println("Wait while we shuffle the cards : ");
                    int waiting = 0;
                    while(waiting < 5){
                        Dealer.pause();
                        System.out.println(".");
                        waiting++;
                    }
                }
                System.out.println("Here are the cards that are being dealt : ");
                System.out.println("------------------------------------------------------");
                dealer.assegnation(deck1);
                int dealerScore = dealer.calculateHisPoints();

                int myScore = dealer.calculateMyPoints();


                if(dealer.Blackjack(dealer.getMyHand()) && !dealer.Blackjack(dealer.getDealerHand())){
                    System.out.println("Blackjack! You win!");
                    games++;
                    wins++;
                } else {
                    do {
                        if(dealer.Blackjack(dealer.getDealerHand()) && !dealer.Blackjack(dealer.getMyHand())){
                            System.out.println("You lose, dealer had blackjack since the beginning.");
                            games++;
                            losses++;
                            break;
                        }
                        System.out.println("What's your choice now ? : ");

                        word = scanner.next();
                        switch (word) {
                            case "Hit" :
                                while(word.equals("Hit") && myScore < 21) {
                                    dealer.myHit(deck1);
                                    myScore = dealer.calculateMyPoints();

                                    if(myScore < 21){
                                        System.out.println("What's your decision ?");
                                        word = scanner.next();
                                    }
                                }
                                if (myScore > 21) {
                                    System.out.println("You busted , dealer wins");
                                    word = "Out";
                                    games++;
                                    losses++;
                                    break;
                                } else if (myScore == 21) {
                                    word = "Stand";
                                }
                            case "Stand" :
                                System.out.println("Dealer's Turn : ");
                                System.out.println("--------------------------------");
                                Dealer.pause();
                                System.out.println(dealer.getDealerHand() + " -> " + dealer.calculateHisPoints());
                                if(dealer.Blackjack(dealer.getDealerHand()) && dealer.Blackjack(dealer.getMyHand())){
                                    System.out.println("The dealer had Blackjack, it's a draw.");
                                    games++;
                                    break;
                                } else if(dealer.Blackjack(dealer.getDealerHand())){
                                    System.out.println("The dealer had BlackJack, you lose");
                                    games++;
                                    losses++;
                                    break;
                                }
                                while(dealerScore < 17 || (dealerScore == 17 && dealer.isSoft(dealer.getDealerHand()))){
                                    dealer.dealerHit(deck1);
                                    dealerScore = dealer.calculateHisPoints();
                                    Dealer.pause();
                                }
                                if (dealerScore > 21) {
                                    System.out.println("Dealer busted , all player that have not busted win");
                                    word = "Out";
                                    games++;
                                    wins++;
                                    break;
                                }
                                System.out.println("Dealer has to stand with : " + dealerScore);
                                if(myScore > dealerScore){
                                    System.out.println("You win! You beat the delaer with : "+ myScore + ", against " + dealerScore + ".");
                                    games++;
                                    wins++;
                                    break;
                                } else if(myScore == dealerScore){
                                    System.out.println("Your score is the same as the dealer , bets are pushed.");
                                    games++;
                                    break;
                                } else {
                                    System.out.println("You lose! The dealer has higher points.");
                                    games++;
                                    losses++;
                                    break;
                                }
                        }
                    } while (word.equals("Hit"));

                }

                System.out.println("Would like to play again?");
                word = scanner.next();
                dealer.removeHands();
            }
        } while(word.equalsIgnoreCase("y"));

        System.out.println("-----------------");
        System.out.println("Game's played : " + games);
        System.out.println("Here's your resume : " + wins + " wins and " + losses + " losses.");
    }
}
