package org.example.symulatorgui;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import symulator.*;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class HelloController implements Listener {
    public Samochod current_samochod;

    public Button AddNewCarButton;
    public Button RemoveCarButton;

    public TextField CarModelTextField;
    public TextField CarRegNrTextField;
    public TextField CarWeightTextField;
    public TextField CarSpeedTextField;

    public Button CarTurnOnButton;
    public Button CarTurnOffButton;

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
    public AnchorPane mapa;

    @FXML
    public void initialize(){
        Image carImage = new Image(getClass().getResource("/honda.png").toExternalForm());
        System.out.println("Image width: " + carImage.getWidth() + ", height: " + carImage.getHeight());
        carImageView.setVisible(false);
        carImageView.setImage(carImage);
        carImageView.setFitWidth(120);
        carImageView.setFitHeight(80);
        carImageView.setTranslateX(0);
        carImageView.setTranslateY(0);


        refresh();

        CarTurnOnButton.setOnAction(event -> {
            if (current_samochod != null){
                current_samochod.wlacz();
            }
            refresh();
        });

        CarTurnOffButton.setOnAction(event -> {
            if (current_samochod != null){
                current_samochod.wylacz();
            }
            refresh();
        });

        GearboxShiftUpButton.setOnAction(event -> {
            if (current_samochod != null){
                current_samochod.getSkrzynia().zwiekszBieg();
            }
            refresh();
        });

        GearboxShiftDownButton.setOnAction(event -> {
            if (current_samochod != null){
                current_samochod.getSkrzynia().zmniejszBieg();
            }
            refresh();
        });

        EngineAccelerateButton.setOnAction(event -> {
            if (current_samochod != null){
                current_samochod.getSilnik().zwiekszObroty();
            }
            refresh();
        });

        EngineDecelerateButton.setOnAction(event -> {
            if (current_samochod != null){
                current_samochod.getSilnik().zmniejszObroty();
            }
            refresh();
        });

        ClutchEngageButton.setOnAction(e -> {
            if (current_samochod != null){
                current_samochod.getSkrzynia().getSprzeglo().wcisnij();
            }
            refresh();
        });

        ClutchDisengageButton.setOnAction(e -> {
            if (current_samochod != null){
                current_samochod.getSkrzynia().getSprzeglo().zwolnij();
            }
            refresh();
        });

        RemoveCarButton.setOnAction(event -> {
            removeCar();
        });

        AddNewCarButton.setOnAction(event -> {
            //current_samochod = AddNewCar();
            try {
                openAddCarWindow();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            refresh();

        });

        mapa.setOnMouseClicked(event -> {
            if (current_samochod != null) {
                double halfWidth = carImageView.getFitWidth() / 2.0;
                double halfHeight = carImageView.getFitHeight() / 2.0;

                double celX = event.getX() - halfWidth;
                double celY = event.getY() - halfHeight;

                Pozycja nowaPozycja = new Pozycja(celX, celY);
                if(current_samochod.isStanWlaczenia() && !current_samochod.getSkrzynia().getSprzeglo().getStanSprzegla())
                current_samochod.jedzDo(nowaPozycja);
            } else {
                System.out.println("Błąd: Wybierz lub dodaj samochód przed kliknięciem na mapę.");
            }
        });

        CarSelectionComboBox.valueProperty().addListener((_, _, _) -> {
            int selectedIndex = CarSelectionComboBox.getSelectionModel().getSelectedIndex();

            if (selectedIndex >= 0 && selectedIndex < samochody.size()) {
                current_samochod = samochody.get(selectedIndex);
                refresh();
            }
        });

    }
    @FXML
    public void addCarToList(String model, String registration, double weight, int speed, Silnik silnik, SkrzyniaBiegow skrzynia) {
        Sprzeglo sprzeglo = skrzynia.getSprzeglo();
        Pozycja pozycja= new Pozycja(0,0);
        Samochod new_samochod = new Samochod(pozycja,silnik,skrzynia,false,Integer.valueOf(registration),model,speed);
        new_samochod.addListener(this);
        samochody.add(new_samochod);
        current_samochod = new_samochod;
        CarSelectionComboBox.getItems().add(new_samochod.getModel());
        CarSelectionComboBox.getSelectionModel().selectLast();
        carImageView.setVisible(true);
        refresh();

    }

    @FXML
    public void removeCar() {
        if (current_samochod != null) {
            current_samochod.interrupt();
            if (samochody.size() <= 1) {
                carImageView.setVisible(false);
            }

            int index = samochody.indexOf(current_samochod);
            samochody.remove(current_samochod);
            CarSelectionComboBox.getItems().remove(index);

            if (!samochody.isEmpty()) {
                CarSelectionComboBox.getSelectionModel().selectFirst();
                current_samochod = samochody.get(0);
            } else {
                current_samochod = null;
            }

            refresh();
        }
    }

    @FXML
    public void openAddCarWindow() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DodajSamochod.fxml"));
        Scene scene = new Scene(loader.load());

        DodajSamochodController controller = loader.getController();
        controller.setMainController(this);

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Dodaj nowy samochód");
        stage.show();
        refresh();
    }
    @FXML
    public void refresh(){
        Platform.runLater(() -> {
            if (current_samochod == null) {
                System.out.println("Brak wybranego samochodu do odświeżenia.");
                return;
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

        carImageView.setTranslateX(current_samochod.getPozycja().getX());
        carImageView.setTranslateY(current_samochod.getPozycja().getY());

        System.out.println("refresh");
        });
    }


    @Override
    public void update() {
        Platform.runLater(() -> {
            carImageView.setTranslateX(current_samochod.getPozycja().getX());
            carImageView.setTranslateY(current_samochod.getPozycja().getY());
            carImageView.setRotate(current_samochod.getKat());
        });
    }
}
