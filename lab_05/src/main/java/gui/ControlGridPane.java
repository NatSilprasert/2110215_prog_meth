package gui;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class ControlGridPane extends VBox {
    private final String miningImageURL;
    private ControlPane controlPane;

    public ControlGridPane (ControlPane controlPane) {
        this.controlPane = controlPane;
        this.miningImageURL = "bitcoin.png";

        ImageView imageView = new ImageView(new Image(miningImageURL));
        imageView.setFitWidth(150);
        imageView.setFitHeight(150);

        BorderPane borderPane = new BorderPane();
        borderPane.setPrefWidth(150);
        borderPane.setPrefHeight(200);
        borderPane.setCenter(imageView);

        getChildren().addAll(borderPane,controlPane);
    }
}