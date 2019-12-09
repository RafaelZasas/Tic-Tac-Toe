import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    public static void main(String[] args) {
        buildGameViews();
        buildGameModel();
        playGame();

    }

    private static void playGame() {
    }

    private static void buildGameModel() {
    }

    private static void buildGameViews() {
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
        for (int i = 0; i <3 ; i++) {
            for (int j = 0; j < 3; j++) {
                GameView.squares[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane p = new JOptionPane("hit me baby one more time");
                        p.show();
                        System.out.println("hi ");
                    }
                });
            }
        }



    }
}
