public class Pawn extends Pices {
    private String name = "Pawn";

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


}
