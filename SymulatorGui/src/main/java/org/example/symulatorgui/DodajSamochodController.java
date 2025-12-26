package org.example.symulatorgui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import symulator.Silnik;
import symulator.SkrzyniaBiegow;
import symulator.Sprzeglo;

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

    private HelloController mainController;

    public void setMainController(HelloController mainController) {
        this.mainController = mainController;
    }

    @FXML
    private void onConfirmButton() throws IOException {
        String model = modelField.getText();
        String registration = regNumberField.getText();
        double weight;
        int speed;
        Silnik wybranySilnik = (Silnik) engineComboBox.getSelectionModel().getSelectedItem();
        SkrzyniaBiegow wybranaSkrzynia = (SkrzyniaBiegow) gearboxComboBox.getSelectionModel().getSelectedItem();
        if (wybranySilnik == null || wybranaSkrzynia == null) {
            System.out.println("Musisz wybrać silnik i skrzynię!");
            return;
        }
        try {
            weight = Double.parseDouble(weightField.getText());
            speed = Integer.parseInt(MaxSpeedField.getText());
        } catch (NumberFormatException e) {
            System.out.println("Niepoprawne dane. Spróbuj ponownie.");
            return;
        }
        this.mainController.addCarToList(model, registration, weight, speed, wybranySilnik,wybranaSkrzynia);
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

        Silnik s1 = new Silnik(3000, 0, 1500, 10, "Silnik EcoBoost 1.0", "Ford", "v1");
        Silnik s2 = new Silnik(6000, 0, 25000, 20, "Silnik V8 HEMI", "Dodge", "v8");


        Sprzeglo sprzeglo = new Sprzeglo(500, 10, "Sprzęgło Sport", "Sachs", "S1");
        SkrzyniaBiegow sk1 = new SkrzyniaBiegow(sprzeglo, 0, 5, 1000, 30, "Manualna 5-bieg", "Getrag", "M5");
        SkrzyniaBiegow sk2 = new SkrzyniaBiegow(sprzeglo, 0, 7, 2500, 45, "Automatyczna DSG", "ZF", "A7");


        engineComboBox.getItems().addAll(s1, s2);
        gearboxComboBox.getItems().addAll(sk1, sk2);

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
