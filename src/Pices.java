public abstract class Pices {
    int  x;
    private int y;
    private String color;

    public enum xChar{
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

    public void setX(char z){
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
    }


    public void setY(int u){
        y = u;
    }

    public void move(Character xe,int u){
        setX(xe);
        y = u;
    }



}
