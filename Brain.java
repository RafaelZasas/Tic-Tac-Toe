import javax.swing.*;

public abstract class Brain {
    abstract  void buildGameViews();
    abstract void insertX(int row, int col, GameView game, JFrame frame);

    abstract void insertO(GameView game, JFrame frame);


}
