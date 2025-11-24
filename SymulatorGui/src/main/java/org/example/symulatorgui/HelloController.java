package org.example.symulatorgui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.control.MenuItem;
import symulator.*;

public class HelloController {
    public MenuItem ContexMenuOpen;
    public MenuItem ContextMenuSave;
    public MenuItem ContextMenuClose;

    public MenuItem ContextMenuUndo;
    public MenuItem ContextMenuRedo;


    public Button AddNewCarButton;
    public Button RemoveCarButton;

    public Samochod auto;

    @FXML
            public void initialize(){
        AddNewCarButton.setOnAction(event -> {
            Samochod auto = AddNewCar();
        });
    }

    public Samochod AddNewCar(){
        System.out.println("AddNewCar");
        return new Samochod();

    }

    Samochod Honda = new Samochod();

}
