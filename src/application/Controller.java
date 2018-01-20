package application;

import java.awt.Insets;
import java.io.ByteArrayInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;

public class Controller implements Initializable {

	@FXML
	private Button myButton;
	@FXML
	private TableView<Profile> table = new TableView<Profile>();
	@FXML
	private TableColumn<Profile, String> columnStudentID;
	@FXML
	private TableColumn<Profile, String> columnName;
	@FXML
	private TableColumn<Profile, String> columnProject;

	private DBConnection db;
	private ResultSet result;

	// private ObservableList<Profile> data;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO Auto-generated method stub
		db = new DBConnection();
		loadDB();
	}

	@FXML
	public void checkConnection(ActionEvent event) {
		columnStudentID.setCellValueFactory(new PropertyValueFactory<>("id"));
		columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
		columnProject.setCellValueFactory(new PropertyValueFactory<>("proj"));
		table.setItems(listData());
	}

	private ObservableList<Profile> listData() {
		ObservableList<Profile> list = FXCollections.observableArrayList();
		try {
			for (int i = 0; i <= result.getMetaData().getColumnCount(); i++) {
				String id = result.getString("StudentID");
				String name = result.getString("Name");
				String major = result.getString("Major");
				list.add(new Profile(id, name, major));
				result.next();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public void loadDB() {
		try {
			Connection connect = db.connectDB();
			result = connect.createStatement().executeQuery("SELECT * FROM `Profile`");
			result.first();
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
