import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {

    Board(){

        setBounds(0 , 0 , 100 , 100);
        setLayout(new GridLayout(8 , 8));
        setBackground(Color.pink);

        for (Integer i = 1 ; i <= 64 ; i++){

            JButton square = new JButton(i.toString());
            add(square);
        }

    }




}
