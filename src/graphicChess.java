import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class graphicChess extends JButton{

    private JFrame frame ;
    private JPanel line,chess,white,black,turn;
    private Square[][] squares = new Square[8][8];
    private String turnPiece = "white";
    public Ground ground;
    /*
    public String getTurnPiece() {
        return turnPiece;
    }
    public void setTurnPiece(String h){
        turnPiece = h;
    } */

    public  void settingImageFirst(){
        Ground ground = new Ground();
        this.ground = ground;
        ground.makingChessPicess();
        ground.makingPicessChoices();
        Pices[][] pices = new Pices[8][8];

        for (int i = 0; i <8 ; i++) {
            for (int j = 0; j <8 ; j++) {
                squares[i][j] = new Square(i,j,ground);
            }
        }

        int t = 16;
        int u = 24;
        for (int i = 0; i < 8; i++) {
            squares[ground.chessPicess.get(t).getY()-1][ground.chessPicess.get(t).getX()-1]=squares[ground.chessPicess.get(t).getY()-1][ground.chessPicess.get(t).getX()-1].setP(ground.chessPicess.get(t),"chessPng/Black_Pawn.png","black");
            squares[ground.chessPicess.get(u).getY() - 1][ground.chessPicess.get(u).getX() - 1]=squares[ground.chessPicess.get(u).getY() - 1][ground.chessPicess.get(u).getX() - 1].setP(ground.chessPicess.get(u), "chessPng/White_Pawn.png","white");
            u++;
            t++;
        }

        squares[ground.chessPicess.get(12).getY()-1][ground.chessPicess.get(12).getX()-1]=squares[ground.chessPicess.get(12).getY()-1][ground.chessPicess.get(12).getX()-1].setP(ground.chessPicess.get(12),"chessPng/White_King.png","white");

        squares[ground.chessPicess.get(4).getY()-1][ground.chessPicess.get(4).getX()-1] = squares[ground.chessPicess.get(4).getY()-1][ground.chessPicess.get(4).getX()-1].setP(ground.chessPicess.get(4),"chessPng/Black_King.png","black");

        squares[ground.chessPicess.get(11).getY()-1][ground.chessPicess.get(11).getX()-1] = squares[ground.chessPicess.get(11).getY()-1][ground.chessPicess.get(11).getX()-1].setP(ground.chessPicess.get(11),"chessPng/White_Queen.png","white");

        squares[ground.chessPicess.get(3).getY()-1][ground.chessPicess.get(3).getX()-1] = squares[ground.chessPicess.get(3).getY()-1][ground.chessPicess.get(3).getX()-1].setP(ground.chessPicess.get(3),"chessPng/Black_Queen.png","black");

        squares[ground.chessPicess.get(13).getY()-1][ground.chessPicess.get(13).getX()-1] = squares[ground.chessPicess.get(13).getY()-1][ground.chessPicess.get(13).getX()-1].setP(ground.chessPicess.get(13),"chessPng/White_Bishop.png","white");

        squares[ground.chessPicess.get(10).getY()-1][ground.chessPicess.get(10).getX()-1] = squares[ground.chessPicess.get(10).getY()-1][ground.chessPicess.get(10).getX()-1].setP(ground.chessPicess.get(10),"chessPng/White_Bishop.png","white");

        squares[ground.chessPicess.get(5).getY()-1][ground.chessPicess.get(5).getX()-1] = squares[ground.chessPicess.get(5).getY()-1][ground.chessPicess.get(5).getX()-1].setP(ground.chessPicess.get(5),"chessPng/Black_Bishop.png","black");

        squares[ground.chessPicess.get(2).getY()-1][ground.chessPicess.get(2).getX()-1] = squares[ground.chessPicess.get(2).getY()-1][ground.chessPicess.get(2).getX()-1].setP(ground.chessPicess.get(2),"chessPng/Black_Bishop.png","black");

        squares[ground.chessPicess.get(15).getY()-1][ground.chessPicess.get(15).getX()-1] = squares[ground.chessPicess.get(15).getY()-1][ground.chessPicess.get(15).getX()-1].setP(ground.chessPicess.get(15),"chessPng/White_Rook.png","white");

        squares[ground.chessPicess.get(8).getY()-1][ground.chessPicess.get(8).getX()-1] = squares[ground.chessPicess.get(8).getY()-1][ground.chessPicess.get(8).getX()-1].setP(ground.chessPicess.get(8),"chessPng/White_Rook.png","white");

        squares[ground.chessPicess.get(9).getY()-1][ground.chessPicess.get(9).getX()-1]=squares[ground.chessPicess.get(9).getY()-1][ground.chessPicess.get(9).getX()-1].setP(ground.chessPicess.get(9),"chessPng/White_Knight.png","white");

        squares[ground.chessPicess.get(14).getY()-1][ground.chessPicess.get(14).getX()-1] = squares[ground.chessPicess.get(14).getY()-1][ground.chessPicess.get(14).getX()-1].setP(ground.chessPicess.get(14),"chessPng/White_Knight.png","white");

        squares[ground.chessPicess.get(6).getY()-1][ground.chessPicess.get(6).getX()-1]=squares[ground.chessPicess.get(6).getY()-1][ground.chessPicess.get(6).getX()-1].setP(ground.chessPicess.get(6),"chessPng/Black_Knight.png","black");

        squares[ground.chessPicess.get(1).getY()-1][ground.chessPicess.get(1).getX()-1] = squares[ground.chessPicess.get(1).getY()-1][ground.chessPicess.get(1).getX()-1].setP(ground.chessPicess.get(1),"chessPng/Black_Knight.png","black");

        squares[ground.chessPicess.get(0).getY()-1][ground.chessPicess.get(0).getX()-1]=squares[ground.chessPicess.get(0).getY()-1][ground.chessPicess.get(0).getX()-1].setP(ground.chessPicess.get(0),"chessPng/Black_Rook.png","black");

        squares[ground.chessPicess.get(7).getY()-1][ground.chessPicess.get(7).getX()-1]=squares[ground.chessPicess.get(7).getY()-1][ground.chessPicess.get(7).getX()-1].setP(ground.chessPicess.get(7),"chessPng/Black_Rook.png","black");

    }

    public graphicChess(){
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Square thisSquare;
                int x = e.getX();
                int y = e.getY();
                thisSquare = (Square)e.getSource();
                System.out.println(thisSquare.p.getName()+thisSquare.p.getNumber());
                for(int i=0;i<thisSquare.p.getNumber();i++){
                    squares[thisSquare.p.getyChoice()[i]][thisSquare.p.getxChoice()[i]].setColor(new Color(0x327824));
                }
            }
        });

        frame = new JFrame();
        GridLayout g = new GridLayout(8,8,10,4);
        GridLayout g2 = new GridLayout(3,0,10,4);
        BorderLayout b = new BorderLayout();

        line = new JPanel();
        chess = new JPanel();
        white = new JPanel();
        black = new JPanel();
        turn = new JPanel();

        ActionEvent e;
        settingImageFirst();

        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                frame.add(squares[i][j]);
                squares[i][j].addMouseListener(new MouseDemo(squares,ground));
            }
        }

        frame.setLayout(b);
        line.setBackground(new Color(0xC0602FA0, true));
        line.setLayout(g2);
        chess.setBackground(new Color(0x82452A));

        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if((i+j) %2 ==0){
                    squares[i][j].setBackground(new Color(0x40200D));
                }
                else {
                    squares[i][j].setBackground(Color.white);
                }
            }
        }

        white.setBackground(new Color(0xD3715DB0, true));
        black.setBackground(new Color(0x7366DE));
        turn.setBackground(Color.gray);
        line.setPreferredSize(new Dimension(400,100));
        chess.setPreferredSize(new Dimension(100,100));
        white.setPreferredSize(new Dimension(100,100));
        black.setPreferredSize(new Dimension(100,100));
        turn.setPreferredSize(new Dimension(100,100));
        chess.setLayout(g);

        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                chess.add(squares[i][j]);
            }

        }
        line.add(white);
        line.add(turn);
        line.add(black);

        frame.getContentPane().add(line,BorderLayout.WEST);
        frame.getContentPane().add(chess,BorderLayout.CENTER);
        frame.setSize(1500,700);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                squares[i][j].addActionListener(new ActionListener(){
                    @Override

                    public void actionPerformed(ActionEvent e) {

                    }
                });

            }
        }*/


    }

    public static void main(String[] args) {
        graphicChess g = new graphicChess();

    }

}
