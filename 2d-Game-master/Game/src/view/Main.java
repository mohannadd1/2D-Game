package view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.layout.*;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.media.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;



import javafx.scene.paint.*;
import javafx.stage.*;
import javafx.scene.Group.*;
import javafx.scene.image.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.scene.input.KeyCombination;
import java.io.FileInputStream;
import javafx.scene.input.MouseEvent;

import javafx.geometry.*;


public class Main extends Application {
	//Stage window;
	Scene scene,scene2,scene3;

	@Override
	public void start(Stage primaryStage) throws IOException {

		primaryStage.setScene(new Scene1(primaryStage,new StackPane()));
	
		


		music();
	
		primaryStage.show();
	}
	
	MediaPlayer mediaPlayer;
	
	public void music() {
		String s = "StartAudio.mp3";
		Media h = new Media(new File(s).toURI().toString());
		mediaPlayer = new MediaPlayer(h);
		mediaPlayer.play();
		
	
	}
















	public static void main(String[] args) {
		launch(args);
	}
}
