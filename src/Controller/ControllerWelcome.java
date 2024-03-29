package Controller;

import Model.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controller of the welcomeGame.fxml
 **/
public class ControllerWelcome  {

    //////////////////////////// ATTRIBUTES /////////////////////////////
	@FXML ToggleButton play;
	@FXML ToggleButton rules;
	@FXML ToggleButton quit;
	/* indicates which button [play, rules, quit] is selected */
	private int cursorButton = 1;
	
	@FXML Pane pane;
    @FXML Text bestScoreText;
    private Score score;

    
    //////////////////////////// METHODS /////////////////////////////
	public Score getScore() { return score; }
	public void setScore(Score scoreMax) { this.score = scoreMax; }

    /**
     * setBestScoreText(): display the best score of the player
     * @param score String, the final score of the player
     */
    public void setBestScoreText(String score) {
        this.bestScoreText.setText(score);
    }
        
    @FXML public void start(KeyEvent k) throws IOException {
        Stage primaryStage = (Stage) pane.getScene().getWindow();
                
    	if(k.getCode().equals(KeyCode.UP)) {
    		if(cursorButton == 1) { //if the cursor is on the play button
    			play.setSelected(true);
    			rules.setSelected(false);
    			quit.setSelected(false);
        		play.setStyle("-fx-background-color: transparent; -fx-border-color: orange;");
        		rules.setStyle("-fx-background-color: transparent;");
        		quit.setStyle("-fx-background-color: transparent;");
    		}else if(cursorButton == 2) { //if the cursor is on the rules button
    			cursorButton = 1;
    			play.setSelected(true);
    			rules.setSelected(false);
    			quit.setSelected(false);
        		play.setStyle("-fx-background-color: transparent; -fx-border-color: orange;");
        		rules.setStyle("-fx-background-color: transparent;");
        		quit.setStyle("-fx-background-color: transparent;");
    		}else if(cursorButton == 3){ //if the cursor is on the quit button
    			cursorButton = 2;
    			play.setSelected(false);
    			rules.setSelected(true);
    			quit.setSelected(false);
	    		play.setStyle("-fx-background-color: transparent;");
	    		rules.setStyle("-fx-background-color: transparent; -fx-border-color: orange;");
	    		quit.setStyle("-fx-background-color: transparent;");
    		}
    	}else if(k.getCode().equals(KeyCode.DOWN)) {
    		if(cursorButton == 1) { //if the cursor is on the play button
    			cursorButton = 2;
    			play.setSelected(false);
    			rules.setSelected(true);
    			quit.setSelected(false);
	    		play.setStyle("-fx-background-color: transparent;");
	    		rules.setStyle("-fx-background-color: transparent; -fx-border-color: orange;");
	    		quit.setStyle("-fx-background-color: transparent;");
    		}else if(cursorButton == 2){ //if the cursor is on the rules button
    			cursorButton = 3;
    			play.setSelected(false);
    			rules.setSelected(false);
    			quit.setSelected(true);
        		play.setStyle("-fx-background-color: transparent;");
        		rules.setStyle("-fx-background-color: transparent;");
        		quit.setStyle("-fx-background-color: transparent; -fx-border-color: orange;");
    		}else if(cursorButton == 3) { //if the cursor is on the quit button
    			play.setSelected(false);
    			rules.setSelected(false);
    			quit.setSelected(true);
        		play.setStyle("-fx-background-color: transparent;");
        		rules.setStyle("-fx-background-color: transparent;");
        		quit.setStyle("-fx-background-color: transparent; -fx-border-color: orange;");
    		}

    	}else if(k.getCode().equals(KeyCode.ENTER)) {
    		if(play.isSelected()) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXML/level1.fxml"));
                Pane paneLevel1 = loader.load();

                Scene sceneLevel1 = new Scene(paneLevel1, paneLevel1.getPrefWidth(), paneLevel1.getPrefHeight());
                sceneLevel1.getRoot().requestFocus();

				ControllerLevel controllerLevel = loader.getController();
                controllerLevel.setStage(primaryStage);
                controllerLevel.setPane(paneLevel1);
                controllerLevel.setPlayer(new Player(controllerLevel.imagePlayer));
                controllerLevel.setListRemainingLife();
                controllerLevel.setListRemainingMunition();
                controllerLevel.setListViruses();

				// start the animation of the game play
				Animation animation = new Animation(pane.getPrefWidth(), pane.getPrefHeight(),
                        controllerLevel, paneLevel1,"../Images/jet_lv1.png", score);
                animation.start();

                primaryStage.setScene(sceneLevel1);
                primaryStage.show();
                
    		}else if(rules.isSelected()) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXML/rulesGame.fxml"));
                Pane myPane = loader.load();

                Scene myScene = new Scene(myPane, myPane.getPrefWidth(),myPane.getPrefHeight());
                myScene.getRoot().requestFocus();

                primaryStage.setScene(myScene);
                primaryStage.show();
    		}else if(quit.isSelected()) {
                primaryStage.close();
    		}
    	}
    }
}