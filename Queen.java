import java.util.HashMap;

/**
 * used for defining the features of queen piece
 * Tahoora Majlesi
 */
public class Queen extends Pices {
    private String name = "Queen";

    public Queen(int d,int r,String o){
        super.setX(d);
        super.setY(r);
        super.setColor(o);
    }
    public void setX(char t){
        super.setX(t);
    }

    public void setY(int yu){
        super.setY(yu);
    }

    @Override
    public void move(Character x, int u) {
        super.move(x, u);
    }

    public void setColor(String colors){
        super.setColor(colors);
    }

    @Override
    public String getName(){
        return name;
    }

    public String getColor(){
        return super.getColor();
    }

   // public void setChoices(int x,int y){
     //   super.setChoices(x,y);
    //}



}
