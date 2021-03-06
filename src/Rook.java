import java.util.HashMap;

/**
 * used for defining the features and methods of rook piece
 * Tahoora Majlesi
 */
public class Rook extends Pices {
    private int num;
    private String name = "Rook";

    @Override
    public String getName(){
        return name;
    }


    public Rook(int e,int u,String h,int i){
        super.setX(e);
        super.setY(u);
        super.setColor(h);
        num = i;
    }

    public void setX(char t){
        super.setX(t);
    }

    public void setY(int yu){
        super.setY(yu);
    }

    @Override
    public void move(Character xe, int u) {
        super.move(xe, u);
    }

    public void setColor(String colors){
        super.setColor(colors);
    }

    public String getColor(){
        return super.getColor();
    }
   // public void setChoices(int x,int y){
   //     super.setChoices(x,y);
   // }



}
