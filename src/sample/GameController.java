package sample;
/** Sample Skeleton for 'sample.fxml' Controller Class */
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.util.Random;

public class GameController {

  private int gamesLostCount;
  private int gamesTiedCount;
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

  @FXML
  void playRockPaperScissors(MouseEvent event) {
    setComputerChoice();
    String gameResult = determineWinner();
    winnerLabel.setText(gameResult);
    updateScorecard(gameResult);
  }

  private String determineWinner() {

    if ((playerRockButton.isSelected() && computerRockButton.isSelected())
        || (playerPaperButton.isSelected() && computerPaperButton.isSelected())
        || (playerScissorsButton.isSelected() && computerScissorsButton.isSelected())) {
      setGamesTiedCount(getGamesTiedCount() + 1);
      winnerLabel.setText("TIE GAME");
      return "Tied Game";
    } else if ((playerRockButton.isSelected() && computerScissorsButton.isSelected())
        || (playerPaperButton.isSelected() && computerRockButton.isSelected())
        || (playerScissorsButton.isSelected() && computerScissorsButton.isSelected())) {
      setGamesLostCount(getGamesWonCount() + 1);
      winnerLabel.setText("Player Wins");
      return "Player Wins";

    } else {
      setGamesLostCount(getGamesLostCount() + 1);
      winnerLabel.setText("Player Loses");
      return "Player Loses";
    }
  }

  private void setComputerChoice() {
    Random randomGenerator = new Random();
    int randomNumber = randomGenerator.nextInt(8);
    if (randomNumber <= 2) {
      computerRockButton.setSelected(true);
    } else if (randomNumber <= 5) {
      computerPaperButton.setSelected(true);
    } else {
      computerScissorsButton.setSelected(true);
    }
  }

  private void updateScorecard(String gameResult) {
    if (gameResult.equals("Tied Game")) {
      tiedGamesLabel.setText(String.valueOf(getGamesTiedCount()) + " Ties");
    } else if (gameResult.equals("Player Wins")) {
      gamesWonLabel.setText(String.valueOf(getGamesWonCount()) + " Wins");
    } else {

      lostGamesLabel.setText(String.valueOf(getGamesLostCount()) + " Losses");
    }
  }

  public int getGamesLostCount() {
    return gamesLostCount;
  }

  public void setGamesLostCount(int gamesLostCount) {
    this.gamesLostCount = gamesLostCount;
  }

  public int getGamesTiedCount() {
    return gamesTiedCount;
  }

  public void setGamesTiedCount(int gamesTiedCount) {
    this.gamesTiedCount = gamesTiedCount;
  }

  public int getGamesWonCount() {
    return gamesWonCount;
  }

  public void setGamesWonCount(int gamesWonCount) {
    this.gamesWonCount = gamesWonCount;
  }
}
