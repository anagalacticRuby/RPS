package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import java.util.Random;

/**
 * The controller class for the Rock Paper Scissors program
 *
 * @author anagalacticRuby
 */
public class GameController {

  // A private variable that keeps count of how many games the player has lost
  private int gamesLostCount;

  // A private variable that keeps count of how many games the player has tied
  private int gamesTiedCount;

  // A private variable that keeps count of how many games the player has won
  private int gamesWonCount;

  @FXML // fx:id="playerRockButton"
  private RadioButton playerRockButton; // Value injected by FXMLLoader

  @FXML // fx:id="playerControl"
  private ToggleGroup playerControl; // Value injected by FXMLLoader

  @FXML // fx:id="playerPaperButton"
  private RadioButton playerPaperButton; // Value injected by FXMLLoader

  @FXML // fx:id="playerScissorsButton"
  private RadioButton playerScissorsButton; // Value injected by FXMLLoader

  @FXML // fx:id="playerWinstreakLabel"
  private Label playerWinstreakLabel; // Value injected by FXMLLoader

  @FXML // fx:id="battleButton"
  private Button battleButton; // Value injected by FXMLLoader

  @FXML // fx:id="computerWinstreakLabel"
  private Label computerWinstreakLabel; // Value injected by FXMLLoader

  @FXML // fx:id="gamesWonLabel"
  private Label gamesWonLabel; // Value injected by FXMLLoader

  @FXML // fx:id="lostGamesLabel"
  private Label lostGamesLabel; // Value injected by FXMLLoader

  @FXML // fx:id="tiedGamesLabel"
  private Label tiedGamesLabel; // Value injected by FXMLLoader

  @FXML // fx:id="computerRockButton"
  private RadioButton computerRockButton; // Value injected by FXMLLoader

  @FXML // fx:id="computerControl"
  private ToggleGroup computerControl; // Value injected by FXMLLoader

  @FXML // fx:id="computerPaperButton"
  private RadioButton computerPaperButton; // Value injected by FXMLLoader

  @FXML // fx:id="computerScissorsButton"
  private RadioButton computerScissorsButton; // Value injected by FXMLLoader

  @FXML // fx:id="winnerLabel"
  private Label winnerLabel; // Value injected by FXMLLoader

  /**
   * This method is tied to the 'Battle!' button, and will trigger whenever the button is pressed.
   *
   * @param event An event listener that awaits the button being clicked
   */
  @FXML
  void playRockPaperScissors(MouseEvent event) {
    setComputerChoice();
    // First, the computer decides what weapon it will select.
    // NOTE: The computer does NOT look at your input, in order to maintain a fair game.
    String gameResult = determineWinner();
    // A string is set to the value returned by determineWinner() for quick setting of the results.

    winnerLabel.setText(gameResult);
    /*
     * Once a result has been obtained, update the label in the center of the screen to display
     * the outcome obtained by determineWinner (now currently being stored in gameResult.
     */

    updateScorecard(gameResult);
    // Next, update the scorecard that rests at the top of the screen using the string stored in
    // gameResult.
  }

  /**
   * This method will check the selected options of both players and determine a winner.
   *
   * <p>After a winner is determined, the counter for the respective result is incremented by one.
   *
   * @return A string message of the game result is returned
   */
  private String determineWinner() {

    /*
     * Large conditional if-else chains are used here because the game needs to check for two things.
     * The player's choice, and the computer's choice.
     * After these two things have been obtained,
     * they are then compared to one another to determine a winner of the game.
     */
    if ((playerRockButton.isSelected() && computerRockButton.isSelected())
        || (playerPaperButton.isSelected() && computerPaperButton.isSelected())
        || (playerScissorsButton.isSelected() && computerScissorsButton.isSelected())) {
      setGamesTiedCount(getGamesTiedCount() + 1);
      winnerLabel.setText("TIE GAME");
      winnerLabel.setVisible(true);
      return "Tied Game";
    } else if ((playerRockButton.isSelected() && computerScissorsButton.isSelected())
        || (playerPaperButton.isSelected() && computerRockButton.isSelected())
        || (playerScissorsButton.isSelected() && computerPaperButton.isSelected())) {
      setGamesWonCount(getGamesWonCount() + 1);
      winnerLabel.setText("Player Wins");
      winnerLabel.setVisible(true);
      return "Player Wins";

    } else {
      setGamesLostCount(getGamesLostCount() + 1);
      winnerLabel.setText("Player Loses");
      winnerLabel.setVisible(true);
      return "Player Loses";
    }
  }

  /**
   * This method allows for the computer to have a 'fair' chance of picking any option equally.
   *
   * <p>There are only three possible options to choose from, but only one may be picked.
   */
  private void setComputerChoice() {
    Random randomGenerator = new Random();
    int randomNumber = randomGenerator.nextInt(3);
    if (randomNumber == 0) {
      computerRockButton.setSelected(true);
    } else if (randomNumber == 1) {
      computerPaperButton.setSelected(true);
    } else {
      computerScissorsButton.setSelected(true);
    }
  }

  /**
   * This method is to be run after determineWinner(), so that accurate scores are kept.
   *
   * <p>A string message is accepted as a parameter for quick and easy comparisons.
   *
   * @param gameResult A string containing the result of the most recent game that was played.
   */
  private void updateScorecard(String gameResult) {
    if (gameResult.equals("Tied Game")) {
      tiedGamesLabel.setText(getGamesTiedCount() + " Ties");
    } else if (gameResult.equals("Player Wins")) {
      gamesWonLabel.setText(getGamesWonCount() + " Wins");
    } else {
      lostGamesLabel.setText(getGamesLostCount() + " Losses");
    }
  }

  /**
   * Obtains the current count of games that the player has lost
   *
   * @return returns the count of games lost by the player as an integer
   */
  public int getGamesLostCount() {
    return gamesLostCount;
  }

  /**
   * Mutator that sets the value of the counter for games lost by the player
   *
   * @param gamesLostCount An integer value of games lost
   */
  public void setGamesLostCount(int gamesLostCount) {
    this.gamesLostCount = gamesLostCount;
  }

  /**
   * Accessor to obtain the count of games that ended in a tie
   *
   * @return returns the count of games ending in a tie
   */
  public int getGamesTiedCount() {
    return gamesTiedCount;
  }

  /**
   * Mutator that sets the value of the counter for games that ended in a tie
   *
   * @param gamesTiedCount An integer value of the games ending in a tie
   */
  public void setGamesTiedCount(int gamesTiedCount) {
    this.gamesTiedCount = gamesTiedCount;
  }

  /**
   * Accessor to obtain the count of games won by the player
   *
   * @return returns the count of games won by the player as an integer
   */
  public int getGamesWonCount() {
    return gamesWonCount;
  }

  /**
   * Mutator that sets the value of the counter for games won by the player
   *
   * @param gamesWonCount An integer value of the games won by the player
   */
  public void setGamesWonCount(int gamesWonCount) {
    this.gamesWonCount = gamesWonCount;
  }
}
