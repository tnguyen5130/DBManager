package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			// Read XML //
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene1.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
//			FXMLLoader loader2 = new FXMLLoader(getClass().getResource("Scene2.fxml"));
//			Parent root2 = loader2.load();
//			Scene scene2 = new Scene(root2);
			primaryStage.setTitle("MemberManager");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
