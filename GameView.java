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
                JButton button = new JButton(""); // create a new button that has nothing on it
                // CHANGE THE FONT OF THE BUTTON
                button.setFont(new Font("Arial", Font.BOLD, 24)); // have to create a font object
                // ADD A BORDER TO THE BUTTON
                button.setBorderPainted(true);  // add a border to the button
                squares[i][j]=button;  // put this button into the Array
                this.add(squares[i][j]); // have to use this because were in the panel
            }
        }

    }

    public void insX(int row, int col){
        this.remove(squares[row][col]);
        JButton button = new JButton("X"); // create a new button that has an x on it
        button.setFont(new Font("Arial", Font.BOLD, 24)); // have to create a font object
        button.setBorderPainted(true);  // add a border to the button
        squares[row][col]=button;  // put this button into the Array

        for (int i = 0; i <3 ; i++) {
            for (int j = 0; j < 3; j++) {
                this.add(squares[i][j]); // have to use this because were in the panel
            }
        }
    }

    public void insO(){
        int rand1=0;
        int rand2=0;
        do {
            rand1=(int) (Math.random()*3); // random row #
            rand2=(int) (Math.random()*3); // random col #
        } while (squares[rand1][rand2].getText().equals("X") || squares[rand1][rand2].getText().equals("O"));

        this.remove(squares[rand1][rand2]);
        JButton button = new JButton("O"); // create a new button that has an O on it
        button.setFont(new Font("Arial", Font.BOLD, 24));    // create a font object
        button.setBorderPainted(true);  // add a border to the button
        squares[rand1][rand2]=button;  // put this button into the Array

        for (int i = 0; i <3 ; i++) {
            for (int j = 0; j < 3; j++) {
                this.add(squares[i][j]); // have to use this because were in the panel
            }
        }
    }

    public void evaluate(){
    boolean playerWin=false;
    boolean computerWin=false;
    int xCount=0;
    int oCount=0;

        //check row 1
        for(int i = 0; i < 3; i++){
            if(squares[0][i].getText().equals("X"))
                xCount++;
            if(squares[0][i].getText().equals("O"))
                oCount++;
           playerWin= xCount == 3; // true if all 3 in first row is X
           computerWin = oCount==3; // true if all 3 in first row is O
        }
        checkWin(playerWin,computerWin);

        //check row 2
        xCount=0;oCount=0;
        for(int i = 0; i < 3; i++){
            if(squares[1][i].getText().equals("X"))
                xCount++;
            if(squares[1][i].getText().equals("O"))
                oCount++;
            playerWin= xCount == 3; // true if all 3 in second row is X
            computerWin = oCount==3; // true if all 3 in second row is O
        }
        checkWin(playerWin,computerWin);

        //check row 3
        xCount=0;oCount=0;
        for(int i = 0; i < 3; i++){
            if(squares[2][i].getText().equals("X"))
                xCount++;
            if(squares[2][i].getText().equals("O"))
                oCount++;
            playerWin= xCount == 3; // true if all 3 in third row is X
            computerWin = oCount==3; // true if all 3 in third row is O
        }
        checkWin(playerWin,computerWin);


        //check col 1
        for(int i = 0; i < 3; i++){
            if(squares[i][0].getText().equals("X"))
                xCount++;
            if(squares[i][0].getText().equals("O"))
                oCount++;
            playerWin= xCount == 3; // true if all 3 in first col is X
            computerWin = oCount==3; // true if all 3 in first col is O
        }
        checkWin(playerWin,computerWin);

        //check row 2
        xCount=0;oCount=0;
        for(int i = 0; i < 3; i++){
            if(squares[i][1].getText().equals("X"))
                xCount++;
            if(squares[i][1].getText().equals("O"))
                oCount++;
            playerWin= xCount == 3; // true if all 3 in second col is X
            computerWin = oCount==3; // true if all 3 in second col is O
        }
        checkWin(playerWin,computerWin);

        //check row 3
        xCount=0;oCount=0;
        for(int i = 0; i < 3; i++){
            if(squares[i][2].getText().equals("X"))
                xCount++;
            if(squares[i][2].getText().equals("O"))
                oCount++;
            playerWin= xCount == 3; // true if all 3 in third col is X
            computerWin = oCount==3; // true if all 3 in third col is O
        }
        checkWin(playerWin,computerWin);




        //check left diag
        xCount=0;oCount=0;
        for(int i = 0; i < 3; i++){
            if(squares[i][i].getText().equals("X"))
                xCount++;
            if(squares[i][i].getText().equals("O"))
                oCount++;
            playerWin= xCount == 3; // true if all 3 in third col is X
            computerWin = oCount==3; // true if all 3 in third col is O
        }
        checkWin(playerWin,computerWin);

        //check right diag
        xCount=0;oCount=0;
        for(int i = 2; i > -1; i--){
            if(squares[i][i].getText().equals("X"))
                xCount++;
            if(squares[i][i].getText().equals("O"))
                oCount++;
            playerWin= xCount == 3; // true if all 3 in third col is X
            computerWin = oCount==3; // true if all 3 in third col is O
        }
        checkWin(playerWin,computerWin);





    }

    public void checkWin(boolean playerWin, boolean computerWin){
        if (playerWin){
            JOptionPane.showMessageDialog(this,"Congratulations! You beat the PC!");
            System.exit(0);
        } else if (computerWin) {
            JOptionPane.showMessageDialog(this,"Sorry... Better luck next time buddy :) ");
            System.exit(0);
        }
    }

    public void draw(){
        JOptionPane.showMessageDialog(this,"It's a Draw!");
        System.exit(0);
    }

}
