public class Test {
    public static void main(String[] args) {
        Ground g = new Ground();
        g.makingChessPicess();
        g.makingPicessChoices();
        for (int i = 0; i <g.chessPicess.size() ; i++) {
            System.out.println(g.chessPicess.get(i).getName()+g.chessPicess.get(i).getColor()+"x:"+g.chessPicess.get(i).getX()+"y:"+g.chessPicess.get(i).getY()+"number::"+g.chessPicess.get(i).getNumber());
        }




    }


}
