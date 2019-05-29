import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseDemo implements MouseListener {
    JButton[][] b;
    Ground ground;
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
            if(ground.getTurnPiece().equals(s.getColor())) {
                ground.setCurrentSquare(s);
            if(s.color.equals("black")){
                ground.setTurnPiece("white");
            }if(s.color.equals("white")){
                ground.setTurnPiece("black");
            }
            b[s.getx()][s.gety()].setBackground(new Color(0xA05452));
            //System.out.println("name" + s.p.getName() + "x:::" + s.p.getNumber() + "x:" + s.p.getxChoice()[0]);
            for (int i = 0; i < s.p.getNumber(); i++) {
                b[s.p.getxChoice()[i]][s.p.getyChoice()[i]].setBackground(new Color(0x327824));
            }
                folowingSquare = (Square)e.getSource();
                System.out.println("following squre:"+folowingSquare.getx()+"s"+s.getx());
            for(int i=0;i<s.p.getNumber();i++){
               // System.out.println("folowing x:"+folowingSquare.getx()+"previous x:"+s.p.getxChoice()[i]+"folowing y:"+folowingSquare.gety()+"previous y:"+s.p.getyChoice()[i]);
                if(folowingSquare.getx()==s.p.getxChoice()[i] && folowingSquare.gety()==s.p.getyChoice()[i]){
                    folowingSquare.setImage(ground.getCurrentSquare().getImage());
                    folowingSquare.setPiece(ground.getCurrentSquare().getPiece());
                    ground.getCurrentSquare().setImage(null);
                    ground.setCurrentSquare(null);

                }
            }

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
