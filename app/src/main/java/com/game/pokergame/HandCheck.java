package com.game.pokergame;

public class HandCheck {
    private static Integer[] Two = {1, 14, 27, 40};
    private static Integer[] Three = {2, 15, 28, 41};
    private static Integer[] Four = {3, 16, 29, 42};
    private static Integer[] Five = {4, 17, 30, 43};
    private static Integer[] Six = {5, 18, 31, 44};
    private static Integer[] Seven = {6, 19, 32, 45};
    private static Integer[] Eight = {7, 20, 33, 46};
    private static Integer[] Nine = {8, 21, 34, 47};
    private static Integer[] Ten = {9, 22, 35, 48};
    private static Integer[] Jack = {10, 23, 36, 49};
    private static Integer[] Queen = {11, 24, 37, 50};
    private static Integer[] King = {12, 25, 38, 51};
    private static Integer[] Ace = {13, 26, 39, 52};

    public static int cardType [] = {0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    public static int cardTypeCheck [] = {0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    public static int Straight [] = {0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    public static int straightCheck [] = {0,0,0,0,0,0,0,0,0,0,0,0,0,0};

    private static int heart = 0;
    private static int club = 0;
    private static int spade = 0;
    private static int diamond = 0;
    private static int HCheck = 0;
    private static int CCheck = 0;
    private static int SCheck = 0;
    private static int DCheck = 0;

    public static int win = 0;
    private static int fourKind = 0;
    private static int threeKind = 0;
    private static int pair = 0;
    private static int royaleFlush = 0;
    private static int straight = 0;


    public static void evalCard() {
        isPair();
        isStraight();

        if(royaleFlush == 1 && isFLush() == true){
            win = 10;
            royaleFlush = 0;
            straight = 0;
            for (int i = 0; i < 13; i++) {
                Straight[i] = 0;
                straightCheck[i] = 0;
            }
            //Sets the straight checker variables back to zero, so they do not misscheck on future rounds of the game.
            for (int i = 0; i < 13; i++) {
                Straight[i] = 0;
                straightCheck[i] = 0;
            }
        }
        else if (isFLush() == true && straight ==1){
            win = 9;
            royaleFlush = 0;
            straight = 0;
            for (int i = 0; i < 13; i++) {
                Straight[i] = 0;
                straightCheck[i] = 0;
            }
            //Sets the straight checker variables back to zero, so they do not misscheck on future rounds of the game.
            for (int i = 0; i < 13; i++) {
                Straight[i] = 0;
                straightCheck[i] = 0;
            }
        }

        else if (fourKind == 1){
            win = 8;
            fourKind = 0;
            for (int i = 0; i < 13; i++) {
                cardType[i] = 0;
                cardTypeCheck[i] = 0;
            }
            //Sets the straight checker variables back to zero, so they do not misscheck on future rounds of the game.
            for (int i = 0; i < 13; i++) {
                Straight[i] = 0;
                straightCheck[i] = 0;
            }
        }
        else if (threeKind == 1 && pair == 1){
            win = 7;
            threeKind = 0;
            pair = 0;
            for (int i = 0; i < 13; i++) {
                cardType[i] = 0;
                cardTypeCheck[i] = 0;
            }
            //Sets the straight checker variables back to zero, so they do not misscheck on future rounds of the game.
            for (int i = 0; i < 13; i++) {
                Straight[i] = 0;
                straightCheck[i] = 0;
            }
        }
        else if (isFLush() == true) {
            win = 6;
            heart = 0;
            spade = 0;
            club = 0;
            diamond = 0;
            //Sets the straight checker variables back to zero, so they do not misscheck on future rounds of the game.
            for (int i = 0; i < 13; i++) {
                Straight[i] = 0;
                straightCheck[i] = 0;
            }
        }
        else if(straight == 1){
            win = 5;
            royaleFlush = 0;
            straight = 0;
            for (int i = 0; i < 13; i++) {
                Straight[i] = 0;
                straightCheck[i] = 0;
            }
            //Sets the straight checker variables back to zero, so they do not misscheck on future rounds of the game.
            for (int i = 0; i < 13; i++) {
                Straight[i] = 0;
                straightCheck[i] = 0;
            }
        }
        else if (threeKind == 1){
            win = 4;
            threeKind = 0;
            for (int i = 0; i < 13; i++) {
                cardType[i] = 0;
                cardTypeCheck[i] = 0;
            }
            //Sets the straight checker variables back to zero, so they do not misscheck on future rounds of the game.
            for (int i = 0; i < 13; i++) {
                Straight[i] = 0;
                straightCheck[i] = 0;
            }
        }
        else if (pair == 2) {
            win = 3;
            pair = 0;
            for (int i = 0; i < 13; i++) {
                cardType[i] = 0;
                cardTypeCheck[i] = 0;
            }
            //Sets the straight checker variables back to zero, so they do not misscheck on future rounds of the game.
            for (int i = 0; i < 13; i++) {
                Straight[i] = 0;
                straightCheck[i] = 0;
            }
        }
        else if (pair == 1) {
            win = 2;
            pair = 0;
            for (int i = 0; i < 13; i++) {
                cardType[i] = 0;
                cardTypeCheck[i] = 0;
            }
            //Sets the straight checker variables back to zero, so they do not misscheck on future rounds of the game.
            for (int i = 0; i < 13; i++) {
                Straight[i] = 0;
                straightCheck[i] = 0;
            }
        }
        else {
            win = 1;
            for (int i = 0; i < 13; i++) {
                cardType[i] = 0;
                cardTypeCheck[i] = 0;
                Straight[i] = 0;
                straightCheck[i] = 0;
            }
            //Sets the straight checker variables back to zero, so they do not misscheck on future rounds of the game.
            for (int i = 0; i < 13; i++) {
                Straight[i] = 0;
                straightCheck[i] = 0;
            }
        }
    }

    public static void isFlushCheck() {
        int p1 = Gameboard.deck.get(0);
        int p2 = Gameboard.deck.get(1);
        int r1 = Gameboard.deck.get(2);
        int r2 = Gameboard.deck.get(3);
        int r3 = Gameboard.deck.get(4);
        int r4 = Gameboard.deck.get(5);
        int r5 = Gameboard.deck.get(6);
        //Checks for heart flush
        if (p1 < 14) {
            heart++;
            HCheck++;
        }
        if (p2 < 14) {
            heart++;
            HCheck++;
        }
        if (r1 < 14) {
            heart++;
        }
        if (r2 < 14) {
            heart++;
        }
        if (r3 < 14) {
            heart++;
        }
        if (r4 < 14) {
            heart++;
        }
        if (r5 < 14) {
            heart++;
        }
        if (heart < 5) {
            heart = 0;
            HCheck = 0;

        }

        //check for club flush
        if (p1 > 13 && p1 < 27) {
            club++;
            CCheck++;
        }
        if (p2 > 13 && p2 < 27) {
            club++;
            CCheck++;
        }
        if (r1 > 13 && r1 < 27) {
            club++;
        }
        if (r2 > 13 && r2 < 27) {
            club++;
        }
        if (r3 > 13 && r3 < 27) {
            club++;
        }
        if (r4 > 13 && r4 < 27) {
            club++;
        }
        if (r5 > 13 && r5 < 27) {
            club++;
        }
        if (club < 5) {
            club = 0;
            CCheck = 0;
        }

        //check for spades flush
        if (p1 > 26 && p1 < 40) {
            spade++;
            SCheck++;
        }
        if (p2 > 26 && p2 < 40) {
            spade++;
            SCheck++;
        }
        if (r1 > 26 && r1 < 40) {
            spade++;
        }
        if (r2 > 26 && r2 < 40) {
            spade++;
        }
        if (r3 > 26 && r3 < 40) {
            spade++;
        }
        if (r4 > 26 && r4 < 40) {
            spade++;
        }
        if (r5 > 26 && r5 < 40) {
            spade++;
        }
        if (spade < 5) {
            spade = 0;
            SCheck = 0;

        }

        //check for diamonds flush
        if (p1 > 39 && p1 < 53) {
            diamond++;
            DCheck++;
        }
        if (p2 > 39 && p2 < 53) {
            diamond++;
            DCheck++;
        }
        if (r1 > 39 && r1 < 53) {
            diamond++;
        }
        if (r2 > 39 && r2 < 53) {
            diamond++;
        }
        if (r3 > 39 && r3 < 53) {
            diamond++;
        }
        if (r4 > 39 && r4 < 53) {
            diamond++;
        }
        if (r5 > 39 && r5 < 53) {
            diamond++;
        }
        if (diamond < 5) {
            diamond = 0;
            DCheck = 0;
        }

    }

    public static boolean isFLush() {
        isFlushCheck();

        if (club > 4 && CCheck > 0) {
            return true;
        }
        if (heart > 4 && HCheck > 0) {
            return true;
        }
        if (spade > 4 && SCheck > 0) {
            return true;
        }
        if (diamond > 4 && DCheck > 0) {
            return true;
        }
        return false;
    }

    //Checks what the river and player cards are. For loops help save hundreds of lines of code.
    public static void gameHand(){
        int r1 = Gameboard.deck.get(2);
        int r2 = Gameboard.deck.get(3);
        int r3 = Gameboard.deck.get(4);
        int r4 = Gameboard.deck.get(5);
        int r5 = Gameboard.deck.get(6);
        int p1 = Gameboard.deck.get(0);
        int p2 = Gameboard.deck.get(1);
        Integer[] Card = {p1, p2};
        Integer[] RCard = {r1,r2,r3,r4,r5};
        for (int j = 0; j < 5; j++) {
            for (int i = 0; i < 4; i++) {
                if (RCard[j] == Two[i]) {
                    cardType[0]++;
                    Straight[0]++;
                }
                //Checks for three pairs
                if (RCard[j] == Three[i]) {
                    cardType[1]++;
                    Straight[1]++;
                }
                //Checks for four pairs
                if (RCard[j] == Four[i]) {
                    cardType[2]++;
                    Straight[2]++;
                }
                //Checks for five pairs
                if (RCard[j] == Five[i]) {
                    cardType[3]++;
                    Straight[3]++;
                }
                //Checks for six pairs
                if (RCard[j] == Six[i]) {
                    cardType[4]++;
                    Straight[4]++;
                }
                //Checks for seven pairs
                if (RCard[j] == Seven[i]) {
                    cardType[5]++;
                    Straight[5]++;
                }
                //Checks for eight pairs
                if (RCard[j] == Eight[i]) {
                    cardType[6]++;
                    Straight[6]++;
                }
                //Checks for nine pairs
                if (RCard[j] == Nine[i]) {
                    cardType[7]++;
                    Straight[7]++;
                }
                //Checks for ten pairs
                if (RCard[j] == Ten[i]) {
                    cardType[8]++;
                    Straight[8]++;
                }
                //Checks for jack pairs
                if (RCard[j] == Jack[i] ) {
                    cardType[9]++;;
                    Straight[9]++;
                }
                //Checks for queen pairs
                if (RCard[j] == Queen[i]) {
                    cardType[10]++;
                    Straight[10]++;
                }
                //Checks for king pairs
                if (RCard[j] == King[i]) {
                    cardType[11]++;
                    Straight[11]++;
                }
                //Checks for Ace pairs
                if (RCard[j] == Ace[i]) {
                    cardType[12]++;
                    Straight[12]++;
                }
            }
        }
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < 4; i++) {
                //Checks for two pairs
                if (Card[j] == Two[i]) {
                    cardType[0]++;
                    cardTypeCheck[0]++;
                    Straight[0]++;
                    straightCheck[0]++;
                }
                //Checks for three pairs
                if (Card[j] == Three[i]) {
                    cardType[1]++;
                    cardTypeCheck[1]++;
                    Straight[1]++;
                    straightCheck[1]++;
                }
                //Checks for four pairs
                if (Card[j] == Four[i]) {
                    cardType[2]++;
                    cardTypeCheck[2]++;
                    Straight[2]++;
                    straightCheck[2]++;
                }
                //Checks for five pairs
                if (Card[j] == Five[i]) {
                    cardType[3]++;
                    cardTypeCheck[3]++;
                    Straight[3]++;
                    straightCheck[3]++;
                }
                //Checks for six pairs
                if (Card[j] == Six[i]) {
                    cardType[4]++;
                    cardTypeCheck[4]++;
                    Straight[4]++;
                    straightCheck[4]++;
                }
                //Checks for seven pairs
                if (Card[j] == Seven[i]) {
                    cardType[5]++;
                    cardTypeCheck[5]++;
                    Straight[5]++;
                    straightCheck[5]++;
                }
                //Checks for eight pairs
                if (Card[j] == Eight[i]) {
                    cardType[6]++;
                    cardTypeCheck[6]++;
                    Straight[6]++;
                    straightCheck[6]++;
                }
                //Checks for nine pairs
                if (Card[j] == Nine[i]) {
                    cardType[7]++;
                    cardTypeCheck[7]++;
                    Straight[7]++;
                    straightCheck[7]++;
                }
                //Checks for ten pairs
                if (Card[j] == Ten[i]) {
                    cardType[8]++;
                    cardTypeCheck[8]++;
                    Straight[8]++;
                    straightCheck[8]++;
                }
                //Checks for jack pairs
                if (Card[j] == Jack[i] ) {
                    cardType[9]++;
                    cardTypeCheck[9]++;
                    Straight[9]++;
                    straightCheck[9]++;
                }
                //Checks for queen pairs
                if (Card[j] == Queen[i]) {
                    cardType[10]++;
                    cardTypeCheck[10]++;
                    Straight[10]++;
                    straightCheck[10]++;
                }
                //Checks for king pairs
                if (Card[j] == King[i]) {
                    cardType[11]++;
                    cardTypeCheck[11]++;
                    Straight[11]++;
                    straightCheck[11]++;
                }
                //Checks for Ace pairs
                if (Card[j] == Ace[i]) {
                    cardType[12]++;
                    cardTypeCheck[12]++;
                    Straight[12]++;
                    straightCheck[12]++;
                }
            }
        }

        //These if statments make sure to set the checks variables back to zero, if they do meet the pair or higher threshold.
        //Not using these means the check will result in the variables incrementing on every call button click giving wrong a wrong hand evaluation.
        for (int i = 0; i < 13; i++) {
            if (cardType[i] <= 1) {
                cardType[i] = 0;
                cardTypeCheck[i] = 0;
            }
        }
    }
    // Checks to see if a pair is found within user and river cards.
    // The Check varaiables are for making sure the player has that card in their hand.
    public static void isPair() {
        gameHand();
        for (int i = 0; i < 13; i++) {
            if (cardType[i] == 2 && cardTypeCheck[i] > 0) {
                pair++;
            }
        }

        // Checks to see if a three of kind is found within user and river cards.
        // The Check varaiables are for making sure the player has that card in their hand.
        for (int i = 0; i < 13; i++) {
            if (cardType[i] == 3 && cardTypeCheck[i] > 0) {
                threeKind++;
            }
        }
        // Checks to see if a four of kind is found within user and river cards.
        // The Check varaiables are for making sure the player has that card in their hand.
        for (int i = 0; i < 13; i++) {
            if (cardType[i] == 4 && cardTypeCheck[i] > 0) {
                fourKind++;
            }
        }
    }
    // Checks to see if a straight is found within user and river cards.
    // The Check varaiables are for making sure the player has that card in their hand.
    public static void isStraight(){
        gameHand();
        for (int i = 0; i < 8; i++){
            if ((Straight[i] > 0 && Straight[i + 1] > 0 && Straight[i + 2] > 0 && Straight[i + 3] > 0 && Straight[i + 4] > 0) && (straightCheck[i] > 0 || straightCheck[i + 1] >= 0 || straightCheck[i + 2] > 0 || straightCheck[i + 3] > 0 || straightCheck[i + 4] > 0)) {
                straight = 1;
            }
        }
        //Checks for the straight but with the Ace being a 1.
        if((Straight[12] > 0 && Straight[0] > 0 && Straight[1] > 0 && Straight[2] > 0 && Straight[3] > 0 ) && (straightCheck[13] > 0 && straightCheck[0] > 0 || straightCheck[1] > 0 || straightCheck[2] > 0 || straightCheck[3] > 0)){
            straight = 1;
        }
        //Checks for Royale Flush.
        if((Straight[8] > 0 && Straight[9] > 0 && Straight[10] > 0 && Straight[11] > 0 && Straight[12] >0) && (straightCheck[8] > 0 && straightCheck[9] > 0 || straightCheck[10] > 0 || straightCheck[11] > 0 || straightCheck[12] > 0)){
            royaleFlush = 1;
            straight = 1;
        }
    }

}



