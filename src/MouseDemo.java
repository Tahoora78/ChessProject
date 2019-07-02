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
                    b[s.p.getxChoice()[i]][s.p.getyChoice()[i]].setBackground(new Color(0x327824));
                }
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
                System.out.println("second start"+ground.getStart());
                System.out.println("jjjjjjjjjjjjjjjjjj"+u);
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
