package gui;

import java.util.ArrayList;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import java.util.ArrayList;

public class MineSweeperPane extends GridPane {
    private ArrayList<MineSweeperSquare> allCells;

    public MineSweeperPane() {
        allCells = new ArrayList<>();

        setHgap(8);
        setVgap(8);
        setPadding( new Insets(8,8,8,8));
        setPrefWidth(500);
        setAlignment(Pos.CENTER);

        BorderStroke borderStroke = new BorderStroke(
                Color.LIGHTGRAY,
                BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY,
                BorderWidths.DEFAULT
        );
        setBorder(new Border(borderStroke));

        setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                MineSweeperSquare cell = new MineSweeperSquare(i, j);
                allCells.add(cell);
                add(cell, i, j);
            }
        }
    }

    public ArrayList<MineSweeperSquare> getAllCells() {
        return allCells;
    }
}
