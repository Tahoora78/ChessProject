public class Bishop extends Pices {
    private int num;
    private String name = "Bishop";

    @Override
    public String getName(){
        return name;
    }

    public Bishop(Character s,int u,String d,int y){
        super.setX(s);
        super.setY(u);
        super.setColor(d);
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


}
