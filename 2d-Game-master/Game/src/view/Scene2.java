package view;

import java.io.IOException;

import engine.Game;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.characters.Hero;
import javafx.scene.shape.*;


public class Scene2 extends Scene{
	private int heroIndex = 0;

	public Scene2(Stage window,StackPane root2) {
		super(root2,1280,720);
		this.getStylesheets().add(this.getClass().getResource("HeroSelection.css").toExternalForm());

		Image backgroundImage2 = new Image("scene2Option2.jpg");
		ImageView backgroundView2 = new ImageView(backgroundImage2);
		Text LoadingMenuText = new Text();
		LoadingMenuText.setText("Choose your "+"\n"+" hero!");
		
		LoadingMenuText.setFont(Font.font("Impact", FontWeight.BOLD, FontPosture.ITALIC,65));
		LoadingMenuText.setFill(Color.WHITE);



		root2.getChildren().add(backgroundView2);
		root2.getChildren().add(LoadingMenuText);

		StackPane.setAlignment(LoadingMenuText, javafx.geometry.Pos.TOP_LEFT);
		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(0, 0, 10, 10));
		gridPane.setHgap(10);
		gridPane.setVgap(10);


		
		Text info = new Text();
		Text displayName = new Text();
		displayName.setFont((Font.font("Arial",FontWeight.BOLD,25)));
		
		LoadingMenuText.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC,65));
		LoadingMenuText.setFill(Color.WHITE);
		
		info.setFont(Font.font("Arial",FontWeight.BOLD,20));
		
		info.setFill(Color.BLACK);
		info.setTranslateY(36);
		StackPane data = new StackPane();
		Rectangle rec = new Rectangle(0,0,300,380);
		rec.setTranslateY(-55);
		rec.setArcHeight(25);
		rec.setArcWidth(25);
		rec.setFill(Color.rgb(40, 80, 40));
		Rectangle img = new Rectangle(0,0,110,150);
		Rectangle imgCont = new Rectangle(0,0,85,85);
		imgCont.setTranslateY(-105);
		img.setTranslateY(-105);
		img.setFill(Color.rgb(82, 164, 82));
		img.setArcHeight(25);
		img.setArcWidth(25);
		Rectangle infobox = new Rectangle(0,0,250,150);
		infobox.setFill(Color.rgb(82, 164, 82));
		infobox.setArcHeight(40);
		infobox.setArcWidth(40);
		infobox.setTranslateY(52);
		data.getChildren().addAll(rec,img,imgCont,infobox,info,displayName);
		displayName.setTranslateY(-205);
		root2.getChildren().add(data);
		data.setVisible(false);
		StackPane.setAlignment(info, javafx.geometry.Pos.CENTER);
		Button proceed = new Button("",new ImageView(new Image("proceed.png")));
		
		

		proceed.setVisible(false);
		
		
		
		
		
		
		try {
			Game.loadHeroes("Heroes.csv");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < Game.availableHeroes.size(); i++) {
			Hero h = Game.availableHeroes.get(i);
			String name = h.getName();
			String type = h.getClass().getSimpleName();
			int maxHP = h.getMaxHp();
			int attackDamage = h.getAttackDmg();
			int maxActions = h.getMaxActions();

			Button button = new Button(name);
			button.setMaxSize(165,70);
			gridPane.setAlignment(Pos.BOTTOM_CENTER);
			gridPane.add(button, i % 2, i / 2);
			final int index = i;
			button.setOnAction(e->{
				displayName.setText(name);
				info.setText( "\n"+"Type: "+ type  +"\n"+"Max HP: " +maxHP +"\n"+"Attack Damage: "+ attackDamage +"\n"+ "Max Actions: "+maxActions);
			
				imgCont.setFill(new ImagePattern(new Image(name+"Icon.png")));
				data.setVisible(true);
				heroIndex = index;
				
				proceed.setVisible(true);  
			});

		}





		VBox hbox = new VBox(gridPane);
		hbox.setAlignment(Pos.BOTTOM_LEFT);
		root2.getChildren().add(hbox);


		proceed.setMaxSize(100, 120);
		root2.getChildren().addAll(proceed);
		StackPane.setAlignment(proceed, Pos.BOTTOM_RIGHT);
		proceed.setOnAction(e -> {
			Hero x=  Game.availableHeroes.get(heroIndex);
			Game.startGame(x);
			

			window.setScene(new Scene3(window,new BorderPane(), x));
		});
	}
}
