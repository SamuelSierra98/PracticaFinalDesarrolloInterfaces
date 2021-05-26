package controladores;

import java.io.IOException;

import dao.clienteDAO;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import constructores.Cliente;

public class Login {

	@FXML
	Button boton;

	@FXML
	TextField textGmail;

	@FXML
	PasswordField textPassword;

	int contador = 0;

	@FXML
	public void confirm(ActionEvent event) {

		String gmail = textGmail.getText();
		String password = textPassword.getText();

		clienteDAO cd = new clienteDAO();
		boolean correcto = false;
		
		for (Cliente c : cd.getAll()) {
			if (gmail.equals(c.getEmail()) && password.equals(c.getPassword())) {
				correcto = true;
			} 
		}

		if (correcto) {
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("VistaMenu.fxml"));
				Parent root = loader.load();
				Menu controlador = loader.getController();
				Scene scene = new Scene(root);
				Stage stage = new Stage();
				stage.setScene(scene);
				stage.show();
				stage.setOnCloseRequest(e -> controlador.closeWindowsMenu());
				Stage mystage = (Stage) this.boton.getScene().getWindow();
				mystage.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("INCORRECTO");
			alert.setContentText("Usuario o Password incorrecto");
			alert.showAndWait();
		}
	}
}