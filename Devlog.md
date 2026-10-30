DEVLOG
0. Planning the game (written before the code)

so let's do it like this :
i want my programm to be a blackjack executor
in short i have 8 decks of 52 cards , every player ( or maybe just me for now ) has two cards that get drawn from these 8 decks
every single time a card gets called my deck has to update
For now we don't add the cut card because it's not needed

Let's just analyze how the game wroks:

1. A deck is made of 52 cards
2. The dealer deals the cards and gives one card per person and one to himself too as the very first round , after that the second card gets dsitributed to all the players
3. to decide if i want to apply dealer rules on the dealing of the second card : Wait for all plyaers to finish playnig and then asign the second car to the dealer , or give it to him right away before the game
4. With two equal cards ( number , which can also be the same seed ) you can split ( if i have a 10 and a face card no , only 2 face cards or 10 and 10)
5. the double down is face down ( i can give it ? as a returned value that i don't know )
6. If i decide hit , the card gets assigned , no alert , same thing for stay
7. i'll decide if i want to add a bet or not ( so if i want to make it a real casino )
8. You can leave the table at any moment , possibly we'll give a counter of hands won and hands lost
9. The dealer hsa to stand on >= 17 as a score, if he makes 22 there's no push but bust.
10. The dealer is forced to call a soft 17.
11. i can implement a shuffle function , since for now i'm not adding the cut card ( and possibly it's too long alone against the dealer to fnish 8 decks )
12. The ace is clearly worth both 1 and 11.

How can i do it now ?
So i have different ideas on how it works. If i use for example 8 decks it means that of one card there will be 8 equal copies , of the same number there will be 32
So the ideal would be for example to create a Deck class to explain how it is made , so 52 cards that all have to be inserted and have to hvae an assigned value
Here a Map would be more than useful since it contains both the card and the value.
My card is so a fixed variable that must not change : I have that card and that card only
For the moment i don't even need to focus on the seed of the card itself since i'm not adding side bet , but let's say that i already have this project in mind
So is my card an object ? Or not? I'd say yes
It has two properties that belong only to it : Value and seed. Every deck contains 52 of them.
So it would be ideal to create a card clas
Its attributes are its own though, but i can't really initialize all 52 of them. I should give some instructions that allow to make all the comnbinations
4 seeds , 13 cards. Jokers excluded obviously.
So let's think for a second about the logic that i have to implement to make it
My card class contains parameters that we already know. Is my deck a class that contains 52 cards then , or is it just simlpy a container of 52 cards , in the end it only has this parameter
Yeah i'd say it's only a container. So a List of Card objects.
My dealer has 6 / 8 of these decks , so i have to count the same deck repeated another 6 times
Then there's the possibility for the user to click shuffle the deck , so there has to be a funciton that is able to shuffle the deck
Now i have to focus on the idea that the cards have to be dealt with complete randomness , same thing during the shuffle
To do it i can use random which is a method that is basically made for this , but i have to actually understand if it's able to assign to the player random objects of type card from a deck that keeps updating
The problem is that i'm sure it would be very slow . The deck is a list and my object should get inside the list itself to try to shuffle everything
A HashMap oor a Set in general could help , but the set doesn't allow any duplicate so the idea of more decks falls automatically
For the moment let's follow the idea of using a list of objects which surely makes more sense.

The real question now is based on the code : How many cases do we have and how many can i simplify ?
If my hand is made of the first two cards and i score 21 then i made blakcjack :

case : the dealer has a 10 face up , we don't know if under the second card there's the ace -> if he reveals and there's the 10 it's push , if it's another card then we win automatically.
case : the dealer has an ace face up , we don't know if under the second card there's the ace -> if he reveals and there's the ace it's push , if it's another card then we win automatically.
case : the delaer has any other card face up , we win

If my score is lower than 21
Decisions of hit or stand based on the score of my hand
If i decide to hit i have to recalculate every time the score that i'm assigning to my hand and decide again if i want to hit or stay
Regardless of the phase , if you end your turn ( even without calling any card ) with stand , then the dealer reveals his card

The score of the dealer's cards is lower than 21 but equal or higher than 17 -> if my score is higher than his then i win
if the score is lower than 17 he'll keep hitting until he gets to at least 17 with bound at 21 -> if my score is higher than his i win

Important things to remember to implement : My hand remembers all its values after every hand , so i have to recalculate to 0 the score of my player and reduce to 0 the hand before the new dealing of the cards
1. Designing the Card

The problem is that I actually need a way to understand what im gonna return to my console
Because my game actually needs to be played there
so do I actually need a getter for every instance ? or just a toString() that gets me both of the properties?

Let's just imagine the game right : I'm from the console looking at the cards , and then I see something like :
Dealer has : J of Diamonds , ?
You have : 10 of Hearts, 10 of Diamonds -> total score = 20.
What do you want to do? ( then I want to fisically write down hit or stay , or maybe I don't know if I can implement something with a button on the console )
then if I choose hit it's gonna become something like : [10 of Hearts, 10 of Diamonds, 4 of Clubs] -> total score = 24 , after few seconds , I think I can do a time function where I can put busted , hand lost
I will try to time the distribution of the cards.
so this actually solved another doubt : The dealer hands and mine is actually a list of object too.
since I've created an enum of seeds , I have to actually call it in my method

I don't that I need any setters , because the cards are just like that. I take it and see it , they don't overwrite each-others.

2. Building the deck

so my cards have values between 1 and 11 , with aces that alterns between the 1 and the 11.
How do I actually understand how to initialize my cards with the correct values???
every card has 4 copies with 4 different seeds. Would here the setters be useful to say : this is my new Card object inside the list ?
Let's follow it step by step : My card has to be created before the insertion on the list. So i have to create 52 Cards.
Could I implement something that doesn't need to create 52 cards alone and just create it with a double for ?
The thing is that there is the possibility of the ace to be two different numbers, I have to be aware of that.

Also i thought about it : in the casino it not a list od fecks , or separeted decks , but just a big container of cards where every card is random.
so i could simply put in the constructor of deck the number of deck that i want to play with , in my case 8.
Bu tthat does not work clearly because the constructor only tells me how much the number of decks are , it does not create 8 decks.

3. Drawing a random card

so there's a big problem now : Random is a class that only gives numbers ( or at least indices of numbers )
The hashmap is a data structure without any indices , it's non sorted and not casual. So the only way that I can use the random class is to use a list

4. Where do the hands live?

for the hit method I'm a little confused. Because only me should hit , so the dealer does it automatically if the total sum is less then 17.
So this one is dedicated to me. For the dealer I will try to automazite it.

so he was two cards in his hand , both are Card object of course.
Should I implement the possibility of the dealer to stay or hit ( forced from the system ) in this class or it must happen during the main?

so now I have another doubt / problem -> should myhand be in the delaer class ?? Yes , it's true that the dealer should give the card to me
But it's also true that now I don't have any control of my Hand , it is only found inside the Dealer Class. Then what should i do ?

ok I might have found a solution : I could leave my hand as private so no one can catually touch it , but at the same time I can implement the method calculatePoints
Where if my hand only contains two cards and the points are 21 , that means that we have done blackjack -> thing is that it also depends on which card my dealer also has
For example if the dealer has an ace in the open and the other card is ? then it is not said that i've won , it can also be a push.
If he has a 10 , then it's the same because the other card could possibly be an ace.
for every other card we win.

5. Making it playable

so now I have to think a way of actually playing
Either I decide to implement functions inside my main ( it should be my player , so me ) or another class
to do that I wanted to create an introduction and then I have two options based on the cards on the table: hit or stand

ok , so I actually can see the cards being dealt with a little latency so it does feel more
Now I have to fix the dealing cards , because the hand only exists if I'm playing that hand
Before doing that i have to create function -> Hit , beacause it is used both by me and the dealer.
It is important because it is the only way to actually give a meaning to the game
I'm also curious if I can add the card directly onto the line in the terminal that i want to put in

So I inserted a lot of function which i will add in the Dealer menu. But the thing is that i have to consider first a check
Whenever myhand is composed of an Ace and card that has 10 as a value, then it means that my Phase has to stop

```java
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
```
so this could be a potential loop for my hand , i have to consider the delaer hand now
but before doing that i have to find a way to say that i've done blackjack and how to use the ace if it is not a blackjack.

Let's analyze it.

All right so i made it officially playable , the only thing that i gotta understand now is how to treat the ace
I have to play to actually see if it works properly.

6. Checking for Blackjack
   ```java
   if(!(dealer.myHand.contains(Card(11, "", )) && dealer.myHand.contains(Card(10, "", )))

This type of check is actually very hard , and creates problems with contains because it uses equals , but it only confronts the indices of the Cards , not the argument
And not only that but it would make my code a lot harder :
The real question that I want to answer is : is my hand equal or inferior to 21 points ?

so let's say that the dealer has 21 and I dont know , then it means that i need a check of a boolean to actually see if the dealer has blackjack
for example if don't have blackjack then i need a boolean as a check. if the boolean is false then i lose , else it's a push.

7. The Ace

i have to implement tha ace case in here now. I can manually set the points.

SUummarising :
An initial assigment method has been created -> I'll need it to check if the score is already 21 ( since it has only two cards it means that he has blackjack )
a hit method has been used for both parties
a remove method for noth parties has been implemented
Now i have to create a check for the Ace -> is this a method or just a case ?
No , this is a method , i can recall the draw from the deck , when he draws me an Ace ( since it returns me the object then i can check if the score with the other card is already
10 , because if it is , then it means that it is blackjack , if it isn't then the Ace can act as a 1 or a 11 too. This pretty much depends also on the score
If the score is inferior to 10 , then the ace must be 11 if the player decides to stand , otherwise if he hits he's trating it as a 1 to not bust. The max number that he can get is a 10
if two aces are on the same hand oonly the first ( as a convention ) is considered as the double choice.

```java
public void setAceValue(){
    if(caseAce()){
        if(calculateMyPoints() < 21 && calculateMyPoints() > 10){
            for(Card c : myHand){
                if(c.getName().equals("Ace")){
                    c.setValue(1);
                    break;
                }
            }
        }
    }
}
```
im thinking that this method right here is wrong
Even tho the implementation is right , the problem is that it pretty much depens on whether the player chooses ti hor or stand
And it depends by the points , so how do I experiment with it??
I added the caseAce so if there is even a single ace then it must go into the multpli choice bewtween 1 and 11
I already know that the ace has 11 has a value , but here we want it to 1 if the points are higher than 10
if it were 10 then it would have mean that I had 21 as a total

But the thing is : 1. The ace MAYBE should be calculated after , because since it depends on the player,
if I had any number bewtween 2 and 9 and an Ace , It could mean 12 to 20 has total points
so then I decide to call , and when it draws -> if the card goes over the points of 21 then my ace has to become 1 to save the player+
Otherwise it just adds up
If I have a hand that does not contain an ace , then it means that if the points are higher than , 10
the ace must be valued has a 1.
so yeah , the best solution here is to actually assign the value to the ace as a last option, so that I can already set it up , instead of changing it while inside myHand
I pretty much have to recall the myHit and delaerHit methods, since I used draw for the deck has a normal assignment.
So do i really need caseAce as a method ?
well if myhand in the first 2 cards contains an Ace then yes, otherwise no

so I need to update the ace now , let's see what i can do.

all right , so the ace is now done. Now i only need to not print out the first card value of the dealer.

8. Final touches: shuffling

The game is theortically over , i don't know about some bugs , maybe i should start looking inside the code.
I could implement a shuffle function whenever i hit , maybe , 52 cards , so that a person cannot count the number of cards that have been out
But maybe 52 is too much , 30 should do.