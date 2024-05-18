package view;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Scene1 extends Scene{

	public Scene1(Stage window,StackPane root) {
		super(root,1280,720);
		this.getStylesheets().add(this.getClass().getResource("application.css").toExternalForm());
		
		Image icon = new Image("icon.png");
		window.setTitle("The Last Of Us");
		window.getIcons().add(icon);
		// scene 1
		Image backgroundImage = new Image("LoadingScreenResized.jpg");
		Image Logo = new Image("Logo.png");
	
		
		ImageView backgroundView = new ImageView(backgroundImage);
		ImageView LogoView = new ImageView(Logo);

		VBox btns = new VBox(10);
		btns.setAlignment(Pos.CENTER);
		btns.setTranslateY(130);
		ImageView playView = new ImageView(new Image("LogoStart.png"));
		ImageView exitView = new ImageView(new Image("exitlogo.png"));
		Button playButton = new Button("       START GAME",playView);
		
		playButton.setAlignment(Pos.CENTER_LEFT);
		playButton.setTextAlignment(TextAlignment.CENTER);
		playButton.setFont(Font.font("Arial",FontWeight.BOLD,25));
		playButton.setPrefWidth(300);
		Button exitButton = new Button("Exit",exitView);
		btns.getChildren().addAll(playButton,exitButton);

		StackPane.setAlignment(btns, Pos.CENTER);
		
		root.getChildren().add(backgroundView);
		root.getChildren().add(LogoView);
		StackPane.setAlignment(LogoView,Pos.TOP_CENTER);
		playButton.setOnAction(e ->window.setScene(new Scene2(window,new StackPane())));
		exitButton.setOnAction(e ->Platform.exit());
		StackPane.setMargin(playButton, new Insets(0, 0, 60, 0));
		StackPane.setMargin(exitButton, new Insets(0, 0, 20, 0));


		root.getChildren().addAll(btns);
		// TODO Auto-generated constructor stub
	}

}
