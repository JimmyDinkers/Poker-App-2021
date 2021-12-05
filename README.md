# Poker-App-2021 -- Mobile App Development (Dr. Porter): Fall 2021.
The app is a varaint of Texas Hold'em poker with a few different rules. 
<ol>
  <li>The raise is always set to 500 for the player.</li>
  <li>Tie hands will be split the pot between the bot and player. The higher card does not matter in these hands.</li>
  <li>This app is meant to be played landscape mode at all times. The orientation is set in the manifest file. </li>
  <li>The hand strength is still the same as traditional poker. <em> See link for hand strength tier list </em>(https://www.telegraph.co.uk/betting/casino-guides/poker/hand-rankings-chart-cheat-sheet/)</li>
  <li>Wait for the Toast pop-up messages after you perform an action with the buttons to see if the bot raises, calls, or folds. A message will also display if you won the round or game.</li>
  <li>The bot will always start as the dealer when a new game is created. The dealer will then switch between the player and bot for future rounds in that same game. </li>
  <li>There is a built in <em> How to Play </em> menu option at the home screen of the app which contains information and the rules of the game.</li> 
</ol>

### Back-End Code Information:
This app contains 5 java classes. 
<ul> 
  <li><strong> Gameboard: </strong> The Controller of our App. This sets the cards ImageViews in the actual gameboard activity. It also updates and resets the river when the call and raise button are clicked. It updates and shuffles the deck for every new round and game. This class also contains the basic logic behind the bots decision making. Finally, it will pass the variables from the HandCheck class to see who won the round and display the message. </li>  
  <li><strong> HandCheck:</strong> The Model of our App. This uses many arrays and for loops to check for the hand combos in the poker games. It will save the <code>Win</code> variable with a number 1-10 depending on the combo. This will be used for the Gameboard class. </li>  
  <li><strong> HandCheckBot: </strong>Does the same thing as the other HandCheck class but does it for the bot's cards. </li>  
  <li><strong> HelpActivity: </strong> Basic screen with information and rules of the game.</li>
  <li><strong> MainActivity: </strong> The home screen of the app. Contains the two buttons, Play and How to Play. These button will bring to the gameboard activity and help activity, respectively. </li>
</ul>

The View portion of our app has three XML files for the three different activities in the app, Main, Help, and Gameboard.
