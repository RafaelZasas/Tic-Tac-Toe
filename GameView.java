import javax.swing.*;
import java.awt.*;

public class GameView extends JPanel {  // this class will be the JPanel that contains the buttons

    // VIEW MEMBERS

    public static JButton[][] squares; // A 2D array that will contain J Buttons.
    // static so you can access it through the class

    // CONSTRUCTOR

    public GameView(){
        // TASK 1: SET THE GRID LAYOUT AND THE BACKGROUND COLOR
        setLayout( new GridLayout(3,3,5,5)); // sets the layout to 3x3 grid with gaps
        setBackground(Color.BLACK); // change the background color of the panel


        // TASK 2: INSTANTIATE SQUARES

        squares = new JButton[3][3]; // instantiate a 3x3 array to house the buttons

        // TASK 3: ADD BUTTONS TO THE ARRAY. PLACE AN X IN EACH BUTTON

        for (int i = 0; i <3 ; i++) {
            for (int j = 0; j < 3; j++) {
                JButton button = new JButton("X"); // create a new button that has an x on it
                // CHANGE THE FONT OF THE BUTTON
                button.setFont(new Font("Arial", Font.BOLD, 24)); // have to create a font object
                // ADD A BORDER TO THE BUTTON
                button.setBorderPainted(true);  // add a border to the button
                squares[i][j]=button;  // put this button into the Array
                this.add(squares[i][j]); // have to use this because were in the panel
            }
        }


        // TASK 4:
    }

}
