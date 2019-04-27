public class Queen extends Pices {
    private String name = "Queen";

    public Queen(Character d,int r,String o){
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
    public void move(Character xe, int u) {
        super.move(xe, u);
    }

    public void setColor(String colors){
        super.setColor(colors);
    }

    @Override
    public String getName(){
        return name;
    }

}
