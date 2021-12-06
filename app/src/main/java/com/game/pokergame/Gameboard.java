package com.game.pokergame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pokergame.R;

import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class Gameboard extends AppCompatActivity {

    static ArrayList<Integer> deck = new ArrayList<Integer>();
    int playercard1;
    int playercard2;
    int rivercard1;
    int rivercard2;
    int rivercard3;
    int rivercard4;
    int rivercard5;
    int oppcard1;
    int oppcard2;



    private static final int START_MONEY=2500;
    Random rand = new Random();

    int playerMoney;
    int oppMoney;
    int potMoney;
    int mImageId;
    int playerBet;
    int cpuBet;

    TextView mPLayerMoney;
    TextView mCPUMoney;
    TextView mPotMoney;
    ImageView mPlayerHand1;
    ImageView mPlayerHand2;

    ImageView mRiver1;
    ImageView mRiver2;
    ImageView mRiver3;
    ImageView mRiver4;
    ImageView mRiver5;

    ImageView mOppHand1;
    ImageView mOppHand2;

    String dealer;
    String bigBlind;
    String smallBlind;

    boolean gameOver;
    boolean playerTurn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameboard);

        for(int i = 0; i < 52; ++i)
        {
            deck.add(i);
        }
        //shuffles the array so the numbers are out of order
        Collections.shuffle(deck);
        //assigns the hands and river numbers that will match up to cards
        gameOver=false;
        playerTurn=false;

        playercard1= deck.get(0);
        playercard2= deck.get(1);

        rivercard1=deck.get(2);
        rivercard2=deck.get(3);
        rivercard3=deck.get(4);
        rivercard4=deck.get(5);
        rivercard5=deck.get(6);

        oppcard1=deck.get(7);
        oppcard2=deck.get(8);


        playerMoney = START_MONEY;
        oppMoney = START_MONEY;
        potMoney=0;

        dealer="CPU";
        bigBlind="CPU";
        oppMoney=oppMoney-200;
        potMoney=potMoney+200;

        smallBlind="Player";
        playerMoney=playerMoney-100;
        potMoney=potMoney+100;


        mPLayerMoney = findViewById(R.id.PlayerMoney);
        mCPUMoney = findViewById(R.id.CPUMoney);
        mPotMoney = findViewById(R.id.PotMoney);
        mPlayerHand1=findViewById(R.id.playerhand1);
        mPlayerHand2=findViewById(R.id.playerhand2);

        mRiver1 = findViewById(R.id.river1);
        mRiver2 = findViewById(R.id.river2);
        mRiver3 = findViewById(R.id.river3);
        mRiver4 = findViewById(R.id.river4);
        mRiver5 = findViewById(R.id.river5);

        mOppHand1=findViewById(R.id.cPUcard1);
        mOppHand2=findViewById(R.id.cPUcard2);

        mPlayerHand1.setImageResource(setCard(playercard1));
        mPlayerHand2.setImageResource(setCard(playercard2));

        mPLayerMoney.setText("Player Money: $ "+playerMoney);
        mCPUMoney.setText("CPU Money: $ "+oppMoney);
        mPotMoney.setText("Money in the Pot: $" +potMoney);
        cardsVisible=0;
        cpuTurn();

    }


    int cardsVisible;
    public void onCallClick(View view) {
        if(dealer.equals("CPU")) {
            playerBet = cpuBet;
            playerMoney = playerMoney - playerBet;
            mPLayerMoney.setText("Player Money: $ " + playerMoney);

            potMoney = potMoney + playerBet;
            mPotMoney.setText("Money in the Pot: $" + potMoney);
            playerBet = 0;
            cpuBet = 0;
            if(cardsVisible==0)
            {

                mRiver1.setImageResource(setCard(rivercard1));
                mRiver2.setImageResource(setCard(rivercard2));
                mRiver3.setImageResource(setCard(rivercard3));
                cardsVisible++;
                cpuTurn();

            }
            else if(cardsVisible==1)
            {
                mRiver4.setImageResource(setCard(rivercard4));
                cardsVisible++;
                cpuTurn();
            }
            else if(cardsVisible==2)
            {
                mRiver5.setImageResource(setCard(rivercard5));
                cardsVisible++;
                cpuTurn();
            }
            else
            { HandCheck.evalCard();
                HandCheckBot.evalCardBot();
                mOppHand1.setImageResource(setCard(oppcard1));
                mOppHand2.setImageResource(setCard(oppcard2));
                if (HandCheck.win == 1 ) {
                    Toast.makeText(this, R.string.highcard, Toast.LENGTH_SHORT).show();
                }
                if (HandCheck.win == 2 ) {
                    Toast.makeText(this, R.string.pair, Toast.LENGTH_SHORT).show();
                }
                if (HandCheck.win == 3 ) {
                    Toast.makeText(this, R.string.twopair, Toast.LENGTH_SHORT).show();
                }
                if (HandCheck.win == 4 ) {
                    Toast.makeText(this, R.string.threekind, Toast.LENGTH_SHORT).show();
                }
                if (HandCheck.win == 5 ) {
                    Toast.makeText(this, R.string.straight, Toast.LENGTH_SHORT).show();
                }
                if (HandCheck.win == 6 ) {
                    Toast.makeText(this, R.string.flush, Toast.LENGTH_SHORT).show();
                }
                if (HandCheck.win == 7 ) {
                    Toast.makeText(this, R.string.fullhouse, Toast.LENGTH_SHORT).show();
                }
                if (HandCheck.win == 8 ) {
                    Toast.makeText(this, R.string.fourkind, Toast.LENGTH_SHORT).show();
                }
                if (HandCheck.win == 9 ) {
                    Toast.makeText(this, R.string.straightflush, Toast.LENGTH_SHORT).show();
                }
                if (HandCheck.win == 10 ) {
                    Toast.makeText(this, R.string.royaleflush, Toast.LENGTH_SHORT).show();
                }

                //Checks to see who won. You can add in other variables that are needed here for the game rules to function etc.
                if (HandCheck.win == HandCheckBot.winBot){
                    HandCheck.win = 0;
                    HandCheckBot.winBot = 0;
                    Toast.makeText(this, R.string.tie, Toast.LENGTH_LONG).show();
                    Toast.makeText(this, R.string.newHand, Toast.LENGTH_SHORT).show();
                    potMoney=potMoney/2;
                    oppMoney= oppMoney+potMoney;
                    playerMoney= playerMoney+potMoney;
                    potMoney=0;

                    mPLayerMoney.setText("Player Money: $ "+playerMoney);
                    mCPUMoney.setText("CPU Money: $ "+oppMoney);
                    mPotMoney.setText("Money in the Pot: $" +potMoney);
                }

                else if (HandCheck.win > HandCheckBot.winBot){
                    HandCheck.win = 0;
                    HandCheckBot.winBot = 0;
                    Toast.makeText(this, R.string.win, Toast.LENGTH_LONG).show();

                    playerMoney= playerMoney+potMoney;
                    potMoney=0;

                    mPLayerMoney.setText("Player Money: $ "+playerMoney);
                    mCPUMoney.setText("CPU Money: $ "+oppMoney);
                    mPotMoney.setText("Money in the Pot: $" +potMoney);
                    if(oppMoney<=0)
                    {
                        Toast.makeText(this, R.string.winGame, Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(this, R.string.newHand, Toast.LENGTH_SHORT).show();
                    }
                }

                else if (HandCheck.win < HandCheckBot.winBot){
                    HandCheck.win = 0;
                    HandCheckBot.winBot = 0;
                    Toast.makeText(this, R.string.lost, Toast.LENGTH_LONG).show();
                    oppMoney= oppMoney+potMoney;
                    potMoney=0;

                    mPLayerMoney.setText("Player Money: $ "+playerMoney);
                    mCPUMoney.setText("CPU Money: $ "+oppMoney);
                    mPotMoney.setText("Money in the Pot: $" +potMoney);
                    if(playerMoney<=0)
                    {
                        Toast.makeText(this, R.string.lose, Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(this, R.string.newHand, Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }
        else
        {
            cpuTurn();
        }
    }

    public void onraiseClick(View view) {
        int raise = 500;
        if(oppMoney<playerMoney)
        {
            if(raise>=oppMoney)
            {
                raise=oppMoney;
                playerMoney=playerMoney-raise;
                potMoney=potMoney+raise;
                //call to the CPU's turn
                playerBet=raise;
                mPLayerMoney.setText("Player Money: $ "+playerMoney);
                mCPUMoney.setText("CPU Money: $ "+oppMoney);
                mPotMoney.setText("Money in the Pot: $" +potMoney);

            }
        }
        if(playerMoney<oppMoney)
        {
            if(raise>=playerMoney)
            {
                raise=playerMoney;
                playerMoney=playerMoney-raise;
                potMoney=potMoney+raise;
                playerBet=raise;
                //call to the CPU's Turn
                mPLayerMoney.setText("Player Money: $ "+playerMoney);
                mCPUMoney.setText("CPU Money: $ "+oppMoney);
                mPotMoney.setText("Money in the Pot: $" +potMoney);
            }
        }

        if(raise<playerMoney&&raise<oppMoney)
        {
            playerMoney=playerMoney-raise;
            potMoney=potMoney+raise;
            //call to the CPU's turn
            playerBet=raise;
            mPLayerMoney.setText("Player Money: $ "+playerMoney);
            mCPUMoney.setText("CPU Money: $ "+oppMoney);
            mPotMoney.setText("Money in the Pot: $" +potMoney);
        }
        cpuTurn();
    }
    //creates a new game by reshuffling the deck and resetting the starting values for player and
    //CPU
    public void onnewgameClick(View view) {
        //creates an entirely new game
        //shuffles the array so the numbers are out of order
        Collections.shuffle(deck);
        //assigns the hands and river numbers that will match up to cards

        playercard1= deck.get(0);
        playercard2= deck.get(1);

        rivercard1=deck.get(2);
        rivercard2=deck.get(3);
        rivercard3=deck.get(4);
        rivercard4=deck.get(5);
        rivercard5=deck.get(6);

        oppcard1=deck.get(7);
        oppcard2=deck.get(8);

        playerMoney = START_MONEY;
        oppMoney = START_MONEY;
        potMoney=0;

        gameOver=false;
        playerTurn=false;

        dealer="CPU";
        bigBlind="CPU";
        oppMoney=oppMoney-200;
        potMoney=potMoney+200;

        smallBlind="Player";
        playerMoney=playerMoney-100;
        potMoney=potMoney+100;

        mPLayerMoney.setText("Player Money: $ "+playerMoney);
        mCPUMoney.setText("CPU Money: $ "+oppMoney);
        mPotMoney.setText("Money in the Pot: $" +potMoney);

        mPlayerHand1.setImageResource(setCard(playercard1));
        mPlayerHand2.setImageResource(setCard(playercard2));

        mRiver1.setImageResource(R.drawable.cardback);
        mRiver2.setImageResource(R.drawable.cardback);
        mRiver3.setImageResource(R.drawable.cardback);
        mRiver4.setImageResource(R.drawable.cardback);
        mRiver5.setImageResource(R.drawable.cardback);

        mOppHand1.setImageResource(R.drawable.cardback);
        mOppHand2.setImageResource(R.drawable.cardback);
        cardsVisible=0;
        cpuTurn();

        //PLayerMoney.setText("Player Money: $ "+playerMoney);
        //CPUMoney.setText("CPU Money: $ "+oppMoney);
    }
    public void cpuTurn() {

        int raise = rand.nextInt(5);
        int decider = rand.nextInt(24);

        int storageD2 = 0;
        int storageD3 = 0;
        int storageD4 = 0;
        int storageD5 = 0;
        int storageD6 = 0;
        int knownStrength = 0;
        //Information can be hidden from the bot by setting cards to 53. Such a number will not
        //register in the checks. Thus, the bot can only use revealed cards to influence its
        //decisions.

        switch (cardsVisible){
            case 0: //No cards revealed.
                storageD2 = deck.get(2);
                deck.set(2, 53);

                storageD3 = deck.get(3);
                deck.set(3,53);

                storageD4 = deck.get(4);
                deck.set(4, 53);

                storageD5 = deck.get(5);
                deck.set(5,53);

                storageD6 = deck.get(6);
                deck.set(6, 53);

                HandCheckBot.evalCardBot();
                knownStrength = HandCheckBot.winBot;

                deck.set(2, storageD2);
                deck.set(3, storageD3);
                deck.set(4, storageD4);
                deck.set(5, storageD5);
                deck.set(6, storageD6); //Return values to original
                break;
            case 1: //Flop cards revealed.

                storageD5 = deck.get(5);
                deck.set(5,53);

                storageD6 = deck.get(6);
                deck.set(6, 53);

                HandCheckBot.evalCardBot();
                knownStrength = HandCheckBot.winBot;

                deck.set(5, storageD5);
                deck.set(6, storageD6); //Return values to original
                break;
            case 2: //Turn card revealed.

                storageD6 = deck.get(6);
                deck.set(6, 53);

                HandCheckBot.evalCardBot();
                knownStrength = HandCheckBot.winBot;

                deck.set(6, storageD6); //Return values to original
                break;
            case 3: //All cards revealed.
                HandCheckBot.evalCardBot();
                knownStrength = HandCheckBot.winBot;

                break;

        }

        decider = decider + knownStrength; //Stronger hands mean the bot will be more aggressive

        if(playerBet == 500){ //Usually triggered if the player has raised. Makes the CPU
            //more likely to fold.
            decider = decider - 4;
        }

        if (oppMoney == 0) {
            decider = 1;
        }
        if (decider <= 0) //computer folds
        {
            if (oppMoney == 0) {
                Toast.makeText(this, R.string.winGame, Toast.LENGTH_SHORT).show();
                playerMoney = potMoney + playerMoney;
                potMoney = 0;
                mPLayerMoney.setText("Player Money: $ " + playerMoney);
                mCPUMoney.setText("CPU Money: $ " + oppMoney);
                mPotMoney.setText("Money in the Pot: $" + potMoney);
            } else {
                playerMoney = potMoney + playerMoney;
                potMoney = 0;
                mPLayerMoney.setText("Player Money: $ " + playerMoney);
                mCPUMoney.setText("CPU Money: $ " + oppMoney);
                mPotMoney.setText("Money in the Pot: $" + potMoney);

                Toast.makeText(this, R.string.cpuFold, Toast.LENGTH_SHORT).show();
            }
        } else if (decider > 18)//the computer raises
        {
            cpuBet = (1 + raise) * 100;
            if (cpuBet > oppMoney) {
                cpuBet = oppMoney;
            }
            if (cpuBet > playerMoney) {
                cpuBet = playerMoney;
            }
            oppMoney = oppMoney - cpuBet;
            potMoney = potMoney + cpuBet;
            mPLayerMoney.setText("Player Money: $ " + playerMoney);
            mCPUMoney.setText("CPU Money: $ " + oppMoney);
            mPotMoney.setText("Money in the Pot: $" + potMoney);
            Toast.makeText(this, R.string.cpuRaise, Toast.LENGTH_SHORT).show();
        } else// the computer calls
        {
            Toast.makeText(this, R.string.cpuCall, Toast.LENGTH_SHORT).show();
            cpuBet = playerBet;
            oppMoney = oppMoney - cpuBet;
            potMoney = potMoney + cpuBet;
            mPLayerMoney.setText("Player Money: $ " + playerMoney);
            mCPUMoney.setText("CPU Money: $ " + oppMoney);
            mPotMoney.setText("Money in the Pot: $" + potMoney);
            cpuBet = 0;
            playerBet = 0;
            if (!dealer.equals("CPU")) {
                if (cardsVisible == 0) {
                    mRiver1.setImageResource(setCard(rivercard1));
                    mRiver2.setImageResource(setCard(rivercard2));
                    mRiver3.setImageResource(setCard(rivercard3));
                    cardsVisible++;


                } else if (cardsVisible == 1) {
                    mRiver4.setImageResource(setCard(rivercard4));
                    cardsVisible++;

                } else if (cardsVisible == 2) {
                    mRiver5.setImageResource(setCard(rivercard5));
                    cardsVisible++;

                } else {
                    HandCheck.evalCard();
                    HandCheckBot.evalCardBot();
                    if (HandCheck.win == 1) {
                        Toast.makeText(this, R.string.highcard, Toast.LENGTH_SHORT).show();
                    }
                    if (HandCheck.win == 2) {
                        Toast.makeText(this, R.string.pair, Toast.LENGTH_SHORT).show();
                    }
                    if (HandCheck.win == 3) {
                        Toast.makeText(this, R.string.twopair, Toast.LENGTH_SHORT).show();
                    }
                    if (HandCheck.win == 4) {
                        Toast.makeText(this, R.string.threekind, Toast.LENGTH_SHORT).show();
                    }
                    if (HandCheck.win == 5) {
                        Toast.makeText(this, R.string.straight, Toast.LENGTH_SHORT).show();
                    }
                    if (HandCheck.win == 6) {
                        Toast.makeText(this, R.string.flush, Toast.LENGTH_SHORT).show();
                    }
                    if (HandCheck.win == 7) {
                        Toast.makeText(this, R.string.fullhouse, Toast.LENGTH_SHORT).show();

                    }
                    if (HandCheck.win == 8) {
                        Toast.makeText(this, R.string.fourkind, Toast.LENGTH_SHORT).show();
                    }
                    if (HandCheck.win == 9) {
                        Toast.makeText(this, R.string.straightflush, Toast.LENGTH_SHORT).show();
                    }
                    if (HandCheck.win == 10) {
                        Toast.makeText(this, R.string.royaleflush, Toast.LENGTH_SHORT).show();
                    }
                    //Checks to see who won. You can add in other variables that are needed here for the game rules to function etc.
                    if (HandCheck.win == HandCheckBot.winBot) {
                        HandCheck.win = 0;
                        HandCheckBot.winBot = 0;
                        Toast.makeText(this, R.string.tie, Toast.LENGTH_LONG).show();
                        Toast.makeText(this, R.string.newHand, Toast.LENGTH_SHORT).show();
                        potMoney = potMoney / 2;
                        oppMoney = oppMoney + potMoney;
                        playerMoney = playerMoney + potMoney;
                        potMoney = 0;

                        mPLayerMoney.setText("Player Money: $ " + playerMoney);
                        mCPUMoney.setText("CPU Money: $ " + oppMoney);
                        mPotMoney.setText("Money in the Pot: $" + potMoney);
                    } else if (HandCheck.win > HandCheckBot.winBot) {
                        HandCheck.win = 0;
                        HandCheckBot.winBot = 0;
                        Toast.makeText(this, R.string.win, Toast.LENGTH_LONG).show();

                        playerMoney = playerMoney + potMoney;
                        potMoney = 0;

                        mPLayerMoney.setText("Player Money: $ " + playerMoney);
                        mCPUMoney.setText("CPU Money: $ " + oppMoney);
                        mPotMoney.setText("Money in the Pot: $" + potMoney);
                        if (oppMoney <= 0) {
                            Toast.makeText(this, R.string.winGame, Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(this, R.string.newHand, Toast.LENGTH_SHORT).show();
                        }
                    } else if (HandCheck.win < HandCheckBot.winBot) {
                        HandCheck.win = 0;
                        HandCheckBot.winBot = 0;
                        Toast.makeText(this, R.string.lost, Toast.LENGTH_LONG).show();
                        oppMoney = oppMoney + potMoney;
                        potMoney = 0;

                        mPLayerMoney.setText("Player Money: $ " + playerMoney);
                        mCPUMoney.setText("CPU Money: $ " + oppMoney);
                        mPotMoney.setText("Money in the Pot: $" + potMoney);
                        if (playerMoney <= 0) {
                            Toast.makeText(this, R.string.lose, Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(this, R.string.newHand, Toast.LENGTH_SHORT).show();
                        }
                    }

                }

            }


        }
    }
    //generates a new hand by reshuffling the deck and changing who is dealing and the blinds
    public void onnew_handClick(View view) {
        cardsVisible=0;
        //shuffles the deck and deals out a new hand

        //shuffles the array so the numbers are out of order
        Collections.shuffle(deck);
        //assigns the hands and river numbers that will match up to cards

        playercard1= deck.get(0);
        playercard2= deck.get(1);

        rivercard1=deck.get(2);
        rivercard2=deck.get(3);
        rivercard3=deck.get(4);
        rivercard4=deck.get(5);
        rivercard5=deck.get(6);

        oppcard1=deck.get(7);
        oppcard2=deck.get(8);

        if(dealer.equals("CPU"))
        {
            dealer="Player";
            bigBlind="Player";
            playerMoney=playerMoney-200;
            potMoney=potMoney+200;

            smallBlind="CPU";
            oppMoney=oppMoney-100;
            potMoney=potMoney+100;
            gameOver=false;
            playerTurn=true;
        }
        else
        {
            dealer="CPU";
            bigBlind="CPU";
            oppMoney=oppMoney-200;
            potMoney=potMoney+200;

            smallBlind="Player";
            playerMoney=playerMoney-100;
            potMoney=potMoney+100;
            gameOver=false;
            playerTurn=false;
            cpuTurn();
        }

        mPLayerMoney.setText("Player Money: $ "+playerMoney);
        mCPUMoney.setText("CPU Money: $ "+oppMoney);
        mPotMoney.setText("Money in the Pot: $" +potMoney);

        mPlayerHand1.setImageResource(setCard(playercard1));
        mPlayerHand2.setImageResource(setCard(playercard2));

        mRiver1.setImageResource(R.drawable.cardback);
        mRiver2.setImageResource(R.drawable.cardback);
        mRiver3.setImageResource(R.drawable.cardback);
        mRiver4.setImageResource(R.drawable.cardback);
        mRiver5.setImageResource(R.drawable.cardback);

        mOppHand1.setImageResource(R.drawable.cardback);
        mOppHand2.setImageResource(R.drawable.cardback);

    }
    //fold button says that the player is giving up that round meaning the computer gets the pot
    //and if the player has no money remaining sends a toast telling them they lost
    public void onfoldClick(View view) {
        if(playerMoney==0)
        {
            Toast.makeText(this, R.string.lose, Toast.LENGTH_SHORT).show();
            oppMoney=potMoney+oppMoney;
            potMoney=0;
            mPLayerMoney.setText("Player Money: $ "+playerMoney);
            mCPUMoney.setText("CPU Money: $ "+oppMoney);
            mPotMoney.setText("Money in the Pot: $" +potMoney);
        }
        else
        {
            oppMoney=potMoney+oppMoney;
            potMoney=0;
            mPLayerMoney.setText("Player Money: $ "+playerMoney);
            mCPUMoney.setText("CPU Money: $ "+oppMoney);
            mPotMoney.setText("Money in the Pot: $" +potMoney);

            Toast.makeText(this, R.string.newHand, Toast.LENGTH_SHORT).show();
        }
    }

    public int setCard(int number) {
        switch (number) {
            case 1:
                mImageId = R.drawable.two_of_hearts;
                break;
            case 2:
                mImageId = R.drawable.three_of_hearts;
                break;
            case 3:
                mImageId = R.drawable.four_of_hearts;
                break;
            case 4:
                mImageId = R.drawable.five_of_hearts;
                break;
            case 5:
                mImageId = R.drawable.six_of_hearts;
                break;
            case 6:
                mImageId = R.drawable.seven_of_hearts;
                break;
            case 7:
                mImageId = R.drawable.eight_of_hearts;
                break;
            case 8:
                mImageId = R.drawable.nine_of_hearts;
                break;
            case 9:
                mImageId = R.drawable.ten_of_hearts;
                break;
            case 10:
                mImageId = R.drawable.jack_of_hearts2;
                break;
            case 11:
                mImageId = R.drawable.queen_of_hearts2;
                break;
            case 12:
                mImageId = R.drawable.king_of_hearts2;
                break;
            case 13:
                mImageId = R.drawable.ace_of_hearts;
                break;
            case 14:
                mImageId = R.drawable.two_of_clubs;
                break;
            case 15:
                mImageId = R.drawable.three_of_clubs;
                break;
            case 16:
                mImageId = R.drawable.four_of_clubs;
                break;
            case 17:
                mImageId = R.drawable.five_of_clubs;
                break;
            case 18:
                mImageId = R.drawable.six_of_clubs;
                break;
            case 19:
                mImageId = R.drawable.seven_of_clubs;
                break;
            case 20:
                mImageId = R.drawable.eight_of_clubs;
                break;
            case 21:
                mImageId = R.drawable.nine_of_clubs;
                break;
            case 22:
                mImageId = R.drawable.ten_of_clubs;
                break;
            case 23:
                mImageId = R.drawable.jack_of_clubs2;
                break;
            case 24:
                mImageId = R.drawable.queen_of_clubs2;
                break;
            case 25:
                mImageId = R.drawable.king_of_clubs2;
                break;
            case 26:
                mImageId = R.drawable.ace_of_clubs;
                break;
            case 27:
                mImageId = R.drawable.two_of_spades;
                break;
            case 28:
                mImageId = R.drawable.three_of_spades;
                break;
            case 29:
                mImageId = R.drawable.four_of_spades;
                break;
            case 30:
                mImageId = R.drawable.five_of_spades;
                break;
            case 31:
                mImageId = R.drawable.six_of_spades;
                break;
            case 32:
                mImageId = R.drawable.seven_of_spades;
                break;
            case 33:
                mImageId = R.drawable.eight_of_spades;
                break;
            case 34:
                mImageId = R.drawable.nine_of_spades;
                break;
            case 35:
                mImageId = R.drawable.ten_of_spades;
                break;
            case 36:
                mImageId = R.drawable.jack_of_spades2;
                break;
            case 37:
                mImageId = R.drawable.queen_of_spades2;
                break;
            case 38:
                mImageId = R.drawable.king_of_spades2;
                break;
            case 39:
                mImageId = R.drawable.ace_of_spades2;
                break;
            case 40:
                mImageId = R.drawable.two_of_diamonds;
                break;
            case 41:
                mImageId = R.drawable.three_of_diamonds;
                break;
            case 42:
                mImageId = R.drawable.four_of_diamonds;
                break;
            case 43:
                mImageId = R.drawable.five_of_diamonds;
                break;
            case 44:
                mImageId = R.drawable.six_of_diamonds;
                break;
            case 45:
                mImageId = R.drawable.seven_of_diamonds;
                break;
            case 46:
                mImageId = R.drawable.eight_of_diamonds;
                break;
            case 47:
                mImageId = R.drawable.nine_of_diamonds;
                break;
            case 48:
                mImageId = R.drawable.ten_of_diamonds;
                break;
            case 49:
                mImageId = R.drawable.jack_of_diamonds2;
                break;
            case 50:
                mImageId = R.drawable.queen_of_diamonds2;
                break;
            case 51:
                mImageId = R.drawable.king_of_diamonds2;
                break;
            case 52:
                mImageId = R.drawable.ace_of_diamonds;
                break;
        }
        return mImageId;
    }


}
