package org.example.symulatorgui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class DodajSamochodController {
    @FXML
    public TextField modelField;
    @FXML
    public TextField regNumberField;
    @FXML
    public TextField weightField;
    @FXML
    public TextField MaxSpeedField;
    public ComboBox engineComboBox;
    public ComboBox gearboxComboBox;
    public Button confirmButton;
    public Button cancelButton;

    @FXML
    private void onConfirmButton() throws IOException {
        String model = modelField.getText();
        String registration = regNumberField.getText();
        double weight;
        int speed;
        try {
            weight = Double.parseDouble(weightField.getText());
            speed = Integer.parseInt(MaxSpeedField.getText());
        } catch (NumberFormatException e) {
            System.out.println("Niepoprawne dane. Spróbuj ponownie.");
            return;
        }
        HelloController.addCarToList(model, registration, weight, speed);
        Stage stage = (Stage) confirmButton.getScene().getWindow();
        stage.close();

    }

    @FXML
    private void onCancelButton() throws IOException {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
    @FXML
    public void initialize(){
        cancelButton.setOnAction(event -> {
            //current_samochod = AddNewCar();
            try {
                onCancelButton();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        confirmButton.setOnAction(event -> {
            //current_samochod = AddNewCar();
            try {
                onConfirmButton();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

    }
}
