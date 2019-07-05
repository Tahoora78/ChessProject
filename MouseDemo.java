import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseDemo implements MouseListener {
    JButton[][] b;
    Ground ground;
    int u=0;
    public MouseDemo(JButton button[][],Ground ground){
            b = button;
            this.ground = ground;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
            JButton button = (JButton) (e.getSource());
            Square s = (Square) e.getSource();
            String turn = "black";
            Square folowingSquare;
            System.out.println("x:"+s.getx()+" y:"+s.gety());
            System.out.println("piece"+s.getPiece()+ graphicChess.exist);
        System.out.println("turn color"+graphicChess.turnColor+"color"+s.getColor());
        if(s.getPiece()!= null && s.getPiece().getColor().equals(graphicChess.turnColor)){
            for (int i = 0; i < s.p.getNumber(); i++) {
                b[s.p.getxChoice()[i]][s.p.getyChoice()[i]].setBackground(Color.green);
            }
            graphicChess.exist=1;
            graphicChess.previousSquare = s;
        }
        if(s.getPiece()==null && graphicChess.exist==1 ){
            System.out.println("hh"+graphicChess.previousSquare.p.getNumber());
            for (int i = 0; i < graphicChess.previousSquare.p.getNumber(); i++) {
                if(s.getx()==graphicChess.previousSquare.p.getxChoice()[i] && s.gety()==graphicChess.previousSquare.p.getyChoice()[i]){
                    Square pre = graphicChess.previousSquare;
                    System.out.println("jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj");
                   // System.out.println("previous x:"+graphicChess.previousSquare.getX()+"previous y:"+graphicChess.previousSquare.gety()+"x:"+s.getX()+"y:"+s.gety());
                    s.setPiece(graphicChess.previousSquare.getPiece());
                    s.setImage(graphicChess.previousSquare.getImage());
                    Square w = graphicChess.previousSquare;
                  //  System.out.println("w"+w.getPiece());
                    w.setImage(null);
                    System.out.println("x"+graphicChess.previousSquare.getx()+"y"+graphicChess.previousSquare.gety());
                    b[graphicChess.previousSquare.getx()][graphicChess.previousSquare.gety()].setIcon(null);
                    System.out.println("yyyyyyyyyyyy");
                    System.out.println("pre"+graphicChess.previousSquare.p.getNumber());
                    System.out.println("sx:"+s.getx()+"sy:"+s.gety());
                        if((graphicChess.previousSquare.getx()%2+graphicChess.previousSquare.gety())%2==0){
                            b[graphicChess.previousSquare.getx()][graphicChess.previousSquare.gety()].setBackground(new Color(0x40200D));
                        }else {
                            b[graphicChess.previousSquare.getx()][graphicChess.previousSquare.gety()].setBackground(Color.white);
                        }
                    System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                    for (int j = 0; j < graphicChess.previousSquare.p.getNumber(); j++) {
                        System.out.println("x" + graphicChess.previousSquare.p.getxChoice()[j] + "y" + graphicChess.previousSquare.p.getyChoice()[j]);

                        if ((graphicChess.previousSquare.p.getxChoice()[j]+graphicChess.previousSquare.p.getyChoice()[j]) % 2 == 0) {
                            b[graphicChess.previousSquare.p.getxChoice()[j]][graphicChess.previousSquare.p.getyChoice()[j]].setBackground(new Color(0x40200D));
                            System.out.println("black"+graphicChess.previousSquare.p.getxChoice()[j]);
                        }else {
                            b[graphicChess.previousSquare.p.getxChoice()[j]][graphicChess.previousSquare.p.getyChoice()[j]].setBackground(Color.white);
                            System.out.println("white"+graphicChess.previousSquare.p.getxChoice()[j]);
                        }
                    }
                    System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                    System.out.println("00000000000");
                    System.out.println("iiii"+graphicChess.previousSquare.getPiece().getName());
                    System.out.println("color"+graphicChess.previousSquare.getPiece().getColor());
                 //   System.out.println("pre"+graphicChess.previousSquare.p.getNumber());
                   // if(graphicChess.previousSquare.color.equals("black")){
                        if(graphicChess.previousSquare.getPiece().getColor().equals("black")){
                        graphicChess.turnColor="white";

                    }if(graphicChess.previousSquare.getPiece().getColor().equals("white")){
                         graphicChess.turnColor = "black";
                    }
                    w.setPiece(null);
                    break;
                }

            }
        }

//        System.out.println("number"+s.p.getNumber());
  /*
        if(graphicChess.previousSquare.p != null){
            System.out.println("99999999999999999999999999999999999999");
        for (int i = 0; i < graphicChess.previousSquare.p.getNumber(); i++) {
            System.out.println("gx"+s.getx()+"x"+graphicChess.previousSquare.p.getxChoice()[i]+"y"+s.p.getyChoice()[i]);
            if(s.getx()==graphicChess.previousSquare.p.getxChoice()[i] && graphicChess.previousSquare.gety()==s.p.getyChoice()[i]){
                System.out.println("8************************");
                ground.setTurnPiece("white");
            }
        }}
*/
            if(ground.getTurnPiece().equals(s.getColor())) {
            if(s.color.equals("black")){
               // ground.setTurnPiece("white");

            }if(s.color.equals("white")){
               // ground.setTurnPiece("black");
            }
            if(s.getColor().equals(null)){}
            else {
                b[s.getx()][s.gety()].setBackground(new Color(0xA05452));
                for (int i = 0; i < s.p.getNumber(); i++) {
//                    b[s.p.getxChoice()[i]][s.p.getyChoice()[i]].setBackground(Color.green);
                }

//                for (int i = 0; i < s.p.getNumber(); i++) {
//                    System.out.println("gx"+s.getx()+"x"+s.p.getxChoice()[i]+"y"+s.p.getyChoice()[i]);
//                    if(s.getx()==s.p.getxChoice()[i] && s.gety()==s.p.getyChoice()[i]){
//                        System.out.println("8************************");
//                        ground.setTurnPiece("white");
//                    }}
            }
                System.out.println("u:::"+u);
            if(ground.getStart()){
                System.out.println("number"+ground.getCurrentSquare().p.getNumber());
            for(int i=0;i<ground.getCurrentSquare().p.getNumber();i++){
                System.out.println("sx:"+s.getx()+" gx"+ground.getCurrentSquare().p.getxChoice()[i]+"sy:"+s.gety()+" gy:"+ground.getCurrentSquare().p.getyChoice()[i]);
                if(s.getx() == ground.getCurrentSquare().p.getyChoice()[i] && s.gety()==ground.getCurrentSquare().p.getxChoice()[i]){
                    s.setImage(ground.getCurrentSquare().getImage());
                    s.setPiece(ground.getCurrentSquare().getPiece());
                    ground.getCurrentSquare().setPiece(null);
                    ground.getCurrentSquare().setImage(null);

                }
            }}
                System.out.println("first start"+ground.getStart());
                ground.setStart(true);
                ground.setCurrentSquare(s);
                u++;
            /*
            for(int i=0;i<s.p.getNumber();i++){
               // System.out.println("folowing x:"+folowingSquare.getx()+"previous x:"+s.p.getxChoice()[i]+"folowing y:"+folowingSquare.gety()+"previous y:"+s.p.getyChoice()[i]);
             //   if(folowingSquare.getx()==s.p.getxChoice()[i] && folowingSquare.gety()==s.p.getyChoice()[i]){
                    folowingSquare.setImage(ground.getCurrentSquare().getImage());
                    folowingSquare.setPiece(ground.getCurrentSquare().getPiece());
                    ground.getCurrentSquare().setImage(null);
                    ground.setCurrentSquare(null);

                }
            }
*/
        }
        graphicChess.previousSquare = s;
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {


    }

    @Override
    public void mouseExited(MouseEvent e) {


    }
}
