package org.example.symulatorgui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import symulator.*;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class HelloController {
    public Samochod current_samochod;


    public MenuItem ContexMenuOpen;
    public MenuItem ContextMenuSave;
    public MenuItem ContextMenuClose;

    public MenuItem ContextMenuUndo;
    public MenuItem ContextMenuRedo;

    public Button AddNewCarButton;
    public Button RemoveCarButton;

    public TextField CarModelTextField;
    public TextField CarRegNrTextField;
    public TextField CarWeightTextField;
    public TextField CarSpeedTextField;

    public Button CarTurnOnButton;
    public Button CarTurnOffButton;
    public Button CarActionButton;

    public TextField GearboxNameTextField;
    public TextField GearboxPriceTextField;
    public TextField GearboxWeightTextField;
    public TextField GearboxGearTextField;

    public Button GearboxShiftUpButton;
    public Button GearboxShiftDownButton;

    public TextField EngineNameTextField;
    public TextField EnginePriceTextField;
    public TextField EngineWeightTextField;
    public TextField EngineRPMTextField;

    public Button EngineAccelerateButton;
    public Button EngineDecelerateButton;

    public TextField ClutchNameTextField;
    public TextField ClutchPriceTextField;
    public TextField ClutchWeightTextField;
    public TextField ClutchStatusTextField;

    public Button ClutchEngageButton;
    public Button ClutchDisengageButton;
    public ImageView carImageView;
    public ComboBox CarSelectionComboBox;

    public static ArrayList<Samochod> samochody = new  ArrayList<>();

    @FXML
    public void initialize(){

//        Silnik silnik = new Silnik(100,0,100,10,"ssb silnik","SSB","SuperSzybki1");
//        Sprzeglo sprzeglo = new Sprzeglo(5000,300,"Uuusprzeglo","UuuEntprice","Sigma");
//        SkrzyniaBiegow skrzyniaBiegow = new SkrzyniaBiegow(sprzeglo,0,6,2500,40,"SkrzyniaAlfa","Wilki","Auu");
//        Pozycja pozycja= new Pozycja(21,37);
//
//        Samochod honda_szybsza_niz_wygloada = new Samochod(pozycja,silnik,skrzyniaBiegow,true,21371,"Civic",11);
        current_samochod = new Samochod();
        refresh();

        Image carImage = new Image(getClass().getResource("/honda.png").toExternalForm());
        System.out.println("Image width: " + carImage.getWidth() + ", height: " + carImage.getHeight());
        carImageView.setImage(carImage);
        carImageView.setFitWidth(120);
        carImageView.setFitHeight(80);
        carImageView.setTranslateX(0);
        carImageView.setTranslateY(0);


        AddNewCarButton.setOnAction(event -> {
            //current_samochod = AddNewCar();
            try {
                openAddCarWindow();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            refresh();

        });

        CarSelectionComboBox.valueProperty().addListener((_, _, _) -> {
            current_samochod = samochody.get(CarSelectionComboBox.getSelectionModel().getSelectedIndex());
            refresh();
        });

    }
    @FXML
    public static void addCarToList(String model, String registration, double weight, int speed) {
        Silnik silnik = new Silnik(100,0,100,10,"ssb silnik","SSB","SuperSzybki1");
        Sprzeglo sprzeglo = new Sprzeglo(5000,300,"Uuusprzeglo","UuuEntprice","Sigma");
        SkrzyniaBiegow skrzyniaBiegow = new SkrzyniaBiegow(sprzeglo,0,6,2500,40,"SkrzyniaAlfa","Wilki","Auu");
        Pozycja pozycja= new Pozycja(0,0);
        Samochod new_samochod = new Samochod(pozycja,silnik,skrzyniaBiegow,false,Integer.valueOf(registration),model,speed);
        samochody.add(new_samochod);
    }

    @FXML
    public Samochod AddNewCar(){
        System.out.println("AddNewCar");
        Samochod current_samochod = new Samochod();
        return new Samochod();

    }
    @FXML
    public void openAddCarWindow() throws IOException {
        FXMLLoader loader = new
                FXMLLoader(getClass().getResource("DodajSamochod.fxml"));
        Stage stage = new Stage();
        try {
            stage.setScene(new Scene(loader.load()));
        }
        catch (IOException e) {
            System.out.println("Nie powiodło się. Spróbuj ponownie.");
            return;
        }
        stage.setTitle("Dodaj nowy samochód");
        stage.show();

    }
    @FXML
    public void refresh(){
        CarSelectionComboBox.getItems().clear();
        for(Samochod samochod : samochody){
            CarSelectionComboBox.getItems().add(String.valueOf(samochod.getModel()));
        }


        CarModelTextField.setText(String.valueOf(current_samochod.getModel()));
        CarRegNrTextField.setText(String.valueOf(current_samochod.getNrRejest()));
        CarWeightTextField.setText(String.valueOf(current_samochod.getWaga()));
        CarSpeedTextField.setText(String.valueOf(current_samochod.getPredkoscMax()));


        GearboxNameTextField.setText(String.valueOf(current_samochod.getSkrzynia().getNazwa()));
        GearboxPriceTextField.setText(String.valueOf(current_samochod.getSkrzynia().getCena()));
        GearboxWeightTextField.setText(String.valueOf(current_samochod.getSkrzynia().getWaga()));
        GearboxGearTextField.setText(String.valueOf(current_samochod.getSkrzynia().getAktualnyBieg()));

        EngineNameTextField.setText(String.valueOf(current_samochod.getSilnik().getNazwa()));
        EnginePriceTextField.setText(String.valueOf(current_samochod.getSilnik().getCena()));
        EngineWeightTextField.setText(String.valueOf(current_samochod.getSilnik().getWaga()));
        EngineRPMTextField.setText(String.valueOf(current_samochod.getSilnik().getObroty()));

        ClutchNameTextField.setText(String.valueOf(current_samochod.getSkrzynia().getSprzeglo().getNazwa()));
        ClutchPriceTextField.setText(String.valueOf(current_samochod.getSkrzynia().getSprzeglo().getCena()));
        ClutchWeightTextField.setText(String.valueOf(current_samochod.getSkrzynia().getSprzeglo().getWaga()));
        ClutchStatusTextField.setText(String.valueOf(current_samochod.getSkrzynia().getSprzeglo().getStanSprzegla()));
        current_samochod.getPozycja().setX(current_samochod.getPozycja().getX()+20);
        carImageView.setTranslateX(current_samochod.getPozycja().getX());
        carImageView.setTranslateY(current_samochod.getPozycja().getY());

        System.out.println("refresh");
    }



}
