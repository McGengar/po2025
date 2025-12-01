package org.example.symulatorgui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import symulator.*;

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

    @FXML
    public void initialize(){

        Silnik silnik = new Silnik(6700,0,6700,670,"ssb silnik","SSB","SuperSzybki67");
        Sprzeglo sprzeglo = new Sprzeglo(5000,300,"Uuusprzeglo","UuuEntprice","Sigma");
        SkrzyniaBiegow skrzyniaBiegow = new SkrzyniaBiegow(sprzeglo,0,6,2500,40,"SkrzyniaAlfa","Wilki","Auu");
        Pozycja pozycja= new Pozycja(21,37);

        Samochod honda_szybsza_niz_wygloada = new Samochod(pozycja,silnik,skrzyniaBiegow,true,213767,"Civic",167);
        current_samochod = honda_szybsza_niz_wygloada;
        refresh();

        Image carImage = new Image(getClass().getResource("/honda.png").toExternalForm());
        System.out.println("Image width: " + carImage.getWidth() + ", height: " + carImage.getHeight());
        carImageView.setImage(carImage);
        carImageView.setFitWidth(120);
        carImageView.setFitHeight(80);
        carImageView.setTranslateX(0);
        carImageView.setTranslateY(0);


        AddNewCarButton.setOnAction(event -> {
            current_samochod = AddNewCar();
            refresh();

        });
    }

    public Samochod AddNewCar(){
        System.out.println("AddNewCar");
        Samochod current_samochod = new Samochod();
        return new Samochod();

    }

    void refresh(){
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

        carImageView.setTranslateX(current_samochod.getPozycja().getX());
        carImageView.setTranslateY(current_samochod.getPozycja().getY());

        System.out.println("refresh");
    }



}
