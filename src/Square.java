import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Square extends JButton {
    String name;
    private int x;
    private int y;
    String color;
    Pices p;

    Ground ground;
    String image;
    Boolean mouseClicked;

    public void setMouseClicked(boolean bool){
        mouseClicked = bool;
    }

    public boolean getMouseclicked(){
        return mouseClicked;
    }

    public Square(int x,int y,Ground ground){
        this.x = x;
        this.y = y;
        this.ground = ground;
    }
    public int getx(){
        return x;
    }

    public int gety(){
        return y;
    }

    public Square setP(Pices p, String address,String color){
        this.p = p;
        try {
            Image img = ImageIO.read(getClass().getResource(address));
            img.getScaledInstance(40,80,Image.SCALE_DEFAULT);
            this.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        this.color = color;
        image = address;
        return this;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }


//    public void setColor(String color){
  //      this.color = color;
   // }


    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }

    public void setColor(Color color) {
        this.color = p.getColor();
    }

    public String getImage(){
        return image;
    }

    public void setPiece(Pices op){
        p = op;
    }

    public Pices getPiece(){
        return p;
    }

    public String getColor(){
        return color;
    }
    public void setImage(String address){
        try {
            Image img = ImageIO.read(getClass().getResource(address));
            img.getScaledInstance(40,80,Image.SCALE_DEFAULT);
            this.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        image = address;
        //this.color = color;
    }
}
