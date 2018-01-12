package application;

import java.net.URL;
import java.util.ResourceBundle;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller implements Initializable {

	@FXML
	private Button myButton;
	@FXML
	private TableView<Profile> table;
	@FXML
	private TableColumn<Profile, String> columnStudentID;
	@FXML
	private TableColumn<Profile, String> columnName;
	@FXML
	private TableColumn<Profile, String> columnProject;

	private DBConnection db;
	private ObservableList<Profile> data;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO Auto-generated method stub
		db = new DBConnection();
	}

	@FXML
	public void checkConnection(ActionEvent event) {
		columnStudentID.setCellValueFactory(new PropertyValueFactory<>("id"));
		columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
		columnProject.setCellValueFactory(new PropertyValueFactory<>("proj"));
		try {
			Connection connect = db.connectDB();
			data = FXCollections.observableArrayList();
			Statement statement = connect.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM ititiu16137.Profile");
			while (rs.next()) {
				data.add(new Profile(rs.getString(2), rs.getString(3), rs.getString(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	//	table.setItems(data);
	}
}
