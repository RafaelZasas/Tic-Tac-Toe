import javax.swing.*;

public abstract class Brain {  // child classes must implement these methods
    abstract  void buildGameViews(); // creates the J Panel and J frame
    abstract void insertX(int row, int col, GameView game, JFrame frame);
    //inserts an X

    abstract void insertO(GameView game, JFrame frame);
    // inserts an O


}
