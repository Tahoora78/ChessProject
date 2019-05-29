import java.util.ArrayList;
import java.util.HashMap;

/**
 * this class is used for difining the features of the pices
 * Tahoora majlesi
 */
public abstract class Pices {
    private int  x;
    private int y;
    private String color;
    private String name;
    private String first = "no";
    private int number=0;
    private
    //HashMap<Integer,Integer> choices = new HashMap<>();
    // ArrayList<Integer> xChoice = new ArrayList<>();
    HashMap<Integer,Integer> choice = new HashMap<>();
    Integer[] xChoice = new Integer[64];
    Integer[] yChoice = new Integer[64];
    /**
     * @param x get the x and set it
     * @param y get y and set it
     */

    public void setChoices(int x,int y,int i){
        xChoice[i]=x;
        yChoice[i]=y;
        number++;
        System.out.println("x:"+x+" y:"+y);
        System.out.println("*****************");
    }
    public Integer[] getxChoice(){
        return xChoice;
    }
    public Integer[] getyChoice(){
        return yChoice;
    }

    public int getNumber(){
        return number;
    }
    /**
     *
     * @return the size
     */
    public int getSizeOfChoices(){
        return number;
    }

    public HashMap<Integer,Integer> getChoice(){
        return choice;
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

    /**
     *
     * @param c return the color of the piece
     */
    public void setColor(String c){
        color = c;
    }

    /**
     * change the a to g to integer
     * @param z the parameter to change
     * @return the integer which is changed
     */

    public void setX(int z){
        x = z;
    }
    /*
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
        //System.out.println("X::"+x);
        return x;
    }
*/

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

    /**
     * used for moving the pieces
     * @param x get the x of piece
     * @param u get the y of piece
     */
    public void move(Character x,int u){
        setX(x);
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
