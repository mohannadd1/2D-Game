package view;



import engine.Game;
import exceptions.InvalidTargetException;
import exceptions.MovementException;
import exceptions.NoAvailableResourcesException;
import exceptions.NotEnoughActionsException;
import model.characters.*;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Scene;
import model.collectibles.*;
import model.world.CharacterCell;
import model.world.CollectibleCell;
import model.world.TrapCell;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import javafx.animation.PauseTransition;  
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.stage.Popup;
public class Scene3 extends Scene{
	private Hero h;
	
	
	public Scene3(Stage window,BorderPane root3 , Hero startHero) {
		
		
		super(root3,1280,720);
		h=startHero;
		this.getStylesheets().add(this.getClass().getResource("HeroInfo.css").toExternalForm());
		this.getStylesheets().add(this.getClass().getResource("map.css").toExternalForm());
		//map
		GridPane map = new GridPane();
		UpdateVis(map,window);


		

		BorderPane border = new BorderPane();
		
		StackPane stack = new StackPane();
		Rectangle rect= new Rectangle(0,0,560,720);
		
		root3.setLeft(map);
		root3.setCenter(border);

		rect.setFill(Color.rgb(40, 80, 40));
		//rect.setArcHeight(85);
		//rect.setArcWidth(85);
		stack.getChildren().add(rect);
		GridPane heroinfo = new GridPane();
		
		heroinfo.setPadding(new Insets(10));
		heroinfo.setHgap(10);
		heroinfo.setVgap(10);
		heroinfo.setAlignment(Pos.TOP_LEFT);
		stack.getChildren().add(heroinfo);

		border.setCenter(stack);
		//to do

		UpdateHeros(map,heroinfo);
		
		
		// GAMEWIN window 
		
	
		
	
		
		Stage GameWinStage = new Stage();
	//	GWbutton.setOnAction(e -> GameWinStage.showAndWait());
		GameWinStage.initModality(Modality.APPLICATION_MODAL);
		GameWinStage.initStyle(StageStyle.UTILITY);
		GameWinStage.setTitle("GAME WIN");
		GameWinStage.setHeight(600);
		GameWinStage.setWidth(1024);
	
		ImageView GameWinView = new ImageView(new Image("YouWin.jpg"));
		StackPane GameWinRoot =new StackPane();
		Scene GameWinScene = new Scene(GameWinRoot); 
		
		
		Text wintext =new Text("GAME WIN");
		wintext.setId("fancytext");
		
		Button clseButton = new Button("Close"); 
		clseButton.setPrefSize(100, 60);
		clseButton.setOnAction(e-> Platform.exit());
		
		StackPane.setAlignment(clseButton,Pos.BOTTOM_RIGHT);
		GameWinRoot.getChildren().add(GameWinView);
		GameWinRoot.getChildren().add(clseButton);
		GameWinRoot.getChildren().add(wintext);
		GameWinStage.setResizable(false);
		GameWinStage.setScene(GameWinScene);
		
		// GAMEOVER window
	
		
		Stage GameOverStage = new Stage();
	//	GObutton.setOnAction(e -> GameOverStage.showAndWait());
		GameOverStage.initModality(Modality.APPLICATION_MODAL);
		GameOverStage.initStyle(StageStyle.UNDECORATED);
		GameOverStage.setTitle("GAME OVER");
		GameOverStage.setHeight(650);
		GameOverStage.setWidth(1019);
	
		ImageView GameOverView = new ImageView(new Image("GameOverZombie.png"));
		StackPane GameOverRoot =new StackPane();
		Scene GameOverScene = new Scene(GameOverRoot); 
		GameOverScene.getStylesheets().add(getClass().getResource("HeroInfo.css").toExternalForm());
		
	
		Button closeButton = new Button("Close"); 
		closeButton.setPrefSize(100, 60);
		closeButton.setOnAction(e-> Platform.exit());
		closeButton.setId("close");
		
		StackPane.setAlignment(closeButton,Pos.BOTTOM_RIGHT);
		GameOverRoot.getChildren().add(GameOverView);
		GameOverRoot.getChildren().add(closeButton);
		GameOverStage.setResizable(false);
		GameOverStage.setScene(GameOverScene);
		
		
	
		// HowToPlay
		Button openButton =  new Button("",new ImageView(new Image("info.png")));
		openButton.setId("info");
		openButton.setMinSize(50, 50);
		openButton.setMaxSize(50, 50);
		stack.getChildren().add(openButton);
		
		StackPane.setAlignment(openButton,Pos.BOTTOM_RIGHT); 
		
		Stage HowStage = new Stage();
		openButton.setOnAction(e -> HowStage.showAndWait());
		HowStage.initModality(Modality.APPLICATION_MODAL);
		HowStage.initStyle(StageStyle.UTILITY);
		HowStage.setTitle("How To Play");
		HowStage.setHeight(500);
		HowStage.setWidth(500);
		HowStage.setX(HowStage.getX() + 700);
		HowStage.setY(HowStage.getY() + 500); 

		StackPane HowRoot = new StackPane();
		ImageView backgroundView = new ImageView(new Image("test.png"));

		Scene HowScene = new Scene(HowRoot, 200, 150);   

		VBox V1 = new VBox(14); 
		V1.setPadding(new Insets(10));
		for (int i = 1; i <= 8; i++) {
			Text press = new Text("Press");
			press.setFont(Font.font ("Verdana", 20));
			V1.getChildren().add(press);
		}

		VBox V2 = new VBox(5);
		V2.setPadding(new Insets(5));
		Text W = new Text("W");
		Text A = new Text("A");
		Text S = new Text("S");
		Text D = new Text("D");
		Text C = new Text("C");
		Text X = new Text("X");
		Text E = new Text("E");
		Text F = new Text("F");
		A.setFont(Font.font("Storybook", FontWeight.BOLD, 25));
		S.setFont(Font.font("Storybook", FontWeight.BOLD, 25));
		D.setFont(Font.font("Storybook", FontWeight.BOLD, 25));
		W.setFont(Font.font("Storybook", FontWeight.BOLD, 25));
		C.setFont(Font.font("Storybook", FontWeight.BOLD, 25));
		E.setFont(Font.font("Storybook", FontWeight.BOLD, 25));
		X.setFont(Font.font("Storybook", FontWeight.BOLD, 25));
		F.setFont(Font.font("Storybook", FontWeight.BOLD, 25));
		W.setFill(Color.RED);
		A.setFill(Color.RED);
		S.setFill(Color.RED);
		D.setFill(Color.RED);
		C.setFill(Color.RED);
		X.setFill(Color.RED);
		E.setFill(Color.RED);
		F.setFill(Color.RED);
		V2.getChildren().addAll(W,A,S,D,C,X,E,F);

		VBox V3 = new VBox(14);
		V3.setPadding(new Insets(10));
		Text W1 = new Text("to move UP");
		Text A1 = new Text("to move LEFT");
		Text S1 = new Text("to move DOWN");
		Text D1 = new Text("to move RIGHT");
		Text C1 = new Text("to CURE");
		Text X1 = new Text("to USE SPECIALIST");
		Text E1 = new Text("to END TURN");
		Text F1 = new Text("to Attack");
		W1.setFont(Font.font ("Verdana", 20));
		A1.setFont(Font.font ("Verdana", 20));
		S1.setFont(Font.font ("Verdana", 20));
		D1.setFont(Font.font ("Verdana", 20));
		C1.setFont(Font.font ("Verdana", 20));
		X1.setFont(Font.font ("Verdana", 20));
		E1.setFont(Font.font ("Verdana", 20));
		F1.setFont(Font.font ("Verdana", 20));
		V3.getChildren().addAll(W1,A1,S1,D1,C1,X1,E1,F1);

		HBox movement=new HBox();
		movement.setPadding(new Insets(5));
		movement.getChildren().addAll(V1,V2,V3);

		HowRoot.getChildren().add(backgroundView);	
		HowRoot.getChildren().add(movement);
		StackPane.setAlignment(movement,Pos.TOP_LEFT);
		

		HowStage.setResizable(false);
		HowStage.setScene(HowScene);
		
		





		//keyboardActions
	
		
		
		
		
		Label label = new Label("This is a Popup");
		   
        // create a popup
        Popup popup = new Popup();
   
        // set background
        label.setStyle(" -fx-background-color: white;");
   
        // add the label
        popup.getContent().add(label);
   
        // set size of label
        label.setMinWidth(80);
        label.setMinHeight(50);
        PauseTransition delay = new PauseTransition(Duration.seconds(1));
        delay.setOnFinished(e -> popup.hide());

       
      
		
		root3.setOnKeyPressed(e->{
			if(e.getCode()==KeyCode.E) {
				try {
					Game.endTurn();
					if(Game.checkWin()) {
						GameWinStage.showAndWait();
					}
					if(Game.checkGameOver()) {
						 GameOverStage.showAndWait();
					}
				
					UpdateVis(map,window);
					UpdateHeros(map,heroinfo);

				} catch (NotEnoughActionsException e1) {
					// TODO Auto-generated catch block
					label.setText(e1.getMessage());
					popup.show(window,900,600);
					  delay.play();
					e1.printStackTrace();
				} catch (InvalidTargetException e1) {
					label.setText(e1.getMessage());
					popup.show(window,900,600);
					  delay.play();
					e1.printStackTrace();
				}
			}


			else if(e.getCode()==KeyCode.F) {
				try {
					h.attack();
				
					UpdateVis(map,window);
					UpdateHeros(map,heroinfo);

	
				} catch (NotEnoughActionsException e1) {
					// TODO Auto-generated catch block
					label.setText("You need at least 1 action point in order to move.");
					popup.show(window,-200,-600);
					  delay.play();
					e1.printStackTrace();
				} catch (InvalidTargetException e1) {
					label.setText(e1.getMessage());
					popup.show(window,900,600);
					  delay.play();
					
					e1.printStackTrace();
				}
				
			}else if(e.getCode()==KeyCode.C) {
				try {
					h.cure();
					UpdateHeros(map,heroinfo);
					UpdateVis(map,window);
				} catch (NoAvailableResourcesException e1) {
					label.setText(e1.getMessage());
					popup.show(window,900,600);
					  delay.play();
					e1.printStackTrace();
				} catch (InvalidTargetException e1) {
					label.setText(e1.getMessage());
					popup.show(window,900,600);
					  delay.play();
					e1.printStackTrace();
				} catch (NotEnoughActionsException e1) {
					label.setText("You need at least 1 action point in order to move.");
					popup.show(window,900,600);
					  delay.play();
					e1.printStackTrace();
				}
			}else if(e.getCode()==KeyCode.X) {
				try {
					h.useSpecial();
					UpdateVis(map,window);
					UpdateHeros(map,heroinfo);
				} catch (NoAvailableResourcesException e1) {
					label.setText(e1.getMessage());
					popup.show(window,900,600);
					  delay.play();
					e1.printStackTrace();
				} catch (InvalidTargetException e1) {
					label.setText(e1.getMessage());
					popup.show(window,900,600);
					  delay.play();
					e1.printStackTrace();
				}
			}else if(e.getCode()==KeyCode.W) {
				try {

					h.move(Direction.UP);
					UpdateVis(map,window);
					UpdateHeros(map,heroinfo);
				} catch (MovementException e1) {
					label.setText(e1.getMessage());
					popup.show(window,900,600);
					  delay.play();
					e1.printStackTrace();
				} catch (NotEnoughActionsException e1) {
					// TODO Auto-generated catch block
					label.setText(e1.getMessage());
					popup.show(window,900,600);
					  delay.play();
					e1.printStackTrace();
				}
			}else if(e.getCode()==KeyCode.S) {
				try {
					h.move(Direction.DOWN);
					UpdateVis(map,window);
					UpdateHeros(map,heroinfo);
				} catch (MovementException e1) {
					label.setText(e1.getMessage());
					popup.show(window,900,600);
					  delay.play();
					e1.printStackTrace();
				} catch (NotEnoughActionsException e1) {
					// TODO Auto-generated catch block
					label.setText(e1.getMessage());
					popup.show(window,900,600);
					  delay.play();
					e1.printStackTrace();
				}
			}
			else if(e.getCode()==KeyCode.D) {
				try {
					h.move(Direction.RIGHT);
					UpdateVis(map,window);
					UpdateHeros(map,heroinfo);
				} catch (MovementException e1) {
					label.setText(e1.getMessage());
					popup.show(window,900,600);
					  delay.play();
					e1.printStackTrace();
				} catch (NotEnoughActionsException e1) {
					// TODO Auto-generated catch block
					label.setText(e1.getMessage());
					
					popup.show(window,900,600);
					  delay.play();
					e1.printStackTrace();	
				}
			}
			else if(e.getCode()==KeyCode.A) {
				try {
					h.move(Direction.LEFT);
					UpdateVis(map,window);
					UpdateHeros(map,heroinfo);
				} catch (MovementException e1) {
					label.setText(e1.getMessage());
					popup.show(window,900,600);
					  delay.play();
					e1.printStackTrace();
				} catch (NotEnoughActionsException e1) {
					// TODO Auto-generated catch block
					label.setText(e1.getMessage());
					popup.show(window,900,600);
					  delay.play();
					e1.printStackTrace();
				}
			}
		});
	//	System.out.print(startHero.getCurrentHp());




		//	sideroot.setBottom(actions);

		//map



	}
	public void UpdateHeros(GridPane map, GridPane heroinfo) {
		for(int i=0;i<Game.heroes.size();i++) {


			Hero xy = Game.heroes.get(i);
			Button HeroInfo = new Button("Name:"+xy.getName()+"\n"+"Type: "+ xy.getClass().getSimpleName()  +"\n"+"Current HP: " +xy.getCurrentHp() +
					"\n"+"Attack Damage: "+ xy.getAttackDmg() +"\n"+ "Actions Points: "+xy.getActionsAvailable()+"/"+xy.getMaxActions()+"\n"+ "Supplies:"+ xy.getSupplyInventory().size()+
					"\n"+"Vaccines: "+xy.getVaccineInventory().size());
			HeroInfo.setId("HeroInfo");
			
			if(xy.getCurrentHp()==0) {
				heroinfo.getChildren().remove(HeroInfo);
			}else {
			
			heroinfo.add(HeroInfo, i / 2, i % 2);
			}
			final int index =i;
			HeroInfo.setOnAction(e->{
				h = Game.heroes.get(index);
				
			});
		
			

		}
		
		
	

	}
	public void UpdateVis(GridPane map,Stage window) {
		Label label = new Label("This is a Popup");
		   
        // create a popup
        Popup popup = new Popup();
   
        // set background
        label.setStyle(" -fx-background-color: white;");
   
        // add the label
        popup.getContent().add(label);
   
        // set size of label
        label.setMinWidth(80);
        label.setMinHeight(50);
        PauseTransition delay = new PauseTransition(Duration.seconds(1));
        delay.setOnFinished(e -> popup.hide());

		
	
		for (int row = 0; row < 15; row++) {
			for (int col = 0; col < 15; col++) {
				Button tile = new Button();
				tile.setId("map");
			
			 
				tile.setMinSize(48, 48);
				tile.setMaxSize(48, 48);
				if(!(Game.map[14-row][col].isVisible())) {
					tile.setStyle("-fx-background-color:#b6b6b6");
				}
				
				if(Game.map[14-row][col].isVisible()) {
					tile.setStyle("-fx-background-color:#00bb00 ");
				
				if(Game.map[14-row][col] instanceof CharacterCell) {
					
					if(((CharacterCell) Game.map[14-row][col]).getCharacter() != null) {
						CharacterCell c =(CharacterCell) Game.map[14-row][col];
						tile.setOnAction(e -> {
							h.setTarget(c.getCharacter());
						});	
					}
					
					 
					if(((CharacterCell) Game.map[14-row][col]).getCharacter() instanceof Hero){
						//tile.setFill(Color.GREEN);
						tile.setStyle("-fx-background-color: #00bb00; ");
						Image chr = new Image(((CharacterCell) Game.map[14-row][col]).getCharacter().getName()+"Icon.png");
						tile.setGraphic(new ImageView (chr));

					}
					else if (((CharacterCell) Game.map[14-row][col]).getCharacter() instanceof Zombie ){
					
						Image chr = new Image("ZombieIcon.png");
						tile.setGraphic(new ImageView (chr));
						Tooltip tooltip = new Tooltip("Health:  " +((CharacterCell) Game.map[14-row][col]).getCharacter().getCurrentHp() );
		                 Tooltip.install(tile,tooltip);
					}
				}
				else if(Game.map[14-row][col] instanceof CollectibleCell) {
					if(((CollectibleCell) Game.map[14-row][col]).getCollectible() instanceof Vaccine ){
						//tile.setFill(Color.GREEN);
						Image chr = new Image("medkitIcon.png");
						tile.setGraphic(new ImageView (chr));

					} else if(((CollectibleCell) Game.map[14-row][col]).getCollectible() instanceof Supply ){
						//tile.setFill(Color.GREEN);
						Image chr = new Image("SupplyIcon.png");
						tile.setGraphic(new ImageView (chr));
					} 
					
					
					
					}
				else if(Game.map[14-row][col] instanceof TrapCell) {
				//toDO
					
					label.setText("You Are In A TrapCell!");
					popup.show(window,900,600);
					  delay.play();
				
					
					
					
				}
				}else {
					tile.setStyle("-fx-background-color: #6f0000 ");
					
				}


				GridPane.setRowIndex(tile, row);
				GridPane.setColumnIndex(tile, col);
				map.getChildren().add(tile);
			}
		}

	}

	



	

}
