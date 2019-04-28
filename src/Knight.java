import java.util.HashMap;

public class Knight extends Pices {
    private int num;
    private String name = "Knight";

    @Override
    public String getName(){
        return name;
    }

    public Knight(Character d,int r,String f,int y){
        super.setX(d);
        super.setY(r);
        super.setColor(f);
        num = y;
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


    public void setChoices(int x,int y){
        super.setChoices(x,y);
    }



}
