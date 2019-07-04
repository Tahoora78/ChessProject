import java.util.HashMap;

/**
 * used for defining the features and methods of king piece
 * Tahoora Majlesi
 */
public class King extends Pices {
    public String name = "King";

    @Override
    public String getName(){
        return name;
    }

    public King(int d,int r,String g){

        super.setX(d);
        super.setY(r);
        super.setColor(g);
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
    //    super.setChoices(x,y);
    //}



}
