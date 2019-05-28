import java.util.HashMap;

public class Pawn extends Pices {
    private String name = "Pawn";
    private String first = "no";
    @Override
    public String getFirst(){
        return first;
    }
    @Override
    public void setFirst(String y){
        first = y;
    }

    public Pawn(Character g,int r,String d){
        super.setX(g);
        super.setY(r);
        super.setColor(d);

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

    @Override
    public String getName() {
        return name;
    }

    public String getColor(){
        return super.getColor();
    }

    public void setChoices(int x,int y){
        super.setChoices(x,y);
    }



}
