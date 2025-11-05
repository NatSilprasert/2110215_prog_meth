package gui;

import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import logic.GameLogic;
import logic.SquareMark;
import logic.SquareState;
import javafx.event.EventHandler;
import javafx.geometry.Insets;

public class MineSweeperSquare extends Pane {
	private boolean isDrawn;
    private Color baseColor;
    private int xPosition;
    private int yPosition;
    private final String oURL;
    private final String oneURL;
    private final String mineURL;
    private final String flagURL;

    public MineSweeperSquare(int x, int y) {
        oURL = "o.png";
        oneURL = "one.png";
        mineURL = "mine.png";
        flagURL = "flag.png";
        xPosition = x;
        yPosition = y;
        setPrefSize(100, 100);
        setMinSize(100, 100);
        baseColor = Color.MOCCASIN;
        initializeCellColor();
        this.setOnMouseClicked(event -> onClickHandler());
    }

    private void onClickHandler() {
        if (GameLogic.getInstance().isGameEnd()) return;

        if (!GameLogic.getInstance().isSecureMode() && GameLogic.getInstance().getBoardState()[xPosition][yPosition] != SquareState.REVEALED) {
            SquareMark c = GameLogic.getInstance().getBoardMark()[xPosition][yPosition];
            if (c == SquareMark.ONE) {
                draw(new Image(oneURL), Color.ORANGE);
            }
            else if (c == SquareMark.NOTHING) {
                draw(new Image(oURL), Color.YELLOW);
            }
            else if (c == SquareMark.MINE) {
                draw(new Image(mineURL), Color.RED);
            }
            GameLogic.getInstance().updateState(xPosition, yPosition, SquareState.REVEALED);
            setDrawn(true);
        }
        else if (GameLogic.getInstance().isSecureMode() && !isDrawn) {
            draw(new Image(flagURL), Color.GREEN);
            GameLogic.getInstance().updateState(xPosition, yPosition, SquareState.SECURED);
            setDrawn(true);
        }
    }

	private void draw(Image image, Color backgroundColor) {
		BackgroundFill bgFill = new BackgroundFill(backgroundColor, CornerRadii.EMPTY, Insets.EMPTY);
		BackgroundFill[] bgFillA = {bgFill};
		BackgroundSize bgSize = new BackgroundSize(100,100,false,false,false,false);
		BackgroundImage bgImg = new BackgroundImage(image, null, null, null, bgSize);
		BackgroundImage[] bgImgA = {bgImg};
		this.setBackground(new Background(bgFillA,bgImgA));

        isDrawn = true;
	}

    public void initializeCellColor() {
        BackgroundFill bgFill = new BackgroundFill(baseColor, CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(bgFill);
        this.setBackground(background);

        isDrawn = false;
    }

    public boolean isDrawn() {
        return isDrawn;
    }

    public void setDrawn(boolean drawn) {
        isDrawn = drawn;
    }

    public Color getBaseColor() {
        return baseColor;
    }

    public void setBaseColor(Color baseColor) {
        this.baseColor = baseColor;
    }

    public int getxPosition() {
        return xPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public String getoURL() {
        return oURL;
    }

    public String getOneURL() {
        return oneURL;
    }

    public String getMineURL() {
        return mineURL;
    }

    public String getFlagURL() {
        return flagURL;
    }
}
