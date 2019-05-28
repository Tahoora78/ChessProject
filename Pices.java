import java.util.ArrayList;
import java.util.HashMap;

public abstract class Pices {
    int  x;
    private int y;
    private String color;
    private String name;
    private String first = "no";
    HashMap<Integer,Integer> choices = new HashMap<>();
    ArrayList<Integer> xChoice = new ArrayList<>();
    ArrayList<Integer> yChoice = new ArrayList<>();

    public void setChoices(int x,int y){
        xChoice.add(x);
        yChoice.add(y);
    }

    public int getSizeOfChoices(){
        return xChoice.size();
    }

    public ArrayList<Integer> getXChoice(){
        return xChoice;
    }

    public ArrayList<Integer> getyChoice(){
        return yChoice;
    }

    public enum xChar{
        z,
        a,
        b,
        c,
        d,
        e,
        f,
        g,
        h
    }

    public void setColor(String c){
        color = c;
    }

    public int setX(Character z){
        switch (z){
            case('a'):
                x = xChar.a.ordinal();
                break;
            case('b'):
                x = xChar.b.ordinal();
                break;
            case('c'):
                x = xChar.c.ordinal();
                break;
            case('d'):
                x = xChar.d.ordinal();
                break;
            case('e'):
                x = xChar.e.ordinal();
                break;
            case('f'):
                x = xChar.f.ordinal();
                break;
            case('g'):
                x = xChar.g.ordinal();
                break;
            case('h'):
                x = xChar.h.ordinal();
                break;
        }
        return x;
    }


    public abstract String getName();

    public void setY(int u){
        y = u;
    }

    public String getFirst(){
        return first;
    }

    public void setFirst(String y){
        first = y;
    }

    public void move(Character xe,int u){
        setX(xe);
        y = u;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public String getColor(){
        return color;
    }
}
