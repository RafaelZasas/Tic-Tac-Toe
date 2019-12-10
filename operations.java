import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class operations extends Brain {


    @Override
    void buildGameViews() {
        // TASK1: CREATE A FRAME, SET THE TITLE AND DIMENSIONS, MAKE VISIBLE
        JFrame frame = new JFrame();  // create a new JFrame
        frame.setTitle("X's an O's"); // set the title
        frame.setSize(500,550);  // specify the dimensions of the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // make sure the frame can be closes

        // TASK 2: INSTANTIATE A GameView OBJECT AND ADD IT TO THE FRAME

        GameView game = new GameView();
        frame.add(game); // add the J panel to the J frame
        frame.setVisible(true);  // show the j frame

        // TASK 3: REGISTER LISTENER EVENTS FOR EACH OF THE BUTTONS IN THE GAME VIEW
        final int[] count = {0};
        for (int i = 0; i <3 ; i++) {
            for (int j = 0; j < 3; j++) {
                int finalI = i;
                int finalJ = j;
                GameView.squares[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // System.out.println(""+ finalI +" "+ finalJ);
                        insertX(finalI,finalJ,game,frame);
                        insertO(game,frame);
                        count[0]++;
                        if (count[0]<4){
                            game.evaluate();
                        } else game.draw();

                    }
                });
            }
        }
    }

    @Override
    void insertX(int row, int col, GameView game, JFrame frame) {
        game.insX(row,col);
        frame.remove(game);
        frame.add(game);
        frame.setVisible(true);  // show the j frame
    }

    @Override
    void insertO(GameView game, JFrame frame) {
        game.insO();
        frame.remove(game);
        frame.add(game);
        frame.setVisible(true);  // show the j frame
    }
}
